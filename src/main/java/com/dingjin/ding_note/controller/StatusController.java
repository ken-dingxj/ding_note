package com.dingjin.ding_note.controller;

import com.dingjin.ding_note.annotation.CheckSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StatusController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @CheckSource(sources = {"huyan", "huihui"})
    @RequestMapping(value ="/status.do",method = {RequestMethod.GET})
    public Object status(@RequestParam("source") String source) {
        return "哈哈哈";
    }
}
