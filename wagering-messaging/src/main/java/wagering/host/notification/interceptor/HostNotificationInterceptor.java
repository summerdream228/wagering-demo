package wagering.host.notification.interceptor;

import java.util.Map;

import org.springframework.stereotype.Service;

import wagering.event.ActionEvent;
import wagering.host.notification.HostNotification;
import wagering.util.CollectionsUtil;
import wagering.util.JsonUtil;
import wagering.util.LoggableService;

@Service
public class HostNotificationInterceptor extends LoggableService implements NotificationInterceptor {

	private Map<String, ActionEventRestorer> notificationRegistry = CollectionsUtil.newMap();
	
	@Override
	public void registerNotificationType(String type, ActionEventRestorer restorer) {
		notificationRegistry.put(type, restorer);
	}

	@Override
	public ActionEvent restore(HostNotification notification) {
		ActionEventRestorer restorer = notificationRegistry.get(notification.getType());
		if (restorer != null) {
			return restorer.restore(notification);
		}
		warn("Unknown host type %s notification %s", notification.getType(), JsonUtil.writeObject(notification));
		return null;
	}

	
}
