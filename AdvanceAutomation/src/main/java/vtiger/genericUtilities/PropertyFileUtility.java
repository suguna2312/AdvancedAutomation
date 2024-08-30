package vtiger.genericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * This class consist of methods to read data from property file
 * @author Hp
 *
 */

public class PropertyFileUtility {
	/**
	 * This method will read the data from property file provided key
	 * @param key
	 * @return
	 * @throws IOException
	 */
	
	public String toReadDataFromPropertyFile(String key) throws IOException {
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\commonData.properties");
		Properties prop=new Properties();
		prop.load(fis);
		String value = prop.getProperty(key);
		
		return value;
	}

}
