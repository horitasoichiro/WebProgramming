package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.PassDigest;

public class UserUpdateDao {
	public void update(String password, String userName, String birthdate, String id2) {
		Connection conn = null;

		try {

			// password暗号化
			PassDigest pass = new PassDigest();
			String passMd5 = pass.build(password);

			// データベースへ接続
			conn = DBManager.getConnection();

			// //update文を準備
			String sql = " UPDATE user SET password = ? , name = ? , birth_date = ? , update_date = now() WHERE id = ? ";

			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, passMd5);
			pStmt.setString(2, userName);
			pStmt.setString(3, birthdate);
			pStmt.setString(4, id2);

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

	public void update2(String userName, String birthdate, String id2) {
		Connection conn = null;

		try {
			// データベースへ接続
			conn = DBManager.getConnection();

			// //update文を準備
			String sql = " UPDATE user SET name = ? , birth_date = ? , update_date = now() WHERE id = ? ";

			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, userName);
			pStmt.setString(2, birthdate);
			pStmt.setString(3, id2);

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
