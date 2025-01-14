package com.servletTask.app;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.coyote.RequestGroupInfo;

/**
 * Servlet implementation class MyServlet1
 */
//@WebServlet("/MyServlet1")
public class MyServlet01 extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet01() {
        super();
        // TODO Auto-generated constructor stub
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
//      response.getWriter().append("Served at: ").append(request.getContextPath());
		String userName = request.getParameter("name");
//		getParameter()는 문자열로 반환됨
		int userAge = Integer.parseInt(request.getParameter("age"));
		String userGender = request.getParameter("gender");
		String[] userHobbies = request.getParameterValues("hobby");
		
//		System.out.println("userName : " + userName);
//		System.out.println("userAge : " + userAge);
		
		request.setAttribute("userName", userName);
		request.setAttribute("userAge", userAge);
		request.setAttribute("userGender", userGender);
		request.setAttribute("userHobbies", userHobbies);
		
		request.getRequestDispatcher("result.jsp").forward(request, response);
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      doGet(request, response);
   }

}
