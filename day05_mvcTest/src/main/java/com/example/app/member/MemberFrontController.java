package com.example.app.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.app.Result;

/**
 * Servlet implementation class MemberFrontController
 */
//@WebServlet("/MemberFrontController")
public class MemberFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
//		호출전 인코딩 꼭 넣어줄것!!!
		doProcess(request, response);
	}
	
//	멤버에 관한 서블릿 경로만 작성해줌
//	get, post 구분 없이 사용
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      System.out.println("member 서블릿 실행");

//	      request.getContextPath() URL 루트경로를 의미
	      System.out.println(request.getContextPath());

//	      request.getRequestURI 현재 요청의 URI를 의미
	      System.out.println(request.getRequestURI());

//	      변수에 저장후 분기처리로 사용
//	      요청 URL이 뭔지 구분하기
//	      필요 : 전체 URI에서 COntextPath를 제외시킨 부분
	      String target = request.getRequestURI().substring(request.getContextPath().length());
	      System.out.println(target);
	      
	      Result result = null;
	      
	      switch(target) {
	      case "/member/join.me" :
	    	  System.out.println("join!!");
	    	  request.getRequestDispatcher("/app/member/join.jsp").forward(request, response);
	    	  break;
	    	  
	      case "/member/joinOk.me" : 
	    	  System.out.println("join ok~~~!!!");
	    	  
//	    	  ------------------------------------------------------------------------------------
//	    	  아래 작성한 로직은 비즈니스 로직으로 프론트 컨트롤러에 작성 x
//	    	  각 Controller와 DAO에서 작업 예정

//	    	  비즈니스 로직 정리 - 만들어둔 메소드 사용을 위해 선언해줌
	    	  result = new JoinOkController().execute(request, response);
	    	  
//	    	  비즈니스 로직 정리 - 아래 글은 MemberDAO로 이동
////	    	  sqlSession 사용
//	    	  MemberDTO memberDTO = new MemberDTO();
//	    	  System.out.println(memberDTO);
//	    	  
//	    	  memberDTO.setMemberId(request.getParameter("memberId"));
//	    	  memberDTO.setMemberPw(request.getParameter("memberPassword"));
//	    	  memberDTO.setMemberName(request.getParameter("memberName"));
////	    	  valueOf()	: 문자열을 Integer 타입으로 바꿔줌
////	    	  pareInt() 와의 차이는 parseInt()는 문자열이 숫자가 아닐 경우 numberFormatException이 발생
////	    	  But, valueOf()는 null을 반환함 / 즉, 예외로 인한 강제종료가 되지 않음
//	    	  memberDTO.setMemberAge(Integer.valueOf(request.getParameter("memberAge")));
//	    	  memberDTO.setMemberGender(request.getParameter("memberGender"));
	    	
//	    	  비즈니스 로직 정리 - 아래 2줄은 joinOkController로 이동
//	    	  SqlSession sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
//	    	  sqlSession.insert("member.join", memberDTO);
	    	  
//	    	  사용자가 입력한 데이터를 계속 가져가지 않고 페이지를 새로고침하기 위해 redirect 방식 사용
//	    	  request.getContextPath() = 루트 경로 / 즉, index.jsp 페이지로 이동됨
//	    	  response.sendRedirect(request.getContextPath());
	    	  
	    	  break;
	    	  
	      case "/member/login.me" :
	    	  System.out.println("login!!");
	    	  request.getRequestDispatcher("/app/member/login.jsp").forward(request, response);
	    	  break;
	    	  
	      case "/member/loginOk.me" :
	    	  System.out.println("login ok~~~!!!!!");
	    	  result = new LoginOkController().execute(request, response);
	    	  break;
	      }
	      
	      if(result != null) {
	          if(result.isRedirect()) {
	             response.sendRedirect(result.getPath());
	          }else {
	             request.getRequestDispatcher(result.getPath());
	          }
	       }
	      
	}

}
