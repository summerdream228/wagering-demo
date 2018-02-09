package tatts.wagering.model;

public class OddsImpl implements Odds {
	private float decimal;
	
	public OddsImpl(float decimal) {
		this.decimal = decimal;
	}
	
	@Override
	public float getDecimal() {
		return decimal;
	}

	@Override
	public String toString() {
		return "Odds [decimal=" + decimal + "]";
	}

}
