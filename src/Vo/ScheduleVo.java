package Vo;

import java.sql.Timestamp;

public class ScheduleVo {
	private Timestamp SCH_DATE;
	private String MOV_Name;
			
	public ScheduleVo(Timestamp sCH_DATE, String mOV_Name) {
		super();
		SCH_DATE = sCH_DATE;
		MOV_Name = mOV_Name;
	}

	public Timestamp getSCH_DATE() {
		return SCH_DATE;
	}

	public void setSCH_DATE(Timestamp sCH_DATE) {
		SCH_DATE = sCH_DATE;
	}

	public String getMOV_Name() {
		return MOV_Name;
	}

	public void setMOV_Name(String mOV_Name) {
		MOV_Name = mOV_Name;
	}

	public String getMovId() {
		// TODO Auto-generated method stub
		return null;
	}


	
	
}
