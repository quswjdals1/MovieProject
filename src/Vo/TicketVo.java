package Vo;

import java.sql.Timestamp;

public class TicketVo {
	

		private String TICKET_NO;
		private int TICKET_PRICE;
		private String MOV_ID;
		private String SEAT_NO;
		private Timestamp SCH_DATE; //date는 시간이 안나와서 timestamp를 시각을 보여주기위해서선호  
		 // insert 할때 사용
		public TicketVo(String TICKET_NO, int TICKET_PRICE, String MOV_ID) {
			this.TICKET_NO = TICKET_NO;
			this.MOV_ID = MOV_ID;
		}

		
		// update 할때 사용
		public TicketVo(String TICKET_NO, int TICKET_PRICE, String MOV_ID, String SEAT_NO, 
				                    Timestamp SCH_DATE) {
			
		  this.TICKET_NO = TICKET_NO;
		  this.TICKET_PRICE = TICKET_PRICE;
		  this.MOV_ID = MOV_ID;
		  this.SEAT_NO = SEAT_NO;
		  this.SCH_DATE = SCH_DATE;
		}


		public String getTICKET_NO() {
			return TICKET_NO;
		}


		public void setTICKET_NO(String tICKET_NO) {
			TICKET_NO = tICKET_NO;
		}


		public int getTICKET_PRICE() {
			return TICKET_PRICE;
		}


		public void setTICKET_PRICE(int tICKET_PRICE) {
			TICKET_PRICE = tICKET_PRICE;
		}


		public String getMOV_ID() {
			return MOV_ID;
		}


		public void setMOV_ID(String mOV_ID) {
			MOV_ID = mOV_ID;
		}


		public String getSEAT_NO() {
			return SEAT_NO;
		}


		public void setSEAT_NO(String sEAT_NO) {
			SEAT_NO = sEAT_NO;
		}


		public Timestamp getSCH_DATE() {
			return SCH_DATE;
		}


		public void setSCH_DATE(Timestamp sCH_DATE) {
			SCH_DATE = sCH_DATE;
		}
		@Override
		public String toString() {
			return String.format("%s\\t%s\\t%s\\t%s\\t%s\\t%s\\t%s\\n", TICKET_NO, TICKET_PRICE, MOV_ID, SEAT_NO, SCH_DATE );
		}
		
		
		  

}
