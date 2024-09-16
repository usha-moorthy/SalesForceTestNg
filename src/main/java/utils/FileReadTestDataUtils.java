package utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import constants.FileConstants;



public class FileReadTestDataUtils {

	public  static String readLoginPropertiesFile(String key) throws FileNotFoundException, IOException {
		Properties p = new Properties();
		p.load(new FileReader(FileConstants.LOGIN_TEST_DATA_FILE_PATH));
	//	System.out.print("p.getProperty(key) "+ p.getProperty(key));
		return p.getProperty(key);
	

}
}