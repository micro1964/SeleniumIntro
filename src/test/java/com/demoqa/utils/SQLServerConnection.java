package com.demoqa.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLServerConnection {

	public static void main(String[] args) {

        String url = "jdbc:sqlserver://localhost:1433;databaseName=BookStore;encrypt=true;trustServerCertificate=true;";
        //String url = "jdbc:sqlserver://WCITY-DEV;databaseName=BookStore;encrypt=true;trustServerCertificate=true;";
		//String url = "jdbc:sqlserver://WCITY-DEV;Database=BookStore;IntegratedSecurity=true;";
        String username = "developer"; // Replace with your SQL Server username
        String password = "developer"; // Replace with your SQL Server password

        //try (Connection conn = DriverManager.getConnection(url)) {
        try (Connection conn = DriverManager.getConnection(url,username,password)) {
            System.out.println("Connected to SQL Server successfully!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


	}

}
