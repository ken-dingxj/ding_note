package com.dingjin.ding_note.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.dingjin.ding_note.service.UserService;
import com.dingjin.ding_note.util.NoteResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.alibaba.fastjson.JSONObject;

import com.dingjin.ding_note.entity.User;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")//匹配请求路径
public class UserLoginController {
	@Resource
	private UserService userService;
	/**
	 *
	 * @Author: dingjin
	 * @Description: 用户登录
	 */
	@RequestMapping(name = "用户登陆",value ="/login.do",method = {RequestMethod.POST})
	@ResponseBody
	public NoteResult<User> execute(@RequestBody String param) {
		JSONObject jsonObject = (JSONObject) JSONObject.parse(param);
		String name=jsonObject.get("name").toString();
		String password=jsonObject.get("password").toString();
		//调用UserService处理登录请求
		NoteResult<User> result = userService.checkLogin(name, password);
		return result;
	}
}
