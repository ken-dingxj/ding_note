package com.dingjin.ding_note.dao;

import com.dingjin.ding_note.entity.Book;

import java.util.List;

public interface  BookDao {
    //根据登录的uid查找笔记本的数据
    public List<Book> findByUserId(String userId);
    //增加笔记本的操作
    public void save(Book book);
}
