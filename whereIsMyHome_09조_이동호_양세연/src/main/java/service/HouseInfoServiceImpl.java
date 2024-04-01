package service;

import java.util.List;

import dao.HouseInfoDao;
import dao.HouseInfoDaoImpl;
import dto.HouseInfoDto;

public class HouseInfoServiceImpl implements HouseInfoService {
	private static HouseInfoService instance = new HouseInfoServiceImpl();
    private HouseInfoDao dao;
    
    

    private HouseInfoServiceImpl() {
        dao = HouseInfoDaoImpl.getInstance();
    }
    
    public static HouseInfoService getInstance() {
        return instance;
    }
	

	@Override
	public List<HouseInfoDto> findAllbyDongCode(String code) throws Exception {
		return dao.findAllbyDongCode(code);
	}

}
