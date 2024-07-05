package newproject;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
import java.sql.Connection;

public class delete {

public static void main(String[] args) {
	try {
		Scanner scr =new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","root");
		System.out.println("enter data base name");
		String sql=" create database "+scr.next();
		PreparedStatement pmst =conn.prepareStatement(sql);
		int i=pmst.executeUpdate();
		if (i>0) {
			System.out.println("Database is created");
		}
		else
		{
			System.out.println("Database is notcreated");
		}
		pmst.close();
		conn.close();
	} catch (Exception e) {
		// TODO: handle exception
	}
	
}
}
