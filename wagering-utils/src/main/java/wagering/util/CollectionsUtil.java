package wagering.util;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CollectionsUtil {

	public static <K, V> Map<K, V> synchronizedMap() {
		Map<K, V> map = new HashMap<>();
		return Collections.synchronizedMap(map);
	}
	
	public static <K, V> Map<K, V> newMap() {
		return new HashMap<>();
	}
}
