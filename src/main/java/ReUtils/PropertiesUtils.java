package ReUtils;


import org.testng.annotations.Test;

import java.io.*;
import java.util.Properties;

/**
 * 读取配置文件
 */
public class PropertiesUtils {

    public static Properties properties = new Properties();
    static {
        //静态代码块，只会执行一次  不经常更改的配置数据，

        try {
            InputStream inputStream = new FileInputStream(new File("src\\main\\resources\\config.properties"));

            properties.load(inputStream);//数据加载到properties对象中


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //调用配置数据
    public static void main(String[] args) {
        String type = PropertiesUtils.properties.getProperty("api.content.type.form");
        System.out.println(type);
    }

}

