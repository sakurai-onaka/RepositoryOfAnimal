package jp.co.sss.crud.main;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.dto.Department;
import jp.co.sss.crud.dto.EmpAuthority;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.io.AuthorityIdReader;
import jp.co.sss.crud.io.DeptIdReader;
import jp.co.sss.crud.io.EmployeeBirthdayReader;
import jp.co.sss.crud.io.EmployeeGenderReader;
import jp.co.sss.crud.io.EmployeeIdReader;
import jp.co.sss.crud.io.EmployeeNameReader;
import jp.co.sss.crud.io.EmployeePasswordReader;
import jp.co.sss.crud.io.MenuNoReader;
import jp.co.sss.crud.io.loginCheck;

/**
 * 社員管理システム実行用クラス
 */
public class MainSystem02ImplementsValid {
	/**
	 * ログイン者の権限を保持
	 */
	public static int loginUserAuthority = 9;

	/**
	 * メイン処理02
	 * 
	 * <p>各入力チェック機能から更新対象項目の任意選択までを実装し、このクラスで呼び出す。
	 * 
	 * <p>入力項目ごとのクラスを実装しコンソールから必要な項目を入力する。
	 * 不正な入力値の場合は例外処理し、メニュー番号の入力から再度行う。
	 * 
	 * <p>例外処理は以下の2つのcatchブロックに分ける
	 * <p>(IOException | ClassNotFoundException | SQLException e)
	 * 	"システムエラーが発生しました"と出力し、スタックトレースを出力する。
	 * 	その後、ループを抜けてシステムを終了する。
	 * 
	 * <p>(IllegalArgumentException e)
	 * ブロック内でエラーメッセージを出力する。
	 * {@code System.out.println(e.getMessage());}
	 * その後、continueしてループに戻る。
	 * 
	 *
	 */
	public static void main(String[] args) {

		/**
		 * エンティティ
		 */
		Employee employee = new Employee();
		Department department = new Department();

		/**
		 * データベースアクセス
		 */
		EmployeeDAO employeeDAO = new EmployeeDAO();
		
		loginCheck.loginInput();

		int menuNo = 0;
		do {
			/**
			 * メニューの表示
			 */
			System.out.println("=== 社員管理システム ===");
			System.out.println("1. 全件表示");
			System.out.println("2. 社員名検索");
			System.out.println("3. 部署ID検索");
			System.out.println("4. 登録");
			System.out.println("5. 更新");
			System.out.println("6. 削除");
			System.out.println("7. 終了");
			System.out.print("メニュー番号を入力してください:");

			try {

				/**
				 * TODO メニュー番号の入力
				 */
				MenuNoReader menuNoReader = new MenuNoReader();
				menuNo = menuNoReader.input();

				EmployeeNameReader employeeNameReader = new EmployeeNameReader();
				EmployeeIdReader employeeIdReader = new EmployeeIdReader();
				EmployeeGenderReader employeeGenderReader = new EmployeeGenderReader();
				EmployeeBirthdayReader employeeBirthdayReader = new EmployeeBirthdayReader();
				DeptIdReader deptIdReader = new DeptIdReader();
				AuthorityIdReader authIdReader = new AuthorityIdReader();
				EmployeePasswordReader empPassReader = new EmployeePasswordReader();

				int empNo = 0;
				String empName = null;
				Integer empGender = 0;
				String empBirthday = null;
				Integer empDeptIdReader = 0;
				Integer empAuthId = 0;
				String empPass = null;

				/**
				 * 機能の呼出
				 */
				switch (menuNo) {

				case 1:
					/**
					 *全件検索
					 *全件検索処理はMainSystem01NonValidと同一である。
					 */
					if (MainSystem02ImplementsValid.loginUserAuthority == 1) {
						System.out.println("社員ID\t社員名\t部署名");
					} else {
						System.out.println("社員ID\t社員名\t性別\t生年月日\t部署名\t権限名");
					}
					List<Employee> employees;

					try {
						employees = employeeDAO.findAll();

						for (Employee emp : employees) {
							System.out.println(emp);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;

				case 2:
					/**
					*社員名検索
					TODO 以下に実装する
					*/
					System.out.print("社員名を入力してください:");

					empName = employeeNameReader.input();

					if (MainSystem02ImplementsValid.loginUserAuthority == 1) {
						System.out.println("社員ID\t社員名\t部署名");
					} else {
						System.out.println("社員ID\t社員名\t性別\t生年月日\t部署名\t権限名");
					}
					try {
						employees = employeeDAO.findByEmployeeName(empName);

						for (Employee emp : employees) {
							System.out.println(emp);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}

					break;

				case 3:
					/**
					*部署ID検索
					*TODO 以下に実装する
					*/
					System.out.print("部署ID(1：営業部、2：経理部、3：総務部)を入力してください: ");
					empDeptIdReader = deptIdReader.input();
					if (MainSystem02ImplementsValid.loginUserAuthority == 1) {
						System.out.println("社員ID\t社員名\t部署名");
					} else {
						System.out.println("社員ID\t社員名\t性別\t生年月日\t部署名\t権限名");
					}

					try {
						employees = employeeDAO.findByDeptId(empDeptIdReader);

						for (Employee emp : employees) {
							System.out.println(emp);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;

				case 4:
					/**
					*登録機能
					*TODO 以下に実装する
					*/
					System.out.print("社員名:");
					empName = employeeNameReader.input();
					System.out.print("性別(0:回答しない, 1:男性, 2:女性, 9:その他):");
					empGender = employeeGenderReader.input();
					System.out.print("生年月日(西暦年/月/日):");
					empBirthday = employeeBirthdayReader.input();
					System.out.print("部署ID(1:営業部、2:経理部、3:総務部):");
					empDeptIdReader = deptIdReader.input();
					System.out.print("パスワード:");
					empPass = empPassReader.input();
					System.out.print("権限:");
					empAuthId = authIdReader.input();

					employee = new Employee(null, empName, empGender, empBirthday,
							new Department(empDeptIdReader, null), empPass, new EmpAuthority(empAuthId, null));
					employeeDAO.insert(employee);

					break;

				case 5:
					/**
					*更新機能
					*TODO 以下に実装する
					*/

					System.out.print("更新する社員の社員IDを入力してください:");
					empNo = employeeIdReader.input();
					System.out.print("社員名:");
					empName = employeeNameReader.input();
					System.out.print("性別(0:回答しない, 1:男性, 2:女性, 9:その他):");
					empGender = employeeGenderReader.input();
					System.out.print("生年月日(西暦年/月/日):");
					empBirthday = employeeBirthdayReader.input();
					System.out.print("部署ID(1:営業部、2:経理部、3:総務部):");
					empDeptIdReader = deptIdReader.input();
					System.out.print("パスワード:");
					empPass = empPassReader.input();
					System.out.print("権限:");
					empAuthId = authIdReader.input();
					employee = new Employee(empNo, empName, empGender, empBirthday,
							new Department(empDeptIdReader, null), empPass, new EmpAuthority(empAuthId, null));

					employeeDAO.updateOptional(employee);

					break;

				case 6:
					/**
					*削除機能
					* TODO 以下に実装する
					*/
					System.out.print("削除する社員の社員IDを入力してください:");
					empNo = employeeIdReader.input();
					employeeDAO.deleteByFlag(empNo);

					break;
				}

			} catch (IOException | ClassNotFoundException | SQLException e) {//case 1 全件検索を実装するとコンパイルエラーは解消する
				/**
				 * TODO 以下に実装する
				 */
				System.out.println("システムエラーが発生しました");
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				/**
				 * TODO 以下に実装する
				 */
				System.out.println(e.getMessage());
			}
		} while (menuNo != 7);
		System.out.println("システムを終了します。");
	}

}
