package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.DongCodeDto;
import util.DBUtil;

public class DongCodeDaoImpl implements DongCodeDao {
	
	private static DongCodeDao instance = new DongCodeDaoImpl();
	private DBUtil db;

	private DongCodeDaoImpl() {
		db = DBUtil.getInstance();
	}
	
	public static DongCodeDao getInstance() {
		return instance;
	}
	

	@Override
	public List<DongCodeDto> findAllSido() throws Exception{
		Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet result = null;
        
        String sql = new StringBuilder("select distinct left(dongCode, 2) sido, sidoName\n")
        		.append("from dongcode\n").toString();
        
        List<DongCodeDto> sidoList = new ArrayList<>();
        
        
        try {
            con = db.getConnection();
            pstmt = con.prepareStatement(sql);
            
            result = pstmt.executeQuery();
            while(result.next()) {
                sidoList.add(new DongCodeDto(
                        result.getString("sido"),
                        result.getString("sidoName"),
                        "",
                        ""
                        ));
            }
        }
        finally {
            db.close(result, pstmt, con);
            
        }
        return sidoList;
	}

	@Override
	public List<DongCodeDto> findGugunFromSido(DongCodeDto sido) throws Exception{
		Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet result = null;
        
        String sql = new StringBuilder("select distinct left(dongCode, 5) gugun, gugunName\n")
        		.append("from dongcode\n")
        		.append("where left(dongcode, 2) = ?")
        		.append("and gugunName is not null").toString();
        
        List<DongCodeDto> gugunList = new ArrayList<>();
        
        
        try {
            con = db.getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, sido.getDongCode());
            
            result = pstmt.executeQuery();
            while(result.next()) {
                gugunList.add(new DongCodeDto(
                        result.getString("gugun"),
                        sido.getSidoName(),
                        result.getString("gugunName"),
                        ""
                        ));
            }
        }
        finally {
            db.close(result, pstmt, con);
            
        }
        return gugunList;
	}

	@Override
	public List<DongCodeDto> findDongFromGugun(DongCodeDto gugun) throws Exception{
		Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet result = null;
        
        String sql = new StringBuilder("select distinct dongCode, dongName\n")
        		.append("from dongcode\n")
        		.append("where left(dongcode, 5) = ?")
        		.append("and dongName is not null").toString();
        
        List<DongCodeDto> gugunList = new ArrayList<>();
        
        
        try {
            con = db.getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, gugun.getDongCode());
            
            result = pstmt.executeQuery();
            while(result.next()) {
                gugunList.add(new DongCodeDto(
                        result.getString("dongCode"),
                        gugun.getSidoName(),
                        gugun.getGugunName(),
                        result.getString("dongName")
                        ));
            }
        }
        finally {
            db.close(result, pstmt, con);
            
        }
        return gugunList;
	}
	
	public static void main(String args[]) throws Exception {
		
        DongCodeDao dao = DongCodeDaoImpl.getInstance();
//        dao.create(new Product("p001", "notebook", 20000));
        List<DongCodeDto> products = dao.findDongFromGugun(new DongCodeDto("11110", "서울특별시", "종로구", ""));
        for(DongCodeDto p: products)
            System.out.println(p);
        
//        
//        System.out.println(dao.findByCode("p001"));
//        dao.update(new Product("p001", "notebook", 10000));
//        System.out.println(dao.findByCode("p001"));
//        
//        dao.delete("p001");
//        
//        System.out.println(dao.findByCode("p001"));
    }

}
