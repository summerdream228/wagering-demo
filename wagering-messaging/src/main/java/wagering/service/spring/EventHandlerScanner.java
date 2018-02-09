package wagering.service.spring;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.annotation.AnnotationUtils;

import wagering.eventhandler.EventHandler;
import wagering.eventhandler.EventHandlerTemplate;
import wagering.eventhandler.EventService;
import wagering.eventhandler.annotation.EventHandlerMethod;
import wagering.exception.WageringException;

public class EventHandlerScanner {
	private EventService eventService;
	private EventHandlerTemplate[] eventHandlerTemplates;

	public EventHandlerScanner(EventService eventService, EventHandlerTemplate[] eventHandlerTemplates) {
		this.eventService = eventService;
		this.eventHandlerTemplates = eventHandlerTemplates;
	}

	public void registerEventHandler(Object eventHandlerBean, String beanName) {

		List<Method> eventHandlerMethods = Arrays.stream(eventHandlerBean.getClass().getDeclaredMethods())
				.filter(method -> AnnotationUtils.findAnnotation(method, EventHandlerMethod.class) != null)
				.collect(Collectors.toList());

		List<EventHandler> eventHandlers = eventHandlerMethods.stream()
				.map(method -> Arrays.stream(eventHandlerTemplates)
						.filter(methodTemplate -> methodTemplate.belongs(method)).findFirst()
						.orElseThrow(() -> new WageringException("No matching event handler template for " + method))
						.build(eventHandlerBean, method))
				.collect(Collectors.toList());

		eventHandlers.forEach(eventHandler -> eventService.registerEventHandler(eventHandler.getEventType(), eventHandler));
	}
}
