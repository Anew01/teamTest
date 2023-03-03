package kr.or.iei.adminMember.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.or.iei.member.service.MemberService;
import kr.or.iei.member.vo.Member;

@WebServlet(name = "UpdateMember", urlPatterns = { "/updateMember.do" })
public class UpdateMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateMemberServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String root = getServletContext().getRealPath("/");
		String saveDirectory = root + "upload/member";
		int maxsize = 10 * 1024 * 1024;

		MultipartRequest mRequest = new MultipartRequest(request, saveDirectory, maxsize, "utf-8",
				new DefaultFileRenamePolicy());

		Member member = new Member();

		member.setMemberId(mRequest.getParameter("memberId"));
		member.setMemberPw(mRequest.getParameter("memberPw"));
		member.setMemberPhone(mRequest.getParameter("memberPhone"));
		member.setMemberAddr(mRequest.getParameter("memberAddr"));
		member.setMemberIntro(mRequest.getParameter("memberIntro"));
		member.setMemberProfile(mRequest.getFilesystemName("upProfile"));

		MemberService service = new MemberService();

		int result = service.updateMember(member);

		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");

		if (result > 0) {
			request.setAttribute("title", "성공");
			request.setAttribute("msg", "정보 수정 성공");
			request.setAttribute("icon", "success");
		} else {
			request.setAttribute("title", "실패");
			request.setAttribute("msg", "정보 수정에 문제가 발생했습니다. 홈페이지에 문의해주세요.");
			request.setAttribute("icon", "error");
		}

		request.setAttribute("loc", "/adminPage.do?reqPage=1");

		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
