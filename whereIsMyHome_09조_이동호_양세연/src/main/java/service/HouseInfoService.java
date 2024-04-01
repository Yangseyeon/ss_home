package service;

import java.util.List;

import dto.HouseInfoDto;

public interface HouseInfoService {
	List<HouseInfoDto> findAllbyDongCode(String code) throws Exception;	
}
