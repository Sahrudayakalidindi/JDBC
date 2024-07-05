package newproject;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.util.Scanner;

	public class create {
		private static final String Driver = "com.mysql.cj.jdbc.Driver";
		private static final String url ="jdbc:mysql://localhost:3306/";
		private static final String username = "root";
		private static final String password = "root";
		public static void main(String[] args) {

			try {
				Scanner scr = new Scanner(System.in);
				//load the driver
				//my sql driver name com.mysql.cj.jdbc.Driver : it is used when sql version is greater than 8
				Class.forName(Driver);

				Connection conn = DriverManager.getConnection(url,username,password);
				System.out.println("Enter the databse name");
				String name="Create database " +scr.next();

				PreparedStatement pmst = conn.prepareStatement(name);  //connection between the connection and statement

				int i = pmst.executeUpdate();

				if (i>0) {
					System.out.println("Databse Created");
				}
				else {
					System.out.println("Database not created");
				}
				conn.close();
				pmst.close();


				} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}


