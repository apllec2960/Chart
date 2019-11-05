package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import db.DBHelper;
import vo.Pie;

public class PieDao {

	public List<Pie> selectDay(){
		List<Pie> list = new ArrayList<Pie>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBHelper.getConncetion();
			String sql = "select day, count(*) from tips group by day";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Pie p = new Pie();
				p.setDay(rs.getString("day"));
				p.setSize(rs.getInt("count(*)"));
				
				list.add(p);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.close(rs, stmt, conn);		
		}
		return list;
	}
}
