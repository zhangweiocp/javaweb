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
 * Spring MVC 接收请求参数值： 1 使用HttpServletRequest获取 2 使用@RequestParam注解 3
 * 使用自动机制封装为实体参数 Spring MVC 向页面传值： 1 使用ModelAndView 2 使用ModelMap参数对象 3 使用@ModelAttribute注解
 * */
@Controller
public class LoginController {
	@Resource
	private AdminMapperDao adminMapperDao;// mapper映射器实例
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
	// @RequestParam里边指定request传入参数名称和形参进行绑定
	// 通过required属性指定的参数是否必须传入
	// 通过defaultValue可以设置默认值，如果参数没有传入，将默认值和形参进行绑定
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
