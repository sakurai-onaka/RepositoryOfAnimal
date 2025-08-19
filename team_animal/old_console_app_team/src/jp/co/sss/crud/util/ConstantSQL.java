package jp.co.sss.crud.util;

/**
 * SQL文の管理用クラス
 */
public class ConstantSQL {

	/**
	 * インスタンス化禁止
	 */
	private ConstantSQL() {
	}

	/** SQL文(全件検索) */
	public static String SQL_FIND_ALL = "SELECT emp_id, emp_name, gender, TO_CHAR(birthday, 'yyyy/MM/dd') AS birthday, dept_name FROM employee e INNER JOIN department d ON e.dept_id = d.dept_id ORDER BY emp_id";

	/** SQL文(社員名検索) */
	public static String SQL_FIND_BY_EMP_NAME = "SELECT emp_id, emp_name, gender, TO_CHAR(birthday, 'yyyy/MM/dd') AS birthday, dept_name FROM employee e INNER JOIN department d ON e.dept_id = d.dept_id WHERE emp_name LIKE ? ORDER BY emp_id";

	/** SQL文(部署検索) */
	public static String SQL_FIND_BY_DEPTID = "SELECT emp_id, emp_name, gender, TO_CHAR(birthday, 'yyyy/MM/dd') AS birthday, dept_name FROM employee e INNER JOIN department d ON e.dept_id = d.dept_id WHERE e.dept_id = ? ORDER BY emp_id";

	/** 登録 */
	public static final String SQL_INSERT = "INSERT INTO employee VALUES (seq_emp.nextval,?,?,?,?)";

	/** 更新 */
	public static final String SQL_UPDATE = "UPDATE employee SET emp_name = ?, gender = ?, birthday = ?, dept_id = ? WHERE emp_id = ?";

	/** 削除 */
	public static final String SQL_DELETE = "DELETE FROM employee WHERE emp_id = ?";

	/** 任意項目の更新の結合ベース */
	public static final String SQL_UPDATE_BASE = "UPDATE employee SET ";
}
