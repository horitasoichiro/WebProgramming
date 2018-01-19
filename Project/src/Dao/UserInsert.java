package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserInsert {
	public void update(String loginId, String password,String name,String birthDate) {
		Connection conn = null;
		try {
			// データベースへ接続
			conn = DBManager.getConnection();

			// //update文を準備



			String sql =
					" INSERT INTO user ( login_id , name , birth_date , password , create_date , update_date ) "
					+ " VALUES ( ? , ? , ? , ? , now() , now() ) ";

			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, loginId);
			pStmt.setString(2, name);
			pStmt.setString(3, birthDate);
			pStmt.setString(4, password);
			// ResultSet rs =
			String buildSql = pStmt.toString();
			pStmt.executeUpdate();

			// 結果表に格納されたレコードの内容を
			// userインスタンスに設定し、ArrayListインスタンスに追加
			// while (rs.next()) {
			// String id = rs.getString("id");
			// String loginID = rs.getString("login_id");
			// String name = rs.getString("name");
			// String birth_date = rs.getString("birth_date");
			// String password2 = rs.getString("password");
			// String create_date = rs.getString("create_date");
			// String update_date = rs.getString("update_date");
			//
			// User user = new User(loginID,
			// password2,name,id,birth_date,create_date,update_date);
			// userList.add(user);
			// }
		} catch (SQLException e) {
			e.printStackTrace();
			e = null;
		} finally {
			// データベース切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					conn = null;
				}
			}
		}
	}
}