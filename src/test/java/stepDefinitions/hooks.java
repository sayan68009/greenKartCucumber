package stepDefinitions;

import java.io.IOException;
import java.io.*;

import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import utils.TestContextSetup;

public class hooks {
	
	TestContextSetup testContextSetup;
	
	public hooks(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
	}
		
		@After
		public void afterScenario() {
			testContextSetup.testBase.quit();
		}
		
		@AfterStep
		public void addScreenshot(Scenario scenario) throws IOException {
			WebDriver driver = testContextSetup.testBase.webDriverManager();
			if(scenario.isFailed()) {
				File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				byte[] fileContent = FileUtils.readFileToByteArray(sourceFile);
				scenario.attach(fileContent, "image/png", "image");
			}
		}
	}
	

