package com.adobe.myproject.impl;

import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.myproject.ISerializer;

/**
 * @author tnaroska
 */
public class JsonSerializer implements ISerializer
{
	private static final Logger LOG = LoggerFactory.getLogger(JsonSerializer.class);

	private final ObjectMapper MAPPER;


	public JsonSerializer()
	{
		MAPPER = new ObjectMapper();
		MAPPER.configure(SerializationConfig.Feature.INDENT_OUTPUT, true);
	}


	@Override
	public String serialize(Object object) throws IOException
	{
		LOG.info("serializing {}", object);

		String result = MAPPER.writeValueAsString(object);

		LOG.info("serialized {}", result);
		return result;
	}
}
