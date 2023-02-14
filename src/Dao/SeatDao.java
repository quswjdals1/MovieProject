package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import Vo.ScheduleVo;
import Vo.SeatVo;

/*
 *********************************************************
String now = "2009-03-20 10:20:30.0";  		timestamp 생성시 형식
java.sql.Timestamp t = java.sql.Timestamp.valueOf(now);
***********************************************************
*/

public class SeatDao {
	//select update
	

	public List<SeatVo> selectSeatByDate(Timestamp schDate){
		
		// 좌석객체를 담은 리스트 리턴.
		// 결과가 없을경우 SIZE=0의 LIST, 있을경우 SIZE=ROWNUM의 LIST 리턴
		
		
		List<SeatVo> list = new ArrayList<>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.146.61:1521:xe","movie","java");
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT ");
			sb.append("    seat_no, ");
			sb.append("    seat_check ");
			sb.append("FROM ");
			sb.append("    seat ");
			sb.append("where sch_date=? ");
			String sql=sb.toString();
			PreparedStatement pStatement = connection.prepareStatement(sql);
			pStatement.setTimestamp(1, schDate);
			ResultSet resultSet = pStatement.executeQuery();

			while(resultSet.next()) {
				String seatNo=resultSet.getString("seat_no");
				String seatCheck=resultSet.getString("seat_check");
				
				list.add(new SeatVo(seatNo, schDate, seatCheck));
			}
			resultSet.close();
			pStatement.close();
			connection.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	}
	
	
	
	
public String selectSeatByDateNo(Timestamp schDate,String seatNo){
		
		// 좌석객체정보를 입력받아 예약유무를 String으로 리턴.
		
		
		String seatCheck="";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.146.61:1521:xe","movie","java");
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT ");
			sb.append("    seat_no, ");
			sb.append("    seat_check ");
			sb.append("FROM ");
			sb.append("    seat ");
			sb.append("where sch_date=? ");
			sb.append("		and seat_no=? ");
			String sql=sb.toString();
			PreparedStatement pStatement = connection.prepareStatement(sql);
			pStatement.setTimestamp(1, schDate);
			pStatement.setString(2, seatNo);
			ResultSet resultSet = pStatement.executeQuery();
			resultSet.next();
			seatCheck=resultSet.getString("seat_check");
			
			resultSet.close();
			pStatement.close();
			connection.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return seatCheck;

	}



	

	public int updateSeat(SeatVo seatVo, boolean isNoToYes){
	
	// 좌석객체를 입력받은 정보로 업데이트. isNoToYes가 트루이면 no를 yes로 false이면
	// yes를 no로. 성공시 1, 실패시 0 리턴
		String newSeatCheck="";
		int result = 0;
		
		if(isNoToYes) {
			newSeatCheck="yes";
		}else {
			newSeatCheck="no";
		}

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.146.61:1521:xe","movie","java");
			StringBuilder sb = new StringBuilder();
			sb.append("UPDATE seat ");
			sb.append("    SET ");
			sb.append("        seat_check =? ");
			sb.append("WHERE ");
			sb.append("    seat_no =? ");
			sb.append("    AND   sch_date =? ");

			String sql=sb.toString();
			PreparedStatement pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, newSeatCheck);
			pStatement.setString(2, seatVo.getSEAT_NO());
			pStatement.setTimestamp(3, seatVo.getSCH_DATE());
			result= pStatement.executeUpdate();
	
			
			pStatement.close();
			connection.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	
	}
	
}
