package Vo;

import java.sql.Timestamp;

public class ScheduleVo {
	private Timestamp SCH_DATE;
	private String MOV_ID;

	public ScheduleVo(String MOV_ID) {
		this.MOV_ID = MOV_ID;
	}

	public ScheduleVo(Timestamp SCH_DATE, String MOV_ID) {
		this.SCH_DATE = SCH_DATE;
		this.MOV_ID = MOV_ID;

	}

	public Timestamp getSCH_DATE() {
		return SCH_DATE;
	}

	public void setSCH_DATE(Timestamp sCH_DATE) {
		SCH_DATE = sCH_DATE;
	}

	public String getMOV_ID() {
		return MOV_ID;
	}

	public void setMOV_ID(String mOV_ID) {
		MOV_ID = mOV_ID;
	}

	@Override
	public String toString() {
		return String.format("%s\t%s\t%s\n", SCH_DATE, MOV_ID);

	}
}
