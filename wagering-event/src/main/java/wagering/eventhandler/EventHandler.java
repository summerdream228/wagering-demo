package wagering.eventhandler;

import java.util.concurrent.CompletableFuture;

import wagering.event.ActionEvent;

public interface EventHandler {
	Class<ActionEvent> getEventType();
	CompletableFuture<?> dispatch(ActionEvent event);
}
