package wagering.eventhandler.services;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;

import wagering.event.ActionEvent;
import wagering.eventhandler.EventService;
import wagering.eventhandler.dispatcher.EventDispatcher;
import wagering.util.LoggableService;

public abstract class EventDrivenService extends LoggableService implements EventDispatcher {

	@Autowired
	private EventService eventService;

	@Override
	public CompletableFuture<?> dispatch(ActionEvent event) {
		return eventService.dispatch(event);
	}
}
