package wagering.service.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import wagering.eventhandler.CompletableFutureEventHandlerBuilder;
import wagering.eventhandler.EventHandlerRegistry;
import wagering.eventhandler.EventHandlerTemplate;
import wagering.eventhandler.EventService;
import wagering.eventhandler.SimpleEventHandlerBuilder;
import wagering.eventhandler.services.DefaultEventService;

@Configuration
public class SpringEventHandlerConfiguration {
	
	@Bean
	public EventHandlerRegistry eventHandlerRegistry() {
		return new EventHandlerRegistry();
	}
	
	@Bean
	public EventHandlerTemplate simpleEventHandlerTemplate() {
		return new SimpleEventHandlerBuilder();
	}
	
	@Bean
	public EventHandlerTemplate completableFutureEventHandlerTemplate() {
		return new CompletableFutureEventHandlerBuilder();
	}

	@Bean
	public EventService eventService() {
		return new DefaultEventService();
	}
	
	@Bean
	public EventHandlerScanner eventHandlerScanner(EventHandlerTemplate[] templates, EventService eventService) {
		return new EventHandlerScanner(eventService, templates);
	}

	@Bean
	public SpringBeanPostProcessor eventHandlerBeanPostProcessor(EventHandlerScanner scanner) {
		return new SpringBeanPostProcessor(scanner);
	}
}
