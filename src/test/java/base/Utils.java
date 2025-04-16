package base;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Utils {
	
	public static String getConfigProperties(String value) throws IOException {
		 FileReader red=new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
		  Properties prop=new Properties();
		  prop.load(red);
		  return prop.getProperty(value);
		
	}

}
