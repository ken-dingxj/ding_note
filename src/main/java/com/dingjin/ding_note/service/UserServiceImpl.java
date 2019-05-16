package com.dingjin.ding_note.service;

import javax.annotation.Resource;

import com.dingjin.ding_note.util.NoteResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dingjin.ding_note.dao.UserDao;
import com.dingjin.ding_note.entity.User;

/**
 * @author dingjin
 * 用户表业务类实现
 */
@Service("userService") //扫描到Spring容器
@Transactional
public class UserServiceImpl implements UserService{
	@Resource
	private UserDao userDao;
	//查询用户
	public NoteResult<User> checkLogin(String name, String password) {
		//接受结果数据
		NoteResult<User> result=new NoteResult<User>();
		//按参数name查询数据库
		User user = userDao.findByName(name);
		//检测用户名
		if(user==null) {
			result.setStatus(1);
			result.setMsg("用户名不存在");
			return result;
		}
		//检测密码
//		String md5Password= NoteUtil.md5(password);//对输入的密码进行加密，然后进行比较
		String md5Password= password;//对输入的密码进行加密，然后进行比较
		if(!user.getCn_user_password().equals(md5Password)) {
			result.setStatus(2);
			result.setMsg("密码错误");
			return result;
		}
		//用户名跟密码都正确
		result.setStatus(0);
		result.setMsg("登录成功");
		result.setData(user);
		return result;
	}
	//注册用户
	public NoteResult<User> addUser(String name, String password, String nick) {
		//接受结果数据
		NoteResult<Object> result=new NoteResult<Object>();
		//用户检测
		User hasUser = userDao.findByName(name);
		if(hasUser!=null){//用户名存在
			result.setStatus(1);//用户名已经被占用
			result.setMsg("用户名已经被占用");
			return result;
		}
		return null;
	}


}
