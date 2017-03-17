package com.apidemo.dropwizarddemo;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by markibid on 17/03/17.
 */
public class MySqlConnector {

    private static Connection connect;

    public static Connection getConnect() throws SQLException{
        if(connect==null){
            new Driver();

            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/gcm_chat?user=root&password=markibid");
        }
        return connect;
    }
}
