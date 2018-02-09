package wagering.eventhandler;

import java.lang.reflect.Method;

public interface EventHandlerTemplate {
	boolean belongs(Method method);
	EventHandler build(Object eventHandlerInstance, Method eventHandlerMethod);
}
