package service;

import java.util.List;

import dto.BoardDto;

public interface BoardService {

    void writeArticle(BoardDto boardDto) throws Exception;
    List<BoardDto> listArticle() throws Exception;
    BoardDto getArticle(int articleNo) throws Exception;
    void updateHit(int articleNo) throws Exception;
    
    void modifyArticle(BoardDto boardDto) throws Exception;
    void deleteArticle(int articleNo) throws Exception;
    
}