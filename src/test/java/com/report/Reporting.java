package com.report;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import baseClass.BaseClassCucumber;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class Reporting extends BaseClassCucumber {
	
	
	public static void generateJvmReport(String jsonFile) throws FileNotFoundException, IOException {
		
//		Path of JVM report
		File file = new File(getProjectPath()+getPropertyFileValue("jvm"));
		
//		Browser Details
		Configuration configuration=new Configuration(file, "Adactin Hotel Booking Automation");
		configuration.addClassifications("Browser", "Chrome");
		configuration.addClassifications("Browser Version", "107");
		configuration.addClassifications("Operating Software", "Windows 11");
		configuration.addClassifications("Spring", "35");

//		to fetch Json details
		List<String> jsonFiles=new ArrayList<String>();
		jsonFiles.add(jsonFile);
		ReportBuilder builder=new ReportBuilder(jsonFiles, configuration);
		
//		Generate JVM Files
		
		builder.generateReports();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
