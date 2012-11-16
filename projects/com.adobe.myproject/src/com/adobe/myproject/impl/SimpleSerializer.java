package com.adobe.myproject.impl;

import java.io.IOException;

import com.adobe.myproject.ISerializer;

/**
 * @author tnaroska
 */
public class SimpleSerializer implements ISerializer
{
	@Override
	public String serialize(Object object) throws IOException
	{
		return object.toString();
	}
}
