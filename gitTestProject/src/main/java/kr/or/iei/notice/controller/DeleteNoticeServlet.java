package kr.or.iei.notice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.iei.notice.service.NoticeService;

@WebServlet(name = "DeleteNotice", urlPatterns = { "/deleteNotice.do" })
public class DeleteNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteNoticeServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));

		NoticeService service = new NoticeService();
		int result = service.deleteNotice(noticeNo);

		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");

		if (result > 0) {
			request.setAttribute("title", "삭제 성공");
			request.setAttribute("msg", "공지사항이 삭제되었습니다.");
			request.setAttribute("icon", "success");
			request.setAttribute("loc", "/noticeList.do?reqPage=1");
		} else {
			request.setAttribute("title", "삭제 실패");
			request.setAttribute("msg", "관리자에게 문의하세요");
			request.setAttribute("icon", "error");
			request.setAttribute("loc", "/noticeList.do?reqPage=1");
		}

		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
