package com.tribbles.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Singleton used to retrieve the JDBC connection
 */
public class JDBCConfiguration {

    private static JDBCConfiguration instance;

    private JDBCConfiguration(){}

    public static JDBCConfiguration getInstance(){
        if(instance == null){
            instance = new JDBCConfiguration();
        }
        return instance;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:postgresql://samplepsql.cvit2io6ehiq.us-east-1.rds.amazonaws.com:5432/postgres?currentSchema=tribble",
                "",
                ""
        );
    }
}
