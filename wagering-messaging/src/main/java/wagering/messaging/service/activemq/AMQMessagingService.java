package wagering.messaging.service.activemq;

import javax.jms.Destination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import wagering.messaging.service.MessagingService;

@Service
public class AMQMessagingService implements MessagingService {

	@Autowired
	private JmsMessagingTemplate jmsMessagingTemplate;
	
	@Override
	public void send(String msg, String destination) {
		this.jmsMessagingTemplate.convertAndSend(destination, msg);
	}

	@Override
	public void send(String msg, Destination destination) {
		this.jmsMessagingTemplate.convertAndSend(destination, msg);		
	}

}
