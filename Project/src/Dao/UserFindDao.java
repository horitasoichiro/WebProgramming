package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.User;

public class UserFindDao {
	public List<User> find(String loginId,String password,String dateStart,String dateLast) {
        Connection conn = null;
        List<User> userList = new ArrayList<User>();
        try {
            // データベースへ接続
			conn = DBManager.getConnection();
//			//SELECT文を準備
			String sql =
					"SELECT* FROM user where login_id = ? OR password = ? OR birth_date >= ? OR birth_date <= ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, loginId);
			pStmt.setString(2, password);
			pStmt.setString(3, dateStart);
			pStmt.setString(4, dateLast);

			ResultSet rs = pStmt.executeQuery();

            // 結果表に格納されたレコードの内容を
            // userインスタンスに設定し、ArrayListインスタンスに追加
            while (rs.next()) {
                String id = rs.getString("id");
                String loginID = rs.getString("login_id");
                String name = rs.getString("name");
                String birth_date = rs.getString("birth_date");
                String password2 = rs.getString("password");
                String create_date = rs.getString("create_date");
                String update_date = rs.getString("update_date");

                User user = new User(loginID, password2,name,id,birth_date,create_date,update_date);
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            // データベース切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
        return userList;
    }

}
