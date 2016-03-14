package cn.wit.zhangwei.entity;

public class AdminManage {
	private Integer id;
	private String userName;
	private String passWord;
	private Integer roleLevel;
	private String collegeId;
	private String collegeName;
	public AdminManage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AdminManage(Integer id, String userName, String passWord,
			Integer roleLevel, String collegeId, String collegeName) {
		super();
		this.id = id;
		this.userName = userName;
		this.passWord = passWord;
		this.roleLevel = roleLevel;
		this.collegeId = collegeId;
		this.collegeName = collegeName;
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
	public void setCollegeId(String collegeId) {
		this.collegeId = collegeId;
	}
	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	@Override
	public String toString() {
		return "AdminManage [id=" + id + ", userName=" + userName
				+ ", passWord=" + passWord + ", roleLevel=" + roleLevel
				+ ", collegeId=" + collegeId + ", collegeName=" + collegeName
				+ "]";
	}
	
}
