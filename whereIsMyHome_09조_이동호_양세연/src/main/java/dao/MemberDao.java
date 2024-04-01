package dao;

import dto.Member;

public interface MemberDao {
	
    Member loginCheck(String userId) throws Exception;
    boolean login(String userId, String userPassword) throws Exception;
	boolean delete(String userId);
	boolean join(Member member);
	void update(Member member);
	Member findById(String userId);
}