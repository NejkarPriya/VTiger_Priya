package Data_Driven_Testing;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Javautility_Class_Tricentis {
	public static  String logindata(String key) throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(".\\Configurefile\\LoginFunction.properties");
		prop.load(fis);
		String data = prop.getProperty(key);
		return data;
	}
}
