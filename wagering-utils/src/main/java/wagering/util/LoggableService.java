package wagering.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggableService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public void trace(String log, Object... args) {
		logger.trace(String.format(log, args));
	}
	
	public void debug(String log, Object... args) {
		logger.debug(String.format(log, args));
	}
	
	public void info(String log, Object... args) {
		logger.info(String.format(log, args));
	}
	
	public void warn(String log, Object... args) {
		logger.warn(String.format(log, args));
	}
	
	public void error(String log, Throwable e, Object... args) {
		logger.error(String.format(log, args), e);
	}
	
	public void error(String log, Object... args) {
		logger.error(String.format(log, args));
	}
}
