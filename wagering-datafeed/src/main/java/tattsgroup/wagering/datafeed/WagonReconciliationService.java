package tattsgroup.wagering.datafeed;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tattsgroup.wagering.wagon.WagonSystemFacade;
import wagering.eventhandler.annotation.EventHandlerMethod;
import wagering.eventhandler.annotation.EventSubscriber;
import wagering.eventhandler.services.EventDrivenService;
import wagering.sportsbook.event.OfferChangeEvent;

@EventSubscriber(id = "WagonReconciliationService")
@Service
public class WagonReconciliationService extends EventDrivenService {

	@Autowired
	private WagonSystemFacade wagonSystemFacade;
	
	@PostConstruct
	public void init() {
		info("starting up WagonReconciliationService");
	}

	@EventHandlerMethod
	public void handleOfferUpdate(OfferChangeEvent event) {
		info("handling offer update for eventId %s, offerId %s, odds %s", event.getEventId(), event.getOfferId(),
				event.getChangedOdds());

		wagonSystemFacade.updateOfferPrice(event.getOfferId(), String.valueOf(event.getChangedOdds().getDecimal()));
	}
}
