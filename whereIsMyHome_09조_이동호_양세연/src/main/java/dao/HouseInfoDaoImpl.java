package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dto.HouseInfoDto;
import util.DBUtil;

public class HouseInfoDaoImpl implements HouseInfoDao {
	
	private static HouseInfoDao instance = new HouseInfoDaoImpl();
	private DBUtil db;
	
	

	public HouseInfoDaoImpl() {
		db = DBUtil.getInstance();
	}
	
	public static HouseInfoDao getInstance() {
		return instance;
	}



	@Override
	public List<HouseInfoDto> findAllbyDongCode(String code) throws Exception{
		Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet result = null;
        
        String sql = new StringBuilder("select buildYear, roadName, dong, dongCode, apartmentName, jibun, lng, lat\n")
        		.append("from houseinfo\n")
        		.append("where dongCode = ?").toString();
        
        List<HouseInfoDto> houseInfoList = new ArrayList<>();
        
        
        try {
            con = db.getConnection();
            pstmt = con.prepareStatement(sql);
            
            pstmt.setString(1, code);
            
            result = pstmt.executeQuery();
            
            while(result.next()) {
            	houseInfoList.add(new HouseInfoDto(
                        result.getInt("buildYear"),
                        result.getString("roadName"),
                        result.getString("dong"),
                        result.getString("dongCode"),
                        result.getString("apartmentName"),
                        result.getString("jibun"),
                        result.getString("lng"),
                        result.getString("lat")
                        ));
            }
        }
        finally {
            db.close(result, pstmt, con);
            
        }
        return houseInfoList;
	}
	
	public static void main(String[] args) throws Exception{
		HouseInfoDao dao = HouseInfoDaoImpl.getInstance();
		List<HouseInfoDto> products = dao.findAllbyDongCode("1111017400");
		
		for(HouseInfoDto p: products)
	        System.out.println(p);
		
		
	}

}
