package cn.wit.zhangwei.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;



import cn.wit.zhangwei.dao.AdminMapperDao;
import cn.wit.zhangwei.dao.CollegeMapperDao;
import cn.wit.zhangwei.dao.MajorMapperDao;
import cn.wit.zhangwei.dao.StudentMapperDao;
import cn.wit.zhangwei.dao.VoluntaryMapperDao;
import cn.wit.zhangwei.entity.Admin;
import cn.wit.zhangwei.entity.AdminManage;
import cn.wit.zhangwei.entity.College;
import cn.wit.zhangwei.entity.Major;
import cn.wit.zhangwei.entity.Student;
import cn.wit.zhangwei.entity.User;
import cn.wit.zhangwei.entity.Voluntary;
import cn.wit.zhangwei.service.services.AdminOperationUtil;
import cn.wit.zhangwei.service.services.FenLiuOperationUtil;
import cn.wit.zhangwei.service.services.StudentOperationUtil;

@Controller
public class DispatchController {
	@Resource
	private AdminMapperDao adminMapperDao;// mapper映射器实例
	@Resource
	private StudentMapperDao studentMapperDao;
	@Resource
	private MajorMapperDao majorMapperDao;
	@Resource
	private VoluntaryMapperDao voluntaryMapperDao;
	@Resource 
	private CollegeMapperDao collegeMapperDao;

	
	public void setStudentMapperDao(StudentMapperDao studentMapperDao) {
		this.studentMapperDao = studentMapperDao;
	}
	
	
	public void setAdminMapperDao(AdminMapperDao adminMapperDao) {
		this.adminMapperDao = adminMapperDao;
	}

	public void setProfessionMapperDao(MajorMapperDao majorMapperDao) {
		this.majorMapperDao = majorMapperDao;
	}

	public void setVoluntaryMapperDao(VoluntaryMapperDao voluntaryMapperDao) {
		this.voluntaryMapperDao = voluntaryMapperDao;
	}

	public CollegeMapperDao getCollegeMapperDao() {
		return collegeMapperDao;
	}


	public void setCollegeMapperDao(CollegeMapperDao collegeMapperDao) {
		this.collegeMapperDao = collegeMapperDao;
	}


	@RequestMapping("shouye")
	public String toShouYe(){
		return "role/superadmin";
	}
	@RequestMapping("superadmin")
	public String adminList(HttpServletRequest request,Model model){
		User userInfo = (User)request.getSession().getAttribute("user");
		String collegeId = userInfo.getCollegeId();
		List<AdminManage> list;
		if(collegeId.equals("62")){
			list = AdminOperationUtil.adminOperationUtil.findAll(adminMapperDao);
		}else{
		    list = adminMapperDao.findAll2(collegeId);	
		}
		model.addAttribute("list", list);
		int maxID = AdminOperationUtil.adminOperationUtil.findMaxID(adminMapperDao);
		model.addAttribute("maxID", maxID);
		int totalSize = 0;
		if(list != null){
			totalSize = list.size();
		}
		model.addAttribute("totalSize", totalSize);
		//查询所有的学院
		List<College> colList = null;
		if(collegeId.equals("62")){
			colList = collegeMapperDao.findAll();
		}else{
			colList = collegeMapperDao.findAll1(collegeId);
		}
		//List<College> colList =  collegeMapperDao.findAll();
		model.addAttribute("colList", colList);
		return "role/superadmin1";
	}
	@RequestMapping("findAdmin")
	public String adminList1(HttpServletRequest request,Model model){
		User userInfo = (User)request.getSession().getAttribute("user");
		String collegeId = userInfo.getCollegeId();
		String userName = request.getParameter("userName");
		String detail = request.getParameter("detail");
		List<AdminManage> list = null;
		if(collegeId.equals("62")){
			list = AdminOperationUtil.adminOperationUtil.findAdmin(adminMapperDao, userName, detail);
		}else{
			list = adminMapperDao.findAdmin1(userName, collegeId);
		}
		model.addAttribute("list", list);
		int maxID = AdminOperationUtil.adminOperationUtil.findMaxID(adminMapperDao);
		model.addAttribute("maxID", maxID);
		return "role/superadmin1";
	}
	@RequestMapping("student")
	public String studentList(HttpServletRequest request,Model model){
		List<Student> list = StudentOperationUtil.studentOperationUtil.findAll(studentMapperDao);
		model.addAttribute("list", list);
		return "role/student";
	}
	@RequestMapping("findStudent")
	public String studentList1(HttpServletRequest request,Model model){
		String xueHao = request.getParameter("xueHao");
		String name = request.getParameter("name");
		User userInfo = (User)request.getSession().getAttribute("user");
		String collegeId = userInfo.getCollegeId();
		System.out.println(xueHao);
		System.out.println(name);
		List<Student> list;
		if(collegeId.equals("62")){
			list = studentMapperDao.findStudent1(xueHao, name);
		}else{
			list = StudentOperationUtil.studentOperationUtil.findStudent(studentMapperDao, xueHao, name,collegeId);
		}
		model.addAttribute("list", list);
		return "role/student";
	}

