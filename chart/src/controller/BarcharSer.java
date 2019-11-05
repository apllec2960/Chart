package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.BarcharDao;
import vo.Tips;

/**
 * Servlet implementation class BarcharSer
 */
@WebServlet("/BarcharSer")
public class BarcharSer extends HttpServlet {
	private BarcharDao bar;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("서블렛 실행");
		// TODO Auto-generated method stub
		response.setContentType("application/json;charset=utf-8");
		
		bar = new BarcharDao();
		
		List<Tips> list = bar.selectBarchar();
		
		
		Gson json = new Gson();
		String jsonStr = json.toJson(list);
		response.getWriter().write(jsonStr);
	}

}
