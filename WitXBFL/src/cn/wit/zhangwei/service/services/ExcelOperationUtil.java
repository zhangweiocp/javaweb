package cn.wit.zhangwei.service.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import cn.wit.zhangwei.dao.StudentMapperDao;
import cn.wit.zhangwei.entity.Student;
import cn.wit.zhangwei.entity.Voluntary;

public class ExcelOperationUtil {
//	@Resource
//	private StudentMapperDao studentMapperDao;
//	
//
//	public StudentMapperDao getStudentMapperDao() {
//		return studentMapperDao;
//	}
//
//
//	public void setStudentMapperDao(StudentMapperDao studentMapperDao) {
//		this.studentMapperDao = studentMapperDao;
//	}


	public void readExcelFileToDB(String filePath,StudentMapperDao studentMapperDao,String fileType){
//		List<Student> list = new ArrayList<Student>();
		Workbook workbook = null;
		File xlsorxlsxFile = new File(filePath);
		try {
			FileInputStream fileInputStream = new FileInputStream(xlsorxlsxFile);
			//Workbook workbook = WorkbookFactory.create(xlsorxlsxFile);//创建excel工作簿对象
			if(fileType.contains("xlsx")){
//				2007
				workbook = new XSSFWorkbook(fileInputStream);
			}else if(fileType.contains("xls")){
//				2003
				workbook = new HSSFWorkbook(fileInputStream);
			}
			Sheet sheet = workbook.getSheetAt(0);
			for(int i=1;i<=sheet.getLastRowNum();i++ ){
				Student student = new Student();
				Row row = sheet.getRow(i);
				Cell cell1 = row.getCell(0);
				Cell cell2 = row.getCell(1);
				Cell cell3 = row.getCell(2);
				Cell cell4 = row.getCell(3);
				Cell cell5 = row.getCell(5);
				Cell cell6 = row.getCell(6);
				//Cell cell7 = row.getCell(7);
				String xuehao = cell1.getStringCellValue();
				student.setXuehao(xuehao);
				System.out.println(xuehao);
				String name = cell2.getStringCellValue();
				student.setName(name);
				System.out.println(name);
				String gender = cell3.getStringCellValue();
				student.setGender(gender);
				System.out.println(gender);
				String collegeId = cell4.getStringCellValue();
				student.setCollegeId(collegeId);
				System.out.println(collegeId);
				String id_card = cell5.getStringCellValue();
				int length = 18 - id_card.length();
				if(id_card.length() < 18){
					for(int j = 0;j < length; j++){
						id_card = id_card + "0";
					}
				}
				student.setId_card(id_card);
				System.out.println(id_card);
				String phone = cell6.getStringCellValue();
				student.setPhone(phone);
				System.out.println(phone);
				String password = id_card.substring(12, 18);
				student.setPassword(password);
				System.out.println(password);
//				list.add(student);
				System.out.println(student.toString());
				try{
					studentMapperDao.addStudent(student);
				}catch (Exception e) {
					// TODO: handle exception
					studentMapperDao.updateStudent(xuehao, password);
				}
				
			}
//			for(Student s:list){
//				System.out.println(studentMapperDao);
//				studentMapperDao.addStudent(s);
//			}
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void writeExcelFileFromDB(HttpServletRequest request,List<Voluntary> list){
//		创建Excel文档
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFRow row;
		HSSFCell cell;
//		sheet对应一个工作页
		HSSFSheet sheet = wb.createSheet("专业分流结果");
		row = sheet.createRow(0);//从下标为0的行开始
		String[] title = {"学号","姓名","学院编号","一志愿","二志愿","三志愿","录取专业"};//表头 
		for(int i =0;i<title.length;i++){
			cell = row.createCell(i);
			cell.setCellValue(new HSSFRichTextString(title[i]));
		}
//		循环输出表文
		for(int i = 0;i < list.size(); i++){
			row = sheet.createRow(i+1);
			Voluntary voluntary = list.get(i);
			cell = row.createCell(0);
			cell.setCellValue(new HSSFRichTextString(voluntary.getXueHao()));
			cell = row.createCell(1);
			cell.setCellValue(new HSSFRichTextString(voluntary.getName()));
			cell = row.createCell(2);
			cell.setCellValue(new HSSFRichTextString(voluntary.getCollegeId()));
			cell = row.createCell(3);
			cell.setCellValue(new HSSFRichTextString(voluntary.getPro1()));
			cell = row.createCell(4);
			cell.setCellValue(new HSSFRichTextString(voluntary.getPro2()));
			cell = row.createCell(5);
			cell.setCellValue(new HSSFRichTextString(voluntary.getPro3()));
			cell = row.createCell(6);
			cell.setCellValue(new HSSFRichTextString(voluntary.getFinal_pro()));
		}
		String filePath = request.getSession().getServletContext().getRealPath("WEB-INF/download");
		String filename = filePath +"/"+ "专业分流结果表.xls";
//		创建文件输出流，准备输出电子表格
		FileOutputStream out;
		try {
			out = new FileOutputStream(filename);
			wb.write(out);
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
