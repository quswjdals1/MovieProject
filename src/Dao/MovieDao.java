package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Vo.MemberVo;
import Vo.MovieVo;

public class MovieDao {

	private static MovieDao movieDao = new MovieDao();
	
	public static MovieDao getInstance() {
		return movieDao;
	}
	
	public List<MovieVo> selectMovie(){
		
		// 모든 영화객체를 담은 리스트 리턴.
		// 결과가 없을경우 SIZE=0의 LIST, 있을경우 SIZE=ROWNUM의 LIST 리턴
		
		
		List<MovieVo> list = new ArrayList<>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.146.61:1521:xe","movie","java");
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT ");
			sb.append("    mov_id, ");
			sb.append("    mov_name, ");
			sb.append("    mov_director ");
			sb.append("FROM ");
			sb.append("    movie ");
			String sql=sb.toString();
			PreparedStatement pStatement = connection.prepareStatement(sql);
			ResultSet resultSet = pStatement.executeQuery();

			while(resultSet.next()) {
				String movId=resultSet.getString("mov_id");
				String movName=resultSet.getString("mov_name");
				String movDirector=resultSet.getString("mov_director");
				
				list.add(new MovieVo(movId, movName, movDirector));
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
	
	
	
	
	public List<MovieVo> selectMovieByName(String name){
		
		// 영화이름을 입력받아 해당 영화객체를 담은 리스트 리턴.
		// 결과가 없을경우 SIZE=0의 LIST, 있을경우 SIZE=ROWNUM의 LIST 리턴
		
		
		List<MovieVo> list = new ArrayList<>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.146.61:1521:xe","movie","java");
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT ");
			sb.append("    mov_id, ");
			sb.append("    mov_name, ");
			sb.append("    mov_director ");
			sb.append("FROM ");
			sb.append("    movie ");
			sb.append("WHERE ");
			sb.append("    mov_name = ? ");
			String sql=sb.toString();
			PreparedStatement pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, name);
			ResultSet resultSet = pStatement.executeQuery();

			while(resultSet.next()) {
				String movId=resultSet.getString("mov_id");
				String movName=resultSet.getString("mov_name");
				String movDirector=resultSet.getString("mov_director");
				
				list.add(new MovieVo(movId, movName, movDirector));
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
	
	
	
	
public String selectNameById(String Id){
		
		// 영화id를 입력받아 이름 리턴
		
		String movName="";
		List<MovieVo> list = new ArrayList<>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.146.61:1521:xe","movie","java");
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT ");
			sb.append("    mov_id, ");
			sb.append("    mov_name, ");
			sb.append("    mov_director ");
			sb.append("FROM ");
			sb.append("    movie ");
			sb.append("WHERE ");
			sb.append("    mov_id = ? ");
			String sql=sb.toString();
			PreparedStatement pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, Id);
			ResultSet resultSet = pStatement.executeQuery();
			
			while(resultSet.next()) {
				String movId=resultSet.getString("mov_id");
				movName=resultSet.getString("mov_name");
				String movDirector=resultSet.getString("mov_director");
				
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
		return movName;

	}
	
	
	
	
	
	
	
	
	
	public int insertMovie(MovieVo movieVo) {
		
		//Movie 등록 성공시 1, 실패시 0 리턴
		
		int result=0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.146.61:1521:xe","movie","java");
			
			
			StringBuilder sb = new StringBuilder();
			sb.append("INSERT INTO movie VALUES ( ");
			sb.append("    ?, ");
			sb.append("    ?, ");
			sb.append("    ? ");
			sb.append(") ");
			
			String sql = sb.toString();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, movieVo.getMovId());
			statement.setString(2, movieVo.getMovName());
			statement.setString(3, movieVo.getMovDirector());

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
	
	
	
	
	public int deleteMovie(String movId) throws Exception{
		
		//MOVid를 받아서 영화 삭제성공시 1, 삭제 실패시 0
		int result=0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.146.61:1521:xe","movie","java");
			
			
			StringBuilder sb = new StringBuilder();
			sb.append("DELETE FROM Movie WHERE ");
			sb.append("mov_id = ? ");

			String sql = sb.toString();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, movId);
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
