/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.UUID;

/**
 *
 * @author 黑妹
 */
public class Property {
    public String getPropertyData(String propertyName) {
        return getProperty("configuration.properties", propertyName);
    }

    private String getProperty(String file, String property) {
        try {
            Properties properties = new Properties();

            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(file);
            assert inputStream != null;
            properties.load(inputStream);

            return properties.getProperty(property);

        } catch (IOException e) {
            System.out.println("Unable to read: " + file + " or find property: " + property + ". Error: " + e);
            return null;
        }
    }
    
    public String getRandomUUID(){
        return String.valueOf(UUID.randomUUID());
    }
}
