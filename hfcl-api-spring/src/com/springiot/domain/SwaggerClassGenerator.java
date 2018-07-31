package com.springiot.domain;

import java.io.File;
import java.io.FileWriter;

public class SwaggerClassGenerator {

	public static String generatePDF(String data, String path) {

		try {
			File file = new File(path);
			file.createNewFile();
			FileWriter writer = new FileWriter(file);
			writer.write(data);
			writer.flush();
			writer.close();

			return path;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

}