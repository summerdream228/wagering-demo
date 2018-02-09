package wagering.eventhandler;

import java.lang.reflect.Method;

import wagering.event.ActionEvent;
import wagering.eventhandler.util.EventHandlerUtil;

public class SimpleEventHandlerBuilder implements EventHandlerTemplate {

	@Override
	public boolean belongs(Method method) {
		return EventHandlerUtil.isVoidMethodWithOneParameterOfType(method, ActionEvent.class);
	}

	@Override
	public EventHandler build(Object eventHandlerInstance, Method eventHandlerMethod) {
		return new SimpleEventHandler(eventHandlerInstance, eventHandlerMethod);
	}

}
