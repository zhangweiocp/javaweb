package com.infrastructure.project.common.utilities;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class PageTag extends TagSupport{

	/*
	 * ��ҳ��Ҫ������
	 * 1.��ǰҳ
	 * 2.����
	 * 3.ÿҳ����
	 */
	private int pageSize = 5;//ÿҳ��ʾ������ 
	private int pageNo = 1;//��ǰҳ�����
	private int totalSize;//��¼������
	@Override
	public int doStartTag() throws JspException {
		// �����ж���ҳ
		int pageCount = (totalSize+pageSize-1)/pageSize;
		StringBuffer str = new StringBuffer();
		if(totalSize == 0){
			str.append("<strong>û�м�¼</strong>");
		}else{//�м�¼Ҫ����ҳ
			//1.����Ҫ��ҳ����¼����С��pageSize
			//2.��ǰҳΪ��һҳ������Ҫ��ʾ��һҳ
			//3.���һҳ������Ҫ��ʾ��һҳ
			if(pageNo == 1){//��ǰΪ��һҳ
				str.append("��һҳ");
			}else{
				str.append("<a href='javascript:doPage("+(pageNo-1)+")'>").append("��һҳ</a>");
			}
			//���ҳ������
			int start = 1;
			//���ǰ���ҳ�����࣬��ô��...��ʾ
			if(pageNo>4){
				start = this.pageNo-1;
				str.append("<a href='javascript:doPage(1)'>").append("1</a>");
				str.append("<a href='javascript:doPage(2)'>").append("2</a>");
				str.append("&hellip;");
			}
			//��ʾ��ǰҳ������ҳ
			int end = this.pageNo+1;
			if(end > pageCount){
				end = pageCount;
			}
			for(int i=start;i<=end;i++){
				if(pageNo==i){
					str.append(pageNo);
				}else{
					str.append("<a href='javascript:doPage("+i+")'>").append(i+"</a>");
				}
			}
			//�����ҳ������Ҳ��...
			if(end<pageCount-2){
				str.append("&hellip;");
			}
			//��ʾ�����ҳ
			if(end<pageCount-1){
				str.append("<a href='javascript:doPage("+(pageCount-1)+")'>").append((pageCount-1)+"</a>");
			}
			if(end<pageCount){
				str.append("<a href='javascript:doPage("+(pageCount)+")'>").append((pageCount)+"</a>");
			}
			//��һҳ
			if(pageNo==pageCount){
				str.append("��һҳ");
			}else{
				str.append("<a href='javascript:doPage("+(pageNo+1)+")'>").append("��һҳ"+"</a>");
			}
		}
		//pageContext  ͨ���������õ�һ�������
		try {
			this.pageContext.getOut().println(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SKIP_BODY;//��ǩΪ�գ�����������ǩ�м������
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getTotalSize() {
		return totalSize;
	}
	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}
	
}
