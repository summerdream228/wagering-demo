package tattsgroup.wagering.datafeed.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.scheduling.annotation.EnableScheduling;

import wagering.service.spring.EnableEventHandlers;

@SpringBootApplication
@Import(WageringDataFeedConfig.class)
@EnableScheduling
@EnableJms
@EnableEventHandlers
public class WageringDataFeedApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(WageringDataFeedApplication.class, args);
	}
}
