package controller;

import java.io.IOException;

import dto.Member;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.MemberService;
import service.MemberServiceImpl;

/**
 * Servlet implementation class MemberController
 */
@WebServlet("/member")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static MemberService memberService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberController() {
    	memberService = MemberServiceImpl.getInstance();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String path = "";
		switch (action){
		case "loginForm": {
			response.sendRedirect(request.getContextPath() + "/login.jsp");
			break;
		}
		case "login": {
			path = doLogin(request, response);
			forward(request, response, path);
//			response.sendRedirect(path);
			break;
		}
		case "registForm": {
			response.sendRedirect(request.getContextPath() + "/signup.jsp");
			break;
		}
		case "regist": {
			path = doRegist(request, response);
			response.sendRedirect(path);
			break;
		}
		case "profile": {
			response.sendRedirect(request.getContextPath() + "/profile.jsp");
			break;
		}
		case "modify": {
			path = doModify(request, response);
			response.sendRedirect(path);
			break;
		}
		case "delete": {
			path = doDeletes(request, response);
			response.sendRedirect(path);
			break;
		}
		case "modifyForm": {
			path = request.getContextPath() + "/update.jsp";
			response.sendRedirect(path);
			break;
		}
		case "logout": {
			path = doLogout(request, response);
			response.sendRedirect(path);
		}
		
		}
	}

	private String doLogout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.invalidate();
		return request.getContextPath() + "/index.jsp";
	}

	private String doDeletes(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("member");
		memberService.delete(member.getUserId());
		session.invalidate();
		return request.getContextPath() + "/index.jsp";
	}

	private String doModify(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("member");
		if (member != null) {
			String userId = request.getParameter("email");
		    String userName = request.getParameter("name");
		    String userPassword = request.getParameter("password");
		    String address = request.getParameter("address");
		    String phoneNumber = request.getParameter("phoneNumber");
		    member = new Member(userId, userName, userPassword, address, phoneNumber);		
			memberService.update(member);
			
			session = request.getSession();
			session.setAttribute("member", member);
			System.out.println(member);
			
			return request.getContextPath() + "/profile.jsp";
		} else
			return "/login.jsp";
		
		
	}

	private String doRegist(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("member");
		String userId = request.getParameter("email");
	    String userName = request.getParameter("name");
	    String userPassword = request.getParameter("password");
	    String address = request.getParameter("address");
	    String phoneNumber = request.getParameter("phoneNumber");
		member = new Member(userId, userName, userPassword, address, phoneNumber);
		memberService.join(member);

		return request.getContextPath() + "/login.jsp";

	}

	private void forward(HttpServletRequest request, HttpServletResponse response, String path) throws ServletException, IOException {
		request.getRequestDispatcher(path).forward(request, response);
	}

	private String doLogin(HttpServletRequest request, HttpServletResponse response) {
		try {
			String id = request.getParameter("email");
			if(memberService.login(id, request.getParameter("password"))) {
				Member member = memberService.findById(id);
				HttpSession session = request.getSession();
				session.setAttribute("member", member);
				Cookie cookie = new Cookie("sessionId", session.getId());
				cookie.setMaxAge(24*60*60*60);
				response.addCookie(cookie);	
			} else {
				request.setAttribute("msg", "로그인 실패");
				return "login.jsp";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index.jsp";
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
