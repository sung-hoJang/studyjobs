package org.sjac.model;

import java.util.List;
import java.util.Map;

public interface ScheduleService {
	public List<ScheduleVO> findMyScheduleById(String id); // 자신의 아이디로 스케줄리스트 받아오기
	public List<ScheduleVO> findMyLastScheduleById(String id); // 자신의 아이디로 지난 스케줄 받아오기
	public void submitSchedule(ScheduleVO schvo);
	public List<ScheduleVO> getGroupScheduleListBygLeaderId(String gLeaderId); 
	public ScheduleVO findScheduleByScheduleDate(ScheduleVO schvo);
	public void updateSchedule(ScheduleVO schvo, String orgScheduleDate); 
	public void deleteScheduleByScheduleDate(ScheduleVO schvo);// 스케쥴 삭제 
	public List<ScheduleVO> findGroupPageScheduleByYearAndMonth(Map<String, Object> map);
	
}
