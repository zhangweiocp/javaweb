package cn.wit.zhangwei.annotation;

import org.springframework.stereotype.Repository;

@Repository
public @interface MyBatisDao {
	String value() default "";
}
