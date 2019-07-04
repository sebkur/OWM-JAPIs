package net.aksingh.owmjapis;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Testing {

    public static String loadApiKey() {
        Properties properties = new Properties();
        try (InputStream input = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("secure.properties")) {
            properties.load(input);
            return (String) properties.get("api.key");
        } catch (IOException e) {
            System.err.println(
                    "Error while loading api key. Make sure 'api.key' is defined in 'src/test/resources/secure.properties'");
        }
        return null;
    }

}
