package cn.wit.zhangwei.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.wit.zhangwei.dao.AdminMapperDao;
import cn.wit.zhangwei.dao.CollegeMapperDao;
import cn.wit.zhangwei.dao.StudentMapperDao;
import cn.wit.zhangwei.entity.Admin;
import cn.wit.zhangwei.entity.Student;
import cn.wit.zhangwei.entity.User;
import cn.wit.zhangwei.service.services.AdminOperationUtil;

/**
 * Spring MVC �����������ֵ�� 1 ʹ��HttpServletRequest��ȡ 2 ʹ��@RequestParamע�� 3
 * ʹ���Զ����Ʒ�װΪʵ����� Spring MVC ��ҳ�洫ֵ�� 1 ʹ��ModelAndView 2 ʹ��ModelMap�������� 3 ʹ��@ModelAttributeע��
 * */
@Controller
public class LoginController {
	@Resource
	private AdminMapperDao adminMapperDao;// mapperӳ����ʵ��
	@Resource
	private StudentMapperDao studentMapperDao;
	@Resource
	private CollegeMapperDao collegeMapperDao;
	private String collegeName;
	private String collegeId;

	public void setadminMapperDao(AdminMapperDao adminMapperDao) {
		this.adminMapperDao = adminMapperDao;
	}
	
	public void setStudentMapperDao(StudentMapperDao studentMapperDao) {
		this.studentMapperDao = studentMapperDao;
	}

	public void setCollegeMapperDao(CollegeMapperDao collegeMapperDao) {
		this.collegeMapperDao = collegeMapperDao;
	}

	@RequestMapping(value="/login", method = {RequestMethod.GET})
    public String login(Model model){
		//if(!model.containsAttribute("contentModel"))
            //model.addAttribute("contentModel", new AccountLoginModel());
        return "account/login";
    }
	
	@RequestMapping("logout")
	public String logout(HttpServletRequest request){
		HttpSession session =  request.getSession(false);
		if(session != null){
			session.removeAttribute("user");
		}
		return "account/login";
	}
	@RequestMapping("errorlogin")
	public String loginerror(){
		return "role/loginerror";
	}

	@RequestMapping("mylogin")
	// @RequestParam���ָ��request����������ƺ��βν��а�
	// ͨ��required����ָ���Ĳ����Ƿ���봫��
	// ͨ��defaultValue��������Ĭ��ֵ���������û�д��룬��Ĭ��ֵ���βν��а�
	public void adminlogin(HttpServletRequest request, String username, String password, String role,
			HttpServletResponse response) throws IOException {
		if (role.equals("student")) {
			List<Student> sList = studentMapperDao.findAll();
			for (Student s : sList) {
				System.out.println(s.getXuehao());
				System.out.println(username);
				System.out.println(s.getId_card().substring(12,18));
				System.out.println(password);
				if (username.equals(s.getXuehao())
						&& password.equals(s.getPassword())) {
					//model.addAttribute("list", sList);
					collegeId = s.getCollegeId();
					collegeName = collegeMapperDao.findName(collegeId);
					User userInfo = new User(username,password,collegeId,collegeName);
					request.getSession().setAttribute("user", userInfo);
					response.sendRedirect("introduce.action");
					return;
//					return "xbfl/shouye";
				}
			}
		}
		if (role.equals("role")) {
			List<Admin> list = adminMapperDao.findAll();
			for (Admin r : list) {
				if (username.equals(r.getUserName())
						&& password.equals(r.getPassWord())) {
					if(0 == r.getRoleLevel()){
						collegeId = r.getCollegeId();
						collegeName = collegeMapperDao.findName(collegeId);
						User userInfo = new User(username,password,collegeId,collegeName);
						request.getSession().setAttribute("user", userInfo);
//						model.addAttribute("list", list);
//						return "role/superadmin";
						response.sendRedirect("shouye.action");
						return;
					}
					if(1 == r.getRoleLevel()){
						collegeId = r.getCollegeId();
						collegeName = collegeMapperDao.findName(collegeId);
						User userInfo = new User(username,password,collegeId,collegeName);
						request.getSession().setAttribute("user", userInfo);
//						model.addAttribute("list",list);
//						return "role/admin";
						response.sendRedirect("shouye.action");
						return;
					}
				}
			}
		}

//		return "role/loginerror";
		response.sendRedirect("errorlogin.action");
	}
	@RequestMapping("/querystudent")
	public String query(Model model){
		List<Student> sList = studentMapperDao.findAll();
		model.addAttribute("list",sList);
		return "role/superadmin";
	}
	@RequestMapping("addAdmin")
	public void add(HttpServletRequest request,HttpServletResponse response ,Model model){
		int id = Integer.parseInt(request.getParameter("id"));
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		int rolelevel = Integer.parseInt(request.getParameter("rolelevel"));
		String detail = request.getParameter("detail");
		String collegeId = detail.substring(0, 2);
		System.out.println(detail);
		Admin admin = new Admin(id,username,password,rolelevel,collegeId);
		AdminOperationUtil.adminOperationUtil.addAdmin(adminMapperDao, admin);
	    try {
			response.sendRedirect("superadmin.action");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@RequestMapping("updateAdmin")
	public void update(HttpServletRequest request, HttpServletResponse response, Model model){
		AdminOperationUtil.adminOperationUtil.updateAdmin(adminMapperDao, request);
		try {
			response.sendRedirect("superadmin.action");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@RequestMapping("deleteAdmin")
	public void delete(HttpServletRequest request, HttpServletResponse response){
		AdminOperationUtil.adminOperationUtil.deleteAdmin(adminMapperDao, request);
		try {
			response.sendRedirect("superadmin.action");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
