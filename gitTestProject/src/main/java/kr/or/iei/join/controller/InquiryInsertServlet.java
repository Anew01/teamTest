package kr.or.iei.join.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.iei.inquiry.vo.Inquiry;
import kr.or.iei.join.service.JoinFripService;
import kr.or.iei.join.vo.JoinFrip;

/**
 * Servlet implementation class InquiryServlet
 */
@WebServlet(name = "InquiryInsert", urlPatterns = { "/inquiryInsert.do" })
public class InquiryInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InquiryInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//query : insert  into frip_inquiry values(frip_inquiry_seq.nextval, frip_no, inquiry_writer, inquiry_content,  fi_no, to_char(sysdate,'yyyy-mm-dd'));
		//1. 인코딩
		request.setCharacterEncoding("utf-8");
		//2. 값추출
		String msgText = request.getParameter("messageText");
		String guestmail = request.getParameter("guestmail");
		int fripNo= Integer.parseInt(request.getParameter("fripNo"));
		Inquiry i = new Inquiry();
		i.setInquiryContent(msgText);
		i.setInquiryWriter(guestmail);
		i.setFripNo(fripNo);
		//3. 비즈니스 로직
		JoinFripService service = new JoinFripService();
		int result = service.InquiryInsert(i);
		//4. 결과처리 
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(result>0) {
			request.setAttribute("title", "문의 완료");
			request.setAttribute("msg", "호스트에게 문의가 잘 전송되었습니다.");
			request.setAttribute("icon", "success");
			request.setAttribute("loc", "/joinFrip.do?fripNo="+fripNo);
			
		}else {
			request.setAttribute("title", "문의전송 오류");
			request.setAttribute("msg", "재시도 후 실패시 고객센터 문의 바랍니다.");
			request.setAttribute("icon", "error");
			request.setAttribute("loc", "/joinFrip.do?fripNo="+fripNo);
		}
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
