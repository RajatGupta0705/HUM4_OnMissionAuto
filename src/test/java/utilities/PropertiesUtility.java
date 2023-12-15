package utilities;

import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.util.Properties;

public class PropertiesUtility
{    public static String getPropertyValue(String filePath , String propertyName) throws Exception
   {
        File f = new File(filePath); // take the file path
        FileReader fr = new FileReader(f); // take the read permission
        Properties p = new Properties();
        p.load(fr); // load into ram
        return p.getProperty(propertyName);
    }
}
