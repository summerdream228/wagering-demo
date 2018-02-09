package wagering.messaging.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import wagering.activemq.listeners.HostNotificationListener;
import wagering.host.notification.interceptor.HostNotificationInterceptor;

@Configuration
public class HostMessagingConfig {

	@Bean
	public HostNotificationInterceptor hostNotificationInterceptor() {
		return new HostNotificationInterceptor();
	}
	
	@Bean
	public HostNotificationListener hostNotificationListener() {
		return new HostNotificationListener();
	}
}
