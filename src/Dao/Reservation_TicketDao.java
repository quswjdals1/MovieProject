package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Vo.MemberVo;
import Vo.Reservation_TicketVo;


public class Reservation_TicketDao {

	
	
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
	
	
	
	
	

}

