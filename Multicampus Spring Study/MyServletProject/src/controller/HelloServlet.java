package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

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
		System.out.println("HelloServlet doget()");
		process(request, response);
		//����� ��� ��ȸ ó��
		//1. User DAO�� �żҵ� ȣ��
		
	}

	private void showUsers(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<UserVO> userlist =  userDAO.getUsers();
		//2. ���� ���� List ��ü�� JSP�� ����� �� �ֵ��� Request scope�� �����ؾ� ��.
		request.setAttribute("userList", userlist);
		//3. List��ü�� ������� JSP�� �������Ѵ�.
		request.getRequestDispatcher("userList.jsp");
		RequestDispatcher rd = request.getRequestDispatcher("userList.jsp");
		rd.forward(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		if(cmd == null) {
			return;
		}
		if(cmd.equals("user_list")) {
			showUsers(request, response);
		}else if(cmd.equals("user_form")) {
			insertUser(request, response);
		}else if(cmd.equals("user_insert")) {
			String userId = request.getParameter("userid");
			String name = request.getParameter("name");
			String gender = request.getParameter("gender");
			String city = request.getParameter("city");
			UserVO userVO = new UserVO(userId, name, gender, city);
			userDAO.insert(userVO);
		} 
	}

	private void insertUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		List<String> cities = new ArrayList<String>();
		cities.add("����");
		cities.add("�뱸");
		cities.add("����");
		cities.add("����");
		cities.add("�λ�");
		session.setAttribute("cityList", cities.toArray());
		RequestDispatcher rd = request.getRequestDispatcher("inserUser.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	
	}
	
	@Override
	public void destroy() {
		System.out.println("HelloServlet destroy()");
	}

}
