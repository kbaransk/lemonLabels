/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kbaranski.lemonlabels;

/**
 *
 * @author krzysiek
 */
public class ConfigReader {
    private ConfigReader() {
        this.dbHost = "localhost";
        this.dbPort = "3602";
        this.dbUser = "root";
        this.dbPass = "masterkey";
        this.fontName = "Ubuntu";
        this.fontDir = "/usr/share/fonts/truetype/ubuntu-font-family";
    }
    
    private static ConfigReader configReader = null;

    private String dbUser;
    private String dbPass;
    private String dbHost;
    private String dbPort;
    
    private String fontName;
    private String fontDir;
    
    public static ConfigReader instance() {
        if (configReader == null)
            configReader = new ConfigReader();
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

    public String getFontName() {
        return fontName;
    }

    public String getFontDir() {
        return fontDir;
    }    
}
