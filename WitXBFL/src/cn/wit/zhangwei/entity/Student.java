package cn.wit.zhangwei.entity;

public class Student {
	private String xuehao;
	private String name;
	private String gender;
	private String collegeId;
	private String majId;
	private String id_card;
	private String phone;
	private String password;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(String xuehao, String name, String gender, String collegeId,
			String majId, String id_card, String phone, String password) {
		super();
		this.xuehao = xuehao;
		this.name = name;
		this.gender = gender;
		this.collegeId = collegeId;
		this.majId = majId;
		this.id_card = id_card;
		this.phone = phone;
		this.password = password;
	}
	public String getXuehao() {
		return xuehao;
	}
	public void setXuehao(String xuehao) {
		this.xuehao = xuehao;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCollegeId() {
		return collegeId;
	}
	public void setCollegeId(String collegeId) {
		this.collegeId = collegeId;
	}
	public String getMajId() {
		return majId;
	}
	public void setMajId(String majId) {
		this.majId = majId;
	}
	public String getId_card() {
		return id_card;
	}
	public void setId_card(String id_card) {
		this.id_card = id_card;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Student [xuehao=" + xuehao + ", name=" + name + ", gender="
				+ gender + ", collegeId=" + collegeId + ", majId=" + majId
				+ ", id_card=" + id_card + ", phone=" + phone + ", password="
				+ password + "]";
	}
}
