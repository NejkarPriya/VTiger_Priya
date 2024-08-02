public class JavaUtility {
	public static String logindata(String key) throws IOException {
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(".\\Confiqurefile\\LoginFunction.properties");
		prop.load(fis);
		String data=prop.getProperty(key);
		return data;	
	}
}
