package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Employee;

public class EmployeeDao {
	public List<Employee>findAll(){
		Connection conn = null;
		List<Employee>empList = new ArrayList<Employee>();

		try {
			//DBへ接続
			conn = DBmanager.getConnection();
			String sql = "SELECT id,name,age FROM employee";
			//SELECTを実行し、結果表を取得
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			//結果表に格納されたレコードの内容を
			//Employeeインスタンスに設定し、ArrayListインスタンスに追加
			while(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				Employee employee = new Employee(id,name,age);
				empList.add(employee);
			}
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			//DB切断
			if(conn != null) {
				try {
					conn.close();
				}catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return empList;
	}
	public Employee findById(String targetId) {
		Connection conn = null;
		try {
			//DBへ接続
			conn = DBmanager.getConnection();
//			//SELECT文を準備
			String sql = "SELECT id,name,age FROM employee WHERE id = " + targetId;

			//SELECTを実行し、結果表を取得
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
//			//主キーに紐づくレコードは一件のみなので、rs.next()は一回だけ行う
//
			 // SELECT文を準備
//			String sql = "SELECT id, name, age FROM employee WHERE id = ?";
//			 // SELECTを実行し、結果表を取得
//			PreparedStatement pStmt = conn.prepareStatement(sql);
//			pStmt.setString(1, targetId);
//			ResultSet rs = pStmt.executeQuery();


			if(!rs.next()) {
				return null;
			}
			String id = rs.getString("id");
			String name = rs.getString("name");
			int age = rs.getInt("age");
			return new Employee(id,name,age);
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			//DB切断
			if(conn != null) {
				try {
					conn.close();
				}catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
	}
}
