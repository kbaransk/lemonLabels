package pl.kbaranski.lemonlabels;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author krzysiek
 */
public class Database {
    private Connection connection;
    private PreparedStatement pStatement;
    
    private void initConnection() throws SQLException {
        com.mysql.jdbc.Driver.class.getName();
        String url = "jdbc:mysql://" + ConfigReader.instance().getDbHost() + ":" + ConfigReader.instance().getDbPort() + "/" + ConfigReader.instance().getDbName();
        this.connection = DriverManager.getConnection(url,ConfigReader.instance().getDbUser(), ConfigReader.instance().getDbPass());
    }
    
    private Connection getConnection() throws SQLException {
        if (connection == null)
            initConnection();
        return connection;
    }
    
    private PreparedStatement getStatement() throws SQLException {
        if (pStatement == null)
            pStatement = getConnection().prepareStatement("SELECT p.code, p.name, p.price, m.text FROM products p, measures m WHERE m.id = p.units AND p.code = ?");
        return pStatement;
    }
    
    public Product findProduct(Long code) {
        try {
            Product p = null;
            PreparedStatement preparedStatement = getStatement();
            preparedStatement.setLong(1, code);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                p = new Product(rs.getLong(1), rs.getString(2), rs.getFloat(3), rs.getString(4));
                rs.close();
            }
            return p;
        }
        catch (SQLException e) {
            return null;
        }
    }
    
    public void destroyConnection() {
        if (pStatement != null) {
            try {
                if (!pStatement.isClosed())
                    pStatement.close();
                pStatement = null;
            }
            catch (SQLException e) {
            }
        }
        
        if (connection != null) {
            try {
                if (!connection.isClosed())
                    connection.close();
                connection = null;
            }
            catch (SQLException e) {
            }
        }
    }
}
