package wagering.eventhandler;

import java.lang.reflect.Method;
import java.util.concurrent.CompletableFuture;

import wagering.event.ActionEvent;
import wagering.eventhandler.util.EventHandlerUtil;

public class CompletableFutureEventHandlerBuilder implements EventHandlerTemplate {

	@Override
	public boolean belongs(Method method) {
		return EventHandlerUtil.isWithReturnTypeAndParameterType(method, CompletableFuture.class, ActionEvent.class);
	}

	@Override
	public EventHandler build(Object eventHandlerInstance, Method eventHandlerMethod) {
		return new CompletableFutureEventHandler(eventHandlerInstance, eventHandlerMethod);
	}

}
