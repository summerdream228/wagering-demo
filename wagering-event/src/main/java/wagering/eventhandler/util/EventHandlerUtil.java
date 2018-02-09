package wagering.eventhandler.util;

import java.lang.reflect.Method;

import wagering.event.ActionEvent;
import wagering.eventhandler.annotation.EventHandlerMethod;

public class EventHandlerUtil {
	
	public static boolean isVoidMethodWithOneParameterOfType(Method method, Class<?> parameterClazz) {
		return isWithReturnTypeAndParameterType(method, void.class, parameterClazz);
	}
	
	public static boolean isWithReturnTypeAndParameterType(Method method, Class<?> returnClazz, Class<?> parameterClazz) {
		if (isEventHandlerMethod(method)) {
			if (method.getParameterCount() == 1 && parameterClazz.isAssignableFrom(method.getParameterTypes()[0])
					&& method.getReturnType() == returnClazz) {
				return true;
			}
		}
		return false;
	}

	public static boolean isEventHandlerMethod(Method method) {
		return method.getAnnotation(EventHandlerMethod.class) != null;
	}
	
	@SuppressWarnings("unchecked")
	public static Class<ActionEvent> getEventClass(Method eventHandlerMethod) {
		return (Class<ActionEvent>) eventHandlerMethod.getParameterTypes()[0];
	}
}
