package Vo;

import java.sql.Timestamp;

public class SeatVo {
	private String SEAT_NO;
	private Timestamp SCH_DATE;
	private String SEAT_CHECK;

	public SeatVo(String SEAT_NO, Timestamp SCH_DATE, String SEAT_CHECK) {

		this.SEAT_NO = SEAT_NO;
		this.SCH_DATE = SCH_DATE;
		this.SEAT_CHECK = SEAT_CHECK;

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

	public String getSEAT_CHECK() {
		return SEAT_CHECK;
	}

	public void setSEAT_CHECK(String sEAT_CHECK) {
		SEAT_CHECK = sEAT_CHECK;
	}

	@Override
	public String toString() {
		return String.format("%s\t%s\t%s\t%s\n", SEAT_NO, SCH_DATE, SEAT_CHECK);

	}
}
