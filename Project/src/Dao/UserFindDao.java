package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.User;

public class UserFindDao {
	public List<User> find(String loginId,String userName,String dateStart,String dateLast) {
        Connection conn = null;
        List<User> userList = new ArrayList<User>();
        try {
            // データベースへ接続
			conn = DBManager.getConnection();

//			if(dateStart == "") {
//				dateStart = null;
//			}
//			if(dateLast == "") {
//				dateLast = null;
//        }
//			//SELECT文を準備
			List<String> pram = new ArrayList<String>();

			StringBuilder sql = new StringBuilder();

			  sql.append(" SELECT * FROM user WHERE ");
			  if(loginId != "") {
//				  sql.append(" login_id = '" + loginId + "' AND ");
				  sql.append(" login_id = ? AND ");
				  pram.add(loginId);
			  }
			  if(userName != "") {
//				  sql.append(" name = '" + userName + "' AND ");
				  userName = "%" + userName + "%";
				  sql.append(" name LIKE ? AND ");
				  pram.add(userName);
			  }
			  if(dateStart != "") {
//				  sql.append(" birth_date >= '" + dateStart + "' AND ");
				  sql.append(" birth_date >= ? AND ");
				  pram.add(dateStart);
			  }
			  if(dateLast != "") {
//				  sql.append(" birth_date <= '" + dateLast + "' AND ");
				  sql.append(" birth_date <= ? AND ");
				  pram.add(dateLast);
			  }
			  sql.append(" id <> 1 ");
			  String buildSql = sql.toString();


//			  sql.append("   ");
//			  sql.append("     hoge");
//			  sql.append("  ) ");
//			  sql.append(" values (?) ");



//			String sql =
//					"SELECT* FROM user where login_id = ? OR name = ? OR birth_date >= ? OR birth_date <= ? ";
			PreparedStatement pStmt = conn.prepareStatement(buildSql);

			for(int i = 0; i < pram.size(); i++) {
				pStmt.setString(i+1, pram.get(i));
			}
//			pStmt.setString(1, loginId);
//			pStmt.setString(2, userName);
//			pStmt.setString(3, dateStart);
//			pStmt.setString(4, dateLast);
			String str = pStmt.toString();

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
