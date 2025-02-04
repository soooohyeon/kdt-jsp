package com.example.app.board;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.app.Execute;
import com.example.app.Result;
import com.example.app.board.dao.BoardDAO;
import com.example.app.dto.BoardDTO;
import com.example.app.dto.FileDTO;
import com.example.app.file.dao.FileDAO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class BoardWriteOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		Result result = new Result();
		BoardDAO boardDAO = new BoardDAO();
		BoardDTO boardDTO = new BoardDTO();
		FileDAO fileDAO = new FileDAO();
		FileDTO fileDTO = new FileDTO();
		
//		로그인한 회원 정보 가져오기
		Integer memberNum = (Integer)request.getSession().getAttribute("memberNumber");
		
		if (memberNum == null) {
			System.out.println("오류 : 로그인된 사용자가 없습니다.");
			response.sendRedirect("login.jsp");
			return null;
		}
		
//		파일이 저장될 경로
		final String UPLOAD_PATH = "D:\\web_0900_psh\\jsp_6\\workspace\\final_jsp\\src\\main\\webapp\\upload";
//		final String UPLOAD_PATH = request.getSession().getServletContext().getRealPath("upload/");
//		final String UPLOAD_PATH = request.getRealPath("/upload");
//		final String UPLOAD_PATH = 
		System.out.println("===================================");
		System.out.println("11111 : " + request.getRealPath("/upload"));
		System.out.println("222222 : " + request.getSession().getServletContext().getRealPath("/"));
		System.out.println("333333333 : " + request.getSession().getServletContext().getRealPath("upload/"));
		System.out.println("===================================");
		
//		파일 사이즈 최대 5MB
		final int FILE_SIZE = 1024 * 1024 * 5;
//		System.out.println("파일 업로드 경로 : " + UPLOAD_PATH);
		
		MultipartRequest multipartRequest = new MultipartRequest(request, UPLOAD_PATH, FILE_SIZE, "UTF-8",
				new DefaultFileRenamePolicy());
		
//		게시글 정보 설정
//		jsp 파일에서 form 인코딩 방식이 multipart로 되어있기때문에 일반 방식으로 값 받아올 수 있음
//		boardDTO.setBoardTitle(request.getParameter("boardTitle"));
//		boardDTO.setBoardContent(request.getParameter("boardContent"));
		boardDTO.setBoardTitle(multipartRequest.getParameter("boardTitle"));
		boardDTO.setBoardContent(multipartRequest.getParameter("boardContent"));
		
		boardDTO.setMemberNumber(memberNum);
//		System.out.println("게시글 추가 - boardDTO : " + boardDTO);
		
//		게시글 추가
		int boardNumber = boardDAO.insertBoard(boardDTO);
//		System.out.println("생성된 게시글 번호 : " + boardNumber);
		
//		파일 업로드
//		Enumeration : java.util 패키지에 포함된 인터페이스, Iterator과 비슷한 역할
		Enumeration<String> fileNames = multipartRequest.getFileNames();
		while(fileNames.hasMoreElements()) {
			String name = fileNames.nextElement();
			String fileSystemName = multipartRequest.getFilesystemName(name);
			String fileOriginalName = multipartRequest.getOriginalFileName(name);
			
//			업로드한 파일이 없다면 진행 X
			if (fileSystemName == null) {
				continue;
			}
			fileDTO.setFileSystemName(fileSystemName);
			fileDTO.setFileOriginalName(fileOriginalName);
			fileDTO.setBoardNumber(boardNumber);
			
			fileDAO.insert(fileDTO);
		}
		
		
		
		result.setPath("/board/boardListOk.bo");
		result.setRedirect(true);
		
		return result;
	}

}
