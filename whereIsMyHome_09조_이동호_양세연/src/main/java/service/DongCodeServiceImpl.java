package service;

import java.util.List;

import dao.DongCodeDao;
import dao.DongCodeDaoImpl;
import dto.DongCodeDto;

public class DongCodeServiceImpl implements DongCodeService {
	
	private static DongCodeService instance = new DongCodeServiceImpl();
    private DongCodeDao dao;
    
    

    private DongCodeServiceImpl() {
        dao = DongCodeDaoImpl.getInstance();
    }
    
    public static DongCodeService getInstance() {
        return instance;
    }
    

	@Override
	public List<DongCodeDto> findAllSido() throws Exception {
		return dao.findAllSido();
	}

	@Override
	public List<DongCodeDto> findGugunFromSido(DongCodeDto sido) throws Exception {
		return dao.findGugunFromSido(sido);
	}

	@Override
	public List<DongCodeDto> findDongFromGugun(DongCodeDto gugun) throws Exception {
		return dao.findDongFromGugun(gugun);
	}

}
