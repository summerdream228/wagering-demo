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

package wagering.util;

import java.io.IOException;
import java.io.StringWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author meng.xia
 */
public class JsonUtil {
	private static ObjectMapper objectMapper;
	public static final String DEFAULT_ENCODING = "UTF-8";
	private static Logger logger = LoggerFactory.getLogger(JsonUtil.class);
	
	static {
		objectMapper = new ObjectMapper();
		objectMapper.configure(MapperFeature.DEFAULT_VIEW_INCLUSION, false);
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	public static <R> R readObject(String jsonStr, Class<R> clazz) {
		try {
			return objectMapper.readValue(jsonStr, clazz);
		} catch (IOException e) {
			logger.error("error json {}", e, jsonStr);
		}
		return null;
	}

	public static String writeObject(Object obj) {
		try {
			StringWriter sw = new StringWriter();

			objectMapper.writeValue(sw, obj);

			return sw.toString();
		}
		catch (IOException e) {
			logger.error("error writing obj to json", e);
		}
		return null;
	}
}
