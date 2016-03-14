package cn.wit.zhangwei.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspWriter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.wit.zhangwei.dao.StudentMapperDao;
import cn.wit.zhangwei.dao.VoluntaryMapperDao;
import cn.wit.zhangwei.entity.Student;
import cn.wit.zhangwei.entity.User;
import cn.wit.zhangwei.entity.Voluntary;
import cn.wit.zhangwei.service.services.ExcelOperationUtil;

@Controller
public class ServiceController {
	
	private ExcelOperationUtil excelOperationUtil;
	@Resource
	private StudentMapperDao studentMapperDao;
	@Resource
	private VoluntaryMapperDao voluntaryMapperDao;
	public void setStudentMapperDao(StudentMapperDao studentMapperDao) {
		this.studentMapperDao = studentMapperDao;
	}
	public void setVoluntaryMapperDao(VoluntaryMapperDao voluntaryMapperDao){
		this.voluntaryMapperDao = voluntaryMapperDao;
	}

	//@SuppressWarnings("unchecked")
	@RequestMapping("upload")
	public String upload(HttpServletRequest request, Model model)
		throws ServletException,IOException{
		//判断表格的提交方式是否是multipart/form-data类型
		if(!ServletFileUpload.isMultipartContent(request)){
            //如果不是该类型,采用普通方式处理。  
            //response.setContentType("text/html;charset=utf-8");  
            //PrintWriter out = response.getWriter();  
            //request.getParameter("user");//此时便可以使用request.getParameter方法  
            //为了方便在此直接退出 
			model.addAttribute("finish","请选择文件");
			return "role/superadmin";
		}
		
//		创建一个解析工厂
		DiskFileItemFactory factory = new DiskFileItemFactory();
//		设置临时缓存文件的保存目录
		factory.setRepository(new File(request.getSession().getServletContext().getRealPath("/temp")));
		//System.out.println(request.getSession().getServletContext().getRealPath("/temp"));
//		得到解析器对象
		ServletFileUpload upload = new ServletFileUpload(factory);
//		设置保存文件的编码方式
		upload.setHeaderEncoding("UTF-8");
		try{
//		设置上传文件的最大值大小，最大值为200MB
		upload.setFileSizeMax(1024*1024*200);
//		定义规定上传文件的类型
		String[] arr = {".xls",".xlsx"};
//		将类型放到List中
		List fileStandType = Arrays.asList(arr);
//		对请求进行解析，有几个输入项就会有几个FileItem对象
		List<FileItem> items=upload.parseRequest(request);

		for(FileItem item : items){
//			判断输入元素的类型
			if(item.isFormField()){//是普通项
				//得到name属性
				String inputName = item.getFieldName();
//				得到相应的值
				String inputValue=item.getString("UTF-8");//可指定字符编码，以防乱码
				System.out.println(inputName+":"+inputValue);
			}else{//是上传文件输入项
//				获取上传文件名称
				String fileName = item.getName();
				System.out.println(fileName);
//				判断fileName是否为空即是否真的选择了上传文件，不为空继续
				if(!fileName.trim().equals("")){
//					对文件名进行处理得到文件名
					fileName=fileName.substring(fileName.lastIndexOf("\\")+1);
//					得到文件后缀判断文件类型
					String fileType = fileName.substring(fileName.lastIndexOf("."));
//					判断是否是指定的文件类型
					if(!fileStandType.contains(fileType)){
//						如果不是指定类型的文件跳转页面
						model.addAttribute("finish","只能上传xls或者xlsx文件");
						//request.getRequestDispatcher("").forward(request,response);
						return "role/superadmin";
					}
//					文件已选择，得到输入流
					InputStream in = item.getInputStream();
//					将上传的文件保存在服务器受保护的WEB-INF的目录下
					String savePath = request.getSession().getServletContext().getRealPath("WEB-INF/upload");
					savePath = getFilePath(savePath,fileName);
//					同名文件覆盖问题对fileName进行进一步处理，工具类UUID
					fileName=UUID.randomUUID().toString()+"_"+fileName;
//					构造输出流
					FileOutputStream fos = new FileOutputStream(savePath + "\\" +fileName);
					byte[] buffer = new byte[1024];
//					int len = 0;
					while(in.read(buffer)>0){
						fos.write(buffer);
						fos.flush();
					}
					in.close();
					fos.close();
					excelOperationUtil = new ExcelOperationUtil();
					System.out.println(fileType);
					excelOperationUtil.readExcelFileToDB(savePath+"\\"+fileName,studentMapperDao,fileType);
					item.delete();//在关闭流之后，删除临时缓存文件
					model.addAttribute("finish", "数据导入成功！");
				}
			}
		}
		}catch(Exception e){
			System.out.println(e);
			model.addAttribute("finish", "数据导入失败！");
		}
		return "role/superadmin";
	}

	private String getFilePath(String path, String fileName) {
		// TODO Auto-generated method stub
//		产生目录结构的算法：hash目录
		int dir1 = fileName.hashCode()&0x0f;//一级目录
		int dir2 = fileName.hashCode()>>4 &0x0f;//二级目录
		String savePath = path+"\\"+"\\"+dir2;
		File file = new File(savePath);
		if(!file.exists()){
			file.mkdirs();
		}
		return savePath;
	}
	
	@RequestMapping("download")
	private String download(HttpServletRequest request,HttpServletResponse response, Model model){
		User userInfo = (User)request.getSession().getAttribute("user");
		String collegeId = userInfo.getCollegeId();
		List<Voluntary> list;
		if(collegeId.equalsIgnoreCase("62")){
			list = voluntaryMapperDao.findAllAndSort();
		}else{
			list = voluntaryMapperDao.findVoluntaryByCol(collegeId);
		}
		ExcelOperationUtil excelOperationUtil = new ExcelOperationUtil();
		excelOperationUtil.writeExcelFileFromDB(request, list);
		String filePath = request.getSession().getServletContext().getRealPath("WEB-INF/download");
		String fileName = "专业分流结果表.xls";
		try {
//			fileName = new String(fileName.getBytes("GBK"),"UTF-8");
			File file = new File(filePath + "\\" + fileName);
			InputStream fileInputStream = new FileInputStream(file);
			OutputStream fileOutputStream = response.getOutputStream();
//			设置响应头,控制浏览器下载该文件
			response.setHeader("Content-disposition", "attachment;filename="+URLEncoder.encode(fileName,"UTF-8"));
//			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/octet-stream");
			int b;
			while((b=fileInputStream.read())!=-1){
				fileOutputStream.write(b);
			}
			fileInputStream.close();
			fileOutputStream.close();
			model.addAttribute("download", "数据成功导出到EXcel");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			model.addAttribute("download", "无法将数据导出到EXcel");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			model.addAttribute("download", "无法将数据导出到EXcel");
			e.printStackTrace();
		}
		return "role/superadmin";
	}
}
