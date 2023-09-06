package com.keduit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.keduit.dao.MemberDAO;
import com.keduit.dto.MemberVo;

/**
 * Servlet implementation class JoinServlet
 */
@WebServlet("/join.do")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher disp = request.getRequestDispatcher("member/join.jsp");
		disp.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int result = 0;
		
		MemberVo mv = new MemberVo();
		
		mv.setName(request.getParameter("name"));
		mv.setUserid(request.getParameter("userid"));
		mv.setPwd(request.getParameter("pwd"));
		mv.setEmail(request.getParameter("email"));
		mv.setPhone(request.getParameter("phone"));
		mv.setAdmin(Integer.parseInt(request.getParameter("admin")));
		
		MemberDAO md = MemberDAO.getInstance();
		result = md.insertMember(mv);
		
		HttpSession session = request.getSession();
		if(result == 1) {
			request.setAttribute("message", "회원가입에 성공했습니다.");
			session.setAttribute("userid", mv.getUserid());
		}else {
			request.setAttribute("message", "회원가입에 실패하셨습니다.");
		}
		
		RequestDispatcher disp = request.getRequestDispatcher("member/01_login.jsp");
		disp.forward(request, response);
	}

}
