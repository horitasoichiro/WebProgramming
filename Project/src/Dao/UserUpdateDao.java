package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserUpdateDao {
	public void update(String password,String userName,String birthdate,String id2) {
        Connection conn = null;

        try {
            // データベースへ接続
			conn = DBManager.getConnection();

//			//update文を準備
			String sql = " UPDATE user SET password = ? , name = ? , birth_date = ? , update_date = now() WHERE id = ? ";

			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, password);
			pStmt.setString(2, userName);
			pStmt.setString(3, birthdate);
			pStmt.setString(4, id2);

			String buildSql =pStmt.toString();
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


