package utils;
import io.github.cdimascio.dotenv.Dotenv;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static final Dotenv dotenv = Dotenv.load();
    private static final Properties properties = new Properties();

        static{
        try (InputStream inputStream = ConfigReader.class.getClassLoader().getResourceAsStream("config/framework.properties")){
            if (inputStream == null)
            {
                throw new RuntimeException("Unable to find framework properties file");
            }
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException("Unable to load framework properties" + e);
        }
    }

    public static String getFromEnvVariables(String key) {
        return dotenv.get(key);
    }

    public static String getFromPropertiesVariables(String key)
    {
        return properties.getProperty(key);
    }
}

//mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="codegen https://automationteststore.com"
//mvn test -Dcucumber.filter.name="Login as existing customer"