package com.dingjin.ding_note.controller;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

public abstract class BaseController {

    /**
     * 校验通过bean当参数的验证结果方法
     * @param bindingResult
     * @return
     */
    protected Map<String, Object> validate(BindingResult bindingResult) {

        Map<String, Object> ret = new HashMap<String,Object>();
        boolean isTrue = true;
        StringBuilder sb = new StringBuilder("");
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(o ->{
                FieldError error = (FieldError) o;
                sb.append("|" + error.getDefaultMessage());//	添加错误信息
            });
            isTrue = false;
        }

        ret.put("isTrue", isTrue);
        ret.put("message", sb.toString());// 错误信息
        return ret;
    }
}