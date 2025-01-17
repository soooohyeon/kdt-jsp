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
import com.example.app.dao.MemberDAO;

public class LoginOkController implements Execute{
   @Override
   public Result execute(HttpServletRequest request, HttpServletResponse response)
		   throws ServletException, IOException {

      MemberDAO memberDAO = new MemberDAO();
      MemberDTO memberDTO = new MemberDTO();
      
      Result result = new Result();
//
//      memberDTO.setMemberId(request.getParameter("memberId"));
//      memberDTO.setMemberPassword(request.getParameter("memberPassword"));

      String memberId = request.getParameter("memberId");
      String memberPassword = request.getParameter("memberPasword");
      memberDTO = memberDAO.login(memberId, memberPassword);
      
      
      //로그인 성공시 로그인 실패시
      if(memberDTO != null) {
         //로그인 성공시 사용자 정보 저장
         HttpSession session = request.getSession();
         
         session.setAttribute("memberDTO", memberDTO);
         
         //쿠키에 사용자 ID저장
         Cookie cookie = new Cookie("memberId", memberId);
         cookie.setMaxAge(60*60*24);// 유효시간 1일
         response.addCookie(cookie);
         
         result.setPath(request.getContextPath()+"/main.jsp");
         result.setRedirect(true);
         
      } else {
         //로그인 실패시 로그인 페이지로 이동
         result.setPath(request.getContextPath() + "/member/login.jsp");
         result.setRedirect(false);
      }
      
      return null;
   }

   
   
   
}
