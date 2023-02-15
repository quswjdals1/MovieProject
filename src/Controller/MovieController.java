package Controller;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import Service.MemberService;
import Service.MovieService;
import Service.ReservationService;
import Vo.TicketVo;

public class MovieController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MovieController movieController = new MovieController();
		movieController.run(1);
	}
	
	final int MAIN = 1;
	final int JOIN = 2;
	final int LOGIN= 3;
	final int MLOGIN=4;
	final int MOVMAIN=5;
	final int MMOVMAIN=6;
	final int resCheckPage=7;
	
	public static String userId;
	public static String userPW;
	public static String resNo;
	public static Set<TicketVo> cart; 
	
	private MemberService memberService =new MemberService();
	private MovieService movieService =new MovieService();
	private ReservationService reservationService =new ReservationService();
	
	Scanner sc = new Scanner(System.in);
	
	
	int view = 1;
	void run(int test) {
		view=test;
		
		out:while(true){
			
			switch(view){
				case 1: 
					view=memberService.main(sc);  
					break;
					
				case 2:
					view=memberService.join(sc);
					break;
		
				case 3:							   
					view=memberService.login(sc);
					break;
					
			    case 4:
					view=memberService.manLogin(sc);
					break;
		
				case 5:
					view=movieService.movMain(sc);
					break;
					
				case 6:
					view=memberService.MMain(sc);
					break;
				
				case 7:
					view=reservationService.resCheckPage(sc);
					break;
				
				case 999:
					System.out.println("에러발생. 프로그램 종료");
				
			}

		}
		
		
		
	}

}
