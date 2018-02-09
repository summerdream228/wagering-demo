package wagering.eventhandler;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.CompletableFuture;

import wagering.event.ActionEvent;
import wagering.eventhandler.util.EventHandlerUtil;

public class SimpleEventHandler implements EventHandler {

	private Method method;
	private Object eventHandler;

	public SimpleEventHandler(Object eventHandler, Method method) {
		this.eventHandler = eventHandler;
		this.method = method;
	}

	@Override
	public Class<ActionEvent> getEventType() {
		return EventHandlerUtil.getEventClass(method);
	}

	@Override
	public CompletableFuture<?> dispatch(ActionEvent event) {
		CompletableFuture<?> f = new CompletableFuture<>();
		try {
			method.invoke(eventHandler, event);
			f.complete(null);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			f.completeExceptionally(e);
		}
		return f;
	}

	@Override
	public String toString() {
		return eventHandler.getClass().getName() + "-" + method.getName();
	}

}
