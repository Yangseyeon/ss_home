package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import dto.Member;
import util.DBUtil;

public class MemberDaoImpl implements MemberDao {

    private static MemberDao instance = new MemberDaoImpl();
    private DBUtil db;

    private MemberDaoImpl() {
        db = DBUtil.getInstance();
    }
    public static MemberDao getInstance() {
        return instance;
    }
    @Override
    public Member loginCheck(String userId) throws Exception {
        Connection con=null;
        PreparedStatement pstmt = null;
        ResultSet result = null;
        String sql = new StringBuilder("SELECT user_id, user_name, user_password\n")
                .append("FROM members\n")
                .append("WHERE user_id = ?").toString();
        Member member = null;
        try {
            con = db.getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, userId);
            result = pstmt.executeQuery();
            if (result.next()) {
                member = new Member(
                        result.getString("user_id"),
                        result.getString("user_name"),
                        result.getString("user_password")
                        );
            }
        } finally {
            db.close(result, pstmt, con);
        }
        return member;
    }

    @Override
    public boolean login(String userId, String userPassword) throws Exception {
        Connection con=null;
        PreparedStatement pstmt = null;
        ResultSet result = null;
        String sql = new StringBuilder("SELECT user_id, user_password\n")
                .append("FROM members\n")
                .append("WHERE user_id = ? AND user_password=?").toString();
        boolean success = false;
        try {
            con = db.getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, userId);
            pstmt.setString(2, userPassword);
            result = pstmt.executeQuery();
            if (result.next()) {
                success = true;
            }
        } finally {
            db.close(result, pstmt, con);
        }
        return success;
    }
    
	@Override
	public boolean join(Member member) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = new StringBuilder("INSERT INTO members (user_id, user_name, user_password, address, phone_number) \n")
				.append("VALUES (?, ?, ?, ?, ?)")
				.toString();
		boolean success = false;
		
        try {
        	conn = db.getConnection();
        	pstmt = conn.prepareStatement(sql.toString());
            pstmt.setString(1, member.getUserId());
            pstmt.setString(2, member.getUserName());
            pstmt.setString(3, member.getUserPassword());
            pstmt.setString(4, member.getAddress());
            pstmt.setString(5, member.getPhoneNumber());
            
			pstmt.executeUpdate();
			success = true;
		} catch (SQLException e) {
			db.close(pstmt, conn);
		}        
        return success;
	}
	
	@Override
	public boolean delete(String userId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = new StringBuilder("DELETE FROM MEMBERS \n")
				.append("WHERE user_id = ?")
				.toString();
		boolean success = false;
		
        try {
        	conn = db.getConnection();
        	pstmt = conn.prepareStatement(sql.toString());
            pstmt.setString(1, userId);
			pstmt.executeUpdate();
			success = true;
		} catch (SQLException e) {
			db.close(pstmt, conn);
		}        
        return success;
	}
	
	@Override
	public void update(Member member) {
		Connection con=null;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		String sql = new StringBuilder("UPDATE members SET user_name=?, user_password=?, address=?, phone_number=? \n")
				.append("WHERE user_id = ?").toString();
		try {
			con = db.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getUserName());
			pstmt.setString(2, member.getUserPassword());
			pstmt.setString(3, member.getAddress());
			pstmt.setString(4, member.getPhoneNumber());
			pstmt.setString(5, member.getUserId());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(result, pstmt, con);
		}
	}
	
	@Override
	public Member findById(String userId) {
		Connection con=null;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		String sql = new StringBuilder("SELECT * FROM MEMBERS\n")
				.append("WHERE user_id = ?").toString();
		Member member = null;
		try {
			con = db.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userId);
			result = pstmt.executeQuery();
			if (result.next()) {
				member = new Member(
						result.getString("user_id"),
						result.getString("user_name"),
						result.getString("user_password"),
						result.getString("address"),
						result.getString("phone_number")
						);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.close(result, pstmt, con);
		}
		return member;
	}	
	
	public static void main(String[] args) {
		MemberDao memberDao = new MemberDaoImpl();
		memberDao.join(new Member("12", "12","12","12", "0105121211"));
		System.out.println("before");
		System.out.println(memberDao.findById("12"));
		memberDao.update(new Member("12", "14", "14", "14", "11111111"));
		System.out.println("after");
		System.out.println(memberDao.findById("12"));
		memberDao.delete("12");
//		System.out.println(memberDao.findById("12"));
	}
}