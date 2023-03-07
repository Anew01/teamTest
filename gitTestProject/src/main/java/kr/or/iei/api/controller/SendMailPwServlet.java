package kr.or.iei.api.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.iei.member.service.MemberService;
import kr.or.iei.member.vo.Member;

/**
 * Servlet implementation class SendMailPwServlet
 */
@WebServlet(name = "SendMailPw", urlPatterns = { "/sendMailPw.do" })
public class SendMailPwServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendMailPwServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.인코딩
		request.setCharacterEncoding("utf-8");
		//2.값추출
		String email = request.getParameter("email");
		
		Member member = new Member();
		member.setMemberId(request.getParameter("email"));
		
		
		//3.비즈니스로직
		MailSenderPw sender = new MailSenderPw();
		String randomCode = sender.sendMail(email);
		member.setMemberPw(randomCode);
		
		MemberService service = new MemberService();
		int result = service.updateMember(member);
		
		
		//4.결과처리
		PrintWriter out = response.getWriter();
		out.print(randomCode);
		
		if(result>0) {
			Member m = new Member();
			m.setMemberPw(member.getMemberPw());
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
