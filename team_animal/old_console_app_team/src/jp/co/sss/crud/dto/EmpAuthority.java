package jp.co.sss.crud.dto;

public class EmpAuthority {
	private int authorityId;
	private EmpAuthority empAuthority;
	
	public EmpAuthority(){
	}
	
	public EmpAuthority(int authorityId, EmpAuthority empAuthority){
		this.authorityId = authorityId;
		this.empAuthority = empAuthority;
	}
	
	public int getAuthorityId() {
		return authorityId;
	}
	
	public void setAuthorityId(int authorityId) {
		this.authorityId = authorityId;
	}
	
	public EmpAuthority getEmpAuthority() {
		return empAuthority;
	}
	
	public void setEmpAuthority(EmpAuthority empAuthority) {
		this.empAuthority = empAuthority;
	}

	@Override
	public String toString() {
		return authorityId + "\t" + empAuthority.getEmpAuthority() + "\t";
	}
	
	
}
