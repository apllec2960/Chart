package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.PieDao;
import vo.Pie;

/**
 * Servlet implementation class pieDay
 */
@WebServlet("/pieDay")
public class pieDay extends HttpServlet {
	private PieDao pd;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("apllication/json; charset=utf-8");
	System.out.println("파이서블렛 실행::");
	pd = new PieDao();
	
	List<Pie> list = pd .selectDay();
	
	Gson json = new Gson();
	String jsonStr = json.toJson(list);
	response.getWriter().write(jsonStr);
	
	}

}
