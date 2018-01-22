package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDelete {
	public void delete(String id) {
		Connection conn = null;

		try {
			// データベースへ接続
			conn = DBManager.getConnection();

			// //update文を準備
			String sql = " DELETE FROM user WHERE id = ? ";

			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, id);

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
