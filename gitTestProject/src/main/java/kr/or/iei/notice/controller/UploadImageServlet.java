package kr.or.iei.notice.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet(name = "UploadImage", urlPatterns = { "/uploadImage.do" })
public class UploadImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UploadImageServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		String root = getServletContext().getRealPath("/");
		String saveDirectory = root + "upload/notice";
		int maxSize = 10 * 1024 * 1024;

		MultipartRequest mRequest = new MultipartRequest(request, saveDirectory, maxSize, "UTF-8",
				new DefaultFileRenamePolicy());

		String filepath = mRequest.getFilesystemName("file");

		PrintWriter out = response.getWriter();
		out.print("/upload/notice/" + filepath);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
