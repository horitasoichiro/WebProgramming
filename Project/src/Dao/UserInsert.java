package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.PassDigest;

public class UserInsert {
	public void update(String loginId, String password,String name,String birthDate) {
		Connection conn = null;
		try {

//			password暗号化
			PassDigest pass = new PassDigest();
			String passMd5 = pass.build(password);

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
			pStmt.setString(4, passMd5);
			// ResultSet rs =
			String buildSql = pStmt.toString();
			pStmt.executeUpdate();

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