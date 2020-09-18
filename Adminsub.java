package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Admin_bean;
import bean.Keigiban_bean;
import dao.Admin_dao;
import dao.Keigiban_dao;

/**
 * Servlet implementation class Adminsub
 */
@WebServlet("/adminsub")
public class Adminsub extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Adminsub() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		//int id = Integer.valueOf(request.getParameter("id"));
		int id = Integer.valueOf(request.getParameter("id"));
		String name = request.getParameter("name");
//		String mail = request.getParameter("mail");
//		String content = request.getParameter("content");
//		String time = request.getParameter("time");
//		Keigiban_bean keigiban = new Keigiban_bean(name,mail,content,time);
//		Keigiban_dao.insert(keigiban);
		ArrayList<Keigiban_bean> list = Keigiban_dao.selectAll();
		ArrayList<Keigiban_bean> list2 = new ArrayList<Keigiban_bean>();
		for( Keigiban_bean s : list){
		list2.add( new Keigiban_bean(s.getId(),s.getName(),s.getContent(),s.getTime()) );
		}
		//なお上記をDAOを使ってArrayListを取得する処理に書き換えることで
		//DBの一覧を表示することも可能

		request.setAttribute("list", list2);



		request.setCharacterEncoding("UTF-8");

		Admin_bean delete = new Admin_bean(id,name);

		Admin_dao.delete(delete);

		//<h1 align="center">『<%=title %>』を削除しました。</h1>

		String view = "/WEB-INF/view/admin.jsp";

		RequestDispatcher dispatcher = request.getRequestDispatcher(view);

		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
