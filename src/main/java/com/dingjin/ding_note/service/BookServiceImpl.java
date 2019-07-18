package com.dingjin.ding_note.service;

import com.dingjin.ding_note.dao.BookDao;
import com.dingjin.ding_note.entity.Book;
import com.dingjin.ding_note.util.NoteResult;
import com.dingjin.ding_note.util.NoteUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.Timestamp;

@Service("BookService") //扫描到Spring容器
@Transactional
public class BookServiceImpl implements BookService {
    @Resource
    BookDao bookDao;
    public NoteResult<Object> addBook(String userId, String title) {
        Book book=new Book();
        //增加笔记本id
        String bookId= NoteUtil.createId();
        book.setCn_notebook_id(bookId);
        //增加用户id
        book.setCn_user_id(userId);
        //增加笔记本名称
        book.setCn_notebook_name(title);
        //增加笔记本的类型
        book.setCn_notebook_type_id("1");
        //增加笔记本的创建时间
        Timestamp time = new Timestamp(System.currentTimeMillis());
        book.setCn_notebook_createtime(time);
        //保存笔记本
        bookDao.save(book);
        //返回结果
        NoteResult<Object> result = new NoteResult<Object>();
        result.setStatus(0);
        result.setMsg("创建笔记本成功");
        result.setData(book);
        return result;
    }
}
