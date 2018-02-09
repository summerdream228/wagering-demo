/*
 * Copyright 2012-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package wagering.activemq.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:${config.location:application.properties}", ignoreResourceNotFound = true)
public class ActiveMQJmsConfig {

	@Value("${jms.broker.url:activemq://localhost:61616}")
	private String brokerUrl;

	@Value("${jms.broker.username:admin}")
	private String brokerUsername = "admin";

	@Value("${jms.broker.password:password}")
	private String brokerPassword = "password";

	@Bean
	public ActiveMQConnectionFactory connectionFactory() {
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
		connectionFactory.setBrokerURL(this.brokerUrl);
		connectionFactory.setPassword(this.brokerUsername);
		connectionFactory.setUserName(this.brokerPassword);
		return connectionFactory;
	}
}
