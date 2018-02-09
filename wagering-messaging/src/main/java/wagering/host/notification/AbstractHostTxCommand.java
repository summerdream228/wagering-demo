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

package wagering.host.notification;

import wagering.event.ActionEvent;
import wagering.messaging.service.MessagingService;
import wagering.util.JsonUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

/**
 * @author meng.xia
 */
public abstract class AbstractHostTxCommand implements CommandLineRunner {

	private ActionEvent actionEvent;

	@Autowired
	private MessagingService messageService;

	/*
	 * (non-Javadoc)
	 *
	 * @see org.springframework.boot.CommandLineRunner#run(java.lang.String[])
	 */
	@Override
	public void run(String... args) throws Exception {
		if (this.actionEvent != null) {
//			this.messageService.send(JsonUtil.writeObject(this.actionEvent));
		}
	}

	protected abstract void build();
}
