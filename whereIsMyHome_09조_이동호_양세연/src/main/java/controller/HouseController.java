package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import dto.HouseDealDto;
import dto.HouseInfoDto;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.HouseDealService;
import service.HouseDealServiceImpl;
import service.HouseInfoService;
import service.HouseInfoServiceImpl;


@WebServlet("/house")
public class HouseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HouseInfoService infoService;
	private HouseDealService dealService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HouseController() {
        infoService = HouseInfoServiceImpl.getInstance();
        dealService = HouseDealServiceImpl.getInstance();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
        String path = "index.jsp";
        if ("list".equals(action)) {
			path = list(request, response);
			forward(request, response, path);
		} else if ("main".equals(action)) {
			response.sendRedirect(request.getContextPath() + "/index.jsp");
		} else if ("announce".equals(action)) {
			response.sendRedirect(request.getContextPath() + "/announce.jsp");
		} 
        
		else if ("aptList".equals(action)) {
			response.sendRedirect(request.getContextPath() + "/aptfilter.jsp");
		} else if ("interest".equals(action)) {
			response.sendRedirect(request.getContextPath() + "/interest.jsp");
		}else if ("loginpage".equals(action)) {
			response.sendRedirect(request.getContextPath() + "/login.jsp");
		}
		
		else if ("viewApt".equals(action)) {
			path = viewApt(request, response);
			request.getRequestDispatcher(path).forward(request, response);
		}
		else if ("viewAptSearch".equals(action)) {
			path = viewAptSearch(request, response);
			request.getRequestDispatcher(path).forward(request, response);
		}
		else if ("viewDetailAptDeal".equals(action)) {
			path = viewDetailAptDeal(request, response);
			request.getRequestDispatcher(path).forward(request, response);
		}
	}

	private String viewApt(HttpServletRequest request, HttpServletResponse response){
	    String dong = request.getParameter("dong");
	    String year = request.getParameter("year");
	    String month = request.getParameter("month");
	    
	    List<HouseInfoDto> aptInfoList = new ArrayList<>();
	    
	    try {
			aptInfoList = infoService.findAllbyDongCode(dong);
			request.setAttribute("aptInfoList", aptInfoList);
			request.setAttribute("year", year);
			request.setAttribute("month", month);
			request.setAttribute("dong", dong);
			
			for(HouseInfoDto info: aptInfoList)
				System.out.println(info);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
	    
		return "/aptfilter.jsp";
	    
	}
	
	private String viewAptSearch(HttpServletRequest request, HttpServletResponse response){
	    StringTokenizer keyword = new StringTokenizer(request.getParameter("keyword"));
	    
//	    List<HouseInfoDto> aptInfoList = new ArrayList<>();
//	    
//	    try {
//			aptInfoList = infoService.findAllbyDongCode(dong);
//			request.setAttribute("aptInfoList", aptInfoList);
//			request.setAttribute("year", year);
//			request.setAttribute("month", month);
//			request.setAttribute("dong", dong);
//			
//			for(HouseInfoDto info: aptInfoList)
//				System.out.println(info);
//			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			
//			e.printStackTrace();
//		}
	    
		return "/aptfilter.jsp";
	    
	}
	
	
	private String viewDetailAptDeal(HttpServletRequest request, HttpServletResponse response){
	    String aptName = request.getParameter("aptName");
	    String dong = request.getParameter("dong");
	    String year = request.getParameter("year");
	    String month = request.getParameter("month");
	    String lng = request.getParameter("lng");
	    String lat = request.getParameter("lat");
	    
	    
	    List<HouseDealDto> aptDealList = new ArrayList<>();
	    List<HouseInfoDto> aptInfoList = new ArrayList<>();
	    
	    
	   
	    
	    try {
	    	if(!year.equals("") && !month.equals(""))
	    		aptDealList = dealService.findAllByAptCode(aptName, Integer.parseInt(year), Integer.parseInt(month));
	    	else if(!year.equals(""))
	    		aptDealList = dealService.findAllByAptCode(aptName, Integer.parseInt(year));
	    	else
	    		aptDealList = dealService.findAllByAptCode(aptName);
			request.setAttribute("aptDealList", aptDealList);
			
			aptInfoList = infoService.findAllbyDongCode(dong);
			request.setAttribute("aptInfoList", aptInfoList);
			request.setAttribute("aptName", aptName);
			request.setAttribute("year", year);
			request.setAttribute("month", month);
			request.setAttribute("dong", dong);
			request.setAttribute("lng", Double.parseDouble(lng));
			request.setAttribute("lat", Double.parseDouble(lat));
			
			
			
			for(HouseDealDto info: aptDealList)
				System.out.println(info);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	    
		return "/aptfilter.jsp";
	    
	}
	

	private String list(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
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
}
