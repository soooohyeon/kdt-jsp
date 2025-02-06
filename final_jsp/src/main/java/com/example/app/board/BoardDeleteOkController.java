package com.example.app.board;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.app.Execute;
import com.example.app.Result;
import com.example.app.board.dao.BoardDAO;
import com.example.app.dto.FileDTO;
import com.example.app.file.dao.FileDAO;

public class BoardDeleteOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		Result result = new Result();
		BoardDAO boardDAO = new BoardDAO();
		FileDAO fileDAO = new FileDAO();
		
		int boardNum = Integer.valueOf(request.getParameter("boardNumber"));
		
		String uploadPath = request.getSession().getServletContext().getRealPath("/") + "upload";
		
//		DB에서 지운 파일들은 실제로도 삭제 되어야함
//		file 객체에 넣고 delete를 하면되는데 실제 이름이 필요하므로 쿼리를 날려 가져옴
		List<FileDTO> files = fileDAO.select(boardNum);
//		스트림과 람다식
		files.stream().map(file -> file.getFileSystemName())
			.map(name -> new File(uploadPath, name))
			.filter(tmp -> tmp.exists())
			. forEach(tmp -> tmp.delete());
			
		fileDAO.delete(boardNum);
		boardDAO.delete(boardNum);
		
		result.setPath("/board/boardListOk.bo");
		result.setRedirect(true);
		
		return result;
	}
	
}
