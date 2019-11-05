package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.CandleData;
import vo.CandleVo;

/**
 * Servlet implementation class Candle
 */
@WebServlet("/tipFemale")
public class Candle2 extends HttpServlet {
	private CandleData cd;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/json; charset=utf-8");
		System.out.println("FFtipMale 써블릿 실행");
		cd = new CandleData();
	
		List<CandleVo> list = cd.selectFemale();
		
		Gson gson = new Gson();
		String jsonStr = gson.toJson(list);
		
		response.getWriter().write(jsonStr);
	}

}
