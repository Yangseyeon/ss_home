package service;

import dao.MemberDao;
import dao.MemberDaoImpl;
import dto.Member;

public class MemberServiceImpl implements MemberService {

    private static MemberService instance = new MemberServiceImpl();
    private MemberDao dao;
    
    private MemberServiceImpl() {
        dao = MemberDaoImpl.getInstance();
    }
    public static MemberService getInstance() {
        return instance;
    }
    @Override
    public Member loginCheck(String userId) throws Exception {
        return dao.loginCheck(userId);
    }

    @Override
    public boolean login(String userId, String userPassword) throws Exception {
        return dao.login(userId, userPassword);
    }
	@Override
	public boolean delete(String userId) {
		return dao.delete(userId);
	}
	@Override
	public boolean join(Member member) {
		return dao.join(member);
	}
	@Override
	public void update(Member member) {
		dao.update(member);
	}
	@Override
	public Member findById(String userId) {
		return dao.findById(userId);
	}

}