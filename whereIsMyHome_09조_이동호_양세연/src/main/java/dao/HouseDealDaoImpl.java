package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dto.HouseDealDto;
import util.DBUtil;

public class HouseDealDaoImpl implements HouseDealDao {
	
	private static HouseDealDao instance = new HouseDealDaoImpl();
	private DBUtil db;
	
	

	private HouseDealDaoImpl() {
		db = DBUtil.getInstance();
	}
	
	public static HouseDealDao getInstance() {
		return instance;
	}
	

	@Override
	public List<HouseDealDto> findAllByAptCode(String aptName) throws Exception {
		Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet result = null;
        
        String sql = new StringBuilder("select hd.dealAmount, hd.dealYear, hd.dealMonth, hd.area, hd.floor, hi.aptCode, hi.apartmentName\n")
        		.append("from houseinfo hi join housedeal hd\n")
        		.append("where hi.aptCode = hd.aptCode and apartmentName = ?").toString();
        
        List<HouseDealDto> houseDealList = new ArrayList<>();
        
        
        try {
            con = db.getConnection();
            pstmt = con.prepareStatement(sql);
            
            pstmt.setString(1, aptName);
            
            result = pstmt.executeQuery();
            
            while(result.next()) {
            	houseDealList.add(new HouseDealDto(
                        result.getString("hd.dealAmount"),
                        result.getInt("hd.dealYear"),
                        result.getInt("hd.dealMonth"),
                        result.getString("hd.area"),
                        result.getString("hd.floor"),
                        result.getString("hi.apartmentName")
                        ));
            }
        }
        finally {
            db.close(result, pstmt, con);
            
        }
        return houseDealList;
		
	}

	@Override
	public List<HouseDealDto> findAllByAptCode(String aptName, int year) throws Exception{
		Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet result = null;
        
        String sql = new StringBuilder("select hd.dealAmount, hd.dealYear, hd.dealMonth, hd.area, hd.floor, hi.aptCode, hi.apartmentName\n")
        		.append("from houseinfo hi join housedeal hd\n")
        		.append("where hi.aptCode = hd.aptCode and apartmentName = ? and dealYear = ?").toString();
        
        List<HouseDealDto> houseDealList = new ArrayList<>();
        
        
        try {
            con = db.getConnection();
            pstmt = con.prepareStatement(sql);
            
            pstmt.setString(1, aptName);
            pstmt.setInt(2, year);
            
            result = pstmt.executeQuery();
            
            while(result.next()) {
            	houseDealList.add(new HouseDealDto(
                        result.getString("hd.dealAmount"),
                        result.getInt("hd.dealYear"),
                        result.getInt("hd.dealMonth"),
                        result.getString("hd.area"),
                        result.getString("hd.floor"),
                        result.getString("hi.apartmentName")
                        ));
            }
        }
        finally {
            db.close(result, pstmt, con);
            
        }
        return houseDealList;
	}

	@Override
	public List<HouseDealDto> findAllByAptCode(String aptName, int year, int month) throws Exception {
		Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet result = null;
        
        String sql = new StringBuilder("select hd.dealAmount, hd.dealYear, hd.dealMonth, hd.area, hd.floor, hi.aptCode, hi.apartmentName\n")
        		.append("from houseinfo hi join housedeal hd\n")
        		.append("where hi.aptCode = hd.aptCode and apartmentName = ? and dealYear = ? and dealMonth = ?").toString();
        
        List<HouseDealDto> houseDealList = new ArrayList<>();
        
        
        try {
            con = db.getConnection();
            pstmt = con.prepareStatement(sql);
            
            pstmt.setString(1, aptName);
            pstmt.setInt(2, year);
            pstmt.setInt(3, month);
            
            result = pstmt.executeQuery();
            
            while(result.next()) {
            	houseDealList.add(new HouseDealDto(
                        result.getString("hd.dealAmount"),
                        result.getInt("hd.dealYear"),
                        result.getInt("hd.dealMonth"),
                        result.getString("hd.area"),
                        result.getString("hd.floor"),
                        result.getString("hi.apartmentName")
                        ));
            }
        }
        finally {
            db.close(result, pstmt, con);
            
        }
        return houseDealList;
	}
	
	public static void main(String[] args) throws Exception {
		HouseDealDao dao = HouseDealDaoImpl.getInstance();
	//    dao.create(new Product("p001", "notebook", 20000));
	    List<HouseDealDto> products = dao.findAllByAptCode("경희궁파크팰리스", 2015);
	    for(HouseDealDto p: products)
	        System.out.println(p);
	}
	

}
