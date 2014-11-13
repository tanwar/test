/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tanwar.classcourt.dwr.db;

import java.sql.*;
//import org.apache.log4j.Logger;

/**
 *
 * @author Tanwar
 */
public class ConnectionManager {

    static int conn_create_count;
    static int conn_drop_count;
    //private static Logger logger = Logger.getLogger(ConnectionManager.class);

    public static Connection getConnection() {
        Connection conn = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://pemysql01.365techsupport.com:3306/I-87620_court?useServerPrepStmts=false", "ccourt", "amar@123");

            if (conn != null) {
                conn_create_count++;
               // logger.info("makeConnection: " + conn_create_count);
            } else {
                conn = null;
            }

        } catch (Exception e) {
        }

        return conn;
    }

    public static void dropConnection(Connection conn) {
        try {
            if (conn != null) {
                ++conn_drop_count;
                conn.close();
            }
        } catch (Exception e) {
        }
    }
    
    public static void main(String[] t){
        getConnection();
    }

}
