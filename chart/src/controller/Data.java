package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.SelectData;
import vo.Temperature;

/**
 * Servlet implementation class Data
 */
@WebServlet("/data")
public class Data extends HttpServlet {
	private SelectData sd;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("서블렛 실행!!!");
	response.setContentType("application/json; charset=utf-8");
	sd = new SelectData();
	
	List<Temperature> list = sd.selectData();
	
	Gson gson = new Gson();
	String jsonStr = gson.toJson(list);
	response.getWriter().write(jsonStr);
	
	}

}


