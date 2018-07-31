package com.rld.main;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

import org.json.JSONException;

import com.rld.apicalling.*;
import com.rld.vendorId.vendorId;

import rld.common.RLDEncryption;
import rld.common.impl.RLDEncrytionImpl;

public class Test {

	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException, JSONException {

		System.out.println("Execute");

		SDKExecution execute = new SDKExecution();

		/*
		 * execute.pushDemographicData("3 Apr 2016", " 6 Apr 2016", "1", "1,2",
		 * true, true, true, "", "", "", "", "orgadmin@barc.com",
		 * "d2714ccb-3f4c-4c78-8247-38f965248c8d");
		 */

//		Object response = RLD.GetDemographicData("orgadmin@barc.com", "d2714ccb-3f4c-4c78-8247-38f965248c8d");
//		System.out.println("FROM TEST CLASS" + response);

		// execute.pushMasters("orgadmin1@barc.com",
		// "420619e7-d23d-41ad-995e-e452cc6a9684");

	}

}
