package wagering.host.notification.registry;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HostNotificationEventRegistryConfig {

	@Bean
	public OfferChaneEventRestorer registerOfferChangeEvent() {
		return new OfferChaneEventRestorer();
	}
}
