package wagering.eventhandler;

import java.util.List;
import java.util.Optional;

import wagering.event.ActionEvent;
import wagering.eventhandler.dispatcher.EventDispatcher;

public interface EventService extends EventDispatcher {
	void registerEventHandler(Class<? extends ActionEvent> event, EventHandler eventHandler);
	Optional<List<EventHandler>> getEventHandlers(Class<? extends ActionEvent> event);
}
