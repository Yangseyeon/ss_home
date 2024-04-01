package dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class DongCodeDto {
	private String dongCode;
	private String sidoName;
	private String gugunName;
	private String dongName;
	
	
	public DongCodeDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public DongCodeDto(String dongCode, String sidoName, String gugunName, String dongName) {
		super();
		this.dongCode = dongCode;
		this.sidoName = sidoName;
		this.gugunName = gugunName;
		this.dongName = dongName;
	}
	
	
	@Override
	public String toString() {
		return "DongCodeDto [dongCode=" + dongCode + ", sidoName=" + sidoName + ", gugunName=" + gugunName
				+ ", dongName=" + dongName + "]";
	}



	public String getDongCode() {
		return dongCode;
	}



	public void setDongCode(String dongCode) {
		this.dongCode = dongCode;
	}



	public String getSidoName() {
		return sidoName;
	}



	public void setSidoName(String sidoName) {
		this.sidoName = sidoName;
	}



	public String getGugunName() {
		return gugunName;
	}



	public void setGugunName(String gugunName) {
		this.gugunName = gugunName;
	}



	public String getDongName() {
		return dongName;
	}



	public void setDongName(String dongName) {
		this.dongName = dongName;
	}
	
	

}
