package com.dingjin.ding_note.controller;

import com.alibaba.fastjson.JSONObject;
import com.dingjin.ding_note.service.UserService;
import com.dingjin.ding_note.util.NoteResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/user")
public class ChangeUserController {
    @Resource
    private UserService userService;

    @RequestMapping(name = "用户注册",value ="/change.do",method = {RequestMethod.POST})
    @ResponseBody
    public NoteResult<Object> execute(@RequestBody String param){
        JSONObject jsonObject = (JSONObject) JSONObject.parse(param);
        String userName=jsonObject.get("userName").toString();
        String last_password=jsonObject.get("last_password").toString();
        String final_password=jsonObject.get("final_password").toString();
        NoteResult<Object> result = userService.changeUser(userName, last_password, final_password);
        return result;
    }
}
