package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import db.DBHelper;
import vo.Temperature;

public class SelectData {

	public List<Temperature> selectData(){
		System.out.println("제발 넣어놓으라고ㅜ 1!!!!");
		List<Temperature> list = new ArrayList<Temperature>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBHelper.getConncetion();
			String sql = "SELECT year, temp FROM plot1";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Temperature temp = new Temperature();
				temp.setTemp(rs.getInt("temp"));
				temp.setYear(rs.getInt("year"));
				list.add(temp);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.close(rs, stmt, conn);		
		}
		return list;
	}
}
