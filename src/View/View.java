package View;

import java.util.Scanner;

public class View {

	public int mainView(Scanner sc) {
		// TODO Auto-generated method stub
		
		System.out.println("=========================================");
		System.out.println();
		System.out.println("	 1. 회원가입");
		System.out.println();
		System.out.println("	 2. 로그인");
		System.out.println();
		System.out.println("	 3. 관리자 로그인");
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("=========================================");
		System.out.print("원하시는 메뉴를 선택해주세요.: ");
	
		return Integer.parseInt(sc.nextLine());
	}

	public int joinView(Scanner sc) {
		// TODO Auto-generated method stub
		loop:while(true) {
			
			System.out.println("=========================================");
			System.out.println();
			System.out.println("                  회원가입");
			System.out.println();
			System.out.println("          I D    : ");
			System.out.println();
			System.out.println("        PASSWORD : ");
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("                   뒤로가려면 엔터키를 누르세요.");
			System.out.println("=========================================");
			System.out.print("id 입력: ");
			String id=sc.nextLine();
			if(id.equals("")) {
				return 1;
			}
			
			System.out.println("=========================================");
			System.out.println();
			System.out.println("                  회원가입");
			System.out.println();
			System.out.println("          I D    : "+id);
			System.out.println();
			System.out.println("        PASSWORD : ");
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("                   뒤로가려면 엔터키를 누르세요.");
			System.out.println("=========================================");
			System.out.print("password 입력: ");
			String pw=sc.nextLine();
			if(id.equals("")) {
				return 1;
			}
			
			System.out.println("=========================================");
			System.out.println();
			System.out.println("                  회원가입");
			System.out.println();
			System.out.println("          I D    : "+id);
			System.out.println();
			System.out.println("        PASSWORD : ****");
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("             회원정보 확인중.");
			System.out.println();
			System.out.println();
			System.out.println("");
			System.out.println("=========================================");
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			System.out.println("=========================================");
			System.out.println();
			System.out.println("                  회원가입");
			System.out.println();
			System.out.println("          I D    : "+id);
			System.out.println();
			System.out.println("        PASSWORD : ****");
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("             회원정보 확인중..");
			System.out.println();
			System.out.println();
			System.out.println("");
			System.out.println("=========================================");
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println("=========================================");
			System.out.println();
			System.out.println("                  회원가입");
			System.out.println();
			System.out.println("          I D    : "+id);
			System.out.println();
			System.out.println("        PASSWORD : ****");
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("             회원정보 확인중...");
			System.out.println();
			System.out.println();
			System.out.println("");
			System.out.println("=========================================");
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			//********************************************************************
			
			
			//select member로 입력한 id가 중복된 id인지 확인하는 dao 
			//중복 true, 중복되지 않으면 false 반환 
			
			
			//********************************************************************
			
			
			boolean result=false;
			if(result) {

				System.out.println("이미 존재하는 id입니다.");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			else {

				System.out.println("회원가입 성공!");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break loop;

			}
		}

		return 1;
	}
	
}
