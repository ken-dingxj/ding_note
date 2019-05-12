package com.dingjin.ding_note.controller;

import javax.annotation.Resource;

import com.dingjin.ding_note.service.UserService;
import com.dingjin.ding_note.util.NoteResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dingjin.ding_note.entity.User;

@Controller
@RequestMapping("/user")//匹配请求路径
public class UserLoginController {
	@Resource
	private UserService userService;
	
	@RequestMapping("/login.do")//匹配请求
	@ResponseBody //以json结果输出
	public NoteResult<User> execute(String name, String password){
		//调用UserService处理登录请求
		System.out.println(name+","+password);
		NoteResult<User> result = userService.checkLogin(name, password);
		return result;
	}
}
