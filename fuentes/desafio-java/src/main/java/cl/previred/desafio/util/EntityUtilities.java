package cl.previred.desafio.util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EntityUtilities {

	private static final ObjectMapper objectMapper;

	private static final Logger log = LoggerFactory.getLogger(EntityUtilities.class);

	private EntityUtilities() {
	}

	static {
		objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
	}

	public static <T> T copyObjectFrom(Object source, Class<T> targetClass) {
		log.info("parsing [{}] to [{}]", source.getClass(), targetClass);
		try {
			return objectMapper.convertValue(source, targetClass);
		} catch (Exception e) {
			throw new RuntimeException("No fue posible convertir el objeto a la clase [" + targetClass + "]", e);
		}
	}

}
