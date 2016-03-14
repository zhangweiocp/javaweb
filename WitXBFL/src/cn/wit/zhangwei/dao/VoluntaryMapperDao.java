package cn.wit.zhangwei.dao;

import java.util.List;

import cn.wit.zhangwei.annotation.MyBatisDao;
import cn.wit.zhangwei.entity.Voluntary;

@MyBatisDao
public interface VoluntaryMapperDao {
	public List<Voluntary> findAll();
	public List<Voluntary> findAllAndSort();
	public List<Voluntary> findVoluntary(String xueHao,String collegeId);
	public List<Voluntary> findVoluntaryByCol(String collegeId);
	public List<Voluntary> findVoluntaryByXueHao(String xueHao);
	public List<Voluntary> search(String xueHao, String name, String collegeId);
	public List<Voluntary> search1(String xueHao,String name);
	public void addVoluntary(Voluntary voluntary);
	public void updateVoluntary(String xueHao,String pro1,String pro2,String pro3);
	public void confirmVoluntary(String xueHao,String final_pro);
}
