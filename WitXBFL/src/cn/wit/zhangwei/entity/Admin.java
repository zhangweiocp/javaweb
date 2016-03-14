package cn.wit.zhangwei.entity;

public class Admin {
	private Integer id;
	private String userName;
	private String passWord;
	private Integer roleLevel;
	private String collegeId;
	
	public Admin() {
		super();
	}

	public Admin(Integer id,String userName, String passWord,
			Integer roleLevel,String collegeId)
	{
		super();
		this.id=id;
		this.userName = userName;
		this.passWord = passWord;
		this.roleLevel = roleLevel;
		this.collegeId = collegeId;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public Integer getRoleLevel() {
		return roleLevel;
	}

	public void setRoleLevel(Integer roleLevel) {
		this.roleLevel = roleLevel;
	}

	public String getCollegeId() {
		return collegeId;
	}

	public void setDetail(String collegeId) {
		this.collegeId = collegeId;
	}

	@Override
	public String toString() {
		return "Role [detail=" + collegeId + ", id=" + id + ", passWord="
				+ passWord + ", roleLevel=" + roleLevel + ", userName="
				+ userName + "]";
	}

}

