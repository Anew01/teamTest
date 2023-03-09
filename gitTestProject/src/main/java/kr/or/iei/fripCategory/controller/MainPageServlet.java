package kr.or.iei.fripCategory.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.iei.frip.service.FripService;
import kr.or.iei.frip.vo.Frip;

/**
 * Servlet implementation class AllCategoryServlet
 */
@WebServlet(name = "MainPage", urlPatterns = { "/mainPage.do" })
public class MainPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//인코딩
		request.setCharacterEncoding("utf-8");
		
		String categoryName = request.getParameter("categoryName");
		String newFeed = request.getParameter("newFeed");
		
		FripService service = new FripService();
		ArrayList<Frip> list = service.selectAllFripByCategory(categoryName);
	    ArrayList<Frip> rList = service.selectAllFripByCategory(categoryName);
	    ArrayList<Frip> nList = service.selectNewFeed(newFeed);
	    
	    for(Frip f : list) {
	        String avgRating = service.selectRating(f.getFripNo());
	        f.setAvgRating(avgRating);
	    }
	    
	    request.setAttribute("list", list);
	    request.setAttribute("rList", rList);
	    request.setAttribute("nList", nList);
	    
	    RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/mainPage.jsp");
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
