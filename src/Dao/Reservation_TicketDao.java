package Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Vo.Reservation_TicketVo;
import Vo.TicketVo;
import oracle.jdbc.OracleTypes;


public class Reservation_TicketDao {
	
	private static Reservation_TicketDao reservation_TicketDao= new Reservation_TicketDao();
	
	public static Reservation_TicketDao getInstance() {
		return reservation_TicketDao;
	}

	
	
	public List<Reservation_TicketVo> selectRtByResNo(String resNo){
		
		// resno를 입력받아 같은 resno의 RT객체를 담은 리스트 리턴.
		// 결과가 없을경우 SIZE=0의 LIST, 있을경우 SIZE=ROWNUM의 LIST 리턴
		
		
		List<Reservation_TicketVo> list = new ArrayList<>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.146.61:1521:xe","movie","java");
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT ");
			sb.append("    res_no, ");
			sb.append("    ticket_no ");
			sb.append("FROM ");
			sb.append("    reservation_ticket ");
			sb.append("WHERE ");
			sb.append("    res_no = ? ");
			String sql=sb.toString();
			PreparedStatement pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, resNo);
			ResultSet resultSet = pStatement.executeQuery();
			
			while(resultSet.next()) {
				String resNoFromSql=resultSet.getString("res_no");
				String ticketNo = resultSet.getString("ticket_no");
				
				list.add(new Reservation_TicketVo(resNoFromSql, ticketNo));
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
	
	
	
	
	
	
	public List<Reservation_TicketVo> selectRt(){
		
		// 모든 RT테이블의 각각 RT객체를 담은 리스트 리턴.
		// 결과가 없을경우 SIZE=0의 LIST, 있을경우 SIZE=ROWNUM의 LIST 리턴
		
		
		List<Reservation_TicketVo> list = new ArrayList<>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.146.61:1521:xe","movie","java");
			Statement statement = connection.createStatement();
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT ");
			sb.append("    res_no, ");
			sb.append("    ticket_no ");
			sb.append("FROM ");
			sb.append("    reservation_ticket ");
			String sql=sb.toString();
			ResultSet resultSet = statement.executeQuery(sql);	
			while(resultSet.next()) {
				String resNoFromSql=resultSet.getString("res_no");
				String ticketNo = resultSet.getString("ticket_no");
				
				list.add(new Reservation_TicketVo(resNoFromSql, ticketNo));
			}
			resultSet.close();
			statement.close();
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
	
	
	

	public int insertRT(String ticketNo, String resNo) {
		
		//res와 ticketNo을 받아서 rt테이블에 insert
		//성공시 1 실패시 0 리턴
		int result=0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.146.61:1521:xe","movie","java");
			
			
			StringBuilder sb = new StringBuilder();
			sb.append("insert into reservation_ticket values(trim(?),trim(?)) ");
	
			String sql = sb.toString();
	
			CallableStatement pcStatement = connection.prepareCall(sql);
			
			pcStatement.setString(1,resNo );
			pcStatement.setString(2,ticketNo );
			result =pcStatement.executeUpdate();

			
	
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
		return result;
		
	}

	
	

}

