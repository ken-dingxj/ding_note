package test.service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dingjin.ding_note.entity.User;
import com.dingjin.ding_note.service.UserService;
import com.dingjin.ding_note.util.NoteResult;

public class TestUserService {
	private UserService service;
	@Before
	public void init() {
		String[] conf= {"conf/spring_mybatis.xml","conf/spring_mvc.xml","conf/spring_transaction.xml"};
		ApplicationContext ac=new ClassPathXmlApplicationContext(conf);
		service= ac.getBean("userService",UserService.class);
	}
	@Test //用例-1:测试登录成功的情况
	public void test3() {
		NoteResult<User> result = service.checkLogin("demo1", "123456");
		System.out.println(result.getStatus());
		System.out.println(result.getMsg());
		System.out.println(result.getData());
	}
}
