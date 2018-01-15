package Dao;

import java.util.List;

import model.User;


public class SelectUser {
    public static void main(String[] args) {
        // userテーブルの全レコードを取得
        UserDao userDao = new UserDao();
        List<User> userList = userDao.findAll();
        // 取得したレコードの内容を出力
        for (User user : userList) {
            System.out.println("ID:" + user.getLoginID());
            System.out.println("pass:" + user.getPassword());
        }
    }
}
