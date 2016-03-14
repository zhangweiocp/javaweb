package cn.wit.zhangwei.entity;

public class Major {
	private Integer maj_ID;
	private String maj_Name;
	private String collegeId;
	private String maj_Detail;
	public Major() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Major(Integer maj_ID, String maj_Name, String collegeId,
			String maj_Detail) {
		super();
		this.maj_ID = maj_ID;
		this.maj_Name = maj_Name;
		this.collegeId = collegeId;
		this.maj_Detail = maj_Detail;
	}
	public Integer getMaj_ID() {
		return maj_ID;
	}
	public void setMaj_ID(Integer maj_ID) {
		this.maj_ID = maj_ID;
	}
	public String getMaj_Name() {
		return maj_Name;
	}
	public void setMaj_Name(String maj_Name) {
		this.maj_Name = maj_Name;
	}
	public String getCollegeId() {
		return collegeId;
	}
	public void setCollegeId(String collegeId) {
		this.collegeId = collegeId;
	}
	public String getMaj_Detail() {
		return maj_Detail;
	}
	public void setMaj_Detail(String maj_Detail) {
		this.maj_Detail = maj_Detail;
	}
	@Override
	public String toString() {
		return "Major [maj_ID=" + maj_ID + ", maj_Name=" + maj_Name
				+ ", collegeId=" + collegeId + ", maj_Detail=" + maj_Detail
				+ "]";
	}
	
}
