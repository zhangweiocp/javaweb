

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.wit.zhangwei.service.services.FenLiuOperationUtil;

public class TestSqlSessionFactoryBean {
	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("springMVC.xml");
		Object obj=ctx.getBean("sqlSessionFactoryBean");
		//测试连接成功
		System.out.println(obj);//org.apache.ibatis.session.defaults.DefaultSqlSessionFactory@1f2cea2
	}
}
