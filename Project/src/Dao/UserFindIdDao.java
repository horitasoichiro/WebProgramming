package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public class UserFindIdDao {
		public User findByOneId(String id) {
			Connection conn = null;
			try {
				//DBへ接続
				conn = DBManager.getConnection();
//				//SELECT文を準備
				String sql ="SELECT* FROM user where id =  ? and id != 1";
				PreparedStatement pStmt = conn.prepareStatement(sql);
				pStmt.setString(1, id);

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

}
