package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
  
  private static Properties prop;
  
  static {
    prop = new Properties();
    try {
      FileInputStream files = new FileInputStream("suitesCRM-URL.properties");
      prop.load(files);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  
  public static String getProperty(String key) {
    String value = prop.getProperty(key);
    return value;
  }
}
