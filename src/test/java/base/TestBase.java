package base;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

public class TestBase {


	private static TestBase base;
	private static WebDriver driver;
	
	private TestBase() throws IOException {
		String browserName=Utils.getConfigProperties("browserName");
		 if(browserName.equalsIgnoreCase("chrome"))
		  {
			 ChromeOptions cp=new ChromeOptions();
			 cp.addArguments("--incognito");
			  driver= new ChromeDriver(cp);
		  }
		  else if(browserName.equalsIgnoreCase("edge")){
			  driver= new EdgeDriver();
		  }
		 
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		 driver.manage().deleteAllCookies();
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
