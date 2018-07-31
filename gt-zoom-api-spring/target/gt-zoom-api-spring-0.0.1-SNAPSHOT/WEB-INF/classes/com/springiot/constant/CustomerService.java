/**
 * This package contain  class for Resource Loader
 */
package com.springiot.constant;

/**
 * To Import Classes to access their functionality
 */
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

/**
 * 
 * This class   is used to get the path Of File
 * according to the system from their file Name to access them Application
 * 
 * @author Ankita Shrothi
 *
 */
@Component
public class CustomerService implements ResourceLoaderAware {
	/**
	 * To Access the respective class Methods as their services
	 */
	private ResourceLoader resourceLoader;

	/**
	 * @return the resourceLoader
	 */
	public ResourceLoader getResourceLoader() {
		return resourceLoader;
	}

	/**
	 * @param resourceLoader
	 *            the resourceLoader to set
	 */
	public void setResourceLoader(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}

	

}
