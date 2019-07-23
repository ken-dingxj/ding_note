package com.dingjin.ding_note.service;

import com.dingjin.ding_note.entity.Book;
import com.dingjin.ding_note.util.NoteResult;

import java.util.List;

public interface  BookService {
    //根据登录的uid查找笔记本的数据
    public NoteResult<List<Book>> loadUserBook(String userId);

    //根据用户添加笔记
    public NoteResult<Object> addBook(String userId,String title);
}
