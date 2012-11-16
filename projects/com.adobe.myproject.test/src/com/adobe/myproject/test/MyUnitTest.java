package com.adobe.myproject.test;

import static java.lang.Boolean.TRUE;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

import com.adobe.myproject.ISerializer;

/**
 * @author tnaroska
 */
public class MyUnitTest
{
	private ServiceTracker<ISerializer, ISerializer> tracker;

	private ISerializer serializer;

	// -------------------------------------------------------------------------------------     Setup

	@Before
	public void setup() throws Exception
	{
		BundleContext ctx = FrameworkUtil.getBundle(getClass()).getBundleContext();

		tracker = new ServiceTracker<ISerializer, ISerializer>(ctx, ISerializer.class, null);
		tracker.open();

		serializer = tracker.waitForService(3000);
		assertNotNull("ISerializer not found", serializer);
	}

	@After
	public void teardown()
	{
		tracker.close();
	}

	// -------------------------------------------------------------------------------------     Tests

	@Test
	public void greatSuccess() throws IOException
	{
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("key1", "value");
		map.put("key2", 112);
		map.put("key3", TRUE);

	
		String result =  serializer.serialize(map);
		
		assertNotNull(result);
		assertTrue(!result.isEmpty());
	}
}
