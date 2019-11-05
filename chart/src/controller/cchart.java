package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.FlightsDao;
import vo.Flights;

/**
 * Servlet implementation class cchart
 */
@WebServlet("/cchart")
public class cchart extends HttpServlet {
	private FlightsDao fd;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("서블렛 실행~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		response.setContentType("apllication/json;charset=utf-8");
		
		fd = new FlightsDao();
		List<Flights> list = fd.selectFlightOne();
		
		System.out.println(list);
		
		Gson json = new Gson();
		String jsonStr = json.toJson(list);
		response.getWriter().write(jsonStr);
		
	}
}
