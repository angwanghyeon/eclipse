package com.keduit;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/upload.do")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset = UTF-8");
		PrintWriter out = response.getWriter();
		
		String savePath = "upload";
		//업로드 파일 사이즈를 5MB로 주었다 
		int uploadFileSizeLimit = 5*1024*1024;
		String encType = "UTF-8";
		
		ServletContext context = getServletContext();
		//컨텍스트가 가지고 있는 패스이다.
		String uploadFilePath = context.getRealPath(savePath);
		System.out.print("서버상의 실제 디렉토리 : ");
		System.out.println(uploadFilePath);
		
		MultipartRequest multi = new MultipartRequest
				(request, uploadFilePath,
				uploadFileSizeLimit, encType
				,new DefaultFileRenamePolicy());
		String fileName = multi.getFilesystemName("uploadFile");
		if(fileName == null) {
			System.out.println("파일이 업로드 되지 않았습니다.");
		}else {
			out.println("<br> 글쓴이 : "+multi.getParameter("name"));
			out.println("<br> 제목 : "+multi.getParameter("title"));
			out.println("<br> 파일명 : "+fileName);
			System.out.println("");
		}
		
	}

}
