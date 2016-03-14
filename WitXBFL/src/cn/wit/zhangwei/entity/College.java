package cn.wit.zhangwei.entity;

public class College {
	String collegeId;
	String collegeName;
	public College() {
		super();
		// TODO Auto-generated constructor stub
	}
	public College(String collegeId, String collegeName) {
		super();
		this.collegeId = collegeId;
		this.collegeName = collegeName;
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
		return "College [collegeId=" + collegeId + ", collegeName="
				+ collegeName + "]";
	}

}
