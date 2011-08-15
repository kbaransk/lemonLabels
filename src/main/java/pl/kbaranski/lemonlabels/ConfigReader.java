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
        
        this.fontSizeName = config.getInt("font.size.name", 12);
        this.fontSizePrice = config.getInt("font.size.price", 18);
        this.fontSizeUnit = config.getInt("font.size.unit", 10);
        this.fontSizeSeparator = config.getInt("font.size.separator", 5);
        
        this.marginLeft = config.getFloat("margin.left", 10.0f);
        this.marginRight = config.getFloat("margin.right", 10.0f);
        this.marginTop = config.getFloat("margin.top", 15.0f);
        this.marginBottom = config.getFloat("margin.bottom", 15.0f);
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
    
    private int fontSizeName;
    private int fontSizePrice;
    private int fontSizeUnit;
    private int fontSizeSeparator;
    
    private float marginLeft;
    private float marginRight;
    private float marginTop;
    private float marginBottom;
    
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
    
    public final File getUserHomeDir() {
        return new File(System.getProperty("user.home"));
    }

    public int getFontSizeName() {
        return fontSizeName;
    }

    public int getFontSizePrice() {
        return fontSizePrice;
    }

    public int getFontSizeUnit() {
        return fontSizeUnit;
    }

    public int getFontSeparator() {
        return getFontSizeSeparator();
    }

    public int getFontSizeSeparator() {
        return fontSizeSeparator;
    }

    public float getMarginLeft() {
        return marginLeft;
    }

    public float getMarginRight() {
        return marginRight;
    }

    public float getMarginTop() {
        return marginTop;
    }

    public float getMarginBottom() {
        return marginBottom;
    }
}
