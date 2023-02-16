package View;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import Controller.MovieController;
import Dao.MemberDao;
import Dao.MovieDao;
import Dao.ReservationDao;
import Dao.Reservation_TicketDao;
import Dao.ScheduleDao;
import Dao.SeatDao;
import Dao.TicketDao;
import Vo.MemberVo;
import Vo.MovieVo;
import Vo.ReservationVo;
import Vo.Reservation_TicketVo;
import Vo.ScheduleVo;
import Vo.SeatVo;
import Vo.TicketVo;

public class View {
	
	private static View view = new View();
	
	public static View getInstance() {
		return view;
	}


	public int mainView(Scanner sc) {
		// TODO Auto-generated method stub
	
		System.out.println("=====================================================");
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
		System.out.println("                          프로그램 종료(enter)");
		System.out.println("=====================================================");
		System.out.print("원하시는 메뉴를 선택해주세요.: ");
		String sel= sc.nextLine();
		if(sel.equals("")) {
			System.out.println("프로그램을 종료합니다.");
			System.exit(0);
		}
		return Integer.parseInt(sel);
	}
	

	public int joinView(Scanner sc) {
		// TODO Auto-generated method stub
		loop: while (true) {

			System.out.println("=====================================================");
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
			System.out.println("=====================================================");
			System.out.print("id 입력: ");
			String id = sc.nextLine();
			if (id.equals("")) {
				return 1;
			}

			System.out.println("=====================================================");
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
			System.out.println("=====================================================");
			System.out.print("PASSWWORD 입력: ");
			String password = sc.nextLine();
			if (password.equals("")) {
				return 1;
			}
			
			
			System.out.println("=====================================================");
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
			System.out.println("=====================================================");
			System.out.print("NAME 입력: ");
			String name = sc.nextLine();
			if (name.equals("")) {
				return 1;
			}
		

			System.out.println("=====================================================");
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
			System.out.println("=====================================================");

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			System.out.println("=====================================================");
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
			System.out.println("=====================================================");

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println("=====================================================");
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
			System.out.println("=====================================================");

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	
			MemberDao memberDao=MemberDao.getInstance();
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


	public int loginView(Scanner sc) {
		// TODO Auto-generated method stub
		
		String []a = {"  내가 왕이될 상인가   -관상-","  이거 방탄 유리야   -아저씨-", "  넌 다 계획이 있구나  -기생충-", "  Boney M - sunny  -써니 OST-" };
		Random rand = new Random();
		
		loop: while (true) {

			System.out.println("=====================================================");
			System.out.println();
			System.out.println("                  로그인");
			System.out.println();
			System.out.println("          I D    : ");
			System.out.println();
			System.out.println("        PASSWORD : ");
			System.out.println();
			System.out.println("");
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("                   뒤로가려면 엔터키를 누르세요.");
			System.out.println("=====================================================");
			System.out.print("id 입력: ");
			String id = sc.nextLine();
			if (id.equals("")) {
				return 1;
			}

			System.out.println("=====================================================");
			System.out.println();
			System.out.println("                  로그인");
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
			System.out.println("=====================================================");
			System.out.print("PASSWWORD 입력: ");
			String password = sc.nextLine();
			if (password.equals("")) {
				return 1;
			}
			
			
		

			System.out.println("=====================================================");
			System.out.println();
			System.out.println("                  로그인");
			System.out.println();
			System.out.println("          I D    : " + id);
			System.out.println();
			System.out.println("        PASSWORD : ****");
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("             회원정보 확인중.");
			System.out.println();
			System.out.println("       "+a[rand.nextInt(4)]);
			System.out.println("");
			System.out.println("=====================================================");

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			System.out.println("=====================================================");
			System.out.println();
			System.out.println("                  로그인");
			System.out.println();
			System.out.println("          I D    : " + id);
			System.out.println();
			System.out.println("        PASSWORD : ****");
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("             회원정보 확인중..");
			System.out.println();
			System.out.println("       "+a[rand.nextInt(4)]);
			System.out.println("");
			System.out.println("=====================================================");

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println("=====================================================");
			System.out.println();
			System.out.println("                  로그인");
			System.out.println();
			System.out.println("          I D    : " + id);
			System.out.println();
			System.out.println("        PASSWORD : ****");
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("             회원정보 확인중...");
			System.out.println();
			System.out.println("       "+a[rand.nextInt(4)]);
			System.out.println("");
			System.out.println("=====================================================");
			
			
			boolean result=false;
			try {
				MemberDao memberDao=MemberDao.getInstance();
				result = memberDao.selectLoginMember(id, password);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			if(result) {
				MovieController.userId=id;
				MovieController.userPW=password;
				String createdNo=ReservationDao.getInstance().insertReservation(id);
				if(!createdNo.equals("error")) {
					MovieController.resNo=createdNo;
					MovieController.cart=new HashSet<>();
					System.out.println("로그인 완료!");
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return 5;
					
				}
				else {
					System.out.println("create_resno 오류");
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}else {
					System.out.println("일치하는 회원정보가 없습니다.");
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		}
		
		
	}


	public int manLogin(Scanner sc) {
		// TODO Auto-generated method stub
		loop: while (true) {

			System.out.println("=====================================================");
			System.out.println();
			System.out.println("                  관리자 로그인");
			System.out.println();
			System.out.println("          I D    : ");
			System.out.println();
			System.out.println("        PASSWORD : ");
			System.out.println();
			System.out.println("");
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("                   뒤로가려면 엔터키를 누르세요.");
			System.out.println("=====================================================");
			System.out.print("id 입력: ");
			String id = sc.nextLine();
			if (id.equals("")) {
				return 1;
			}

			System.out.println("=====================================================");
			System.out.println();
			System.out.println("                  관리자 로그인");
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
			System.out.println("=====================================================");
			System.out.print("PASSWWORD 입력: ");
			String password = sc.nextLine();
			if (password.equals("")) {
				return 1;
			}
			
			
		

			System.out.println("=====================================================");
			System.out.println();
			System.out.println("                  관리자 로그인");
			System.out.println();
			System.out.println("          I D    : " + id);
			System.out.println();
			System.out.println("        PASSWORD : ****");
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("             회원정보 확인중.");
			System.out.println();
			System.out.println();
			System.out.println("");
			System.out.println("=====================================================");

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			System.out.println("=====================================================");
			System.out.println();
			System.out.println("                  관리자 로그인");
			System.out.println();
			System.out.println("          I D    : " + id);
			System.out.println();
			System.out.println("        PASSWORD : ****");
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("             회원정보 확인중..");
			System.out.println();
			System.out.println();
			System.out.println("");
			System.out.println("=====================================================");

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println("=====================================================");
			System.out.println();
			System.out.println("                  관리자 로그인");
			System.out.println();
			System.out.println("          I D    : " + id);
			System.out.println();
			System.out.println("        PASSWORD : ****");
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("             회원정보 확인중...");
			System.out.println();
			System.out.println();
			System.out.println("");
			System.out.println("=====================================================");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			MemberVo result=null;
			try {
				
				MemberDao memberDao=MemberDao.getInstance();
				result = memberDao.selectMemberById(id);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			if(result==null) {
				System.out.println("관리자 계정이 아닙니다.");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}else if(result.getMEM_ID().equals("sys")&&result.getMEM_NAME().equals("관리자")) {
				MovieController.userId=id;
				MovieController.userPW=password;
				System.out.println("로그인 완료!");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return 6;
					
			}else {
					System.out.println("관리자 계정이 아닙니다.");
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		}
		
	}


	public MovieVo movMain(Scanner sc) {
		// TODO Auto-generated method stub
		
		MovieDao movieDao = MovieDao.getInstance();
		
		List<MovieVo> list = movieDao.selectMovie();
		
		int pageNum=0;
		if(list.size()%7==0) {
			pageNum=list.size()/7-1;
		}else {
			pageNum=list.size()/7;
		}
		int curNum=0;
		while(true) {
			System.out.println("=====================================================");
			System.out.println();
			System.out.println("                  영화 목록");
			System.out.println();
			System.out.println("\tno  |mid|   |title|   |director|");
			for(int i=curNum*7+0; i<curNum*7+7; i++) {
				if(i<list.size()) {
					System.out.println("\t"+(i+1)+".   "+list.get(i).getMovId()+"    "+list.get(i).getMovName()+"\t"+list.get(i).getMovDirector());
				}else{
					System.out.println();
				}
			}
			System.out.println(" 예매티켓확인(a)              이전(p), 다음(n)");
			System.out.println(" 로그아웃(enter)           예매할 영화 번호 입력:");
			System.out.println("=====================================================");
			String sel = sc.nextLine();
			if(sel.equals("")) {
				MovieController.resNo=null;
				MovieController.userId=null;
				MovieController.userPW=null;
				MovieController.cart=null;
				return null;
			}else if(sel.equals("a")) {
				return null;
			}else if(sel.equals("n")) {
				if(curNum+1<=pageNum) {
					curNum++;	
				}
				continue;
			}else if(sel.equals("p")) {
				if(curNum-1>=0) {
					curNum--;	
				}
				continue;
			}
			
			return list.get(Integer.parseInt(sel)-1);
		}
	}


	public ScheduleVo schMain(Scanner sc, MovieVo movieVo) {
		// TODO Auto-generated method stub
		
		
		ScheduleDao scheduleDao = ScheduleDao.getInstance();
		
		List<ScheduleVo> list = scheduleDao.selectScheduleByName(movieVo.getMovName());
		int pageNum=0;
		if(list.size()%7==0) {
			pageNum=list.size()/7-1;
		}else {
			pageNum=list.size()/7;
		}
		int curNum=0;
		while(true) {
			System.out.println("=====================================================");
			System.out.println();
			System.out.println("            "+movieVo.getMovName()+" 상영 일정");
			System.out.println();
			System.out.println("\tno\t|상영시간|");
			for(int i=curNum*7+0; i<curNum*7+7; i++) {
				if(i<list.size()) {
					System.out.println("\t"+(i+1)+". "+list.get(i).getSCH_DATE());
				}else{
					System.out.println();
				}
			}
			System.out.println("                         이전(p), 다음(n) ");
			System.out.println("                        예매할 영화 번호 입력");
			System.out.println("=====================================================");
			String sel = sc.nextLine();
			if(sel.equals("n")) {
				if(curNum+1<=pageNum) {
					curNum++;	
				}
				continue;
			}else if(sel.equals("p")) {
				if(curNum-1>=0) {
					curNum--;	
				}
				continue;
			}else {
				boolean isInteger=false;
				
				try {
					Integer.parseInt(sel);
					isInteger=true;
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					isInteger=false;
				}
				
				
				if(isInteger) {
					return list.get(Integer.parseInt(sel)-1);
				}
				else {
					System.out.println("잘못된 입력입니다.");
					try {
						Thread.sleep(1500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
				
		}
		
			
		
	}


	public SeatVo seatMain(Scanner sc, ScheduleVo sRes) {
		// TODO Auto-generated method stub
		
		SeatDao seatDao = SeatDao.getInstance();
		
		
		
		while(true) {
			List<SeatVo> list = seatDao.selectSeatByDate(sRes.getSCH_DATE());
			System.out.println("▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣SCREEN▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣");
			System.out.println("┎  ↙                                    ▣");
			System.out.println("┃  ←   비상구                           ▣");
			System.out.println("┖  ↖   🏃‍♀️ 🏃‍♂️                            ▣");
			System.out.println("▣              선택한 일자 좌석표       ▣");
			System.out.println("▣                                       ▣");
			System.out.println("▣              1    2    3    4        ▣");
			System.out.println("▣                                       ▣");
			System.out.print("▣\ta  ");
			for(int i=0; i<4; i++) {
				if(list.get(i).getSEAT_CHECK().equals("yes")) {
					System.out.print("    ■");
				}else {
					System.out.print("    □");
				}
			}
			System.out.println("         ▣");
			System.out.print("▣\tb  ");
			for(int i=4; i<8; i++) {
				if(list.get(i).getSEAT_CHECK().equals("yes")) {
					System.out.print("    ■");
				}else {
					System.out.print("    □");
				}
			}
			System.out.println("         ▣");
			System.out.print("▣\tc  ");
			for(int i=8; i<12; i++) {
				if(list.get(i).getSEAT_CHECK().equals("yes")) {
					System.out.print("    ■");
				}else {
					System.out.print("    □");
				}
			}
			System.out.println("         ▣");
			System.out.print("▣\td  ");
			for(int i=12; i<16; i++) {
				if(list.get(i).getSEAT_CHECK().equals("yes")) {
					System.out.print("    ■");
				}else {
					System.out.print("    □");
				}
			}
			System.out.println("         ▣");
			System.out.println("▣                                       ▣");
			System.out.println("▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣┌───┐ ▣");
			System.out.println("                                  입 구  ");
			System.out.println("=====================================================");
			System.out.println("원하는 자리를 차례로 입력하세요.ex) \"d3\"");
			String sel = sc.nextLine();
			if(!(sel.equals("a1")||sel.equals("a2")||sel.equals("a3")||sel.equals("a4")||
					sel.equals("b1")||sel.equals("b2")||sel.equals("b3")||sel.equals("b4")||
					sel.equals("c1")||sel.equals("c2")||sel.equals("c3")||sel.equals("c4")||
					sel.equals("d1")||sel.equals("d2")||sel.equals("d3")||sel.equals("d4"))) {
				
				System.out.println("잘못된 입력입니다.");
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				continue;
			}
			if(seatDao.selectSeatByDateNo(sRes.getSCH_DATE(), sel).equals("yes")) {
				System.out.println("이미 예약된 좌석 입니다.");
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				continue;
			}else {
				SeatVo afterSeat =new SeatVo(sel, sRes.getSCH_DATE(), "yes");
				return afterSeat;		
			}
			
		}
	
		
	}


	public int resCheckPage(Scanner sc) {
		// TODO Auto-generated method stub
		
		System.out.println("=====================================================");
		System.out.println();
		System.out.println("");
		System.out.println();
		System.out.println("          1. 과거 모든 결제내역 보기");
		System.out.println();
		System.out.println("          2. 장바구니 확인하기");
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("");
		System.out.println();
		System.out.println();
		System.out.println("뒤로가기(enter)");
		System.out.println("=====================================================");
		String sel = sc.nextLine();
		if(sel.equals("")) {
			return 3;
		}else {
			return Integer.parseInt(sel);
		}
	}


	public int resCartPage(Scanner sc) {
		MovieDao movieDao= MovieDao.getInstance();
		System.out.println("=====================================================");
		System.out.println();
		System.out.println("           "+MovieController.userId+" 님의 장바구니");
		System.out.println("\t 번호, 영화이름, 일자, 가격순");
		System.out.println();
		List<TicketVo> list = new ArrayList<>();
		Iterator<TicketVo> iter = MovieController.cart.iterator();
		for(int i=0; i<5; i++) {	
			if(iter.hasNext()) {
				TicketVo next = iter.next();
				System.out.println("  "+(i+1)+". "+movieDao.selectNameById(next.getMOV_ID())+" "+next.getSCH_DATE().toString().substring(0, 16)+" "+next.getSEAT_NO()+"  "+next.getTICKET_PRICE()+"원");
				list.add(next);
			}else {
				System.out.println();
			}
		}
		System.out.println("");
		System.out.println();
		System.out.println();
		System.out.println("결제(b), 뒤로가기(enter)");
		System.out.println("=====================================================");
		String sel = sc.nextLine();
		if(sel.equals("")) {
			return 5;
		}else if(sel.equals("b")) {
			TicketDao ticketDao = TicketDao.getInstance();
			SeatDao seatDao = SeatDao.getInstance();
			Reservation_TicketDao reservation_TicketDao = Reservation_TicketDao.getInstance();
			int total=0;
			for (int i = 0; i < list.size(); i++) {
				//reservation_ticket테이블에 넣는 작업, list에 값있음
				
				int sRes=seatDao.updateSeat(new SeatVo(list.get(i).getSEAT_NO(),list.get(i).getSCH_DATE(),"no"), true);
				if(sRes==0) {
					System.out.println("좌석예약 에러");
					return 999;
				}

				String ticketNo=ticketDao.insertTicket(list.get(i));
				if(ticketNo.equals("error")) {
					System.out.println("티켓발급 에러");
					return 999;
				}
				
				int res=reservation_TicketDao.insertRT(ticketNo,MovieController.resNo );
				if(res==0) {
					System.out.println("rt 데이터삽입 에러");
					return 999;
				}
				total+=list.get(i).getTICKET_PRICE();
			}
			
			ReservationDao reservationDao= ReservationDao.getInstance();
			try {System.out.println("총 결제 금액: "+total);
				if(reservationDao.updateReservation(MovieController.resNo, total)==0) {
					System.out.println("결제 오류");
					return 999;
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			MovieController.resNo=reservationDao.insertReservation(MovieController.userId);
			MovieController.cart.clear();
			
			System.out.println("결제가 완료되었습니다.");
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return 5;
			
			
		}else {
			System.out.println("잘못된 입력입니다");
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return 5;
		}
	}


	public int preResPage(Scanner sc,List<ReservationVo> list) {
		// TODO Auto-generated method stub
		Reservation_TicketDao reservation_TicketDao = Reservation_TicketDao.getInstance();
		
		
		List<Reservation_TicketVo> rtList = new ArrayList<>();
		List<Timestamp> resDate = new ArrayList<>();

		List<Reservation_TicketVo> rt; 
		for(int i=0; i<list.size(); i++) {
			rt = reservation_TicketDao.selectRtByResNo(list.get(i).getResNo());
			if(rt.size()==0) {
				continue;
			}
			rtList.addAll(rt);
			for (int j = 0; j < rt.size(); j++) {
				resDate.add(list.get(i).getResDate());
			}
		}
		
		TicketDao ticketDao = TicketDao.getInstance();
		
		List<TicketVo> ticketList = new ArrayList<>();
		
		for(int i=0; i<rtList.size(); i++) {
			ticketList.add(ticketDao.selectTicket(rtList.get(i).getTICKET_NO()));
		}

		int pageNum=0;
		if(ticketList.size()%7==0) {
			pageNum=ticketList.size()/7-1;
		}else {
			pageNum=ticketList.size()/7;
		}
		int curNum=0;
		
		MovieDao movieDao = MovieDao.getInstance();
		
		while(true) {
			System.out.println("================================================================================");
			System.out.println();
			System.out.println("                     "+MovieController.userId+" 님의 결제목록");
			System.out.println();
			System.out.println(" |     예매일시   |  티켓번호  좌석   제목             상영일시 가격|");
			for(int i=curNum*7+0; i<curNum*7+7; i++) {
				if(i<ticketList.size()) {
					System.out.println(" |"+(resDate.get(i).toString().substring(0,16))+"|"+ticketList.get(i).getTICKET_NO()+"   "+ticketList.get(i).getSEAT_NO()+"   "+movieDao.selectNameById(ticketList.get(i).getMOV_ID())+"      "+ticketList.get(i).getSCH_DATE().toString().substring(0,16)+" "+ticketList.get(i).getTICKET_PRICE()+"원|");
				}else{
					System.out.println();
				}
			}
			System.out.println("                         이전(p), 다음(n) ");
			System.out.println("                      뒤로가기(n,p제외 아무키)");
			System.out.println("===============================================================================");
			String sel = sc.nextLine();
			if(sel.equals("n")) {
				if(curNum+1<=pageNum) {
					curNum++;	
				}
				continue;
			}else if(sel.equals("p")) {
				if(curNum-1>=0) {
					curNum--;	
				}
				continue;
			}else {
				return 5;
			}
				
		}

	}


	public int MMain(Scanner sc,List<MovieVo> list) {
	
		int pageNum=0;
		if(list.size()%7==0) {
			pageNum=list.size()/7-1;
		}else {
			pageNum=list.size()/7;
		}
		int curNum=0;
		while(true) {
			System.out.println("=====================================================");
			System.out.println();
			System.out.println("                  영화 목록");
			System.out.println();
			System.out.println("\tno  |mid|   |title|   |director|");
			for(int i=curNum*7+0; i<curNum*7+7; i++) {
				if(i<list.size()) {
					System.out.println("\t"+(i+1)+".   "+list.get(i).getMovId()+"    "+list.get(i).getMovName()+"\t"+list.get(i).getMovDirector());
				}else{
					System.out.println();
				}
			}
			System.out.println("                         이전(p), 다음(n) ");
			System.out.println(" (관리자 모드)           영화 추가(a), 제거(d)");			
			System.out.println(" 로그아웃(enter)        영화 선택 후 일정 수정(no)");
			System.out.println("=====================================================");
			String sel = sc.nextLine();
			if(sel.equals("")) {
				MovieController.resNo=null;
				MovieController.userId=null;
				MovieController.userPW=null;
				MovieController.cart=null;
				return 0;
			}else if(sel.equals("d")) {
				return -1;
			}else if(sel.equals("a")) {
				return -2;
			}else if(sel.equals("n")) {
				if(curNum+1<=pageNum) {
					curNum++;	
				}
				continue;
			}else if(sel.equals("p")) {
				if(curNum-1>=0) {
					curNum--;	
				}
				continue;
			}
			return Integer.parseInt(sel);
		}
		
	}
	
	public void MSchedule(Scanner sc, MovieVo movieVo,int pageNum,int curNum, List<ScheduleVo> list) {
		


		// TODO Auto-generated method stub
		
		
		System.out.println("=====================================================");
		System.out.println();
		System.out.println("            "+movieVo.getMovName()+" 상영 일정");
		System.out.println();
		System.out.println("\t번호\t|상영시간|");
		for(int i=curNum*7+0; i<curNum*7+7; i++) {
			if(i<list.size()) {
				System.out.println("\t"+(i+1)+". "+list.get(i).getSCH_DATE().toString().substring(0,16));
			}else{
				System.out.println();
			}
		}
		System.out.println("                         이전(p), 다음(n) ");
		System.out.println("뒤로가기(enter)       추가(0),삭제,수정(행번호).");
		System.out.println("=====================================================");
		
	}


	public int addSchedule(Scanner sc, MovieVo mRes) {
		// TODO Auto-generated method stub
		ScheduleDao scheduleDao = ScheduleDao.getInstance();
		
		System.out.println("=====================================================");
		System.out.println();
		System.out.println("               상영일정 추가");
		System.out.println();
		System.out.println("");		
		System.out.println("        영화 id \t: "+mRes.getMovId());
		System.out.println();
		System.out.println("        영화 제목\t: "+mRes.getMovName() );
		System.out.println();
		System.out.println("        상영 일자\t: ");
		System.out.println();
		System.out.println();
		System.out.println("                해당영화의 상영일자를 입력하세요.");
		System.out.println("                형식: yyyy-mm-dd hh:mm");
		System.out.println("=====================================================");
		String date="";
		try {
			date = sc.nextLine()+":00";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("입력 형식 에러");
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			return 6;
		}
		java.sql.Timestamp t = java.sql.Timestamp.valueOf(date);
		
		if(scheduleDao.selectScheduleByDate(t)) {
			System.out.println("중복된 날짜가 있습니다.");
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return addSchedule(sc, mRes);
		}
		
		
		
		System.out.println("=====================================================");
		System.out.println();
		System.out.println("               상영일정 추가");
		System.out.println();
		System.out.println("");		
		System.out.println("        영화 id \t: "+mRes.getMovId());
		System.out.println();
		System.out.println("        영화 제목\t: "+mRes.getMovName() );
		System.out.println();
		System.out.println("        상영 일자\t: "+date);
		System.out.println();
		System.out.println();
		System.out.println("");
		System.out.println("                       엔터를 누르면 완료됩니다.");
		System.out.println("=====================================================");
		String com = sc.nextLine();
		
		if(scheduleDao.insertSchedule(new ScheduleVo(t, mRes.getMovName()))==1) {
			System.out.println("등록되었습니다.");
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println("등록 실패");
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		return 6;
	}


	public int udSelect(Scanner sc, MovieVo mRes, ScheduleVo scheduleVo) {
		// TODO Auto-generated method stub
		
		System.out.println("=====================================================");
		System.out.println();
		System.out.println("               선택된 상영일정 ");
		System.out.println();
		System.out.println("");		
		System.out.println("        영화 id \t: "+mRes.getMovId());
		System.out.println();
		System.out.println("        영화 제목\t: "+mRes.getMovName() );
		System.out.println();
		System.out.println("        상영 일자\t: "+scheduleVo.getSCH_DATE().toString().substring(0,16));
		System.out.println();
		System.out.println();
		System.out.println("");
		System.out.println("                           삭제(d), 수정(u)");
		System.out.println("=====================================================");
		String duSel=sc.nextLine();
		if(!(duSel.equals("d")||duSel.equals("u"))) {
			System.out.println("잘못된 입력입니다.");
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return udSelect(sc, mRes, scheduleVo);
		}
		
		if(duSel.equals("d")) {
			return 0;
		}else {
			return 1;
		}

	}


	public int delSchedule(Scanner sc, MovieVo mRes, ScheduleVo scheduleVo) {
		// TODO Auto-generated method stub
		System.out.println("=====================================================");
		System.out.println();
		System.out.println("               선택된 상영일정 ");
		System.out.println();
		System.out.println("");		
		System.out.println("        영화 id \t: "+mRes.getMovId());
		System.out.println();
		System.out.println("        영화 제목\t: "+mRes.getMovName() );
		System.out.println();
		System.out.println("        상영 일자\t: "+scheduleVo.getSCH_DATE().toString().substring(0,16));
		System.out.println();
		System.out.println();
		System.out.println("");
		System.out.println("             삭제를 진행하시려면 엔터를 눌러주세요.");
		System.out.println("=====================================================");
		String duSel=sc.nextLine();
		if(duSel.equals("")) {
			ScheduleDao scheduleDao = ScheduleDao.getInstance();
			int res=0;
			try {
				res=scheduleDao.deleteScheduleByDate(scheduleVo.getSCH_DATE());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("삭제가 완료되었습니다.");
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 1;
		}else {
			System.out.println("잘못된 입력입니다.");
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return delSchedule(sc, mRes, scheduleVo);
		}

	}


	public int uptSchedule(Scanner sc, MovieVo mRes, ScheduleVo scheduleVo) {
		// TODO Auto-generated method stub
		ScheduleDao scheduleDao = ScheduleDao.getInstance();
		
		System.out.println("=====================================================");
		System.out.println();
		System.out.println("               선택된 상영일정 ");
		System.out.println();
		System.out.println("");		
		System.out.println("        영화 id	: "+mRes.getMovId());
		System.out.println();
		System.out.println("        영화 제목	: "+mRes.getMovName() );
		System.out.println();
		System.out.println("       현재 상영일자: "+scheduleVo.getSCH_DATE().toString().substring(0,16));
		System.out.println();
		System.out.println("       변경 상영일자: ");
		System.out.println("");
		System.out.println("    수정할 상영일자 입력 형식: yyyy-mm-dd hh:mm");
		System.out.println("=====================================================");
		String date="";
		try {
			date = sc.nextLine()+":00";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("입력 형식 에러");
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			return uptSchedule(sc, mRes, scheduleVo);
		}
		java.sql.Timestamp t = java.sql.Timestamp.valueOf(date);
		
		if(scheduleDao.selectScheduleByDate(t)) {
			System.out.println("중복된 날짜가 있습니다.");
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return uptSchedule(sc, mRes, scheduleVo);
		}else {
			
			System.out.println("=====================================================");
			System.out.println();
			System.out.println("               선택된 상영일정 ");
			System.out.println();
			System.out.println("");		
			System.out.println("        영화 id	: "+mRes.getMovId());
			System.out.println();
			System.out.println("        영화 제목	: "+mRes.getMovName() );
			System.out.println();
			System.out.println("       현재 상영일자: "+scheduleVo.getSCH_DATE().toString().substring(0,16));
			System.out.println();
			System.out.println("       변경 상영일자: "+date.substring(0,16));
			System.out.println("");
			System.out.println("          enter를 누르면 수정이 완료됩니다.");
			System.out.println("=====================================================");
			sc.nextLine();			
			
			int res=0;
			try {
				res=scheduleDao.deleteScheduleByDate(scheduleVo.getSCH_DATE());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(res!=1) {
				System.out.println("update 실패1");
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return 6;
			}
			
			if(scheduleDao.insertSchedule(new ScheduleVo(t, mRes.getMovName()))==1) {
				System.out.println("수정 되었습니다.");
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				System.out.println("update 실패2");
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
			
			
			
		}
		return 0;
		
	}


	public int movAdd(Scanner sc, List<MovieVo> mList) {
		// TODO Auto-generated method stub
		MovieDao movieDao = MovieDao.getInstance();
		
		System.out.println("=====================================================");
		System.out.println();
		System.out.println("                 새로운 영화 추가 ");
		System.out.println();
		System.out.println("");		
		System.out.println("        영화 id \t: ");
		System.out.println();
		System.out.println("        영화 제목\t: ");
		System.out.println();
		System.out.println("        감독 이름\t: ");
		System.out.println();
		System.out.println("");
		System.out.println("");
		System.out.println("                              새로운 영화 id를 입력하세요.");
		System.out.println("=====================================================");
		String id = sc.nextLine();
		if(!movieDao.selectNameById(id).equals("")) {
			System.out.println("중복된 id를 가진 영화가 있습니다.");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return movAdd(sc, mList);
		}
		
		System.out.println("=====================================================");
		System.out.println();
		System.out.println("                 새로운 영화 추가 ");
		System.out.println();
		System.out.println("");		
		System.out.println("        영화 id \t: "+id);
		System.out.println();
		System.out.println("        영화 제목\t: ");
		System.out.println();
		System.out.println("        감독 이름\t: ");
		System.out.println();
		System.out.println("");
		System.out.println("");
		System.out.println("                              새로운 영화 제목을 입력하세요.");
		System.out.println("=====================================================");
		String name = sc.nextLine();
		if(movieDao.selectMovieByName(name).size()!=0) {
			System.out.println("중복된 이름을 가진 영화가 있습니다.");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return movAdd(sc, mList);
		}
		
		
		System.out.println("=====================================================");
		System.out.println();
		System.out.println("                 새로운 영화 추가 ");
		System.out.println();
		System.out.println("");		
		System.out.println("        영화 id \t: "+id);
		System.out.println();
		System.out.println("        영화 제목\t: "+name);
		System.out.println();
		System.out.println("        감독 이름\t: ");
		System.out.println();
		System.out.println("");
		System.out.println("");
		System.out.println("                              새로운 영화 감독을 입력하세요.");
		System.out.println("=====================================================");
		String director = sc.nextLine();
		if(director.equals("")) {
			System.out.println("다시 입력하세요");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return movAdd(sc, mList);
		}
		
		
		
		System.out.println("=====================================================");
		System.out.println();
		System.out.println("                 새로운 영화 추가 ");
		System.out.println();
		System.out.println("");		
		System.out.println("        영화 id \t: "+id);
		System.out.println();
		System.out.println("        영화 제목\t: "+name);
		System.out.println();
		System.out.println("        감독 이름\t: "+director);
		System.out.println();
		System.out.println("");
		System.out.println("");
		System.out.println("                              enter를 누르시면 추가됩니다.");
		System.out.println("=====================================================");
		sc.nextLine();
	
		 
		
		return movieDao.insertMovie(new MovieVo(id, name, director));
		
		
	}


	public int movSelDel(Scanner sc, List<MovieVo> list) {
		// TODO Auto-generated method stub

		
		int pageNum=0;
		if(list.size()%7==0) {
			pageNum=list.size()/7-1;
		}else {
			pageNum=list.size()/7;
		}
		int curNum=0;
		while(true) {
			System.out.println("=====================================================");
			System.out.println();
			System.out.println("                  영화 목록");
			System.out.println();
			System.out.println("\tno  |mid|   |title|   |director|");
			for(int i=curNum*7+0; i<curNum*7+7; i++) {
				if(i<list.size()) {
					System.out.println("\t"+(i+1)+".   "+list.get(i).getMovId()+"    "+list.get(i).getMovName()+"\t"+list.get(i).getMovDirector());
				}else{
					System.out.println();
				}
			}
			System.out.println(" ");
			System.out.println(" (관리자 모드)             이전(p), 다음(n)");			
			System.out.println(" 뒤로가기(enter)            삭제할 영화(no)");
			System.out.println("=====================================================");
			String sel = sc.nextLine();
			if(sel.equals("")) {
				return MMain(sc, list);
			}else if(sel.equals("n")) {
				if(curNum+1<=pageNum) {
					curNum++;	
				}
				continue;
			}else if(sel.equals("p")) {
				if(curNum-1>=0) {
					curNum--;	
				}
				continue;
			}
			return Integer.parseInt(sel);
		}
	}


	public int movDel(Scanner sc, MovieVo movieVo) {
		// TODO Auto-generated method stub
		
		System.out.println("=====================================================");
		System.out.println();
		System.out.println("                 선택된 영화 정보 ");
		System.out.println();
		System.out.println("");		
		System.out.println("        영화 id \t: "+movieVo.getMovId());
		System.out.println();
		System.out.println("        영화 제목\t: "+movieVo.getMovName());
		System.out.println();
		System.out.println("        감독 이름\t: "+movieVo.getMovDirector());
		System.out.println();
		System.out.println("");
		System.out.println("");
		System.out.println("                      삭제를 진행하시려면 enter를 눌러주세요.");
		System.out.println("=====================================================");
		String sel = sc.nextLine();
		if(sel.equals("")) {
			MovieDao movieDao = MovieDao.getInstance();
			try {
				return movieDao.deleteMovie(movieVo.getMovId());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}
	
	
	
	
	
	
	

	


}