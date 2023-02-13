package Vo;


public class Reservation_TicketVo {
	private String RES_NO;
	private String TICKET_NO;
	
	public Reservation_TicketVo(String RES_NO, String TICKET_NO) {
		this.RES_NO = RES_NO;
		this.TICKET_NO = TICKET_NO;
		
	}

	public String getRES_NO() {
		return RES_NO;
	}

	public void setRES_NO(String rES_NO) {
		RES_NO = rES_NO;
	}

	public String getTICKET_NO() {
		return TICKET_NO;
	}

	public void setTICKET_NO(String tICKET_NO) {
		TICKET_NO = tICKET_NO;
	}
	@Override
	public String toString() {
		return String.format("%s\t%s\t%s\n", RES_NO, TICKET_NO ); 
	}


		


	


}
