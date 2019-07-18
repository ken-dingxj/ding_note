package com.dingjin.ding_note.controller;

import com.dingjin.ding_note.entity.Book;
import com.dingjin.ding_note.service.BookService;
import com.dingjin.ding_note.util.GsonUtil;
import com.dingjin.ding_note.util.NoteResult;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/book")
public class AddBookController {
    @Resource
    private BookService bookService;
//    @RequestMapping("/add.do")
    @RequestMapping(name = "用户登陆",value ="/add.do",method = {RequestMethod.POST})
    @ResponseBody
    public NoteResult<Object> execute(@RequestBody String param) {
        Book book = GsonUtil.getGson().fromJson(param, Book.class);
        NoteResult<Object> result=bookService.addBook(book.getCn_user_id(),book.getCn_notebook_name());
        return result;
    }
}
