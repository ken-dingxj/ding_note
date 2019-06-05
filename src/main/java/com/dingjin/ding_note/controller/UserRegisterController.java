package com.dingjin.ding_note.controller;

import com.alibaba.fastjson.JSONObject;
import com.dingjin.ding_note.entity.User;
import com.dingjin.ding_note.service.UserService;
import com.dingjin.ding_note.util.GsonUtil;
import com.dingjin.ding_note.util.NoteResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @autor dingjin
 * 用户注册
 */
@Controller
@RequestMapping("/user")//匹配请求
public class UserRegisterController {
    @Resource
    private UserService userService;

    @RequestMapping(name = "用户注册",value ="/addUser.do",method = {RequestMethod.POST})
    @ResponseBody//以json数据格式返回数据
    public NoteResult<Object> execute(@RequestBody String param) {
//        JSONObject jsonObject = (JSONObject) JSONObject.parse(param);
//        String userName=jsonObject.get("userName").toString();
//        String password=jsonObject.get("password").toString();
//        String nick=jsonObject.get("nick").toString();
//        System.out.println(jsonObject);
        User user= GsonUtil.getGson().fromJson(param, User.class);
        //调用userService处理注册请求
        NoteResult<Object> result = userService.addUser(user.getCn_user_name(), user.getCn_user_password(), user.getCn_user_nick());
        System.out.println(result);
        return result;
    }
}
