package controller;

import java.io.IOException;
import java.util.List;

import dto.BoardDto;
import dto.Member;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.BoardService;
import service.BoardServiceImpl;

@WebServlet("/announcement")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BoardService boardService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		boardService = BoardServiceImpl.getBoardService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		String path = "";
		if ("list".equals(action)) {
			path = list(request, response);
			forward(request, response, path);
		} else if ("view".equals(action)) {
			path = view(request, response);
			forward(request, response, path);
		} else if ("mvwrite".equals(action)) {
			path = "/board/write.jsp";
			forward(request, response, path);
		} else if ("write".equals(action)) {
			path = write(request, response);
			redirect(request, response, path);
		} else if ("mvmodify".equals(action)) {
			path = mvModify(request, response);
			forward(request, response, path);
		} else if ("modify".equals(action)) {
			path = modify(request, response);
			forward(request, response, path);
		} else if ("delete".equals(action)) {
			path = delete(request, response);
			redirect(request, response, path);
		} else {
			redirect(request, response, path);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

	private void forward(HttpServletRequest request, HttpServletResponse response, String path)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}

	private void redirect(HttpServletRequest request, HttpServletResponse response, String path) throws IOException {
		response.sendRedirect(request.getContextPath() + path);
	}

	private String list(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("member");
		if (member != null) {
			try {
				List<BoardDto> list = boardService.listArticle();
				request.setAttribute("articles", list);

				return "/board/list.jsp";
			} catch (Exception e) {
				e.printStackTrace();
				return "/index.jsp";
			}
		} else
			return "/login.jsp";
	}

	private String view(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("member");
		if (member != null) {
			int articleNo = Integer.parseInt(request.getParameter("articleno"));
			try {
				BoardDto boardDto = boardService.getArticle(articleNo);
				boardService.updateHit(articleNo);
				request.setAttribute("article", boardDto);

				return "/board/view.jsp";
			} catch (Exception e) {
				e.printStackTrace();
				return "/index.jsp";
			}
		} else
			return "/login.jsp";
	}

	private String write(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("member");
		if (member != null) {
			BoardDto boardDto = new BoardDto();
			boardDto.setUserId(member.getUserId());
			boardDto.setSubject(request.getParameter("subject"));
			boardDto.setContent(request.getParameter("content"));
			try {
				boardService.writeArticle(boardDto);
				return "/announcement?action=list";
			} catch (Exception e) {
				e.printStackTrace();
				return "/index.jsp";
			}
		} else
			return "/login.jsp";
	}

	private String mvModify(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("member");
		int no = Integer.parseInt(request.getParameter("articleno"));
		if (member != null) {
			try {
				BoardDto boardDto = boardService.getArticle(no);
				System.out.println(boardDto);
				request.setAttribute("boardDto", boardDto);
				return "/board/modify.jsp";
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		} else {
			return "/login.jsp";
		}
	}

	private String modify(HttpServletRequest request, HttpServletResponse response) {
		
			
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("member");
		if (member != null) {
			int no = Integer.parseInt(request.getParameter("articleno"));
			
			BoardDto boardDto = new BoardDto();
			boardDto.setSubject(request.getParameter("subject"));
			boardDto.setContent(request.getParameter("content"));
			boardDto.setArticleNo(no);
			
			try {
				boardService.modifyArticle(boardDto);
				return "/announcement?action=view&articleno=" + no;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		} else {
			return "/login.jsp";
		}
		
	}

	private String delete(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("member");
		if (member != null) {
			int no = Integer.parseInt(request.getParameter("articleno"));
			
			try {
				boardService.deleteArticle(no);
				return "/announcement?action=list";
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		} else {
			return "/login.jsp";
		}
		
	}

}
