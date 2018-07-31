/**
 * This package is used for logging purposes like error and audit logging.
 */
package com.springiot.logging;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.logging.insert.AuditLogInsert;
import com.logging.insert.ErrorLogInsert;
import com.springiot.constant.ProcessParameter;
import com.springiot.genericService.GenericService;
import com.springiot.response.Message;

/**
 * This class is used specifically for the Logging purposes. The audit logs are
 * generated after any any api being called and error logs are generated while
 * any exception occurs while calling api.
 * 
 * @author tanvigarg
 *
 */
@Aspect
public class AOPLogging {

	@Autowired
	private GenericService genericService;

	@Autowired
	private ProcessParameter processParameter;

	@Autowired(required = true)
	private HttpServletRequest request;

	@Autowired
	private SessionFactory sessionFactory;
	static String applicationKey = "9a959887-5946-11e6-9bb0-fe984cc15272";

	/**
	 * This method is used for Audit Logging whenever any api is being called,it
	 * will display audit logs as well as insert the audit logs in the
	 * Corresponding procedure.This method uses the concept of AOP,Aspect Object
	 * Programming.
	 * 
	 * @param joinPoint,this
	 *            point could be a method being called, an exception being
	 *            thrown, or even a field being modified
	 * @param result,
	 *            this is the result obtained after any method execution.
	 * 
	 * @author tanvigarg
	 */
	@AfterReturning("execution(* com.springiot.controllers.*.*(..))")
	public void logAfterMappingHandler(JoinPoint joinPoint) {

		// Get the procedure name for the insertion of audit logs
		Map<String, Object> proParam = processParameter.getMaps();

		// applicationKey is specific by application wise

		// Retrieve organization id to insert error logs on basis of
		// Organization id
		int orgId = 0;
		// Object organizationId = 0;
		if (request.getAttribute("organization_id") != null) {

			orgId = Integer.parseInt(String.valueOf(request.getAttribute("organization_id")));

		}

		// Created object of class which is present in jar
		AuditLogInsert auditLogInsert = new AuditLogInsert();

		// Calling of method from jar for insertion of audit logs.
		auditLogInsert.insertAuditLog(joinPoint, request, sessionFactory, proParam.get("108").toString(),
				applicationKey, orgId, genericService, "executeProcesureFromLogs", Class.class, String.class,
				Object[].class);

		// System.out.println(genericService.toString());

	}

	/**
	 * This method is used for Audit Logging whenever any api which is present
	 * in ignore controllers is being called,it will display audit logs as well
	 * as insert the audit logs in the corresponding procedure.This method uses
	 * the concept of AOP,Aspect Object Programming.
	 * 
	 * @param joinPoint,this
	 *            point could be a method being called, an exception being
	 *            thrown, or even a field being modified
	 * @param result,
	 *            this is the result obtained after any method execution.
	 * 
	 * @author tanvigarg
	 */
	@AfterReturning(pointcut = "execution(* com.springiot.controllers.ignoreControllers.*.*(..))")
	public void logAfterMappingHandlerForIgnoreControllers(JoinPoint joinPoint) {

		// Get the procedure name for the insertion of audit logs
		Map<String, Object> proParam = processParameter.getMaps();

		// applicationKey is specific by application wise
		// String applicationKey = "9a959887-5946-11e6-9bb0-fe984cc15272";

		// Retrieve organization id to insert error logs on basis of
		// Organization id
		int orgId = 0;
		// Object organizationId = 0;
		if (request.getAttribute("organization_id") != null) {
			orgId = Integer.parseInt(String.valueOf(request.getAttribute("organization_id")));
		}

		// Created object of class which is present in jar
		AuditLogInsert auditLogInsert = new AuditLogInsert();

		// Calling of method from jar for insertion of audit logs.
		auditLogInsert.insertAuditLog(joinPoint, request, sessionFactory, proParam.get("108").toString(),
				applicationKey, orgId, genericService, "executeProcesureFromLogs", Class.class, String.class,
				Object[].class);

		// System.out.println(genericService.toString());
	}

