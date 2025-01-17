package com.example.app;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 통일성을 맞추기 위해 인터페이스로 생성함, 해당 인터페이스를 구현받고 그 안에 메소드를 구현하면 됨
public interface Execute {
	
	public Result execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
