package kr.or.iei.frip.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.iei.frip.service.FripService;
import kr.or.iei.frip.vo.Frip;

/**
 * Servlet implementation class FripMainServlet
 */
@WebServlet(name = "FripMain", urlPatterns = { "/fripMain.do" })
public class FripMainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FripMainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/frip/fripMain.jsp");
		FripService service = new FripService();
		String fripWriter = "user01";
		ArrayList<Frip> list = service.selectMyFrip(fripWriter);
		int totalIncome = 0;
		int totalInquiryCount = 0;
		int totalrankCount = 0;
		int totalFeedCount = 0;
		int totalPaymentCount = 0;
		int totalFripCount = 0;
		int totalExpiredFripCount = 0;
		for(Frip f : list) {
			totalIncome += f.getFripIncome();
		}
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
