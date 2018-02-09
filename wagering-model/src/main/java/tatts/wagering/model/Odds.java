package tatts.wagering.model;

public interface Odds {
	float getDecimal();
	
	public static class OddsUtil {
		public static Odds decimal(float decimal) {
			return new OddsImpl(decimal);
		}
	}
}
