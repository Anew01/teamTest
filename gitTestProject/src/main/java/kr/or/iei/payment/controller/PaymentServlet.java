package kr.or.iei.payment.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.iei.frip.service.FripService;
import kr.or.iei.frip.vo.Frip;

/**
 * Servlet implementation class PaymentServlet
 */
@WebServlet(name = "Payment", urlPatterns = { "/payment.do" })
public class PaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 인코딩
		request.setCharacterEncoding("utf-8");
		String strDate = request.getParameter("date");
		
	
		SimpleDateFormat dtFormat = new SimpleDateFormat("MM/dd/yyyy");
		SimpleDateFormat newDtFormat = new SimpleDateFormat("yyyy-MM-dd");
		// String 타입을 Date 타입으로 변환
		Date formatDate = null;
		try {
			formatDate = (Date) dtFormat.parse(strDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Date타입의 변수를 새롭게 지정한 포맷으로 변환
		String strNewDtFormat = newDtFormat.format(formatDate);
		//2. 값추출
		//선택한 날짜와 참석자 수를 결제페이지로 그대로 가져간다.
		int fripNo = Integer.parseInt(request.getParameter("fripNo"));
		String date = request.getParameter("date");
		int attendNumber =Integer.parseInt(request.getParameter("attendNumber"));
		//3. 비즈니스 로직
		//query 2: select frip_addr, frip_name, frip_price from frip_tbl where frip_no=?;
		FripService service  = new FripService();
		Frip f = service.selectOneFripByNo(fripNo);
		
		//4. 결과처리
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/api/pay.jsp");
		request.setAttribute("strNewDtFormat", strNewDtFormat);
		request.setAttribute("date", date);
		request.setAttribute("attendNumber", attendNumber);
		request.setAttribute("f", f);
		view.forward(request, response);

		//response.getWriter().println("<script>alert('결제 성공!'); history.back();</script>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
