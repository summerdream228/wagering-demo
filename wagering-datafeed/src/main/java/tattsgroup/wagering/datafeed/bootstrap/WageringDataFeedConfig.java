package tattsgroup.wagering.datafeed.bootstrap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import tattsgroup.wagering.datafeed.WagonReconciliationService;
import tattsgroup.wagering.wagon.WagonSystemFacade;
import tattsgroup.wagering.wagon.impl.DummyWagonSystemFacadeImpl;
import wagering.activemq.config.ActiveMQJmsConfig;
import wagering.host.notification.registry.HostNotificationEventRegistryConfig;
import wagering.messaging.service.HostMessagingConfig;

@Configuration
@Import({ ActiveMQJmsConfig.class, HostNotificationEventRegistryConfig.class, HostMessagingConfig.class })
public class WageringDataFeedConfig {
	
	@Bean
	public WagonReconciliationService wagonReconcileService() {
		return new WagonReconciliationService();
	}
	
	@Bean
	public WagonSystemFacade wagonSystemFacade() {
		return new DummyWagonSystemFacadeImpl();
	}
}
