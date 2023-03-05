package kr.or.iei.frip.service;

import java.sql.Connection;
import java.util.ArrayList;

import common.JDBCTemplate;
import kr.or.iei.frip.dao.FripDao;
import kr.or.iei.frip.vo.Frip;
import kr.or.iei.frip.vo.FripJoinableDate;
import kr.or.iei.frip.vo.FripJoinableDateData;

public class FripService {
	private FripDao dao;
	
	public FripService() {
		dao = new FripDao();
	}

	public int insertFrip(Frip f) {
		Connection conn = JDBCTemplate.getConnection();
		int result1 = dao.insertFrip(conn, f);
		int result4 = 1;
		
		if(result1 > 0) {
			
			int fripNo = dao.selectFripNo(conn, f);
			int result2 = dao.insertFripCategory(conn, fripNo, f.getFripCategory());
			
			if(result2 > 0) {
				
				int result3= dao.insertFripJoinableDate(conn, f, fripNo);
				if(result3 > 0) {
					result4 = 1;
					
					for(String filepath : f.getFilePath()) {
						int result5 = dao.insertFripFile(conn, fripNo, filepath);
						if(result5 == 0) {
							result4 = 0;
						}
					}
					if(result4 > 0) {
						JDBCTemplate.commit(conn);
					} else {
						JDBCTemplate.rollback(conn);
					}			
				}
			}
		}
		return result4;
	}
	
	public ArrayList<Frip> selectAllFrip(){
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Frip> list = dao.selectAllFrip(conn);
		for(Frip f : list) {
			ArrayList<String> fripFiles = dao.selectFripFiles(conn, f.getFripNo());
			f.setFilePath(fripFiles);
			ArrayList<FripJoinableDate> joinableDates = dao.selectJoinableDates(conn, f.getFripNo());
			f.setJoinableDates(joinableDates);
		}
		return list;
	}

	public ArrayList<Frip> selectMyFrip(String fripWriter) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Frip> list = dao.selectMyFrip(conn, fripWriter);
		for(Frip f : list) {
			ArrayList<String> fripFiles = dao.selectFripFiles(conn, f.getFripNo());
			f.setFilePath(fripFiles);
			ArrayList<FripJoinableDate> joinableDates = dao.selectJoinableDates(conn, f.getFripNo());
			f.setJoinableDates(joinableDates);
		}
		return list;
	}

	public Frip selectOneFripByNo(int fripNo) {
		Connection conn = JDBCTemplate.getConnection();
		Frip f = dao.selectOneFripByNo(conn, fripNo);
		if( f != null) {
			ArrayList<String> fripFiles = dao.selectFripFiles(conn, fripNo);
			f.setFilePath(fripFiles);
			ArrayList<FripJoinableDate> joinableDates = dao.selectJoinableDates(conn, f.getFripNo());
			f.setJoinableDates(joinableDates);
		}
		JDBCTemplate.close(conn);
		return f;
	}

	public ArrayList<Frip> selectAllFripByCategory(String fripCategory){
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Frip> list = dao.selectAllFripByCategory(conn, fripCategory);
		for(Frip f : list) {
			ArrayList<String> fripFiles = dao.selectFripFiles(conn, f.getFripNo());
			f.setFilePath(fripFiles);
			ArrayList<FripJoinableDate> joinableDates = dao.selectJoinableDates(conn, f.getFripNo());
			f.setJoinableDates(joinableDates);
		}
		JDBCTemplate.close(conn);
		return list;
	}

	public FripJoinableDate insertFripJoinableDate(Frip f) {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.insertFripJoinableDate(conn, f, f.getFripNo());
		FripJoinableDate date = null;
		if(result != 0) {
			JDBCTemplate.commit(conn);
			int latestPK = dao.selectLastestFripJoinableDatePK(conn);
			date = dao.selectOneFripJoinableDateByNo(conn, latestPK);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return date;
	}
}
