package com.keduit;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberServlet
 */
@WebServlet("/memberservlet")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//자바 빈 생성
		MemberBean mb = new MemberBean();
		//한글 세팅
		request.setCharacterEncoding("UTF-8");
		
		mb.setName(request.getParameter("name"));
		mb.setUserid(request.getParameter("userid"));
		mb.setNickname(request.getParameter("nickname"));
		mb.setPwd(request.getParameter("pwd"));
		
		//elmemeber jsp로 가겠따.
		RequestDispatcher disp = request.getRequestDispatcher("05_elMember2.jsp");
		disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//자바 빈 생성
		MemberBean mb = new MemberBean();
		//한글 세팅
		request.setCharacterEncoding("UTF-8");
		
		mb.setName(request.getParameter("name"));
		mb.setUserid(request.getParameter("userid"));
		mb.setNickname(request.getParameter("nickname"));
		mb.setPwd(request.getParameter("pwd"));
		
		//elmemeber jsp로 가겠따.
		RequestDispatcher disp = request.getRequestDispatcher("05_elMember.jsp");
		disp.forward(request, response);
	}

}
