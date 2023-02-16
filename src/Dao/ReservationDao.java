package Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Vo.ReservationVo;
import oracle.jdbc.OracleTypes;

public class ReservationDao {
		private static ReservationDao reservationDao = new ReservationDao();
		
		public static ReservationDao getInstance() {
			return reservationDao;
		}


		public List<ReservationVo> selectReservation() throws Exception{
			
			//id를 받아서 중복된 id가 있을경우 true, 중복없으면 false
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.146.61:1521:xe","movie","java");
			
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT ");
			sb.append("    res_no, ");
			sb.append("    res_date, ");
			sb.append("    res_total, ");
			sb.append("    mem_id ");
			sb.append("FROM ");
			sb.append("    reservation ");
			String sql = sb.toString();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			List<ReservationVo> list = new ArrayList<>();
			while(resultSet.next()) {
				String resNo=resultSet.getString("res_no");
				Timestamp resDate=resultSet.getTimestamp("res_date");
				int resTotal = resultSet.getInt("res_total");
				String memId= resultSet.getString("mem_id");
				
				list.add(new ReservationVo(resNo, resDate, resTotal, memId));
			}
			resultSet.close();
			statement.close();
			connection.close();
			return list;
		}
		
		
		public List<ReservationVo> selectReservation(String id) throws Exception{
			
			//id를 받아서 reservation 객체 list로 리턴
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.146.61:1521:xe","movie","java");
			
			
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT ");
			sb.append("    res_no, ");
			sb.append("    res_date, ");
			sb.append("    res_total, ");
			sb.append("    mem_id ");
			sb.append("FROM ");
			sb.append("    reservation ");
			sb.append("WHERE ");
			sb.append("    mem_id = ? ");
			String sql = sb.toString();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, id);
			ResultSet resultSet = statement.executeQuery();
			List<ReservationVo> list = new ArrayList<>();
			while(resultSet.next()) {
				String resNo=resultSet.getString("res_no");
				Timestamp resDate=resultSet.getTimestamp("res_date");
				int resTotal = resultSet.getInt("res_total");
				String memId= resultSet.getString("mem_id");
				
				list.add(new ReservationVo(resNo, resDate, resTotal, memId));
			}
			resultSet.close();
			statement.close();
			connection.close();
			
			return list;
		}
		
		
		
		public String insertReservation(String memId) {
			
			//reservation 번호 생성후 바로 insert 성공시 created_res_no, 실패시 error 리턴
			int result=0;
			String createdNo="";
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.146.61:1521:xe","movie","java");
				
				
				StringBuilder sb = new StringBuilder();
				sb.append("CALL proc_insert_reservation(sysdate,0,?,?,?) ");

				String sql = sb.toString();

				CallableStatement pcStatement = connection.prepareCall(sql);
				
				pcStatement.setString(1,memId );
				pcStatement.registerOutParameter(2, OracleTypes.CHAR);
				pcStatement.registerOutParameter(3, OracleTypes.NUMBER);
				pcStatement.execute();
				createdNo = pcStatement.getString(2);
				result = pcStatement.getInt(3);
				

				pcStatement.close();
				connection.close();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("자바 클래스 오류");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("insert 실패");
			}
			return createdNo;
			
		}
		
		
		
		
		public int deleteReservation(String resNo) throws Exception{
			
			//id를 받아서 reservation삭제 및 종속된 reservation_ticket 삭제.  삭제성공시 1, 삭제 실패시 0
			int result=0;
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.146.61:1521:xe","movie","java");
				
				
				StringBuilder sb = new StringBuilder();
				sb.append("DELETE FROM reservation WHERE ");
				sb.append("res_no = ? ");

				String sql = sb.toString();
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setString(1, resNo);
				result = statement.executeUpdate();	

				statement.close();
				connection.close();
				return result;
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("자바 클래스 오류");
				return result;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("delete 실패");
				return result;
			}
		}
		
		
		public int updateReservation(String resNo,int resTotal) throws Exception{
			

			//resNo와 total을 입력받아서 해당row를 현재시간으로 업데이트
			int result=0;
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.146.61:1521:xe","movie","java");
				
				
				StringBuilder sb = new StringBuilder();
				sb.append("UPDATE reservation ");
				sb.append("    SET ");
				sb.append("        res_date = SYSDATE, ");
				sb.append("        res_total = ? ");
				sb.append("WHERE ");
				sb.append("    res_no = ? ");

				String sql = sb.toString();
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setInt(1, resTotal);
				statement.setString(2, resNo.trim());
				result = statement.executeUpdate();	

				statement.close();
				connection.close();
				return result;
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("자바 클래스 오류");
				return result;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("update 실패");
				e.printStackTrace();
				return result;
			}
		}
}
