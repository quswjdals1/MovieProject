package Service;

import java.util.List;
import java.util.Scanner;

import Controller.MovieController;
import Dao.ReservationDao;
import View.View;
import Vo.ReservationVo;

public class ReservationService {
	private static View view = View.getInstance();
	
	public int resCheckPage(Scanner sc) {
		
		
		int res=0;
		int sel = view.resCheckPage(sc);
		if(sel==1) {
			//티켓 예매테이블 보여주기
			ReservationDao reservationDao = ReservationDao.getInstance();
			try {
				List<ReservationVo> list=reservationDao.selectReservation(MovieController.userId);
				res = view.preResPage(sc,list);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} else if(sel==2) {
			//장바구니
			if(MovieController.cart.size()==0) {
				System.out.println("장바구니가 비어있습니다.");
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return 5;
			}
			ReservationDao reservationDao= ReservationDao.getInstance();
			MovieController.resNo=reservationDao.insertReservation(MovieController.userId);
			res = view.resCartPage(sc);
			
			
		}
		else {
			System.out.println("오류");
			System.exit(0);
		}
		return res;
	}
}
