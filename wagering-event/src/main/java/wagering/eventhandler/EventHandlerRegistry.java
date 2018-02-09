package wagering.eventhandler;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import wagering.event.ActionEvent;

public class EventHandlerRegistry {
	private static Logger log = LoggerFactory.getLogger(EventHandlerRegistry.class);
	
	private Map<Class<? extends ActionEvent>, List<EventHandler>> eventHandlerRegistry = new HashMap<>();

	public void register(EventHandler eventHandler) {
		Class<ActionEvent> eventType = eventHandler.getEventType();
		if (!eventHandlerRegistry.containsKey(eventType)) {
			List<EventHandler> list = new LinkedList<>();
			list.add(eventHandler);
			eventHandlerRegistry.put(eventType, list);
		} else {
			eventHandlerRegistry.get(eventType).add(eventHandler);
		}
		
		log.info("register event {} with EventHandler {}", eventType.getName(), eventHandler);
	}
	
	public void register(List<EventHandler> eventHandlers) {
		eventHandlers.forEach(eh -> register(eh));
	}

	public Optional<List<EventHandler>> getEventHandlers(Class<? extends ActionEvent> event) {
		return Optional.ofNullable(eventHandlerRegistry.get(event));
	}
}
