package cn.wit.zhangwei.service.services;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;


import cn.wit.zhangwei.dao.AdminMapperDao;
import cn.wit.zhangwei.entity.Admin;
import cn.wit.zhangwei.entity.AdminManage;

public class AdminOperationUtil {
	
	private AdminOperationUtil(){
		
	}
	
	static public AdminOperationUtil adminOperationUtil = new AdminOperationUtil();

	public List<AdminManage> findAll(AdminMapperDao adminMapperDao){
		List<AdminManage> list = adminMapperDao.findAll1();
		return list;
	}
	
	public List<AdminManage> findAdmin(AdminMapperDao adminMapperDao,String userName,String detail){
		List<AdminManage> list = adminMapperDao.findAdmin(userName, detail);
		return list;
	}
	
	public int findMaxID(AdminMapperDao adminMapperDao){
		int maxID = adminMapperDao.findMaxID();
		return maxID;
	}
	
	public void addAdmin(AdminMapperDao adminMapperDao,Admin admin){
		adminMapperDao.addAdmin(admin);
	}
	public void deleteAdmin(AdminMapperDao adminMapperDao,HttpServletRequest request){
		String idString = request.getParameter("id");
		String[] s = null;
		if(null != idString){
		  s = idString.split(";");
		}
		for(int i=0;i<s.length;i++){
			int id = Integer.parseInt(s[i]);
			adminMapperDao.deleteAdmin(id);
		}
	}
	public void updateAdmin(AdminMapperDao adminMapperDao,HttpServletRequest request){
		int id = Integer.parseInt(request.getParameter("id"));
		String username = request.getParameter("userName");
		String password = request.getParameter("password");
		String detail = request.getParameter("detail");
		adminMapperDao.updateAdmin(new Admin(id,username,password,0,detail));
	}
}
