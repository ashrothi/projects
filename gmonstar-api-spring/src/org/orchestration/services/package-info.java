/**
 * This package contain the Service class of GlobeTouch Application IT Consist
 * of following Service:
 * 
 * 
 * AuditService: It is the service part of all audit log APIs,contains Get audit
 * log record and count API's
 * 
 * 
 * BSSService: It is the service part of all bss end node API's required by
 * GM-Onstar
 *
 *
 * ESimService:It is the service part of all Esim end node APIs required by
 * GM-Onstar
 *
 *
 * GlobeConnectService:It is the service part of all Globe Connect end node APIs
 * required by GM-Onstar
 *
 *
 * OrchestrationService:It is the service part of all Orchestration APIs which
 * will interact to all end node API's from one Method of this Service defined
 * in the controller
 *
 * GenericMethodService:-This Service contains all the Generic Methods which
 * will be accessed by all orchestration and non-orchestration APIs.For eg:
 * ## Validation 
 * ## Token Management
 * ## Transformation
 * ## Kafka Execution
 *
 * @author Ankita Shrothi
 *
 */
package org.orchestration.services;