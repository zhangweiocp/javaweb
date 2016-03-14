package com.infrastructure.project.common.utilities;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class PageTag extends TagSupport{

	/*
	 * 分页需要的内容
	 * 1.当前页
	 * 2.总数
	 * 3.每页数量
	 */
	private int pageSize = 5;//每页显示多少条 
	private int pageNo = 1;//当前页的序号
	private int totalSize;//记录的条数
	@Override
	public int doStartTag() throws JspException {
		// 计算有多少页
		int pageCount = (totalSize+pageSize-1)/pageSize;
		StringBuffer str = new StringBuffer();
		if(totalSize == 0){
			str.append("<strong>没有记录</strong>");
		}else{//有记录要做分页
			//1.不需要分页，记录条数小于pageSize
			//2.当前页为第一页，不需要显示上一页
			//3.最后一页，不需要显示下一页
			if(pageNo == 1){//当前为第一页
				str.append("上一页");
			}else{
				str.append("<a href='javascript:doPage("+(pageNo-1)+")'>").append("上一页</a>");
			}
			//如果页数过多
			int start = 1;
			//如果前面的页数过多，那么用...表示
			if(pageNo>4){
				start = this.pageNo-1;
				str.append("<a href='javascript:doPage(1)'>").append("1</a>");
				str.append("<a href='javascript:doPage(2)'>").append("2</a>");
				str.append("&hellip;");
			}
			//显示当前页附近的页
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
			//后面的页数过多也用...
			if(end<pageCount-2){
				str.append("&hellip;");
			}
			//显示最后两页
			if(end<pageCount-1){
				str.append("<a href='javascript:doPage("+(pageCount-1)+")'>").append((pageCount-1)+"</a>");
			}
			if(end<pageCount){
				str.append("<a href='javascript:doPage("+(pageCount)+")'>").append((pageCount)+"</a>");
			}
			//下一页
			if(pageNo==pageCount){
				str.append("下一页");
			}else{
				str.append("<a href='javascript:doPage("+(pageNo+1)+")'>").append("下一页"+"</a>");
			}
		}
		//pageContext  通过它可以拿到一个输出流
		try {
			this.pageContext.getOut().println(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SKIP_BODY;//标签为空，所以跳过标签中间的主体
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
