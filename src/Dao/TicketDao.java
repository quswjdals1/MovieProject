package Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Timestamp;

import Vo.TicketVo;
import oracle.jdbc.OracleTypes;



public class TicketDao {


	
	public int insertTicketAndRt(TicketVo ticketVo,String resNo) {
		
		// ticket번호 생성후, 바로 ticket테이블에 insert후, 바로 reservation_ticket 
		//테이블에 insert,    성공시 1, 실패시 0 리턴
		 
		
		int result=0;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.146.61:1521:xe","movie","java");
			
			
			StringBuilder sb = new StringBuilder();
			sb.append("CALL PROC_INSERT_TICKET_AND_RT(?,?,?,?,?) ");

			String sql = sb.toString();

			CallableStatement pcStatement = connection.prepareCall(sql);
			
			pcStatement.setString(1,resNo );
			pcStatement.setString(2,ticketVo.getMOV_ID() );
			pcStatement.setString(3, ticketVo.getSEAT_NO());
			pcStatement.setTimestamp(4, ticketVo.getSCH_DATE());
			pcStatement.registerOutParameter(5, OracleTypes.NUMBER);
			pcStatement.execute();
			result = pcStatement.getInt(5);
			

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
