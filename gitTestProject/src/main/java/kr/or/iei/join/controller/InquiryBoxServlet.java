package kr.or.iei.join.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.iei.inquiry.service.InquiryService;
import kr.or.iei.inquiry.vo.InquiryList;

/**
 * Servlet implementation class InquiryBoxServlet
 */
@WebServlet(name = "InquiryBox", urlPatterns = { "/inquiryBox.do" })
public class InquiryBoxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InquiryBoxServlet() {
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
		int fripNo = Integer.parseInt(request.getParameter("fripNo"));
		//3. 비즈니스 로직
		//query : select inquiry_writer, inquiry_content from frip_inquiry where frip_no=?;
		InquiryService iservice = new InquiryService();
		ArrayList<InquiryList> list = iservice.allInquiryList(fripNo);
		//4. 결과도출 
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/feed/feedList.jsp");
		request.setAttribute("list", list);
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
