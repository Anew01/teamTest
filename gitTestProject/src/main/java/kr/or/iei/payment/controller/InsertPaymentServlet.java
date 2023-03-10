package kr.or.iei.payment.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.iei.payment.service.PaymentService;

/**
 * Servlet implementation class InsertPaymentServlet
 */
@WebServlet(name = "InsertPayment", urlPatterns = { "/insertPayment.do" })
public class InsertPaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertPaymentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String date = request.getParameter("date");
		int price = Integer.parseInt(request.getParameter("price"));
		int memberNo = Integer.parseInt(request.getParameter("memberNo"));
		int attendNo = Integer.parseInt(request.getParameter("attendNumber"));
		int fripNo = Integer.parseInt(request.getParameter("fripNo"));
		
		PaymentService service = new PaymentService();
		int result = service.insertPayment(date, price, memberNo, fripNo, attendNo);
		
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		Gson gson =  new Gson();
		gson.toJson(result, out);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
