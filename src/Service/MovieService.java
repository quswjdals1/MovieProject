package Service;

import java.util.Iterator;
import java.util.Scanner;

import Controller.MovieController;
import Dao.ReservationDao;
import View.View;
import Vo.MovieVo;
import Vo.ScheduleVo;
import Vo.SeatVo;
import Vo.TicketVo;

public class MovieService {
	
	private static View view = View.getInstance();
	
	public int movMain(Scanner sc) {
		
		
		MovieVo mRes = view.movMain(sc);
		if(mRes==null) {
			if(MovieController.userId==null) {
				return 1;
			}else {
				return 7;
			}
		}
		ScheduleVo sRes = view.schMain(sc,mRes);
		SeatVo seatRes;
		TicketVo ticketVo=new TicketVo();
		
		do {
			
			seatRes = view.seatMain(sc, sRes);
			ticketVo.setMOV_ID(mRes.getMovId());
			ticketVo.setSCH_DATE(seatRes.getSCH_DATE());
			ticketVo.setSEAT_NO(seatRes.getSEAT_NO());
			ticketVo.setTICKET_PRICE(1000);
			if (MovieController.cart.contains(ticketVo)) {
				System.out.println("이미 장바구니에 등록되어 있습니다.");
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				break;
			} 
		} while (true);
		
		MovieController.cart.add(ticketVo);	
		System.out.println("장바구니에 담는데 성공했습니다.");
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 5;
	}

	public int MmovMain(Scanner sc) {
		// TODO Auto-generated method stub
		return 0;
	}



}
