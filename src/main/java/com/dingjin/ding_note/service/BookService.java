package com.dingjin.ding_note.service;

import com.dingjin.ding_note.util.NoteResult;

import java.util.List;

public interface  BookService {
    //根据用户添加笔记
    public NoteResult<Object> addBook(String userId,String title);
}
