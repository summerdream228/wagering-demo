package tattsgroup.wagering.wagon.impl;

import tattsgroup.wagering.wagon.WagonSystemFacade;
import wagering.util.LoggableService;

public class DummyWagonSystemFacadeImpl extends LoggableService implements WagonSystemFacade {

	@Override
	public void updateOfferPrice(Long offerId, String changedOfferPrice) {
		info("updating wagon offer %s price %s", offerId, changedOfferPrice);
	}

}
