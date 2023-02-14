package Service;

import java.util.Scanner;

import View.View;
import Vo.MovieVo;
import Vo.ScheduleVo;
import Vo.SeatVo;

public class MovieService {
	
	private View view = new View();
	
	public int movMain(Scanner sc) {
		// TODO Auto-generated method stub
		MovieVo mRes = view.movMain(sc);
		if(mRes==null) {
			return 1;
		}
		ScheduleVo sRes = view.schMain(sc,mRes); 
		SeatVo seatRes = view.seatMain(sc,sRes);
		return 7;
	}

	public int MmovMain(Scanner sc) {
		// TODO Auto-generated method stub
		return 0;
	}

}
