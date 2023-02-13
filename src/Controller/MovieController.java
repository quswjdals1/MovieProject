package Controller;

import Service.MemberService;
import Service.MovieService;

public class MovieController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MovieController movieController = new MovieController();
		movieController.run();
	}
	
	final int MAIN = 1;
	final int JOIN = 2;
	final int LOGIN= 3;
	final int MLOGIN=4;
	final int MOVMAIN=5;
	final int MMOVMAIN=6;
	
	public String userId;
	public String userPW;
	
	private MemberService memberService =new MemberService();
	private MovieService movieService =new MovieService();
	
	
	int view = 1;
	void run() {
		
		out:while(true){
			
			switch(view){
				case 1: 
					view=memberService.main();  
					break;
					
				case 2:
					view=memberService.join();
					break;
		
				case 3:							   
					view=memberService.login();
					break;
					
			    case 4:
					view=memberService.manLogin();
					break;
		
				case 5:
					view=movieService.movMain();
					break;
					
				case 6:
					view=movieService.MmovMain();
					break;
				
			}

		}
		
		
		
	}

}