	@RequestMapping("findStudentByCollegeId")
	public String studentList2(HttpServletRequest request,Model model){
		User userInfo = (User)request.getSession().getAttribute("user");
		String collegeId = userInfo.getCollegeId();
		List<Student> list = null;
		List<College> colList;
		if(collegeId.equals("62")){
			list = StudentOperationUtil.studentOperationUtil.findAll(studentMapperDao);
			colList = collegeMapperDao.findAll();
		}else{
			list = StudentOperationUtil.studentOperationUtil.findStudentByCollegeId(studentMapperDao,collegeId);
			colList = collegeMapperDao.findAll1(collegeId);
		}
		model.addAttribute("colList", colList);
		model.addAttribute("list", list);
		return "role/student";
	}
	@RequestMapping("search")
	public String search(HttpServletRequest request,Model model){
		User userInfo = (User)request.getSession().getAttribute("user");
		String collegeId = userInfo.getCollegeId();
		String xueHao = request.getParameter("xueHao");
		String name = request.getParameter("name");
		List<Voluntary> list;
		if(collegeId.equals("62")){
			list = voluntaryMapperDao.search1(xueHao, name);
		}else{
			list = voluntaryMapperDao.search(xueHao, name, collegeId);
		}
		model.addAttribute("list", list);
		return "enroll/enroll";
	}
	@RequestMapping("deleteStudent")
	public void deleteStudent(HttpServletRequest request,HttpServletResponse response){
		StudentOperationUtil.studentOperationUtil.deleteStudent(studentMapperDao, request);
		try {
			response.sendRedirect("findStudentByCollegeId.action");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@RequestMapping("updateStudent")
	public void updateStudent(HttpServletRequest request,HttpServletResponse response){
		StudentOperationUtil.studentOperationUtil.updateStudent(studentMapperDao, request);
		try {
			response.sendRedirect("findStudentByCollegeId.action");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@RequestMapping("addStudent")
	public void addStudent(HttpServletRequest request,HttpServletResponse response,Model model){
		String xueHao = request.getParameter("xueHao");
		String name = request.getParameter("name");
		//String gender = request.getParameter("gender");
		String collegeId = request.getParameter("collegeId").substring(0,2);
		String majId = null;
		String id_card = request.getParameter("id_card");
		//String phone = request.getParameter("phone");
		//String password = request.getParameter("password");
		try{
			studentMapperDao.addStudent(new Student(xueHao,name,null,collegeId,majId,id_card,null,id_card.substring(12, 18)));
		}catch (Exception e) {
			// TODO: handle exception
			try {
				response.sendRedirect("addError.action");
				return;
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		try {
			//StudentOperationUtil.studentOperationUtil.addStudent(studentMapperDao, request,response);
			response.sendRedirect("findStudentByCollegeId.action");
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
	}
	@RequestMapping("introduce")
	public String introduce(){
		return "xbfl/shouye";
	}
	@RequestMapping("xuanba")
	public String xuanba(){
		return "xbfl/xuanba";
	}
	@RequestMapping("fenliu")
	public String fenliu(Model model,HttpServletRequest request){
		List<Major> list = FenLiuOperationUtil.fenLiuOperationUtil.findMajor(majorMapperDao,studentMapperDao,request);
		System.out.println(list.size());
		model.addAttribute("list", list);
		return "xbfl/fenliu";
	}
	@RequestMapping("selectVol")
	public void selectPro(HttpServletRequest request,HttpServletResponse response){
		try{
			FenLiuOperationUtil.fenLiuOperationUtil.addVoluntary(request,voluntaryMapperDao,studentMapperDao);
		}catch(Exception e){
			FenLiuOperationUtil.fenLiuOperationUtil.updateVoluntary(request, voluntaryMapperDao);
		}
		try {
			response.sendRedirect("introduce.action");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@RequestMapping("xiugai")
	public String xiuGai(HttpServletRequest request,Model model){
		String name = FenLiuOperationUtil.fenLiuOperationUtil.xiuGai(request, studentMapperDao);
		model.addAttribute("name", name);
		return "xbfl/xiugaimima";
	}
	@RequestMapping("modifyPassWord")
	public String modifyPassWord(HttpServletRequest request,Model model){
		User userInfo = (User)request.getSession().getAttribute("user");
		String xueHao = userInfo.getUserName();
		System.out.println(xueHao);
		String name = FenLiuOperationUtil.fenLiuOperationUtil.xiuGai(request, studentMapperDao);
		model.addAttribute("name",name);
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");
		
		if(password1.equals(password2)){
			studentMapperDao.updateStudent(xueHao, password1);
			System.out.println(password1);
			System.out.println(password2);
		}
		return "xbfl/xiugaimima";
	}
	@RequestMapping("voluntaryInfo")
	public String voluntaryInfo(HttpServletRequest request,Model model){
		String pro1="无";
		String pro2="无";
		String pro3="无";
		String final_pro="未公布";
		User userInfo = (User)request.getSession().getAttribute("user");
		String xueHao = userInfo.getUserName();
		String name = FenLiuOperationUtil.fenLiuOperationUtil.xiuGai(request, studentMapperDao);
		model.addAttribute("name", name);
		List<Voluntary> list = voluntaryMapperDao.findVoluntaryByXueHao(xueHao);
		System.out.println(list);
		if(list.size() != 0){
			pro1 = list.get(0).getPro1();
			pro2 = list.get(0).getPro2();
			pro3 = list.get(0).getPro3();
			final_pro= list.get(0).getFinal_pro();
			if(final_pro == null){
				final_pro="未公布";
			}
		}
		model.addAttribute("pro1", pro1);
		model.addAttribute("pro2", pro2);
		model.addAttribute("pro3", pro3);
		model.addAttribute("final_pro", final_pro);
		return "xbfl/voluntaryInfo";
	}
	
	@RequestMapping("enroll")
	public String enroll(HttpServletRequest request,Model model){
		User userInfo = (User)request.getSession().getAttribute("user");
		String collegeId = userInfo.getCollegeId();
		List<Voluntary> list;
		if(collegeId.equals("62")){
			list = voluntaryMapperDao.findAllAndSort();
		}else{
			list = voluntaryMapperDao.findVoluntaryByCol(collegeId);
		}
		model.addAttribute("list", list);
		return "enroll/enroll";
	}
	
	@RequestMapping("confirmVol")
	public void confirmVol(HttpServletRequest request,HttpServletResponse response){
		String string = request.getParameter("para");
		String str = string.substring(0, string.length()-1);
		String[] strings = str.split(";");
		for(int i =0; i <strings.length-1; i++){
			voluntaryMapperDao.confirmVoluntary(strings[i], strings[i+1]);
		}
		try {
			response.sendRedirect("enroll.action");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping("result")
	public String voluntaryInfo(){
		return "enroll/enrollInfo";
	}
	@RequestMapping("addError")
	public String addError(){
		return "xbfl/addError";
	}
}
