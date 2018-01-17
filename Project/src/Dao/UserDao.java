package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.User;

public class UserDao {
	public User findById(String loginID,String password) {
		Connection conn = null;
		try {
			//DBへ接続
			conn = DBManager.getConnection();
//			//SELECT文を準備
			String sql ="SELECT* FROM user where login_id =  ? and password = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, loginID);
			pStmt.setString(2, password);
			ResultSet rs = pStmt.executeQuery();
           // 主キーに紐づくレコードは1件のみなので、rs.next()は1回だけ行う
			if (!rs.next()) {
				return null;
			}
			String rsLoginID = rs.getString("login_id");
			String rsPassword = rs.getString("password");
			String rsName = rs.getString("name");
			String rsid = rs.getString("id");
			String rsBirth_date = rs.getString("birth_date");
			String rsCreate_date = rs.getString("create_date");
			String rsUpdate_date = rs.getString("update_date");

			User user = new User(rsLoginID, rsPassword,rsName,
					rsid,rsBirth_date,rsCreate_date,rsUpdate_date);

			return  user;
	}catch (SQLException e) {
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



	//管理者以外のユーザを一覧で取得する
	public List<User> findAll() {
        Connection conn = null;
        List<User> userList = new ArrayList<User>();
        try {
            // データベースへ接続
            conn = DBManager.getConnection();
            // SELECT文を準備
            String sql = "SELECT id, login_id, name, birth_date, password, create_date, update_date FROM user  WHERE id <> 1";
             // SELECTを実行し、結果表を取得
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // 結果表に格納されたレコードの内容を
            // userインスタンスに設定し、ArrayListインスタンスに追加
            while (rs.next()) {
                String id = rs.getString("id");
                String loginID = rs.getString("login_id");
                String name = rs.getString("name");
                String birth_date = rs.getString("birth_date");
                String password = rs.getString("password");
                String create_date = rs.getString("create_date");
                String update_date = rs.getString("update_date");

                User user = new User(loginID, password,name,id,birth_date,create_date,update_date);
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