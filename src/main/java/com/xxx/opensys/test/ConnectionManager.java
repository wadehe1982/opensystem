package com.xxx.opensys.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	
	private static ThreadLocal<Connection> connectionHolder = new ThreadLocal<Connection>(){

		@Override
		protected Connection initialValue() {
			System.out.println("xxxx");
			 Connection conn = null;  
	            try {  
	                conn = DriverManager.getConnection(  
	                        "jdbc:mysql://localhost:3306/test", "root",  
	                        "root");  
	            } catch (SQLException e) {  
	                e.printStackTrace();  
	            }  
	            return conn;  
		}
	};

	public static Connection getConnection() {  
        return connectionHolder.get();  
    }  
  
    public static void setConnection(Connection conn) {  
        connectionHolder.set(conn);  
    } 
}
