package base;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestBase {

	private static TestBase base;
	private static WebDriver driver;
	
	private TestBase() throws IOException {
		
		String browserName=commonUtils.getConfigProperties("browserName");
		
		 if(browserName.equalsIgnoreCase("chrome"))
		  {
			 ChromeOptions options=new ChromeOptions();
			 options.addArguments("--incognito");
			  driver= new ChromeDriver(options);
			 driver.manage().deleteAllCookies();
		  }
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public static void initDriver() throws IOException {
		if(base==null)
		{
			base=new TestBase();
		}
	}
	
	public static WebDriver getDriver() {
		return driver;
	}
	
	public static void openUrl(String url) {
		driver.get(url);
	}
	
	public static void tearDown() {
		if(driver!=null)
		{
			driver.close();
			driver.quit();
		}
		base=null;
	}

}
