package dao;

import java.util.List;

import dto.DongCodeDto;

public interface DongCodeDao {
	
	List<DongCodeDto> findAllSido() throws Exception;
	List<DongCodeDto> findGugunFromSido(DongCodeDto sido) throws Exception;
	List<DongCodeDto> findDongFromGugun(DongCodeDto gugun) throws Exception;

}
