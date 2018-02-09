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

package wagering.host.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * @author meng.xia
 */

@JsonRootName(value = "Offer")
public class Offer {
	@JsonProperty("OfferId")
	Long offerId;
	@JsonProperty("SubEventId")
	Long subEventId;
	@JsonProperty("EventId")
	Long eventId;
	@JsonProperty("Status")
	String status;
	@JsonProperty("SortOrder")
	Integer sortOrder;
	@JsonProperty("OfferName")
	String offerName;
	@JsonProperty("WWInternetReturn")
	Float decimal;
	@JsonProperty("Deduction")
	Integer deduction;
	@JsonProperty("PlaceDeduction")
	Integer placeDeduction;

	/**
	 * @return the offerId
	 */
	public Long getOfferId() {
		return this.offerId;
	}

	/**
	 * @param offerId the offerId to set
	 */
	public void setOfferId(Long offerId) {
		this.offerId = offerId;
	}

	/**
	 * @return the subEventId
	 */
	public Long getSubEventId() {
		return this.subEventId;
	}

	/**
	 * @param subEventId the subEventId to set
	 */
	public void setSubEventId(Long subEventId) {
		this.subEventId = subEventId;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return this.status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the sortOrder
	 */
	public Integer getSortOrder() {
		return this.sortOrder;
	}

	/**
	 * @param sortOrder the sortOrder to set
	 */
	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}

	/**
	 * @return the offerName
	 */
	public String getOfferName() {
		return this.offerName;
	}

	/**
	 * @param offerName the offerName to set
	 */
	public void setOfferName(String offerName) {
		this.offerName = offerName;
	}

	/**
	 * @return the decimal
	 */
	public Float getDecimal() {
		return this.decimal;
	}

	/**
	 * @param decimal the decimal to set
	 */
	public void setDecimal(Float decimal) {
		this.decimal = decimal;
	}

	/**
	 * @return the deduction
	 */
	public Integer getDeduction() {
		return this.deduction;
	}

	/**
	 * @param deduction the deduction to set
	 */
	public void setDeduction(Integer deduction) {
		this.deduction = deduction;
	}

	/**
	 * @return the placeDeduction
	 */
	public Integer getPlaceDeduction() {
		return this.placeDeduction;
	}

	/**
	 * @param placeDeduction the placeDeduction to set
	 */
	public void setPlaceDeduction(Integer placeDeduction) {
		this.placeDeduction = placeDeduction;
	}

	public Long getEventId() {
		return eventId;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

}
