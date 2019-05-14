package com.dingjin.ding_note.dao;

import com.dingjin.ding_note.entity.User;

public interface UserDao {
	//查找登录的账户名  返回查找到的用户名对象(登录方法)
	public User findByName(String name);
}
