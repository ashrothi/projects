/**
 * This package contain the Service class for All Third Party Application for Flint
 */
package com.springiot.services;

import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

/**
 * 
 * This class work as a Service class for Platform's API and ThirdParty
 * Integration with platform
 * 
 * @author Ankita Shrothi
 *
 */
@Service
@PropertySource(value = "classpath:/UserCreate.properties")
public class OrganizationService {

}