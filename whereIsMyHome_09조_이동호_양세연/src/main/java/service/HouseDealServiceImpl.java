package service;

import java.util.List;

import dao.HouseDealDao;
import dao.HouseDealDaoImpl;
import dto.HouseDealDto;

public class HouseDealServiceImpl implements HouseDealService {
	
	private static HouseDealService instance = new HouseDealServiceImpl();
    private HouseDealDao dao;
    
    

    private HouseDealServiceImpl() {
        dao = HouseDealDaoImpl.getInstance();
    }
    
    public static HouseDealService getInstance() {
        return instance;
    }
	

	@Override
	public List<HouseDealDto> findAllByAptCode(String aptName) throws Exception {
		return dao.findAllByAptCode(aptName);
	}

	@Override
	public List<HouseDealDto> findAllByAptCode(String aptName, int year) throws Exception {
		return dao.findAllByAptCode(aptName, year);
	}

	@Override
	public List<HouseDealDto> findAllByAptCode(String aptName, int year, int month) throws Exception {
		return dao.findAllByAptCode(aptName, year, month);
	}
	
	public static void main(String[] args) throws Exception {
		HouseDealService dao = HouseDealServiceImpl.getInstance();
	//    dao.create(new Product("p001", "notebook", 20000));
	    List<HouseDealDto> products = dao.findAllByAptCode("부천범박힐스테이트1단지", 2015);
	    for(HouseDealDto p: products)
	        System.out.println(p);
	}

}
