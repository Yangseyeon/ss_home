package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.BoardDto;
import util.DBUtil;

public class BoardDaoImpl implements BoardDao {
    
    private static BoardDao boardDao;
    private DBUtil db;
    
    
    private BoardDaoImpl() {
    	db = DBUtil.getInstance();
    }

    public static BoardDao getBoardDao() {
        if(boardDao == null)
            boardDao = new BoardDaoImpl();
        return boardDao;
    }

    @Override
    public void writeArticle(BoardDto boardDto) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = db.getConnection();
            StringBuilder sql = new StringBuilder();
            sql.append("insert into board (user_id, subject, content) \n");
            sql.append("values (?, ?, ?)");
            pstmt = conn.prepareStatement(sql.toString());
            pstmt.setString(1, boardDto.getUserId());
            pstmt.setString(2, boardDto.getSubject());
            pstmt.setString(3, boardDto.getContent());
            pstmt.executeUpdate();
        } finally {
            db.close(pstmt, conn);
        }
    }

    @Override
    public List<BoardDto> listArticle() throws SQLException {
        List<BoardDto> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = db.getConnection();
            StringBuilder sql = new StringBuilder();
            sql.append("select article_no, user_id, subject, content, hit, register_time \n");
            sql.append("from board \n");
            sql.append("order by article_no desc");
            pstmt = conn.prepareStatement(sql.toString());
            rs = pstmt.executeQuery();
            while(rs.next()) {
                BoardDto boardDto = new BoardDto();
                boardDto.setArticleNo(rs.getInt("article_no"));
                boardDto.setUserId(rs.getString("user_id"));
                boardDto.setSubject(rs.getString("subject"));
                boardDto.setContent(rs.getString("content"));
                boardDto.setHit(rs.getInt("hit"));
                boardDto.setRegisterTime(rs.getString("register_time"));
                
                list.add(boardDto);
            }
        } finally {
            db.close(rs, pstmt, conn);
        }
        return list;
    }

    @Override
    public BoardDto getArticle(int articleNo) throws SQLException {
        BoardDto boardDto = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = db.getConnection();
            StringBuilder sql = new StringBuilder();
            sql.append("select article_no, user_id, subject, content, hit, register_time \n");
            sql.append("from board \n");
            sql.append("where article_no = ?");
            pstmt = conn.prepareStatement(sql.toString());
            pstmt.setInt(1, articleNo);
            rs = pstmt.executeQuery();
            if(rs.next()) {
                boardDto = new BoardDto();
                boardDto.setArticleNo(rs.getInt("article_no"));
                boardDto.setUserId(rs.getString("user_id"));
                boardDto.setSubject(rs.getString("subject"));
                boardDto.setContent(rs.getString("content"));
                boardDto.setHit(rs.getInt("hit"));
                boardDto.setRegisterTime(rs.getString("register_time"));
            }
            
            
        } finally {
            db.close(rs, pstmt, conn);
        }
        return boardDto;
    }

    @Override
    public void updateHit(int articleNo) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = db.getConnection();
            StringBuilder sql = new StringBuilder();
            sql.append("update board \n");
            sql.append("set hit = hit + 1 \n");
            sql.append("where article_no = ?");
            pstmt = conn.prepareStatement(sql.toString());
            pstmt.setInt(1, articleNo);
            pstmt.executeUpdate();
        } finally {
            db.close(pstmt, conn);
        }    
    }

    @Override
    public void modifyArticle(BoardDto boardDto) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        StringBuilder sql = new StringBuilder();
        sql.append("update board set subject=?, content=? \n");
        sql.append("where article_no = ?");
        try {
            conn = db.getConnection();
            
            System.out.println("HI " + boardDto);
            pstmt = conn.prepareStatement(sql.toString());
            pstmt.setString(1, boardDto.getSubject());
            pstmt.setString(2, boardDto.getContent());
            pstmt.setInt(3, boardDto.getArticleNo());
            pstmt.executeUpdate();
        } finally {
            db.close(pstmt, conn);
        }        
    }

    @Override
    public void deleteArticle(int articleNo) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        StringBuilder sql = new StringBuilder();
        sql.append("delete from board \n");
        sql.append("where article_no = ?");
        try {
            conn = db.getConnection();
            
            pstmt = conn.prepareStatement(sql.toString());
            pstmt.setInt(1, articleNo);
            
            pstmt.executeUpdate();
        } finally {
            db.close(pstmt, conn);
        }            
    }
    
    public static void main(String[] args) throws Exception {
		BoardDaoImpl boardDaoImpl = new BoardDaoImpl();
		boardDaoImpl.writeArticle(new BoardDto(1, "ssafy", "3", "4", 5, "6"));	
		System.out.println(boardDaoImpl.getArticle(1));
		}

}