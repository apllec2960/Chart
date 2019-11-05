package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.DBHelper;
import vo.CandleVo;

public class CandleData {
	public List<CandleVo> selectMale() {
		List<CandleVo> list = new ArrayList<CandleVo>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT tip FROM tips WHERE Sex='Male'";
		try {
			conn = DBHelper.getConncetion();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				CandleVo cv = new CandleVo();
				cv.setTips(rs.getDouble("tip"));
				list.add(cv);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public List<CandleVo> selectFemale() {
		List<CandleVo> list = new ArrayList<CandleVo>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT tip FROM tips WHERE Sex='FeMale'";
		try {
			conn = DBHelper.getConncetion();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				CandleVo cv = new CandleVo();
				cv.setTips(rs.getDouble("tip"));
				list.add(cv);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}

}