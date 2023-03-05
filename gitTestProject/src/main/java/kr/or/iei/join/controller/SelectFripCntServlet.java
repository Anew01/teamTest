package kr.or.iei.join.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import kr.or.iei.join.service.JoinFripService;
import kr.or.iei.join.vo.JoinFrip;

/**
 * Servlet implementation class SelectFripCntServlet
 */
@WebServlet(name = "SelectFripCnt", urlPatterns = { "/selectFripCnt.do" })
public class SelectFripCntServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectFripCntServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//   03/07/2023
		String strDate = request.getParameter("date");
		int fripNo = Integer.parseInt(request.getParameter("fripNo"));
		
	
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
		
		System.out.println("fripNo : "+fripNo);
		System.out.println("date 포맷 전 : " + strDate);
		System.out.println("date 포맷 후 : " + strNewDtFormat);
		
		JoinFripService service = new JoinFripService();
		JoinFrip j = service.selectCount(strNewDtFormat, fripNo);
			
		System.out.println(j.getMaxCnt()+"  "+j.getUseCnt());
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		
		PrintWriter out = response.getWriter();
		
		
		JSONObject result = new JSONObject();
		result.put("maxCnt", j.getMaxCnt());
		result.put("useCnt", j.getUseCnt());
		
		out.print(result);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
