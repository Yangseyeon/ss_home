package dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Member {
    private String userId;
    private String userName;
    private String userPassword;
    private String address;
    private String phoneNumber;
    public Member() {
        super();
    }

    
    public Member(String userId, String userName, String userPassword) {
        super();
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
    }
    
	public Member(String userId, String userName, String userPassword, String address, String phoneNumber) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Member [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword + ", address="
				+ address + ", phoneNumber=" + phoneNumber + "]";
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getUserPassword() {
		return userPassword;
	}


	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
	
	
}