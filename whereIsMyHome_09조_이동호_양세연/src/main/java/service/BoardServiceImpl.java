package service;


import java.util.List;

import dao.BoardDao;
import dao.BoardDaoImpl;
import dto.BoardDto;

public class BoardServiceImpl implements BoardService {
    
    private static BoardService boardService = new BoardServiceImpl();
    private BoardDao boardDao;
    
    private BoardServiceImpl() {
        boardDao = BoardDaoImpl.getBoardDao();
    }

    public static BoardService getBoardService() {
        return boardService;
    }

    @Override
    public void writeArticle(BoardDto boardDto) throws Exception {
        boardDao.writeArticle(boardDto);
    }

    @Override
    public List<BoardDto> listArticle() throws Exception {
        return boardDao.listArticle();
    }

    @Override
    public BoardDto getArticle(int articleNo) throws Exception {
        return boardDao.getArticle(articleNo);
    }

    @Override
    public void updateHit(int articleNo) throws Exception {
        boardDao.updateHit(articleNo);
    }

    @Override
    public void modifyArticle(BoardDto boardDto) throws Exception {
        boardDao.modifyArticle(boardDto);
        
    }

    @Override
    public void deleteArticle(int articleNo) throws Exception {
        boardDao.deleteArticle(articleNo);
    }

}