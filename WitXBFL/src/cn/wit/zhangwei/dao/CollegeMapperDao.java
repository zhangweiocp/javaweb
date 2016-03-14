package cn.wit.zhangwei.dao;

import java.util.List;

import cn.wit.zhangwei.annotation.MyBatisDao;
import cn.wit.zhangwei.entity.College;

@MyBatisDao
public interface CollegeMapperDao {
	public List<College> findAll();
	public List<College> findAll1(String collegeId);
	public String findName(String collegeId);
}
