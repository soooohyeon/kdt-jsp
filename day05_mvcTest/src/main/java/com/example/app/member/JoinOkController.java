package com.example.app.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.app.Execute;
import com.example.app.Result;
import com.example.app.dao.MemberDAO;
import com.example.app.dto.MemberDTO;

public class JoinOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		MemberDAO memberDAO = new MemberDAO();
		MemberDTO memberDTO = new MemberDTO();
		System.out.println(memberDTO);
		Result result = new Result(); // ++++ Result 클래스 만든 후 추가

		memberDTO.setMemberId(request.getParameter("memberId"));
		memberDTO.setMemberPw(request.getParameter("memberPassword"));
		memberDTO.setMemberName(request.getParameter("memberName"));
		memberDTO.setMemberAge(Integer.valueOf(request.getParameter("memberAge")));
		memberDTO.setMemberGender(request.getParameter("memberGender"));
		
		memberDAO.join(memberDTO);
		
		result.setRedirect(true);	// ++++ Result 객체 추가 후 작성
		result.setPath(request.getContextPath());	// ++++ Result 객체 추가 후 작성
		
		return result;	// 변환값 수정 후 Front Controller로 이동
	}
	
//	프론트 컨트롤러에 작성한 코드를 처리하려는데 일반클래스는 request, response가 없음
//	메소드를 만들어 매개변수로 전달받아 처리
//	public void execute(HttpServletRequest request, HttpServletRequest response) throws ServletException, IOException {
//		MemberDAO memberDAO = new MemberDAO();
//		MemberDTO memberDTO = new MemberDTO();
//		System.out.println(memberDTO);
//
//		memberDTO.setMemberId(request.getParameter("memberId"));
//		memberDTO.setMemberPw(request.getParameter("memberPassword"));
//		memberDTO.setMemberName(request.getParameter("memberName"));
////  	  valueOf()	: 문자열을 Integer 타입으로 바꿔줌
////  	  pareInt() 와의 차이는 parseInt()는 문자열이 숫자가 아닐 경우 numberFormatException이 발생
////  	  But, valueOf()는 null을 반환함 / 즉, 예외로 인한 강제종료가 되지 않음
//		memberDTO.setMemberAge(Integer.valueOf(request.getParameter("memberAge")));
//		memberDTO.setMemberGender(request.getParameter("memberGender"));
//		
//		memberDAO.join(memberDTO);
//	}
}
