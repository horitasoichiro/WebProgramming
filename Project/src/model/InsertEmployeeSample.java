package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertEmployeeSample {
	public static void main(String[]args) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/example", "root", "password");
			//INSERT文を準備

			String sql = "INSERT INTO employee(id,name,age)VALUES('EMP003','川島誠嗣',24)";
			//INSERT実行
			Statement stmt = conn.createStatement();
			int result = stmt.executeUpdate(sql);
			//追加された行数を出力
			System.out.println(result);
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(conn != null) {
				try {
					conn.close();
				}catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
