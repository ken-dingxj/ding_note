package test.dao;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dingjin.ding_note.dao.UserDao;
import com.dingjin.ding_note.entity.User;


public class TestUserDao {
	//测试登录账号名的查找
	@Test
	public void testUserDao() {
		ApplicationContext ac=new ClassPathXmlApplicationContext("conf/spring_mybatis.xml");
		UserDao dao = ac.getBean("userDao",UserDao.class);
		User user = dao.findByName("demo");
		System.out.println(user);
	}
}
