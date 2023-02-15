package View;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
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
			if (password.equals("")) {
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
			if (name.equals("")) {
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
		
		loop: while (true) {

			System.out.println("=========================================");
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
			System.out.println("=========================================");
			System.out.print("id 입력: ");
			String id = sc.nextLine();
			if (id.equals("")) {
				return 1;
			}

			System.out.println("=========================================");
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
			System.out.println("=========================================");
			System.out.print("PASSWWORD 입력: ");
			String password = sc.nextLine();
			if (password.equals("")) {
				return 1;
			}
			
			
		

			System.out.println("=========================================");
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
			System.out.println();
			System.out.println("");
			System.out.println("=========================================");
			
			
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

			System.out.println("=========================================");
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
			System.out.println("=========================================");
			System.out.print("id 입력: ");
			String id = sc.nextLine();
			if (id.equals("")) {
				return 1;
			}

			System.out.println("=========================================");
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
			System.out.println("=========================================");
			System.out.print("PASSWWORD 입력: ");
			String password = sc.nextLine();
			if (password.equals("")) {
				return 1;
			}
			
			
		

			System.out.println("=========================================");
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
			System.out.println("=========================================");

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			System.out.println("=========================================");
			System.out.println();
			System.out.println("                 관리자 로그인");
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
			System.out.println("=========================================");

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println("=========================================");
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
			System.out.println("=========================================");
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
		
		
		System.out.println("=========================================");
		System.out.println();
		System.out.println("                  영화 목록");
		System.out.println();
		System.out.println("\t번호|mid|\t|title|\t|director|");
		for(int i=0; i<7; i++) {
			if(i<list.size()) {
				System.out.println("\t"+(i+1)+". "+list.get(i).getMovId()+"\t"+list.get(i).getMovName()+"\t"+list.get(i).getMovDirector());
			}else{
				System.out.println();
			}
		}
		System.out.println(" 예매티켓확인(a) :");
		System.out.println(" 로그아웃(enter)           예매할 영화 번호 입력:");
		System.out.println("=========================================");
		String sel = sc.nextLine();
		if(sel.equals("")) {
			MovieController.resNo=null;
			MovieController.userId=null;
			MovieController.userPW=null;
			MovieController.cart=null;
			return null;
		}else if(sel.equals("a")) {
			return null;
		}
		
		
		return list.get(Integer.parseInt(sel)-1);
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
			System.out.println("=========================================");
			System.out.println();
			System.out.println("            "+movieVo.getMovName()+" 상영 일정");
			System.out.println();
			System.out.println("\t번호\t|상영시간|");
			for(int i=curNum*7+0; i<curNum*7+7; i++) {
				if(i<list.size()) {
					System.out.println("\t"+(i+1)+". "+list.get(i).getSCH_DATE());
				}else{
					System.out.println();
				}
			}
			System.out.println("                         이전(p), 다음(n) ");
			System.out.println("                        예매할 영화 번호 입력");
			System.out.println("=========================================");
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
			System.out.println("=========================================");
			System.out.println();
			System.out.println("              선택한 일자 좌석표");
			System.out.println();
			System.out.println("               1    2    3    4");
			System.out.println();
			System.out.print("\ta  ");
			for(int i=0; i<4; i++) {
				if(list.get(i).getSEAT_CHECK().equals("yes")) {
					System.out.print("    ■");
				}else {
					System.out.print("    □");
				}
			}
			System.out.println();
			System.out.print("\tb  ");
			for(int i=4; i<8; i++) {
				if(list.get(i).getSEAT_CHECK().equals("yes")) {
					System.out.print("    ■");
				}else {
					System.out.print("    □");
				}
			}
			System.out.println();
			System.out.print("\tc  ");
			for(int i=8; i<12; i++) {
				if(list.get(i).getSEAT_CHECK().equals("yes")) {
					System.out.print("    ■");
				}else {
					System.out.print("    □");
				}
			}
			System.out.println();
			System.out.print("\td  ");
			for(int i=12; i<16; i++) {
				if(list.get(i).getSEAT_CHECK().equals("yes")) {
					System.out.print("    ■");
				}else {
					System.out.print("    □");
				}
			}
			System.out.println();
			System.out.println("");
			System.out.println();
			System.out.println();
			System.out.println("원하는 자리를 차례로 입력하세요.ex) \"d3\"");
			System.out.println("=========================================");
			System.out.print("입력:");
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
		
		System.out.println("=========================================");
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
		System.out.println("");
		System.out.println("=========================================");
		
		int sel = Integer.parseInt(sc.nextLine());

		
		return sel;
	}


	public int resCartPage(Scanner sc) {
		MovieDao movieDao= MovieDao.getInstance();
		System.out.println("=========================================");
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
		System.out.println("=========================================");
		String sel = sc.nextLine();
		if(sel.equals("")) {
			return 5;
		}else if(sel.equals("b")) {
			TicketDao ticketDao = TicketDao.getInstance();
			SeatDao seatDao = SeatDao.getInstance();
			Reservation_TicketDao reservation_TicketDao = Reservation_TicketDao.getInstance();
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
			}
			
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
		
		for(int i=0; i<list.size(); i++) {
			rtList.addAll(reservation_TicketDao.selectRtByResNo(list.get(i).getResNo()));
		}
		
		TicketDao ticketDao = TicketDao.getInstance();
		
		List<TicketVo> ticketList = new ArrayList<>();
		
		for(int i=0; i<rtList.size(); i++) {
			ticketList.add(ticketDao.selectTicket(rtList.get(i).getTICKET_NO()));
		}

		int pageNum=0;
		if(ticketList.size()%7==0) {
			pageNum=list.size()/7-1;
		}else {
			pageNum=list.size()/7;
		}
		int curNum=0;
		
		MovieDao movieDao = MovieDao.getInstance();
		
		while(true) {
			System.out.println("====================================================================");
			System.out.println();
			System.out.println("            "+MovieController.userId+" 님의 결재목록");
			System.out.println();
			System.out.println("\t번호\t|티켓번호|\t|좌석|\t|영화제목|\t|상영시각|\t|가격|");
			for(int i=curNum*7+0; i<curNum*7+7; i++) {
				if(i<ticketList.size()) {
					System.out.println("\t"+(i+1)+". "+ticketList.get(i).getTICKET_NO()+" "+ticketList.get(i).getSEAT_NO()+" "+movieDao.selectNameById(ticketList.get(i).getMOV_ID())+" "+ticketList.get(i).getSCH_DATE()+" "+ticketList.get(i).getTICKET_PRICE()+"원");
				}else{
					System.out.println();
				}
			}
			System.out.println("                         이전(p), 다음(n) ");
			System.out.println("                      뒤로가기(n,p제외 아무키)");
			System.out.println("===================================================================");
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
	
	
	
	
	
	
	
	

	


}