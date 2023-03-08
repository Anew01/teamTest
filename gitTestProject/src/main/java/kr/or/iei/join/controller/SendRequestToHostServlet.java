package kr.or.iei.join.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SendRequestToHostServlet
 */
@WebServlet(name = "SendRequestToHost", urlPatterns = { "/sendRequestToHost.do" })
public class SendRequestToHostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendRequestToHostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 인코딩
		request.setCharacterEncoding("utf-8");
		//2. 값추출
		String hostmail  = request.getParameter("hostmail");
		String guestmail = request.getParameter("guestmail");
		String messageText = request.getParameter("messageText");
		int fripNo = Integer.parseInt(request.getParameter("fripNo"));
		
		//3. 비즈니스 로직
		MailSender sender = new MailSender();
		boolean result = sender.sendMail(hostmail, guestmail, messageText);
		
		//4. 결과처리 
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(result) {
			request.setAttribute("title", "메일 전송 성공");
			request.setAttribute("msg", "이메일이 전송되었습니다.");
			request.setAttribute("icon", "success");
		}else {
			request.setAttribute("title", "메일 전송 실패");
			request.setAttribute("msg", "이메일 전송 오류");
			request.setAttribute("icon", "error");
		}
		request.setAttribute("loc", "/joinFrip.do?fripNo="+fripNo);
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
