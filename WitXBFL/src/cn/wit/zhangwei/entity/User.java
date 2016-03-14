package cn.wit.zhangwei.entity;

public class User {
	String userName;
	String passWord;
	String collegeId;
	String collegeName;
	//String collegeName;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String userName, String passWord, String collegeId,
			String collegeName) {
		super();
		this.userName = userName;
		this.passWord = passWord;
		this.collegeId = collegeId;
		this.collegeName = collegeName;
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
		return "User [userName=" + userName + ", passWord=" + passWord
				+ ", collegeId=" + collegeId + ", collegeName=" + collegeName
				+ "]";
	}
	
}
