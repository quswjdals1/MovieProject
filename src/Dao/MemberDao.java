package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Vo.MemberVo;

public class MemberDao {

	public List<MemberVo> selectMember() throws Exception{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.146.61:1521:xe","movie","java");
		Statement statement = connection.createStatement();
		String sql="select mem_id,mem_pw,mem_name from member";
		ResultSet resultSet = statement.executeQuery(sql);
		List<MemberVo> list = new ArrayList<>();
		while(resultSet.next()) {
			String memId=resultSet.getString("mem_id");
			String memPw=resultSet.getString("mem_pw");
			String memName=resultSet.getString("mem_name");
			
			list.add(new MemberVo(memId, memPw, memName));
		}
		resultSet.close();
		statement.close();
		connection.close();
		return list;
	}
	
	
	public boolean selectPresentMember(String id) throws Exception{
		
		//id를 받아서 중복된 id가 있을경우 true, 중복없으면 false
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.146.61:1521:xe","movie","java");
		
		
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT ");
		sb.append("    mem_id ");
		sb.append("FROM ");
		sb.append("    member ");
		sb.append("WHERE ");
		sb.append("    mem_id = ? ");
		String sql = sb.toString();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, id);
		ResultSet resultSet = statement.executeQuery();
		String dup=null;
		while(resultSet.next()) {
			dup=resultSet.getString(1);
		}
		resultSet.close();
		statement.close();
		connection.close();
		if(dup!=null) {
			return true;
		}
		return false;
	}
	
	
	
	
	
	public int insertMember(MemberVo memberVo) {
		
		//member 등록 성공시 1, 실패시 0 리턴
		
		int result=0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.146.61:1521:xe","movie","java");
			
			
			StringBuilder sb = new StringBuilder();
			sb.append("INSERT INTO member VALUES ( ");
			sb.append("    ?, ");
			sb.append("    ?, ");
			sb.append("    ? ");
			sb.append(") ");
			
			String sql = sb.toString();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, memberVo.getMEM_ID());
			statement.setString(2, memberVo.getMEM_PW());
			statement.setString(3, memberVo.getMEM_NAME());

			result = statement.executeUpdate();

			statement.close();
			connection.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("자바 클래스 오류");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("중복된 아이디가 있습니다.");
		}
		return result;
		
	}
	
	
	
	
	public int deleteMember(String id) throws Exception{
		
		//id를 받아서 아이디 삭제성공시 1, 삭제 실패시 0
		int result=0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.146.61:1521:xe","movie","java");
			
			
			StringBuilder sb = new StringBuilder();
			sb.append("DELETE FROM member WHERE ");
			sb.append("mem_id = ? ");

			String sql = sb.toString();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, id);
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
