package com.keduit;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member")
public class ParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ParamServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//포스트를 받아서 구현한다.
		//일단 한글이 깨지지 않게 해주는 구문작성
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		//받을 변수를 생성
		String id = request.getParameter("id");
		int age = Integer.parseInt(request.getParameter("age"));
		
		
		//화면에 보여줄 writer 생성
		PrintWriter out = response.getWriter();
		out.println("<html><head></head><body>");
		out.println("당신이 입력한 자료를 다음과 같다. <br>");
		out.print("아이디 : ");
		out.println(id);
		out.print("나이 : ");
		out.println(age);
		out.println("<br><a href='javascript:history.go(-1)'>다시 입력</a>");
		out.println("</body></html>");
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//포스트를 받아서 구현한다.
		//일단 한글이 깨지지 않게 해주는 구문작성
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		//받을 변수를 생성
		String id = request.getParameter("id");
		int age = Integer.parseInt(request.getParameter("age"));
		
		
		//화면에 보여줄 writer 생성
		PrintWriter out = response.getWriter();
		out.println("<html><head></head><body>");
		out.println("당신이 입력한 자료를 다음과 같다. <br>");
		out.print("아이디 : ");
		out.println(id);
		out.print("나이 : ");
		out.println(age);
		out.println("<br><a href='javascript:history.go(-1)'>다시 입력</a>");
		out.println("</body></html>");
		out.close();
	}

}
