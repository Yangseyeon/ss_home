package dto;


import lombok.Getter;
import lombok.Setter;


@Getter
@Setter

public class HouseInfoDto {
	private int buildYear;
	private String roadName;
	private String dong;
	private String dongCode;
	private String aptName;
	private String jibun;
	private String lng;
	private String lat;
	
	public HouseInfoDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public int getBuildYear() {
		return buildYear;
	}



	public void setBuildYear(int buildYear) {
		this.buildYear = buildYear;
	}



	public String getRoadName() {
		return roadName;
	}



	public void setRoadName(String roadName) {
		this.roadName = roadName;
	}



	public String getDong() {
		return dong;
	}



	public void setDong(String dong) {
		this.dong = dong;
	}



	public String getDongCode() {
		return dongCode;
	}



	public void setDongCode(String dongCode) {
		this.dongCode = dongCode;
	}



	public String getAptName() {
		return aptName;
	}



	public void setAptName(String aptName) {
		this.aptName = aptName;
	}



	public String getJibun() {
		return jibun;
	}



	public void setJibun(String jibun) {
		this.jibun = jibun;
	}



	public String getLng() {
		return lng;
	}



	public void setLng(String lng) {
		this.lng = lng;
	}



	public String getLat() {
		return lat;
	}



	public void setLat(String lat) {
		this.lat = lat;
	}



	public HouseInfoDto(int buildYear, String roadName, String dong, String dongCode,
			String aptName, String jibun, String lng, String lat) {
		super();
		this.buildYear = buildYear;
		this.roadName = roadName;
		this.dong = dong;
		this.dongCode = dongCode;
		this.aptName = aptName;
		this.jibun = jibun;
		this.lng = lng;
		this.lat = lat;
	}
	
	@Override
	public String toString() {
		return "HouseInfoDto [buildYear=" + buildYear + ", roadName=" + roadName + ", dong="
				+ dong + ", dongCode=" + dongCode + ", aptName=" + aptName + ", jibun=" + jibun + ", lng=" + lng
				+ ", lat=" + lat + "]";
	}
	
	

}
