package wagering.activemq.listeners;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import wagering.event.ActionEvent;
import wagering.eventhandler.services.EventDrivenService;
import wagering.host.notification.HostNotification;
import wagering.host.notification.interceptor.NotificationInterceptor;
import wagering.util.JsonUtil;

@Component
public class HostNotificationListener extends EventDrivenService {
	@Autowired
	private NotificationInterceptor notificationInterceptor;
	
	@PostConstruct
	public void init() {
		info("starting up host notification listener");
	}

	@JmsListener(destination = "sample.tbl_Offer")
	public void receiveOffer(String text) {
		debug("got Offer Notifiction: %s", text);
		try {
			HostNotification notification = JsonUtil.readObject(text, HostNotification.class);

			if (notification == null) {
				warn("unknown notification %s received", text);
				return;
			}
			
			ActionEvent event = notificationInterceptor.restore(notification);

			if (event != null) {
				debug("got offer action: %s", JsonUtil.writeObject(event));
				dispatch(event);
			} else {
				error("unknown offer update %s", text);
			}
		} catch (Exception ex) {
			error("error when handling message from offer queue %s", ex, text);
		}
	}
}