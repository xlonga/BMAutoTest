package TestConfigUtils;

import java.io.*;
import java.util.Properties;

public class TreadConfig {

    public static Properties properties = new Properties();

    static {
        try {
            InputStream inputStream = new FileInputStream(new File("src\\main\\resources\\config.properties"));
            properties.load(inputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