	/**
	 * This method is used for Error Logging whenever any exception occurs,it
	 * will display errors as well as insert the errors in the corresponding
	 * procedure.This method uses the concept of AOP,Aspect Object Programming.
	 * 
	 * @param joinPoint,this
	 *            point could be a method being called, an exception being
	 *            thrown, or even a field being modified
	 * @param result,
	 *            this is the result obtained after any method execution.
	 * 
	 * @author tanvigarg
	 */
	@AfterReturning(pointcut = "execution(* com.springiot.controllers.*.*(..))", returning = "result")
	public void logAfterThrowingException(JoinPoint joinPoint, Object result) {

		try {
			// Retrieve organization id to insert error logs on basis of
			// Organisation id
			int organizationId = 0;
			// Object organizationId = 0;
			if (request.getAttribute("organization_id") != null) {
				organizationId = Integer.parseInt(String.valueOf(request.getAttribute("organization_id")));
			}

			// Get the procedure name for the insertion of error logs
			Map<String, Object> proParam = processParameter.getMaps();

			// applicationKey is specific by application wise
			// String applicationKey = "9a959887-5946-11e6-9bb0-fe984cc15272";

			// Created object of class which is present in jar
			ErrorLogInsert errorLogInsert = new ErrorLogInsert();

			// Casting of result into message class
			Message message = (Message) result;

			// The error logs description is in messageDesciption
			String messageDesciption = message.getDescription();

			// If message is not valid
			if (!message.isValid()) {

				// Calling of method from jar for insertion of error logs.
				errorLogInsert.errorLogInsertion(joinPoint, result, request, sessionFactory,
						proParam.get("420").toString(), applicationKey, organizationId, genericService,
						"executeProcesureFromLogs", messageDesciption, Class.class, String.class, Object[].class);

			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	/**
	 * This method is used for Error Logging whenever any exception occurs,it
	 * will display errors as well as insert the errors in the corrosponding
	 * procedure.This method uses the concept of AOP,Aspect Obbject
	 * Programming.This method is used for the package
	 * com.springiot.controllers.ignoreControllers because all the classes in
	 * this package are not considered as controllers.
	 * 
	 * @param joinPoint,this
	 *            point could be a method being called, an exception being
	 *            thrown, or even a field being modified
	 * @param result,
	 *            this is the result obtained after any method execution.
	 * 
	 * @author tanvigarg
	 */
	@AfterReturning(pointcut = "execution(* com.springiot.controllers.ignoreControllers.*.*(..))", returning = "result")
	public void logAfterThrowingError(JoinPoint joinPoint, Object result) {

		try {

			// Retrieve organization id to insert error logs on basis of
			// Organisation id

			int organizationId = 0;
			// Object organizationId = 0;
			if (request.getAttribute("organization_id") != null) {
				organizationId = Integer.parseInt(String.valueOf(request.getAttribute("organization_id")));
			}

			// Get the procedure name for the insertion of error logs
			Map<String, Object> proParam = processParameter.getMaps();

			// applicationKey is specific by application wise
			// String applicationKey = "9a959887-5946-11e6-9bb0-fe984cc15272";

			// Created object of class which is present in jar
			ErrorLogInsert errorLogInsert = new ErrorLogInsert();

			// Casting of result into message class
			Message message = (Message) result;

			// The error logs description is in messageDesciption
			String messageDesciption = message.getDescription();

			// If message is not valid
			if (!message.isValid()) {

				// Calling of method from jar for insertion of error logs.
				errorLogInsert.errorLogInsertion(joinPoint, result, request, sessionFactory,
						proParam.get("420").toString(), applicationKey, organizationId, genericService,
						"executeProcesureFromLogs", messageDesciption, Class.class, String.class, Object[].class);

			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}
}