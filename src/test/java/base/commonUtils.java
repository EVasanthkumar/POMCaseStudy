package base;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class commonUtils {
	
	public static String getConfigProperties(String value) throws IOException {
		 FileReader red=new FileReader("C:\\workspace\\WebDriverLaunch\\src\\test\\resources\\config.Properties");
		  Properties prop=new Properties();
		  prop.load(red);
		  return prop.getProperty(value);
	}

}
