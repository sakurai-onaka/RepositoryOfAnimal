package jp.co.sss.crud.dto;

public class EmpAuthority {
	private Integer authorityId;
	private String authorityName;

	public EmpAuthority() {
	}

	public EmpAuthority(Integer authorityId, String authorityName) {
		super();
		this.authorityId = authorityId;
		this.authorityName = authorityName;
	}

	public Integer getAuthorityId() {
		return authorityId;
	}

	public void setAuthorityId(int authorityId) {
		this.authorityId = authorityId;
	}

	public String getAuthorityName() {
		return authorityName;
	}

	public void setAuthorityName(String authorityName) {
		this.authorityName = authorityName;
	}

	@Override
	public String toString() {
		return "EmpAuthority [authorityId=" + authorityId + "authorityName=" + authorityName + "]";
	}

}
