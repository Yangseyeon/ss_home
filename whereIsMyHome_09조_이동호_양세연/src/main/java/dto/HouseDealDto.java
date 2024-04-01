package dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HouseDealDto {
	
	private String dealAmount;
	private int dealYear;
	private int dealMonth;
	private String area;
	private String floor;
	private String apartmentName;
	
	public HouseDealDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public String getDealAmount() {
		return dealAmount;
	}




	public void setDealAmount(String dealAmount) {
		this.dealAmount = dealAmount;
	}




	public int getDealYear() {
		return dealYear;
	}




	public void setDealYear(int dealYear) {
		this.dealYear = dealYear;
	}




	public int getDealMonth() {
		return dealMonth;
	}




	public void setDealMonth(int dealMonth) {
		this.dealMonth = dealMonth;
	}




	public String getArea() {
		return area;
	}




	public void setArea(String area) {
		this.area = area;
	}




	public String getFloor() {
		return floor;
	}




	public void setFloor(String floor) {
		this.floor = floor;
	}




	public String getApartmentName() {
		return apartmentName;
	}




	public void setApartmentName(String apartmentName) {
		this.apartmentName = apartmentName;
	}




	public HouseDealDto(String dealAmount, int dealYear, int dealMonth, String area, String floor, String apartmentName) {
		super();
		this.dealAmount = dealAmount;
		this.dealYear = dealYear;
		this.dealMonth = dealMonth;
		this.area = area;
		this.floor = floor;
		this.apartmentName = apartmentName;
	}
	
	@Override
	public String toString() {
		return "HouseDealDto [dealAmount=" + dealAmount + ", dealYear=" + dealYear + ", dealMonth=" + dealMonth
				+ ", area=" + area + ", floor=" + floor + ", apartmentName=" + apartmentName +"]";
	}
	
	
	
	

}
