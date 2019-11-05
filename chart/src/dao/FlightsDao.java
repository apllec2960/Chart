package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DBHelper;
import vo.Flights;


public class FlightsDao {
	public List<Flights> selectFlightOne(){
		List<Flights> list = new ArrayList<Flights>();
		Connection conn= null;
		PreparedStatement stmt =null;
		ResultSet rs = null;
		String sql = "SELECT YEAR," +
				"SUM(CASE WHEN MONTH IN ('january','february','march') THEN passengers ELSE 0 END) '1q',"+
				"SUM(CASE WHEN MONTH IN('april', 'may', 'june') THEN passengers ELSE 0 END) '2q',"+
				"SUM(CASE WHEN month IN ('july','august','september') THEN passengers ELSE 0 END) '3q',"+
				"SUM(CASE WHEN month IN ('october', 'november','december') THEN passengers ELSE 0 END) '4q' "+
				"FROM flights "+
				"GROUP BY year";
		try {
			conn = DBHelper.getConncetion();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Flights ft = new Flights();
				ft.setYear(rs.getInt("YEAR"));
				ft.setPassengers(rs.getInt("1q"));
				ft.setPassengers2(rs.getInt("2q"));
				ft.setPassengers3(rs.getInt("3q"));
				ft.setPassengers4(rs.getInt("4q"));
				list.add(ft);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.close(rs, stmt, conn);
		}
		return list;
	}
}
