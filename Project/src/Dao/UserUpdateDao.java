package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserUpdateDao {
	public void update(String password,String userName,String birthdate,String id2) {
        Connection conn = null;
        String str;

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
//			ResultSet rs =
			String buildSql =pStmt.toString();
			pStmt.executeUpdate();

            // 結果表に格納されたレコードの内容を
            // userインスタンスに設定し、ArrayListインスタンスに追加
//            while (rs.next()) {
//                String id = rs.getString("id");
//                String loginID = rs.getString("login_id");
//                String name = rs.getString("name");
//                String birth_date = rs.getString("birth_date");
//                String password2 = rs.getString("password");
//                String create_date = rs.getString("create_date");
//                String update_date = rs.getString("update_date");
//
//                User user = new User(loginID, password2,name,id,birth_date,create_date,update_date);
//                userList.add(user);
//            }
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


