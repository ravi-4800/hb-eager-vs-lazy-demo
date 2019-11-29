package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false&serverTimezone=UTC";
		String user = "hbstudent";
		String pass = "hbstudent";
		
		try {
			
			System.out.println("Connecting to Database...: " + url);
			
			Connection conn = DriverManager.getConnection(url, user, pass);
			
			System.out.println("Connection successful!!!");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
