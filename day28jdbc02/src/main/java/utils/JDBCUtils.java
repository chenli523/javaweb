package utils;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    static String user;
    static String password;
    static String url;
    // will only load one time
    static {
        // properties
        Properties properties = new Properties();
//        properties.load(new FileInputStream(new File("/Users/a123/IdeaProjects/javaweb/day27jdbc01/src/main/java/com/atguigu/test.properties")));
        try {
            properties.load(JDBCUtils.class.getClassLoader().getResourceAsStream("jdbc.properties"));
            // 1 driver manager
            Class.forName(properties.getProperty("driver"));
            url = properties.getProperty("url");
            user = properties.getProperty("user");
            password = properties.getProperty("password");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    // 1.get connection
    public static Connection getConnection() throws ClassNotFoundException, SQLException, IOException {
//        // properties
//        Properties properties = new Properties();
////        properties.load(new FileInputStream(new File("/Users/a123/IdeaProjects/javaweb/day27jdbc01/src/main/java/com/atguigu/test.properties")));
//        properties.load(JDBCUtils.class.getClassLoader().getResourceAsStream("jdbc.properties"));
//        // 1 driver manager
//        Class.forName(properties.getProperty("driver"));
        // 2 connection
        Connection connection = DriverManager.getConnection(url, user, password);
        return connection;
    }
    // 2.close resources
    public static void closeResources(Connection connection, Statement statement, ResultSet resultSet) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
