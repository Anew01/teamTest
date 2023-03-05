package kr.or.iei.join.service;

import java.sql.Connection;

import common.JDBCTemplate;
import kr.or.iei.join.dao.JoinFripDao;

public class JoinFripService {
	private JoinFripDao joinFripDao;

	public JoinFripService() {
		super();
		joinFripDao = new JoinFripDao();
	}

	public int checkSchedule(int fripNo, String calendar, int attendCount) {
		Connection conn = JDBCTemplate.getConnection();
		int result = joinFripDao.checkCalander(conn, fripNo, calendar);
		if(result==1) {
			//활동의 최대인원수
			int maxCount = joinFripDao.checkMaxCount(conn, fripNo, calendar);
			//활동에 예약된 인원수
			int joinCount = joinFripDao.checkJoinCount(conn,  calendar, fripNo); 
			if(maxCount > joinCount + attendCount) {
				return 1;
			}else {
				return 0;
			}
		}else {
			JDBCTemplate.close(conn);
			return 0;
		}
		
		/**
		 1. 원하는 프립과 날짜에서 가능한 프립 날짜가 있는지 
		 //select joinable_date_no from frip_joinable_date 
		where frip_no=41 and ('2023-03-01'<=end_date and '2023-03-01'>=start_date);  
		  -> 조회결과에서 joinable_date_no 값이 있거나 없음
		  -> 없으면 return 0;
		 2. 원하는 날짜에 이 플립이 몇명이 들어가는지 세오기 
		  -> 2-1. 최대인원수
		  //select max_count from frip_joinable_date
			WHERE frip_no=49 and ('2023-03-09'<=end_date and '2023-03-09'>=start_date);
		  -> 2-2. 해당날짜에 예약된 인원수
		  //SELECT SUM(JOIN_COUNT) FROM JOIN_FRIP WHERE JOIN_DATE='2023-03-06' AND FRIP_NO=45 ;
		  
		  최대인원수 > 예약된인원수 + attendNumber
		  예약가능하면 return 1;
		  예약불가능하면 return 0;
		 */
	}
	
	

}
