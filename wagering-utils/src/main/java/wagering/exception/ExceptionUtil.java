package wagering.exception;

public class ExceptionUtil {

	public static WageringException get(RuntimeException ex) {
		return new WageringException(ex);
	}
}
