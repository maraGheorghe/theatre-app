package repository.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtils {

    private Properties jdbcProperties;


    public JDBCUtils(Properties jdbcProperties) {
        this.jdbcProperties = jdbcProperties;
    }

    private Connection instance = null;

    private Connection getNewConnection() {
        String url = jdbcProperties.getProperty("jdbc.url");
        String username = jdbcProperties.getProperty("jdbc.username");
        String password = jdbcProperties.getProperty("jdbc.password");
        Connection connection = null;
        try {
            if (username != null && password != null)
                connection = DriverManager.getConnection(url, username, password);
            else
                connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println("Error getting new connection: " + e);
        }
        return connection;
    }

    public Connection getConnection() {
        try {
            if(instance == null || instance.isClosed())
                instance = getNewConnection();
        } catch (SQLException e) {
            System.out.println("Error getting connection: " + e);
        }
        return instance;
    }
}
