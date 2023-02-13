package Service;

import java.util.Scanner;

import View.View;

public class MemberService {

	private View view = new View();
	
	public int main(Scanner sc) {
		int select;
		
		int returnNum=-1;
		
		loop:while(true) {
			
			select = view.mainView(sc);
			
			switch(select) {
				case 1:
					returnNum=2;
					break loop;
				case 2:
					returnNum=3;
					break loop;
				case 3:
					returnNum=4;
					break loop;
				default:
					System.out.println("잘못된 입력입니다. 다시입력해주세요.");
					break;
			}
		}
		
		
		return returnNum;
	}

	public int join(Scanner sc) {
		// TODO Auto-generated method stub
		
		int res=view.joinView(sc);
		
		return 1;
	}

	public int login(Scanner sc) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int manLogin(Scanner sc) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int MMain(Scanner sc) {
		// TODO Auto-generated method stub
		return 0;
	}

}
