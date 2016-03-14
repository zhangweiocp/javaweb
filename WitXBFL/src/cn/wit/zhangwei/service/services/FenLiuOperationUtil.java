package cn.wit.zhangwei.service.services;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import cn.wit.zhangwei.dao.MajorMapperDao;
import cn.wit.zhangwei.dao.StudentMapperDao;
import cn.wit.zhangwei.dao.VoluntaryMapperDao;
import cn.wit.zhangwei.entity.Major;
import cn.wit.zhangwei.entity.Student;
import cn.wit.zhangwei.entity.User;
import cn.wit.zhangwei.entity.Voluntary;


public class FenLiuOperationUtil {
	private FenLiuOperationUtil(){
	}
	
	public static FenLiuOperationUtil fenLiuOperationUtil = new FenLiuOperationUtil();
	
	public List<Major> findMajor(MajorMapperDao majorMapperDao,StudentMapperDao studentMapperDao,HttpServletRequest request){
		User userInfo = (User)request.getSession().getAttribute("user");
		String xueHao = userInfo.getUserName();
		List<Major> majList = majorMapperDao.findMajor(xueHao);
		return majList;
	}
	
	public void addVoluntary(HttpServletRequest request,VoluntaryMapperDao voluntaryMapperDao,StudentMapperDao studentMapperDao){
		User userInfo = (User)request.getSession().getAttribute("user");
		String xueHao = userInfo.getUserName();
		String collegeId = userInfo.getCollegeId();
		List<Student> list = studentMapperDao.findStudent(xueHao, "",collegeId);
		String name = list.get(0).getName();
		String pro1 = request.getParameter("pro1");
		String pro2 = request.getParameter("pro2");
		String pro3 = request.getParameter("pro3");
		voluntaryMapperDao.addVoluntary(new Voluntary(xueHao,name,collegeId,pro1,pro2,pro3,null));
	}
	
	public void updateVoluntary(HttpServletRequest request,VoluntaryMapperDao voluntaryMapperDao){
		User userInfo = (User)request.getSession().getAttribute("user");
		String xueHao = userInfo.getUserName();
		String pro1 = request.getParameter("pro1");
		String pro2 = request.getParameter("pro2");
		String pro3 = request.getParameter("pro3");
		voluntaryMapperDao.updateVoluntary(xueHao,pro1,pro2,pro3);
	}
	
	public String xiuGai(HttpServletRequest request, StudentMapperDao studentMapperDao){
		User userInfo = (User)request.getSession().getAttribute("user");
		String xueHao = userInfo.getUserName();
		String collegeId = userInfo.getCollegeId();
		List<Student> list = studentMapperDao.findStudent(xueHao, "",collegeId);
		String name = list.get(0).getName();
		return name;
	}
}
