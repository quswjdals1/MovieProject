package Vo;

public class MovieVo {
	private String movId;
	private String movName;
	private String movDirector;
	
	public MovieVo(String movId, String movName, String movDirector) {
		super();
		this.movId = movId;
		this.movName = movName;
		this.movDirector = movDirector;
	}

	public String getMovId() {
		return movId;
	}

	public void setMovId(String movId) {
		this.movId = movId;
	}

	public String getMovName() {
		return movName;
	}

	public void setMovName(String movName) {
		this.movName = movName;
	}

	public String getMovDirector() {
		return movDirector;
	}

	public void setMovDirector(String movDirector) {
		this.movDirector = movDirector;
	}
	
	
	
}
