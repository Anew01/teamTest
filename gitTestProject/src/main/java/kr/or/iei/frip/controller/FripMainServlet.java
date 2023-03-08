package kr.or.iei.frip.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.iei.feed.service.FeedService;
import kr.or.iei.feed.vo.Feed;
import kr.or.iei.feed.vo.ViewFripFeedData;
import kr.or.iei.frip.service.FripService;
import kr.or.iei.frip.vo.Frip;
import kr.or.iei.frip.vo.FripMainDate;
import kr.or.iei.payment.service.PaymentService;
import kr.or.iei.rating.service.RatingService;

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
		String fripWriter = request.getParameter("memberId");
		ArrayList<Frip> list = service.selectMyFrip(fripWriter);
		System.out.println(list);
		int totalIncome = 0;
		int totalInquiryCount = 0;
		int feedTotalRating = 0;
		int totalRatingAvg = 0;
		int totalFripCount = list.size();
		int totalPaymentCount = 0;
		int	totalFeedCount = 0;
		int totalExpiredFripCount = 0;
		ArrayList<ViewFripFeedData> feedList = new ArrayList<>();
		
		for(Frip f : list) {
			PaymentService pService = new PaymentService();
			FeedService fService = new FeedService();
			feedList = fService.selectAllMyFripFeed(f.getFripNo());
			System.out.println(1);
			if(feedList.size() > 0) {
				for(ViewFripFeedData data : feedList) {
					System.out.println(2);
					RatingService rService = new RatingService();
					feedTotalRating += rService.selectAllMyFripRating(data.getF().getFeedNo());
				}
				totalRatingAvg = feedTotalRating / feedList.size();				
			}
			totalPaymentCount += pService.selectCountMyFripPayment(f.getFripNo());
			totalIncome += f.getFripIncome();
			if( Integer.parseInt(f.getFripStatus()) == 1) {
				totalExpiredFripCount++;
			}
		}
		FripMainDate data = new FripMainDate();
		data.setTotalExpiredFripCount(totalExpiredFripCount);
		data.setTotalFeedCount(totalFeedCount);
		data.setTotalFripCount(totalFripCount);
		data.setTotalIncome(totalIncome);
		data.setTotalInquiryCount(totalInquiryCount);
		data.setTotalPaymentCount(totalPaymentCount);
		data.setTotalrankCount(totalRatingAvg);
		
		request.setAttribute("data", data);
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
