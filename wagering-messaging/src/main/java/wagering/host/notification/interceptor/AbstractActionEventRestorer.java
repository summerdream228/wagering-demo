package wagering.host.notification.interceptor;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import wagering.util.LoggableService;

public abstract class AbstractActionEventRestorer extends LoggableService implements ActionEventRestorer {
	
	@Autowired
	private NotificationInterceptor notificationInterceptor;
	private String notificationType;
	
	public AbstractActionEventRestorer(String notificationType) {
		this.notificationType = notificationType;
	}

	@PostConstruct
	public void init() {
		notificationInterceptor.registerNotificationType(notificationType, this);
		info("regstiering notification type %s with %s", notificationType, this.getClass().getSimpleName());
	}
}
