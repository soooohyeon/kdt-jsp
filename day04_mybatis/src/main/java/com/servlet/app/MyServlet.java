package com.servlet.app;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.config.MyBatisConfig;

/**
 * Servlet implementation class MyServlet
 */
//@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MyServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());

		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		String userName = request.getParameter("userName");
		int userAge = Integer.parseInt(request.getParameter("userAge"));
		String userGender = request.getParameter("userGender");

		request.setAttribute("userId", userId);
		request.setAttribute("userPw", userPw);
		request.setAttribute("userName", userName);
		request.setAttribute("userAge", userAge);
		request.setAttribute("userGender", userGender);

		System.out.println(userId + ", " + userPw + ", " + userName + ", " + userAge + ", " + userGender);

//		sqlSessionFactory의 openSession()을 사용하면 sqlSession 가져옴
//		반환타입 확인하기
//		OpenSession()에 true를넣어줘야 auto commit이 됨
		SqlSession sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);

		// ++++++++++
		// UserMapper에 넘겨줄 map 만들기
		Map<String, String> userMap = new HashMap<>();
		userMap.put("userId", request.getParameter("userId"));
		userMap.put("userPw", request.getParameter("userPw"));
		userMap.put("userName", request.getParameter("userName"));
		userMap.put("userAge", request.getParameter("userAge"));
		userMap.put("userGender", request.getParameter("userGender"));
		// ++++++++++

//		sqlSession에는 insert, select, update, delet 메소드가 존재함(CRUD)
//		매개변수로 미리 작성한 sql문의 위치를 알려주면됨
//		sql믄 mapper/xml 파일에 작성되어야 함 (아직 없으므로 안들어감)
		sqlSession.insert("user.join", userMap);

		request.getRequestDispatcher("/result.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
