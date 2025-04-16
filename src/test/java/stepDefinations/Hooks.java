package stepDefinations;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import base.TestBase;

import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

public class Hooks {
	
	@BeforeAll
	public static void setupDriver() throws IOException {
		TestBase.initDriver();
	}

	@AfterTest
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			TakesScreenshot screen = (TakesScreenshot) TestBase.getDriver();
			byte[] imgBytes = screen.getScreenshotAs(OutputType.BYTES);
			scenario.attach(imgBytes, "image/png", "ScreenImage");
		}
		TestBase.tearDown();
	}

}
