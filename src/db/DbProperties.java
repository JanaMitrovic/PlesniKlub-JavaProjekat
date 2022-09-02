/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author HP
 */
public class DbProperties {

    Properties properties;

    public DbProperties() throws FileNotFoundException, IOException {
        properties = new Properties();
        properties.load(new FileInputStream("properties.config"));
    }

    public String vratiDbPort() {
        return properties.getProperty(DbKonstante.PORT);
    }

    public String vratiDbPassword() {
        return properties.getProperty(DbKonstante.PASSWORD);
    }

    public String vratiDbUrl() {
        return properties.getProperty(DbKonstante.URL);
    }

    public String vratiDbUsername() {
        return properties.getProperty(DbKonstante.USERNAME);
    }

}
