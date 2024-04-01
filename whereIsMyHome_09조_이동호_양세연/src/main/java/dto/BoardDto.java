package dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class BoardDto {

    private int articleNo;
    private String userId;
    private String subject;
    private String content;
    private int hit;
    private String registerTime;


	public BoardDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public BoardDto(int articleNo, String userId, String subject, String content, int hit, String registerTime) {
		super();
		this.articleNo = articleNo;
		this.userId = userId;
		this.subject = subject;
		this.content = content;
		this.hit = hit;
		this.registerTime = registerTime;
	}
	
	@Override
    public String toString() {
        return "BoardDto [articleNo=" + articleNo + ", userId=" + userId + ", subject=" + subject + ", content="
                + content + ", hit=" + hit + ", registerTime=" + registerTime + "]";
    }


	public int getArticleNo() {
		return articleNo;
	}


	public void setArticleNo(int articleNo) {
		this.articleNo = articleNo;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getSubject() {
		return subject;
	}


	public void setSubject(String subject) {
		this.subject = subject;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public int getHit() {
		return hit;
	}


	public void setHit(int hit) {
		this.hit = hit;
	}


	public String getRegisterTime() {
		return registerTime;
	}


	public void setRegisterTime(String registerTime) {
		this.registerTime = registerTime;
	}
	
	
	

	
	
}