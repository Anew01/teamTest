package kr.or.iei.feed.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.or.iei.feed.service.FeedService;
import kr.or.iei.feed.vo.Feed;
import kr.or.iei.feed.vo.ViewFripFeedData;
import kr.or.iei.rating.service.RatingService;

/**
 * Servlet implementation class InsertFeedServlet
 */
@WebServlet(name = "InsertFeed", urlPatterns = { "/insertFeed.do" })
public class InsertFeedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertFeedServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String root = getServletContext().getRealPath("/");
		String saveDirectory = root + "upload/feed";
		int maxsize = 10 * 1024 * 1024;

		MultipartRequest mRequest = new MultipartRequest(request, saveDirectory, maxsize, "utf-8", new DefaultFileRenamePolicy());
		request.setCharacterEncoding("utf-8");
		String feedWriter = mRequest.getParameter("feedWriter");
		String feedContent = mRequest.getParameter("feedContent");
		String filepath = mRequest.getFilesystemName("filepath");
		int fripNo = Integer.parseInt(mRequest.getParameter("fripNo"));
		int rating = Integer.parseInt(mRequest.getParameter("rating"));
		System.out.println("인서트jsp에서 넘어온 memberId 값 : "+feedWriter);
		System.out.println("인서트jsp에서 넘어온 feedContent 값 : "+feedContent);
		System.out.println("인서트jsp에서 넘어온 fripNo 값 : "+fripNo);
		System.out.println("인서트jsp에서 넘어온 rating 값 : "+rating);
		FeedService service = new FeedService();
		int result = service.insertFeed(feedWriter, feedContent, fripNo, filepath);
		int feedNo = service.selectLastestFeedNo(fripNo, feedWriter);
		RatingService rService = new RatingService();
		int rResult = rService.insertRating(feedNo, rating);
		Feed f = service.selectFeed(feedNo);
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		Gson gson = new Gson();
		if(result > 0 && rResult > 0) {
			gson.toJson(f, out);
		} else {
			gson.toJson("실패", out);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
