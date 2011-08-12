/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kbaranski.lemonlabels;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

/**
 *
 * @author krzysiek
 */
public class ConfigReader {
    private ConfigReader() throws ConfigurationException {
        
        PropertiesConfiguration config = new PropertiesConfiguration(new File(getUserHomeDir(), ".lemonLabels.properties"));
        
        this.dbHost = config.getString("db.host", "localhost");
        this.dbPort = config.getString("db.port", "3306");
        this.dbUser = config.getString("db.user", "root");
        this.dbPass = config.getString("db.pass");
        this.dbName = config.getString("db.name", "mysql");
        this.fontName = config.getString("font.name", "Ubuntu");
        this.fontDir = config.getString("font.dir", "/usr/share/fonts/truetype/ubuntu-font-family");
        this.priceFormat = config.getString("price.format", "#0.00");
    }
    
    private static ConfigReader configReader = null;

    private String dbUser;
    private String dbPass;
    private String dbHost;
    private String dbPort;
    private String dbName;
    
    private String fontName;
    private String fontDir;
    
    private String priceFormat;
    
    public static ConfigReader instance() {
        if (configReader == null) {
            try {
                configReader = new ConfigReader();
            } catch (ConfigurationException ex) {
                Logger.getLogger(ConfigReader.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return configReader;
    }

    public String getDbUser() {
        return dbUser;
    }

    public String getDbPass() {
        return dbPass;
    }

    public String getDbHost() {
        return dbHost;
    }

    public String getDbPort() {
        return dbPort;
    }

    public String getDbName() {
        return dbName;
    }

    public String getFontName() {
        return fontName;
    }

    public String getFontDir() {
        return fontDir;
    }

    public String getPriceFormat() {
        return priceFormat;
    }
    
    public File getUserHomeDir() {
        return new File(System.getProperty("user.home"));
    }
}
