package com.dingjin.ding_note.util;

/**
 * 自定义异常
 * @author dingjin
 */
public class NoteException extends RuntimeException{
	public NoteException(String msg,Throwable t){
		super(msg,t);
	}
}
