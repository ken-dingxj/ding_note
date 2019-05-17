package com.dingjin.ding_note.service;
/**
 * 业务处理
 * @author dingjin
 *
 */

import com.dingjin.ding_note.util.NoteResult;
import com.dingjin.ding_note.entity.User;

public interface UserService {
	//查找登录的账户名  返回查找到的用户名对象(登录方法)
	public NoteResult<User> checkLogin(String name, String password);
	//保存一个用户名，输入类型为User（注册方法）
	public NoteResult<Object> addUser(String name, String password, String nick);
	//修改用户名密码
    public NoteResult<Object> changeUser(String userName,String last_password,String final_password);
}
