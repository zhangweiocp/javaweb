package cn.wit.zhangwei.dao;

import java.util.List;

import cn.wit.zhangwei.annotation.MyBatisDao;
import cn.wit.zhangwei.entity.Student;
@MyBatisDao
public interface StudentMapperDao {
	public List<Student> findAll();
	public List<Student> findStudent(String xueHao,String name,String collegeId);
	public List<Student> findStudent1(String xueHao,String name);
	public void addStudent(Student student);
	public void deleteStudent(String xueHao);
	public void updateStudent(String xueHao,String password);
	public List<Student> findStudentByCollegeId(String collegeId);
}
