package wagering.host.notification.interceptor;

import wagering.event.ActionEvent;
import wagering.host.notification.HostNotification;

public interface ActionEventRestorer {
	ActionEvent restore(HostNotification notification);
}
