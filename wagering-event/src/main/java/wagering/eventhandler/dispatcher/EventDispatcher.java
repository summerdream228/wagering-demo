package wagering.eventhandler.dispatcher;

import java.util.concurrent.CompletableFuture;

import wagering.event.ActionEvent;

public interface EventDispatcher {
	CompletableFuture<?> dispatch(ActionEvent event);
}
