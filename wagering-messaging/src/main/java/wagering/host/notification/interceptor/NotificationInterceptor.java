package wagering.host.notification.interceptor;

import wagering.event.ActionEvent;
import wagering.host.notification.HostNotification;

public interface NotificationInterceptor {
	void registerNotificationType(String type, ActionEventRestorer restorer);
	ActionEvent restore(HostNotification notification);
}
