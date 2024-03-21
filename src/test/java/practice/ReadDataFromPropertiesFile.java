package practice;

import java.io.FileInputStream; 
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertiesFile {

	public static void main(String[] args) throws IOException {
		
		//step 1 : Open the document in java readable format
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		
		//step 2 : Create object of Properties class from java.util
		Properties p = new Properties();
		
		//step 3 : Load the document to properties class
		p.load(fis);
		
		//step 4 : Provide the key and fetch the value
		String value = p.getProperty("username");
		System.out.println(value);
		
		String value1 = p.getProperty("password");
		System.out.println(value1);
		
		String value2 = p.getProperty("url");
		System.out.println(value2);
		
		

	}

}
