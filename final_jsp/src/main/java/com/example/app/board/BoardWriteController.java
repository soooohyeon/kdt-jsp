package com.example.app.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.app.Execute;
import com.example.app.Result;
import com.example.app.member.dao.MemberDAO;

public class BoardWriteController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		MemberDAO memberDAO = new MemberDAO();
		Result result = new Result();
		HttpSession session = request.getSession();
		Integer memberNum = (Integer)session.getAttribute("memberNumber");
		String path = null;
		
//		로그인 되어있지 않다면 로그인 페이지로 이동
		if (memberNum == null) {
			path = "/app/member/login.jsp";
		} else {
			path = "/app/board/boardWrite.jsp";
			request.setAttribute("memberId", memberDAO.getMemberId(memberNum));
		}
		
		result.setPath(path);
		result.setRedirect(false);
		
		return result;
	}

}
