package Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import Vo.TicketVo;
import oracle.jdbc.OracleTypes;



public class TicketDao {

	private static TicketDao ticketDao = new TicketDao();
	
	public static TicketDao getInstance() {
		return ticketDao;
	}
	
	
	public String insertTicket(TicketVo ticketVo) {
		
		// ticket번호 생성후, 바로 ticket테이블에  
		//insert,    성공시 ticket_no, 실패시 error문구 리턴
		 
		
		String result=null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.146.61:1521:xe","movie","java");
			
			
			StringBuilder sb = new StringBuilder();
			sb.append("CALL PROC_INSERT_TICKET(?,?,?,?) ");

			String sql = sb.toString();

			CallableStatement pcStatement = connection.prepareCall(sql);
			
			pcStatement.setString(1,ticketVo.getMOV_ID() );
			pcStatement.setString(2, ticketVo.getSEAT_NO());
			pcStatement.setTimestamp(3, ticketVo.getSCH_DATE());
			pcStatement.registerOutParameter(4, OracleTypes.CHAR);
			pcStatement.execute();
			result = pcStatement.getString(4);
			

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
	
	
	
	
	
	
	
	
	
	
	
	
	public TicketVo selectTicket(String ticketNo) {
		
		// 티켓 번호를 받아서 해당하는 티켓 리턴
		 
		
		TicketVo ticketVo=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.146.61:1521:xe","movie","java");
			
			
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT ");
			sb.append("    ticket_no, ");
			sb.append("    ticket_price, ");
			sb.append("    mov_id, ");
			sb.append("    seat_no, ");
			sb.append("    sch_date ");
			sb.append("FROM ");
			sb.append("    ticket ");
			sb.append("WHERE ");
			sb.append("    ticket_no =? ");

			String sql = sb.toString();

			CallableStatement pcStatement = connection.prepareCall(sql);
			
			pcStatement.setString(1,ticketNo );
			
			
			ResultSet resultSet = pcStatement.executeQuery();
			while(resultSet.next()) {
				String TicketNo = resultSet.getString("ticket_no");
				int ticketPrice = resultSet.getInt("ticket_price");
				String movId = resultSet.getString("mov_id");
				String seatNo = resultSet.getString("seat_no");
				Timestamp schDate = resultSet.getTimestamp("sch_date");
				
				ticketVo=new TicketVo(TicketNo, ticketPrice, movId, seatNo, schDate);
			}
			
			resultSet.close();
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
		return ticketVo;
		
	}
}
