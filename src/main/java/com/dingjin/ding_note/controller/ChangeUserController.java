package com.dingjin.ding_note.controller;

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

@Controller
@RequestMapping("/user")
public class ChangeUserController {
    @Resource
    private UserService userService;

    @RequestMapping(name = "用户注册",value ="/change.do",method = {RequestMethod.POST})
    @ResponseBody
    public NoteResult<Object> execute(@RequestBody String param){
        User user= GsonUtil.getGson().fromJson(param, User.class);
        NoteResult<Object> result = userService.changeUser(user.getCn_user_name(), user.getCn_last_password(), user.getCn_final_password());
        return result;
    }
}
