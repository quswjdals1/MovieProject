package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import Vo.MovieVo;
import Vo.ScheduleVo;

/*
 *********************************************************
String now = "2009-03-20 10:20:30.0";  		timestamp 생성시 형식
java.sql.Timestamp t = java.sql.Timestamp.valueOf(now);
***********************************************************
*/
public class ScheduleDao {
	private static ScheduleDao scheduleDao= new ScheduleDao();
	
	public static ScheduleDao getInstance() {
		return scheduleDao;
	}


	
	public List<ScheduleVo> selectSchedule(){
		
		// 모든 일정객체를 담은 리스트 리턴.
		// 결과가 없을경우 SIZE=0의 LIST, 있을경우 SIZE=ROWNUM의 LIST 리턴
		
		
		List<ScheduleVo> list = new ArrayList<>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.146.61:1521:xe","movie","java");
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT ");
			sb.append("    mov_name, ");
			sb.append("    sch_date ");
			sb.append("FROM ");
			sb.append("    movie, ");
			sb.append("    schedule ");
			sb.append("WHERE ");
			sb.append("    schedule.mov_id = movie.mov_id ");
			sb.append("    and sysdate<sch_date ");
			String sql=sb.toString();
			PreparedStatement pStatement = connection.prepareStatement(sql);
			ResultSet resultSet = pStatement.executeQuery();

			while(resultSet.next()) {
				String movName=resultSet.getString("mov_name");
				Timestamp schDate=resultSet.getTimestamp("sch_date");

				list.add(new ScheduleVo(schDate,movName));
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
	
	
	
	
	public List<ScheduleVo> selectScheduleByName(String name){
		
		// 영화이름을 입력받아 해당 일정객체를 담은 리스트 리턴.
		// 결과가 없을경우 SIZE=0의 LIST, 있을경우 SIZE=ROWNUM의 LIST 리턴
		
		
		List<ScheduleVo> list = new ArrayList<>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.146.61:1521:xe","movie","java");
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT ");
			sb.append("    mov_name, ");
			sb.append("    sch_date ");
			sb.append("FROM ");
			sb.append("    movie, ");
			sb.append("    schedule ");
			sb.append("WHERE ");
			sb.append("    schedule.mov_id = movie.mov_id ");
			sb.append("    and movie.mov_name=? ");
			String sql=sb.toString();
			PreparedStatement pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, name);
			ResultSet resultSet = pStatement.executeQuery();

			while(resultSet.next()) {
				String movName=resultSet.getString("mov_name");
				Timestamp schDate=resultSet.getTimestamp("sch_date");
				
				list.add(new ScheduleVo(schDate, name));
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
	
	
	
	
	
	
	public int insertSchedule(ScheduleVo scheduleVo) {
		
		//schedule 등록 성공시 1, 실패시 0 리턴
		
		int result=0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.146.61:1521:xe","movie","java");
			
			
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT ");
			sb.append("    mov_id ");
			sb.append("FROM ");
			sb.append("    movie ");
			sb.append("WHERE ");
			sb.append("    mov_name = ? ");
			
			String sql = sb.toString();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, scheduleVo.getMOV_Name());

			ResultSet resultSet = statement.executeQuery();
			String movId = null;
			while(resultSet.next()) {
				movId=resultSet.getString("mov_id");

			}
			if(movId==null) {
				return 0;
			}
			
			
			StringBuilder sb2 = new StringBuilder();
			sb2.append(" INSERT INTO schedule VALUES ( ");
			sb2.append("        ?, ");
			sb2.append("        ? ");
			sb2.append("    ) ");
			
			sql = sb2.toString();
			PreparedStatement statement2 = connection.prepareStatement(sql);
			statement2.setTimestamp(1, scheduleVo.getSCH_DATE());
			statement2.setString(2, movId);

			result = statement2.executeUpdate();
			
			resultSet.close();
			statement.close();
			connection.close();
			return result;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("자바 클래스 오류");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("중복된 아이디가 있습니다.");
		}
		return result;
		
	}
	
	
	
	
	public int deleteScheduleByDate(Timestamp schDate) throws Exception{
		
		//schDate를 받아서 영화 삭제성공시 1, 삭제 실패시 0
		int result=0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.146.61:1521:xe","movie","java");
			
			
			StringBuilder sb = new StringBuilder();
			sb.append("DELETE FROM schedule WHERE ");
			sb.append("sch_date = ? ");

			String sql = sb.toString();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setTimestamp(1, schDate);
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
			System.out.println("해당 아이디의 계정이 없습니다.");
			return result;
		}
	}
	
	
	
	
}
