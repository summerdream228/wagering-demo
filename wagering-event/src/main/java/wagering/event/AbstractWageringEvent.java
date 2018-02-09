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

package wagering.event;

/**
 * @author meng.xia
 */
public abstract class AbstractWageringEvent implements ActionEvent {

	private Long partitionId;

	/*
	 * (non-Javadoc)
	 *
	 * @see sample.host.event.ActionEvent#isPartitioned()
	 */
	@Override
	public boolean isPartitioned() {
		return partitionId != null;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see sample.host.event.ActionEvent#getPartitionid()
	 */
	@Override
	public Long getPartitionId() {
		return this.partitionId;
	}

	public void setPartitionId(Long partitionId) {
		this.partitionId = partitionId;
	}

	@Override
	public boolean isBlocked() {
		return false;
	}

}
