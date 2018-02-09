package wagering.host.notification.registry;

import org.springframework.stereotype.Component;

import tatts.wagering.model.Odds.OddsUtil;
import wagering.event.ActionEvent;
import wagering.host.dto.Offer;
import wagering.host.notification.HostNotification;
import wagering.host.notification.interceptor.AbstractActionEventRestorer;
import wagering.sportsbook.event.OfferChangeEvent;
import wagering.util.JsonUtil;

@Component
public class OfferChaneEventRestorer extends AbstractActionEventRestorer {

	public OfferChaneEventRestorer() {
		super("tbl_Offer");
	}

	@Override
	public ActionEvent restore(HostNotification notification) {
		Offer offerUpdate = JsonUtil.readObject(notification.getData(), Offer.class);
		OfferChangeEvent event = new OfferChangeEvent(offerUpdate.getEventId(), offerUpdate.getOfferId(), OddsUtil.decimal(offerUpdate.getDecimal()));
		return event;
	}
	
}
