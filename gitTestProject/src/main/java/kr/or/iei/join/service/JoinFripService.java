package kr.or.iei.join.service;

import kr.or.iei.join.dao.JoinFripDao;

public class JoinFripService {
	private JoinFripDao joinFripDao;

	public JoinFripService() {
		super();
		joinFripDao = new JoinFripDao();
	}

	public int checkSchedule(int fripNo, String calendar, int attendNumber) {
		/**
		 
		 1. 원하는 플립과 날짜에서 가능한 프립 날짜가 있는지 
		  -> 조회결과에서 joinable_date_no 값이 있거나 없음
		  -> 없으면 return 0;
		 2. 원하는 날짜에 이 플립이 몇명이 들어가는지 세오기 
		  -> 2-1. 최대인원수
		  -> 2-2. 해당날짜에 예약된 인원수
		  
		  최대인원수 > 예야된인원수 + attendNumber
		  예약가능하면 return 1;
		  예약불가능하면 return 0;
		 */
		return 1;
	}
	
	

}
