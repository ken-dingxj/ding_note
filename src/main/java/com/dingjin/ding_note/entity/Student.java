package com.dingjin.ding_note.entity;

import com.dingjin.ding_note.annotation.CherryAnnotation;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;

@Component
public class Student {
    private String id;
    @NotBlank(message = "密码不能为空")
    private String password;
    @NotBlank(message = "用户名不能为空")
    private String username;

    @CherryAnnotation(name = "cherry-peng",age=23,score={99,66,77})
    public void study(int times){
        for(int i=0;i<times;i++){
            System.out.println("Good Good Study,Day Day Up!");
        }
    }
}
