package jp.co.sss.crud.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.main.MainSystem02ImplementsValid;

public class loginCheck {
	
	public static void loginInput() throws IOException, IllegalArgumentException, ClassNotFoundException, SQLException{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	EmployeeDAO employeeDAO = new EmployeeDAO();
	
	boolean loginCheck = false;

	while(!loginCheck){
		System.out.print("社員ID:");
		String empId = br.readLine();
		int checkEmpId = Integer.parseInt(empId);
				
		System.out.print("パスワード:");
		String checkPassword = br.readLine();

		if(employeeDAO.login(checkEmpId, checkPassword)){
			System.out.println("ログインに成功しました。");
			loginCheck = true;
			int autoNo = employeeDAO.checkAuthority(checkEmpId);
			if(autoNo == 1) {
				MainSystem02ImplementsValid.loginUserAuthority = 1;
			}else {
				MainSystem02ImplementsValid.loginUserAuthority = 9;
			}
		}else{
			System.out.println("ログインに失敗しました。");
		}
	}
}
}
