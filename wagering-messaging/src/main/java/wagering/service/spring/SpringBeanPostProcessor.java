package wagering.service.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.annotation.AnnotationUtils;

import wagering.eventhandler.annotation.EventSubscriber;

public class SpringBeanPostProcessor implements BeanPostProcessor {
	private EventHandlerScanner eventHandlerScanner;

	public SpringBeanPostProcessor(EventHandlerScanner eventHandlerScanner) {
		this.eventHandlerScanner = eventHandlerScanner;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if (AnnotationUtils.findAnnotation(bean.getClass(), EventSubscriber.class) != null) {
			eventHandlerScanner.registerEventHandler(bean, beanName);
		}
		return bean;
	}
}
