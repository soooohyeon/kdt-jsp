package com.example.app.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.app.Execute;
import com.example.app.Result;
import com.example.app.board.dao.BoardDAO;

public class BoardUpdateController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		Result result = new Result();
		BoardDAO boardDAO = new BoardDAO();
		
		int boardNum = Integer.valueOf(request.getParameter("boardNumber"));
		
		request.setAttribute("board", boardDAO.select(boardNum));
		
		result.setPath("/app/board/boardUpdate.jsp");
		result.setRedirect(false);
		
		return result;
	}
	
}
