package cn.wit.zhangwei.dao;

import java.util.List;

import cn.wit.zhangwei.annotation.MyBatisDao;
import cn.wit.zhangwei.entity.Admin;
import cn.wit.zhangwei.entity.AdminManage;

@MyBatisDao
public interface AdminMapperDao {
	public List<Admin> findAll();
	public List<AdminManage> findAll1();
	public List<AdminManage> findAll2(String collegeId);
	public List<AdminManage> findAdmin(String userName,String detail);
	public List<AdminManage> findAdmin1(String userName,String detail);
	public int findMaxID();
	public void updateAdmin(Admin admin);
	public void deleteAdmin(int id);
	public void addAdmin(Admin admin);
}
