package com.adobe.myproject.impl;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import com.adobe.myproject.ISerializer;

/**
 * @author tnaroska
 *
 */
public class Activator implements BundleActivator
{
	private ServiceRegistration<ISerializer> registration;


	@Override
	public void start(BundleContext context) throws Exception
	{
		registration = context.registerService(ISerializer.class, new JsonSerializer(), null);
	}


	@Override
	public void stop(BundleContext context) throws Exception
	{
		registration.unregister();
	}
}
