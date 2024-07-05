package newproject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class insert {
	private static final String Driver = "com.mysql.cj.jdbc.Driver";

	private static final String username = "root";
	private static final String password = "root";
	public static void main(String[] args) {

		try {
			Scanner scr= new Scanner(System.in);
			System.out.println("enter the database name :");
			String url ="jdbc:mysql://localhost:3306/"+scr.next();

			Class.forName(Driver);

			Connection conn = DriverManager.getConnection(url,username,password);
			System.out.println("Enter the table name");
			String name="insert into " +scr.next()+"(id,name,email) values(?,?,?)" ;

			PreparedStatement pmst = conn.prepareStatement(name); 
			System.out.println("enter Id");
			pmst.setInt(1, scr.nextInt());
			System.out.println("enter name");
			pmst.setString(2, scr.next());
			System.out.println("enter email");
			pmst.setString(3, scr.next());

			int i = pmst.executeUpdate();

			if (i>0) {
				System.out.println("data inserted");
			}
			else {
				System.out.println("data not inserted");
			}
			conn.close();
			pmst.close();


			} catch (Exception e) {
			e.printStackTrace();
		}
	}

}



