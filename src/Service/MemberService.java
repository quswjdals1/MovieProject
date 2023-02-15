package Service;

import java.util.List;
import java.util.Scanner;

import Dao.MemberDao;
import Dao.ScheduleDao;
import View.View;
import Vo.MovieVo;
import Vo.ScheduleVo;

public class MemberService {

	private static View view = View.getInstance();
	
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
		int res=view.loginView(sc);
		return res;
	}

	public int manLogin(Scanner sc) {
		// TODO Auto-generated method stub
		int res=view.manLogin(sc);
		return res;
	}

	public int MMain(Scanner sc) {
		// TODO Auto-generated method stub
		MovieVo mRes=view.MMain(sc);
		if(mRes==null) {
			return 1;
		}
		ScheduleDao scheduleDao = ScheduleDao.getInstance();
		
		List<ScheduleVo> list = scheduleDao.selectSchedule();
		int schRowNum=0;
		int pageNum=0;
		if(list.size()%7==0) {
			pageNum=list.size()/7-1;
		}else {
			pageNum=list.size()/7;
		}
		int curNum=0;
		String sel=null;
		while (true) {
			view.MSchedule(sc, mRes,pageNum,curNum,list);
			sel=sc.nextLine();
			if(sel.equals("")) {
				return 6;
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
					schRowNum=Integer.parseInt(sel);
					break;
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
		
		if(schRowNum==0) {
			//추가
			int addRes=view.addSchedule(sc,mRes);
		}else {
			//삭제,수정
			int duSel=view.udSelect(sc,mRes,list.get(schRowNum-1));
			
			if(duSel==0) {
				//삭제
				int delRes=view.delSchedule(sc,mRes,list.get(schRowNum-1));
			}else {
				//수정
				int uptRes=view.uptSchedule(sc,mRes,list.get(schRowNum-1));
			}

		}
		

		
		
		return 6;
	}

}
