package jp.co.sss.crud.dto;

public class Department {

	private Integer deptId;
	private String deptName;

	/**
	 *
	 */
	public Department() {
	}

	/**
	 * @param deptId
	 * @param deptName
	 */
	public Department(Integer deptId, String deptName) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
	}

	/**
	 * @return deptId
	 */
	public Integer getDeptId() {
		return deptId;
	}

	/**
	 * @param deptId セットする deptId
	 */
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	/**
	 * @return deptName
	 */
	public String getDeptName() {
		return deptName;
	}

	/**
	 * @param deptName セットする deptName
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", deptName=" + deptName + "]";
	}

}
