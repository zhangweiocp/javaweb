package cn.wit.zhangwei.service.services;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.wit.zhangwei.dao.StudentMapperDao;
import cn.wit.zhangwei.entity.Student;

public class StudentOperationUtil {

	private StudentOperationUtil(){
	}
	
	public static StudentOperationUtil studentOperationUtil = new StudentOperationUtil();
	
	public List<Student> findAll(StudentMapperDao studentMapperDao){
		List<Student> list = studentMapperDao.findAll();
		return list;
	}
	
	public List<Student> findStudent(StudentMapperDao studentMapperDao,String xueHao,String name,String collegeId){
		List<Student> list = studentMapperDao.findStudent(xueHao, name,collegeId);
		return list;
	}
	
	public void deleteStudent(StudentMapperDao studentMapperDao,HttpServletRequest request){
		String xueHaoString = request.getParameter("xueHaoString");
		String[] xueHao = xueHaoString.split(";");
		for(int i = 0;i < xueHao.length; i++){
			studentMapperDao.deleteStudent(xueHao[i]);
		}
	}
	public void updateStudent(StudentMapperDao studentMapperDao,HttpServletRequest request){
		String xueHao = request.getParameter("xueHao");
		String password = request.getParameter("password");
		studentMapperDao.updateStudent(xueHao, password);
	}
	public void addStudent(StudentMapperDao studentMapperDao,HttpServletRequest request,HttpServletResponse response){
		String xueHao = request.getParameter("xueHao");
		String name = request.getParameter("name");
		//String gender = request.getParameter("gender");
		String collegeId = request.getParameter("collegeId");
		String majId = null;
		String id_card = request.getParameter("id_card");
		//String phone = request.getParameter("phone");
		//String password = request.getParameter("password");
		studentMapperDao.addStudent(new Student(xueHao,name,null,collegeId,majId,id_card,null,id_card.substring(12, 18)));
		
	}

	public List<Student> findStudentByCollegeId(
			StudentMapperDao studentMapperDao, String collegeId) {
		// TODO Auto-generated method stub
		List<Student> list = studentMapperDao.findStudentByCollegeId(collegeId);
		return list;
	}
}
