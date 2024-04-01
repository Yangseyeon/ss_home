package dao;

import java.util.List;

import dto.HouseInfoDto;

public interface HouseInfoDao {
	List<HouseInfoDto> findAllbyDongCode(String code) throws Exception;

}
