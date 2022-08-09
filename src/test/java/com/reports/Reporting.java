package com.reports;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

/**
 * 
 * @author Suresh Kumar G
 * @Description To contains JVM reporting file
 * @CreationDate 27/06/2022
 */
public class Reporting {
/**
 * 
 * @param jsonFile
 * @Description Used to perform generate JVM report
 * @CreationDate 27/06/2022
 */
	public static void generateJVMReport(String jsonFile) {

		File file = new File(System.getProperty("user.dir") + "/target");
		Configuration configuration = new Configuration(file, "OMR Branch API");
		configuration.addClassifications("OS", "WIN11");
		configuration.addClassifications("Browser", "Chrome");
		List<String> jsonFiles = new ArrayList<String>();
		jsonFiles.add(jsonFile);

		ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
		reportBuilder.generateReports();

	}

}
