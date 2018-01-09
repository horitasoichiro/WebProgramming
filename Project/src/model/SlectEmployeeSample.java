package model;

import java.util.List;

import Dao.EmployeeDao;

public class SlectEmployeeSample {
	public static void main(String[]args) {
		//employeeテーブルの全レコード取得
		EmployeeDao empDao = new EmployeeDao();
		List<Employee>empList = empDao.findAll();

		//取得したレコードの内容を出力
		for(Employee emp : empList) {
			System.out.println("ID:"+ emp.getId());
			System.out.println("名前:"+ emp.getName());
			System.out.println("年齢:"+ emp.getAge());
			System.out.println("出力確認１");
		}
		Employee emp = empDao.findById("'EMP002'");
		System.out.println("ID:"+ emp.getId());
		System.out.println("名前:"+ emp.getName());
		System.out.println("年齢:"+ emp.getAge());
		System.out.println("出力確認２");

		Employee emp2 = empDao.findById("'' OR '' = ''");
		System.out.println("ID:" + emp2.getId());
		System.out.println("名前:" + emp2.getName());
		System.out.println("年齢:" + emp2.getAge());

	}

}
