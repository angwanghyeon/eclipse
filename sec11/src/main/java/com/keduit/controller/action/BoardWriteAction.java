package com.keduit.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.keduit.dao.BoardDAO;
import com.keduit.dto.BoardVo;

public class BoardWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		
		String url = "board/boardList.jsp";
		
		BoardVo bv = new BoardVo();
		bv.setName(request.getParameter("name"));
		bv.setTitle(request.getParameter("title"));
		bv.setEmail(request.getParameter("email"));
		bv.setContent(request.getParameter("content"));
		bv.setPass(request.getParameter("pass"));
		
		BoardDAO bd = BoardDAO.getInstance();
		bd.insertBoard(bv);
		List<BoardVo> boardList =  bd.selectAllBoards();
		request.setAttribute("boardList", boardList);
		
		response.sendRedirect("index.jsp");
	}

}
