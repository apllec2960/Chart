package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.DBHelper;
import vo.Tips;

public class BarcharDao {
	public List<Tips> selectBarchar(){
		List<Tips> list =new ArrayList<Tips>();
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql= null;
		ResultSet rs = null;
		try {
			conn = DBHelper.getConncetion();
			sql="SELECT DAY, ROUND(SUM(total_bill)) AS bill , ROUND(SUM(tip)) AS tip \r\n" + 
					"FROM tips \r\n" + 
					"GROUP BY day";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Tips t = new Tips();
				t.setDay(rs.getString("Day"));
				t.setTotal(rs.getDouble("bill"));
				t.setTip(rs.getDouble("tip"));
				list.add(t);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.close(rs, stmt, conn);
		}
		
		return list;
	}
}
