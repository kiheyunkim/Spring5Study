package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myspring.user.vo.UserDAO;
import myspring.user.vo.UserVO;


/**
 * Servlet implementation class HelloServlet
 */
//@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserDAO userDAO;
    
	@Override
	public void init() throws ServletException {
		
		System.out.println("HelloServlet init()");
		userDAO = new UserDAO();
	}
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Get() Called");
		
		// TODO Auto-generated method stub
		//응답데이터의 content-type을 설정 	
		/*
		 * response.setContentType("text/html;charset=utf-8"); //출력 스트림 생성 PrintWriter
		 * out = response.getWriter(); Date myDate = new Date();
		 * out.println("<h2>현재 날짜는 " + myDate + " </h2>"); out.close();
		 */
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		getUsers(request,response);
	}

	private void getUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//사용자 목록 조회 처리
		System.out.println("HelloServlet doget()");
		//1. User DAO의 매소드 호출
		List<UserVO> userlist =  userDAO.getUsers();
		//2. 리턴 받은 List 객체를 JSP가 사용할 수 있도록 Request scope애 저장해야 함.
		request.getRequestDispatcher("userList.jsp");
		//3List객체를 출력해줄 JSP로 포워딩한다.
		RequestDispatcher rd = request.getRequestDispatcher("userList.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
	@Override
	public void destroy() {
		System.out.println("HelloServlet destroy()");
	}

}
