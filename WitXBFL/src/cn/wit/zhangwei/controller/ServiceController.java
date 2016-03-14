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
		//�жϱ����ύ��ʽ�Ƿ���multipart/form-data����
		if(!ServletFileUpload.isMultipartContent(request)){
            //������Ǹ�����,������ͨ��ʽ����  
            //response.setContentType("text/html;charset=utf-8");  
            //PrintWriter out = response.getWriter();  
            //request.getParameter("user");//��ʱ�����ʹ��request.getParameter����  
            //Ϊ�˷����ڴ�ֱ���˳� 
			model.addAttribute("finish","��ѡ���ļ�");
			return "role/superadmin";
		}
		
//		����һ����������
		DiskFileItemFactory factory = new DiskFileItemFactory();
//		������ʱ�����ļ��ı���Ŀ¼
		factory.setRepository(new File(request.getSession().getServletContext().getRealPath("/temp")));
		//System.out.println(request.getSession().getServletContext().getRealPath("/temp"));
//		�õ�����������
		ServletFileUpload upload = new ServletFileUpload(factory);
//		���ñ����ļ��ı��뷽ʽ
		upload.setHeaderEncoding("UTF-8");
		try{
//		�����ϴ��ļ������ֵ��С�����ֵΪ200MB
		upload.setFileSizeMax(1024*1024*200);
//		����涨�ϴ��ļ�������
		String[] arr = {".xls",".xlsx"};
//		�����ͷŵ�List��
		List fileStandType = Arrays.asList(arr);
//		��������н������м���������ͻ��м���FileItem����
		List<FileItem> items=upload.parseRequest(request);

		for(FileItem item : items){
//			�ж�����Ԫ�ص�����
			if(item.isFormField()){//����ͨ��
				//�õ�name����
				String inputName = item.getFieldName();
//				�õ���Ӧ��ֵ
				String inputValue=item.getString("UTF-8");//��ָ���ַ����룬�Է�����
				System.out.println(inputName+":"+inputValue);
			}else{//���ϴ��ļ�������
//				��ȡ�ϴ��ļ�����
				String fileName = item.getName();
				System.out.println(fileName);
//				�ж�fileName�Ƿ�Ϊ�ռ��Ƿ����ѡ�����ϴ��ļ�����Ϊ�ռ���
				if(!fileName.trim().equals("")){
//					���ļ������д���õ��ļ���
					fileName=fileName.substring(fileName.lastIndexOf("\\")+1);
//					�õ��ļ���׺�ж��ļ�����
					String fileType = fileName.substring(fileName.lastIndexOf("."));
//					�ж��Ƿ���ָ�����ļ�����
					if(!fileStandType.contains(fileType)){
//						�������ָ�����͵��ļ���תҳ��
						model.addAttribute("finish","ֻ���ϴ�xls����xlsx�ļ�");
						//request.getRequestDispatcher("").forward(request,response);
						return "role/superadmin";
					}
//					�ļ���ѡ�񣬵õ�������
					InputStream in = item.getInputStream();
//					���ϴ����ļ������ڷ������ܱ�����WEB-INF��Ŀ¼��
					String savePath = request.getSession().getServletContext().getRealPath("WEB-INF/upload");
					savePath = getFilePath(savePath,fileName);
//					ͬ���ļ����������fileName���н�һ������������UUID
					fileName=UUID.randomUUID().toString()+"_"+fileName;
//					���������
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
					item.delete();//�ڹر���֮��ɾ����ʱ�����ļ�
					model.addAttribute("finish", "���ݵ���ɹ���");
				}
			}
		}
		}catch(Exception e){
			System.out.println(e);
			model.addAttribute("finish", "���ݵ���ʧ�ܣ�");
		}
		return "role/superadmin";
	}

	private String getFilePath(String path, String fileName) {
		// TODO Auto-generated method stub
//		����Ŀ¼�ṹ���㷨��hashĿ¼
		int dir1 = fileName.hashCode()&0x0f;//һ��Ŀ¼
		int dir2 = fileName.hashCode()>>4 &0x0f;//����Ŀ¼
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
		String fileName = "רҵ���������.xls";
		try {
//			fileName = new String(fileName.getBytes("GBK"),"UTF-8");
			File file = new File(filePath + "\\" + fileName);
			InputStream fileInputStream = new FileInputStream(file);
			OutputStream fileOutputStream = response.getOutputStream();
//			������Ӧͷ,������������ظ��ļ�
			response.setHeader("Content-disposition", "attachment;filename="+URLEncoder.encode(fileName,"UTF-8"));
//			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/octet-stream");
			int b;
			while((b=fileInputStream.read())!=-1){
				fileOutputStream.write(b);
			}
			fileInputStream.close();
			fileOutputStream.close();
			model.addAttribute("download", "���ݳɹ�������EXcel");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			model.addAttribute("download", "�޷������ݵ�����EXcel");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			model.addAttribute("download", "�޷������ݵ�����EXcel");
			e.printStackTrace();
		}
		return "role/superadmin";
	}
}
