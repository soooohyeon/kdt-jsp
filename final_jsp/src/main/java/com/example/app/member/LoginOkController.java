package com.example.app.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.app.Execute;
import com.example.app.Result;
import com.example.app.dto.MemberDTO;
import com.example.app.member.dao.MemberDAO;

public class LoginOkController implements Execute {
	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MemberDAO memberDAO = new MemberDAO();
		MemberDTO memberDTO = new MemberDTO();
		int memberNumber = 0;
		String path = null;
		Result result = new Result();
		String memberId = request.getParameter("memberId"); // 아이디 저장 처리할 때 재사용...
		String memberPassword = request.getParameter("memberPassword");
		String remember = request.getParameter("remember"); // +++++++++++
		HttpSession session = request.getSession(); // ++++++++++++++세션저장

		memberDTO.setMemberId(memberId);
		memberDTO.setMemberPassword(memberPassword);

		memberNumber = memberDAO.login(memberDTO);

		if (memberNumber != -1) {
			path = "/board/boardListOk.bo";
			session.setAttribute("memberNumber", memberNumber); // ++++++++++
			System.out.println("세션값 : " + memberNumber);

			if (remember != null) {
//				쿠키 : 브라우저에서 기억함
				Cookie cookie = new Cookie("memberId", memberId);
				cookie.setMaxAge(60 * 60 * 24);
				response.addCookie(cookie);
			}
		} else {
			path = "/member/login.me?login=fail";

		}

//		response.sendRedirect(path);
//		세션은 redirect가 되면 사라짐 → forward 방식으로 가야함
//		redirect 방식으로 가고 싶다면 parameter로 전달해야함
//		그러나 ID, PW 같은 경우 parameter로 뜨면 안되기 때문에 사용 X
		result.setRedirect(false);
		result.setPath(path);
		return result;
	}
}
