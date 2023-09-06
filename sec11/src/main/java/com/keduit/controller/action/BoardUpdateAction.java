package com.keduit.controller.action;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.keduit.dao.BoardDAO;
import com.keduit.dto.BoardVo;

public class BoardUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		BoardDAO bd = BoardDAO.getInstance();
		
		BoardVo bv = new BoardVo();
		
		String url = "/board/boardView.jsp";
		
		bv.setName(request.getParameter("name"));
		bv.setPass(request.getParameter("pass"));
		bv.setEmail(request.getParameter("email"));
		bv.setTitle(request.getParameter("title"));
		bv.setContent(request.getParameter("content"));
		bv.setReadcount(Integer.parseInt(request.getParameter("readcount")));
		bv.setWritedate(Timestamp.valueOf(request.getParameter("writedate")));
		bd.updateBoard(bv);
		
		request.setAttribute("board", bv);
		
		RequestDispatcher disp = request.getRequestDispatcher(url);
		disp.forward(request, response);
		
	}

}
