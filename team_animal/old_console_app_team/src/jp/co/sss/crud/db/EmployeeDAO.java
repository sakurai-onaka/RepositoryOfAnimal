package jp.co.sss.crud.db;

import static jp.co.sss.crud.util.ConstantSQL.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.co.sss.crud.dto.Department;
import jp.co.sss.crud.dto.Employee;





/**
 * データベース操作用クラス
 * DAOのメソッドをSystemMainクラスで呼び出す
 */
public class EmployeeDAO {

	/**
	 * 全件表示
	 *
	 * @return {@code List<Employee>} 全社員エンティティリスト
	 * @throws ClassNotFoundException ドライバクラスが存在しない場合に送出
	 * @throws SQLException データベース操作時にエラーが発生した場合に送出
	 */
	public List<Employee> findAll() throws ClassNotFoundException, SQLException {
		List<Employee> employees = new ArrayList<>();
		/**
		 * TODO 以下に実装する
		 */
		Employee employee = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = DBManager.getConnection();
			preparedStatement = connection.prepareStatement(SQL_FIND_ALL);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				employee = new Employee();
				employee.setEmpId(resultSet.getInt("emp_id"));
				employee.setEmpName(resultSet.getString("emp_name"));
				employee.setGender(resultSet.getInt("gender"));
				employee.setBirthday(resultSet.getString("birthday"));
				employee.setDepartment(new Department(null, resultSet.getString("dept_name")));

				employees.add(employee);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(connection);
			DBManager.close(preparedStatement);
			DBManager.close(resultSet);
		}
		return employees;
	}

	/**
	 * 社員名検索
	 * 
	 * @param searchName 検索社員名 
	 * @return {@code List<Employee>} 検索社員名を含むエンティティリスト
	 * @throws ClassNotFoundException ドライバクラスが存在しない場合に送出
	 * @throws SQLException データベース操作時にエラーが発生した場合に送出
	 */
	public List<Employee> findByEmployeeName(String searchName) throws ClassNotFoundException, SQLException {
		List<Employee> employees = new ArrayList<>();
		/**
		 * TODO 以下に実装する
		 */
		Employee employee = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = DBManager.getConnection();
			preparedStatement = connection.prepareStatement(SQL_FIND_BY_EMP_NAME);
			preparedStatement.setString(1, "%" + searchName + "%");
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				employee = new Employee();
				employee.setEmpId(resultSet.getInt("emp_id"));
				employee.setEmpName(resultSet.getString("emp_name"));
				employee.setGender(resultSet.getInt("gender"));
				employee.setBirthday(resultSet.getString("birthday"));
				employee.setDepartment(new Department(null, resultSet.getString("dept_name")));
				employees.add(employee);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(connection);
			DBManager.close(preparedStatement);
			DBManager.close(resultSet);
		}

		return employees;
	}

	/**
	 * 部署ID検索
	 * 
	 * @param deptId
	 * @return {@code List<Employee>} 検索部署IDを含むエンティティリスト
	 * @throws ClassNotFoundException ドライバクラスが存在しない場合に送出
	 * @throws SQLException データベース操作時にエラーが発生した場合に送出
	 */
	public List<Employee> findByDeptId(int deptId) throws ClassNotFoundException, SQLException {
		List<Employee> employees = new ArrayList<>();
		/**
		 * TODO 以下に実装する
		 */
		Employee employee = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = DBManager.getConnection();
			preparedStatement = connection.prepareStatement(SQL_FIND_BY_DEPTID);
			preparedStatement.setInt(1, deptId);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				employee = new Employee();
				employee.setEmpId(resultSet.getInt("emp_id"));
				employee.setEmpName(resultSet.getString("emp_name"));
				employee.setGender(resultSet.getInt("gender"));
				employee.setBirthday(resultSet.getString("birthday"));
				employee.setDepartment(new Department(null, resultSet.getString("dept_name")));

				employees.add(employee);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(connection);
			DBManager.close(preparedStatement);
			DBManager.close(resultSet);
		}
		return employees;
	}

	/**
	 * 登録
	 * <br>引数のEmployeeから社員名、性別、生年月日、部署番号を取得し新たな社員情報を生成する。
	 * <br>社員IDは自動採番機能を用いること
	 * @param employee
	 * @throws ClassNotFoundException ドライバクラスが存在しない場合に送出
	 * @throws SQLException データベース操作時にエラーが発生した場合に送出
	 */
	public void insert(Employee employee) throws ClassNotFoundException, SQLException {
		/**
		 * TODO 以下に実装する
		 */
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DBManager.getConnection();
			preparedStatement = connection.prepareStatement(SQL_INSERT);
			preparedStatement.setString(1, employee.getEmpName());
			preparedStatement.setInt(2, employee.getGender());
			preparedStatement.setString(3, employee.getBirthday());
			preparedStatement.setInt(4, employee.getDepartment().getDeptId());
			int cnt = preparedStatement.executeUpdate();
			if(cnt == 1){
				System.out.println("社員情報を登録しました");
			}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(connection);
				DBManager.close(preparedStatement);
			}
	}

	/**
	 * 社員情報を1件更新する
	 * <br>引数のEmployeeから社員ID、社員名、性別、生年月日、部署番号を取得し社員情報を更新する。
	 * @param employee
	 * @throws ClassNotFoundException ドライバクラスが存在しない場合に送出
	 * @throws SQLException データベース操作時にエラーが発生した場合に送出
	 */
	public void update(Employee employee) throws ClassNotFoundException, SQLException {
		//TODO 以下に実装する
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = DBManager.getConnection();
			preparedStatement = connection.prepareStatement(SQL_UPDATE);
			
			System.out.print("更新する社員の社員IDを入力してください:");
			int empId = Integer.parseInt(br.readLine());
			System.out.print("社員名:");
			String empName = br.readLine();
			System.out.print("性別(0:回答しない, 1:男性, 2:女性, 9:その他):");
			int gender = Integer.parseInt(br.readLine());
			System.out.print("生年月日(西暦年/月/日):");
			String birthday = br.readLine();
			System.out.print("部署ID(1:営業部、2:経理部、3:総務部):");
			int dept_id = Integer.parseInt(br.readLine());
			
			preparedStatement.setInt(5, empId);
			preparedStatement.setString(1, empName);
			preparedStatement.setInt(2, gender);
			preparedStatement.setString(3, birthday);
			preparedStatement.setInt(4, dept_id);
			
			int cnt = preparedStatement.executeUpdate();
			
			if(cnt != 0) {
			System.out.println("社員情報を更新しました。");
			}else {
				System.out.println("対象者がいませんでした");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(connection);
			DBManager.close(preparedStatement);
		}
	}

	/**
	 * 入力された項目のみ社員情報を1件更新する
	 * <p>引数のEmployeeから社員ID、社員名、性別、生年月日、部署番号を取得し社員情報を更新する。
	 * <p>buildSQLメソッドを呼び出し、employeeインスタンスの各フィールドがnullでない場合はSQLのSET句に変更するカラムとプレースホルダを結合する
	 * <p>bindParameterメソッドを呼び出し、組み立てたSQLに応じて値をプレースホルダにバインドする
	 * 
	 * @param employee
	 * @throws ClassNotFoundException ドライバクラスが存在しない場合に送出
	 * @throws SQLException データベース操作時にエラーが発生した場合に送出
	 */
	public void updateOptional(Employee employee) throws ClassNotFoundException, SQLException {
		//TODO 以下に実装する

	}

	/**
	 * Employeeインスタンスのフィールドがnull出ない場合、SQLのSET句にプレースホルダを結合する。
	 * 全てのフィールドがnullの場合、nullをreturnする。
	 * 
	 * @param employee
	 * @return sqlString 結合したSQL文
	 */
	private String buildSQL(Employee employee) {

		StringBuilder sqlBuilder = new StringBuilder(SQL_UPDATE_BASE);
		boolean shouldUpdate = false;

		/*空文字でない場合は更新句をSQLに結合する*/
		if (employee.getEmpName() != null) {
			sqlBuilder.append(" emp_name = ?,");
			shouldUpdate = true;
		}

		if (employee.getGender() != null) {
			sqlBuilder.append(" gender = ?,");
			shouldUpdate = true;
		}

		if (employee.getBirthday() != null) {
			sqlBuilder.append(" birthday = ?,");
			shouldUpdate = true;
		}

		if (employee.getDepartment().getDeptId() != null) {
			sqlBuilder.append(" dept_id = ?,");
			shouldUpdate = true;
		}

		//変更点がない場合はnullを戻す
		if (!shouldUpdate) {
			return null;
		}

		//末尾のカンマを削除
		sqlBuilder.deleteCharAt(sqlBuilder.length() - 1);
		//WHERE句の結合
		sqlBuilder.append(" WHERE emp_id = ?");
		//String型への変換
		String sqlString = sqlBuilder.toString();

		return sqlString;

	}

	/**
	 * 入力値に応じて結合したUPDATE文のプレースホルダに対して値をバインドする
	 * 
	 * @param updateSQL
	 * @param employee
	 * @param preparedStatement
	 * @throws SQLException
	 */
	private void bindParameter(String updateSQL, Employee employee, PreparedStatement preparedStatement)
			throws SQLException {

		int paramIndex = 1;

		/*更新句がある場合はプレースホルダにバインドする*/
		if (updateSQL.contains("emp_name")) {
			preparedStatement.setString(paramIndex, employee.getEmpName());
			paramIndex++;
		}

		if (updateSQL.contains("gender")) {
			// 性別をバインド
			preparedStatement.setInt(paramIndex, employee.getGender());
			paramIndex++;
		}

		if (updateSQL.contains("birthday")) {
			// 誕生日をバインド
			preparedStatement.setString(paramIndex, employee.getBirthday());
			paramIndex++;
		}

		if (updateSQL.contains("dept_id")) {
			// 部署IDをバインド
			preparedStatement.setInt(paramIndex, employee.getDepartment().getDeptId());
			paramIndex++;
		}

		// WHERE句をバインド
		preparedStatement.setInt(paramIndex, employee.getEmpId());

	}

	/**
	 * 社員情報を1件削除する
	 * <br>引数のEmployeeから社員IDから社員情報を削除する。
	 * @param empId 
	 * @throws ClassNotFoundException ドライバクラスが存在しない場合に送出
	 * @throws SQLException データベース操作時にエラーが発生した場合に送出
	 */
	public void delete(Integer empId) throws ClassNotFoundException, SQLException {
		/**
		 * TODO 以下に実装する
		 */
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DBManager.getConnection();
			preparedStatement = connection.prepareStatement(SQL_DELETE);
			preparedStatement.setInt(1, empId);
			int cnt = preparedStatement.executeUpdate();
			if(cnt >= 1){
				System.out.println("社員情報を削除しました");
			}else{
				System.out.println("対象者がいませんでした");
			}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(connection);
				DBManager.close(preparedStatement);
			}

	}

}
