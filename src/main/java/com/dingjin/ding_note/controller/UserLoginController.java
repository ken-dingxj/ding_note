package com.dingjin.ding_note.controller;

import javax.annotation.Resource;

import com.dingjin.ding_note.service.UserService;
import com.dingjin.ding_note.util.GsonUtil;
import com.dingjin.ding_note.util.NoteResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dingjin.ding_note.entity.User;
import org.springframework.web.bind.annotation.ResponseBody;


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
	public NoteResult<Object> execute(@RequestBody String param) {
		User user= GsonUtil.getGson().fromJson(param, User.class);
		//调用UserService处理登录请求
		NoteResult<Object> result = userService.checkLogin(user.getCn_user_name(),user.getCn_user_password() );
		return result;
	}
}
