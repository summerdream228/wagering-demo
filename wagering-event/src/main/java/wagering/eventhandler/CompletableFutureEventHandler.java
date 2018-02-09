package wagering.eventhandler;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.CompletableFuture;

import wagering.event.ActionEvent;
import wagering.eventhandler.util.EventHandlerUtil;
import wagering.util.CompletableFutureUtil;

public class CompletableFutureEventHandler implements EventHandler {

	private Object eventHandlerInstance;
	private Method eventHandlerMethod;
	
	public CompletableFutureEventHandler(Object eventHandlerInstance, Method eventHandlerMethod) {
		this.eventHandlerInstance = eventHandlerInstance;
		this.eventHandlerMethod = eventHandlerMethod;
	}

	@Override
	public Class<ActionEvent> getEventType() {
		return EventHandlerUtil.getEventClass(eventHandlerMethod);
	}

	@Override
	public CompletableFuture<?> dispatch(ActionEvent event) {
		try {
			return (CompletableFuture<?>) eventHandlerMethod.invoke(eventHandlerInstance, event);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			return CompletableFutureUtil.fail(e);
		}
	}

	@Override
	public String toString() {
		return eventHandlerInstance.getClass().getSimpleName() + "-" + eventHandlerMethod.getName();
	}

}
