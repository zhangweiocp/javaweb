package cn.wit.zhangwei.dao;

import java.util.List;

import cn.wit.zhangwei.annotation.MyBatisDao;
import cn.wit.zhangwei.entity.Major;

@MyBatisDao
public interface MajorMapperDao {
	public List<Major> findAll();
	public List<Major> findMajor(String xueHao);
}
