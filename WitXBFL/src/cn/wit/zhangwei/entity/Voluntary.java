package cn.wit.zhangwei.entity;

public class Voluntary {
	private String xueHao;
	private String name;
	private String collegeId;
	private String pro1;
	private String pro2;
	private String pro3;
	private String final_pro;
	public Voluntary() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Voluntary(String xueHao, String name, String collegeId, String pro1,
			String pro2, String pro3, String final_pro) {
		super();
		this.xueHao = xueHao;
		this.name = name;
		this.collegeId = collegeId;
		this.pro1 = pro1;
		this.pro2 = pro2;
		this.pro3 = pro3;
		this.final_pro = final_pro;
	}
	public String getXueHao() {
		return xueHao;
	}
	public void setXueHao(String xueHao) {
		this.xueHao = xueHao;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCollegeId() {
		return collegeId;
	}
	public void setCollegeId(String collegeId) {
		this.collegeId = collegeId;
	}
	public String getPro1() {
		return pro1;
	}
	public void setPro1(String pro1) {
		this.pro1 = pro1;
	}
	public String getPro2() {
		return pro2;
	}
	public void setPro2(String pro2) {
		this.pro2 = pro2;
	}
	public String getPro3() {
		return pro3;
	}
	public void setPro3(String pro3) {
		this.pro3 = pro3;
	}
	public String getFinal_pro() {
		return final_pro;
	}
	public void setFinal_pro(String final_pro) {
		this.final_pro = final_pro;
	}
	@Override
	public String toString() {
		return "Voluntary [xueHao=" + xueHao + ", name=" + name
				+ ", collegeId=" + collegeId + ", pro1=" + pro1 + ", pro2="
				+ pro2 + ", pro3=" + pro3 + ", final_pro=" + final_pro + "]";
	}
	
}
