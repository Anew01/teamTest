package kr.or.iei.notice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.iei.notice.service.NoticeService;
import kr.or.iei.notice.vo.Notice;

@WebServlet(name = "NoticeWrite", urlPatterns = { "/noticeWrite.do" })
public class NoticeWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public NoticeWriteServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		String noticeTitle = request.getParameter("noticeTitle");
		String noticeWriter = request.getParameter("noticeWriter");
		String noticeCategory = request.getParameter("noticeCategory");
		String noticeContent = request.getParameter("noticeContent");

		Notice notice = new Notice();

		notice.setNoticeTitle(noticeTitle);
		notice.setNoticeWriter(noticeWriter);
		notice.setNoticeCategory(noticeCategory);
		notice.setNoticeContent(noticeContent);

		NoticeService service = new NoticeService();

		int result = service.insertNotice(notice);

		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");

		if (result > 0) {
			request.setAttribute("title", "게시글이 작성성공");
			request.setAttribute("msg", "게시글이 작성되었습니다.");
			request.setAttribute("icon", "success");

		} else {
			request.setAttribute("title", "게시글이 작성실패");
			request.setAttribute("msg", "오류가 발생했습니다. 홈페이지에 문의해주세요.");
			request.setAttribute("icon", "error");
		}
		request.setAttribute("loc", "/noticeList.do?reqPage=1");

		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
