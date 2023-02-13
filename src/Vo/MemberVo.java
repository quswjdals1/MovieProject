package Vo;

public class MemberVo {
	private String MEM_ID;
	private String MEM_PW;
	private String MEM_NAME;
	//insert 할때 사용
	public MemberVo(String MEM_ID, String MEM_PW, String MEM_NAME) {
		this.MEM_ID = MEM_ID;
		this.MEM_PW = MEM_PW;
		this.MEM_NAME = MEM_NAME;
		
		// update 할때 사용
		// select 할때 사용
	}
	public String getMEM_ID() {
		return MEM_ID;
	}
	public void setMEM_ID(String mEM_ID) {
		MEM_ID = mEM_ID;
	}
	public String getMEM_PW() {
		return MEM_PW;
	}
	public void setMEM_PW(String mEM_PW) {
		MEM_PW = mEM_PW;
	}
	public String getMEM_NAME() {
		return MEM_NAME;
	}
	public void setMEM_NAME(String mEM_NAME) {
		MEM_NAME = mEM_NAME;
	}
		
	
	public String toSting() {
		return String.format("%s\t%s\\t%s\\t%s\n", MEM_ID, MEM_PW, MEM_NAME);
	
		
		
	}

}
