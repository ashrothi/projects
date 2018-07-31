/**
 * This package contains the class use to create connection with HSQL and perform real time operations.
 */
package com.springiot.controllers.ignoreControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.springiot.response.Message;
import com.springiot.services.HsqlService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author Garima Joshi This controller class contains the API which will update
 *         the real time staus of any rule using HSQL connection.
 *
 */

@ApiIgnore
@Controller
public class HsqlController {

	/**
	 * To access functionality of HsqlService service class method.
	 */

	@Autowired
	private HsqlService hsqlService;

	/**
	 * This API will update the status of any rule in HSQL database in real
	 * time.
	 * 
	 * @param driverName,
	 *            Requires the driver name of HSQL database.
	 * @param connectionUrl,
	 *            Connection url of hsql
	 * @param sql,
	 *            Requires sql query which needs to be executed @return, Return
	 *            the response message.
	 * @throws Exception
	 */

	@SuppressWarnings("static-access")
	@ApiOperation(value = "/rule/status", notes = "To change rule status in HSQL db.")
	@ApiImplicitParams({ @ApiImplicitParam(name = "driver_name", value = "driver name of HSQL is required"),
			@ApiImplicitParam(name = "connection_url", value = "Connection url of hsql"),
			@ApiImplicitParam(name = "sql", value = "Requires sql query which needs to be executed") })

	@RequestMapping(value = "/rule/status", method = RequestMethod.POST)
	public @ResponseBody Message updateHSQL(@RequestParam String driverName, String connectionUrl, String sql)
			throws Exception {
		/*
		 * Call the method to update the status of rule in HSQL database.
		 */
		Message message = hsqlService.update(driverName, connectionUrl, sql);
		/*
		 * Return the response message.
		 */
		return message;
	}
}
