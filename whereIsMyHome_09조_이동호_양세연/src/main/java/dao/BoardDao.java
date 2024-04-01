package dao;

import java.sql.SQLException;
import java.util.List;

import dto.BoardDto;

public interface BoardDao {

    void writeArticle(BoardDto boardDto) throws SQLException;
    List<BoardDto> listArticle() throws SQLException;
    BoardDto getArticle(int articleNo) throws SQLException;
    void updateHit(int articleNo) throws SQLException;
    
    void modifyArticle(BoardDto boardDto) throws SQLException;
    void deleteArticle(int articleNO) throws SQLException;
    
}