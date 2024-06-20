package com.report;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.base.BaseClass;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class Reporting extends BaseClass {
	public static void generateJvmReport(String jsonFile) {

		File f = new File("C:\\Users\\HP\\eclipse-workspace11\\AdactinDinesh\\target");

		// import net.masterthought.cucumber.Configuration;
		// have to import manually ...This system not suggest

		Configuration configuration = new Configuration(f, "Adactin Automation");

		configuration.addClassifications("OS", "WIN11");
		configuration.addClassifications("Browser", "Chrome");
		configuration.addClassifications("Browser Version", "106");
		configuration.addClassifications("Sprint", "35");

		List<String> jsonFiles = new ArrayList<String>();
		jsonFiles.add(jsonFile);

		ReportBuilder builder = new ReportBuilder(jsonFiles, configuration);
		builder.generateReports();

	}
}