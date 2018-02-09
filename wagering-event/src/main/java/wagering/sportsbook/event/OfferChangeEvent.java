package wagering.sportsbook.event;

import tatts.wagering.model.Odds;
import wagering.event.AbstractWageringEvent;

public class OfferChangeEvent extends AbstractWageringEvent {
	private Long eventId;
	private Long offerId;
	private Odds changedOdds;
	
	public OfferChangeEvent(Long eventId, Long offerId, Odds newOdds) {
		this.changedOdds = newOdds;
		this.offerId = offerId;
		this.eventId = eventId;
		this.setPartitionId(eventId);
	}

	public Long getEventId() {
		return eventId;
	}

	public Long getOfferId() {
		return offerId;
	}

	public Odds getChangedOdds() {
		return changedOdds;
	}

}
