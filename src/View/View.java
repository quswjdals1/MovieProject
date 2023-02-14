package View;

import java.util.Scanner;

import Dao.MemberDao;
import Vo.MemberVo;

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
	

	public int joinView(Scanner sc,MemberDao memberDao) {
		// TODO Auto-generated method stub
		loop: while (true) {

			System.out.println("=========================================");
			System.out.println();
			System.out.println("                  회원가입");
			System.out.println();
			System.out.println("          I D    : ");
			System.out.println();
			System.out.println("        PASSWORD : ");
			System.out.println();
			System.out.println("         NAME    :");
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("                   뒤로가려면 엔터키를 누르세요.");
			System.out.println("=========================================");
			System.out.print("id 입력: ");
			String id = sc.nextLine();
			if (id.equals("")) {
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
			System.out.println("         NAME    :");
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("                   뒤로가려면 엔터키를 누르세요.");
			System.out.println("=========================================");
			System.out.print("PASSWWORD 입력: ");
			String password = sc.nextLine();
			if (id.equals("")) {
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
			System.out.println("         NAME    :");
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("                   뒤로가려면 엔터키를 누르세요.");
			System.out.println("=========================================");
			System.out.print("NAME 입력: ");
			String name = sc.nextLine();
			if (id.equals("")) {
				return 1;
			}
		

			System.out.println("=========================================");
			System.out.println();
			System.out.println("                  회원가입");
			System.out.println();
			System.out.println("          I D    : " + id);
			System.out.println();
			System.out.println("        PASSWORD : ****");
			System.out.println();
			System.out.println("         NAME    : "+name);
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
			System.out.println("          I D    : " + id);
			System.out.println();
			System.out.println("        PASSWORD : ****");
			System.out.println();
			System.out.println("         NAME    : "+name);
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
			System.out.println("          I D    : " + id);
			System.out.println();
			System.out.println("        PASSWORD : ****");
			System.out.println();
			System.out.println("         NAME    : "+name);
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

	
			
			boolean result=false;
			try {
				result = memberDao.selectPresentMember(id);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			if (result) {

				System.out.println("이미 존재하는 id입니다.");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else {
				int res =memberDao.insertMember(new MemberVo(id, password, name));
				if(res==1) {
					System.out.println("회원가입 성공!");
				}else {
					System.out.println("알수없는 오류");
				}
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


	public int loginView(Scanner sc, MemberDao memberDao) {
		// TODO Auto-generated method stub
		
		
		
		
		return 0;
	}

	


}