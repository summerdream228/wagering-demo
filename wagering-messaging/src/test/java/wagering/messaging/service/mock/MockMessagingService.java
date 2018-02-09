package wagering.messaging.service.mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.jms.Destination;
import javax.jms.MessageListener;

import wagering.messaging.service.MessagingService;
import wagering.util.CollectionsUtil;

public class MockMessagingService implements MessagingService {

	private Map<String, List<MessageListener>> messageListeners = CollectionsUtil.newMap();

	@Override
	public void send(String msg, String destination) {
		List<MessageListener> listeners = messageListeners.get(destination);
		if (listeners != null) {
			listeners.forEach(l -> l.onMessage(null));
		}
	}

	@Override
	public void send(String msg, Destination destination) {
		send(msg, destination.toString());
	}

	public void addMessagingListener(Destination destination, MessageListener messagingListener) {
		addMessagingListener(destination.toString(), messagingListener);
	}

	public void addMessagingListener(String destination, MessageListener messagingListener) {
		List<MessageListener> listeners = messageListeners.get(destination);
		if (listeners == null) {
			listeners = new ArrayList<>(); 
			messageListeners.put(destination, listeners);
		}
		listeners.add(messagingListener);
	}

}
