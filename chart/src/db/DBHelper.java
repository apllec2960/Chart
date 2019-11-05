package db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBHelper {   
   // db를 연결해주는 메소드
      public static Connection getConncetion() throws Exception{
          Class.forName("org.mariadb.jdbc.Driver");
          Connection conn = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/pythondb","root","java1234");
          return conn;
      }      
      public static void close(ResultSet rs, Statement stmt, Connection conn) {
  		
  		if( rs != null) {
  			try {rs.close();}	catch(SQLException e) {e.printStackTrace();}
  		}
  		if( stmt != null) {
  			try {stmt.close();}	catch(SQLException e) {e.printStackTrace();}
  		}
  		if( conn != null) {
  			try {conn.close();}	catch(SQLException e) {e.printStackTrace();}
  		}
  	}
}
      // db를 종료하는 메소드
