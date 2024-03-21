package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SampleGenericMethod_myown_ {
	public static String properties_utility (String data) throws IOException {
		
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p = new Properties();
		p.load(fis);
		return p.getProperty(data);
		
		
	}

}
