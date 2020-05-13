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
		//���䵥������ content-type�� ���� 	
		/*
		 * response.setContentType("text/html;charset=utf-8"); //��� ��Ʈ�� ���� PrintWriter
		 * out = response.getWriter(); Date myDate = new Date();
		 * out.println("<h2>���� ��¥�� " + myDate + " </h2>"); out.close();
		 */
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		getUsers(request,response);
	}

	private void getUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//����� ��� ��ȸ ó��
		System.out.println("HelloServlet doget()");
		//1. User DAO�� �żҵ� ȣ��
		List<UserVO> userlist =  userDAO.getUsers();
		//2. ���� ���� List ��ü�� JSP�� ����� �� �ֵ��� Request scope�� �����ؾ� ��.
		request.getRequestDispatcher("userList.jsp");
		//3List��ü�� ������� JSP�� �������Ѵ�.
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
