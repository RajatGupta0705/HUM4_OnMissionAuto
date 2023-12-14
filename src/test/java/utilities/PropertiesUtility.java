package utilities;

import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.util.Properties;

public class PropertiesUtility {
    public static String getPropertyValue(String filePath , String propertyName) throws Exception{
        File f = new File(filePath);
        FileReader fr = new FileReader(f);

        Properties p = new Properties();
        p.load(fr);

        return p.getProperty(propertyName);

    }
}
