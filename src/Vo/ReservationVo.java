package Vo;

import java.sql.Timestamp;

public class ReservationVo {
	private String resNo;
	private Timestamp resDate;
	private int resTotal;
	private String memId;
	
	public ReservationVo(String resNo, Timestamp resDate, int resTotal, String memId) {
		super();
		this.resNo = resNo;
		this.resDate = resDate;
		this.resTotal = resTotal;
		this.memId = memId;
	}

	public String getResNo() {
		return resNo;
	}

	public void setResNo(String resNo) {
		this.resNo = resNo;
	}

	public Timestamp getResDate() {
		return resDate;
	}

	public void setResDate(Timestamp resDate) {
		this.resDate = resDate;
	}



	public int getResTotal() {
		return resTotal;
	}

	public void setResTotal(int resTotal) {
		this.resTotal = resTotal;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}
	
		@Override
	public String toString() {
		return "ReservationVo [resNo=" + resNo + ", resDate=" + resDate + ", resTotal=" + resTotal + ", memId=" + memId
				+ "]";
	}
	
}
