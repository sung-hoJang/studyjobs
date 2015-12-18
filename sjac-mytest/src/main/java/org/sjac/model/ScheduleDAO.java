package org.sjac.model;

import java.util.List;
import java.util.Map;

public interface ScheduleDAO {
	public List<ScheduleVO> findMyScheduleById(String id); // 자신의 아이디로 스케줄리스트 받아오기
	public void addLastSchedule(ScheduleVO vo);
	public void deleteLastSchedule(ScheduleVO vo);
	public List<ScheduleVO> findMyLastScheduleById(String id); // 자신의 아이디로 지난 스케줄 받아오기
    public void submitSchedule(ScheduleVO schvo);
    
    public List<ScheduleVO> findMyLastScheduleByGroupLeaderId(String id); // 그룹장 아이디로 지난 스케쥴 리스트 받아오기
    public void deleteLastGroupScheduleByGroupLeaderId(String id); //그룹장 아이디로 지난 스케쥴 지우기
    public void deleteGroupScheduleByGroupLeaderId(String id); //그룹장 아이디로 스케쥴 지우기
    public List<ScheduleVO> findMyScheduleByGroupLeaderId(String id); // 그룹장 아이디로 스케쥴 리스트 받아오기

	public List<ScheduleVO> getGroupScheduleListBygLeaderId(String gLeaderId); 
	
	public ScheduleVO findScheduleByScheduleDate(ScheduleVO schvo);
	public void updateSchedule(ScheduleVO schvo, String orgScheduleDate); 
	public void deleteScheduleByScheduleDate(ScheduleVO schvo);
	public List<ScheduleVO> findGroupPageScheduleByYearAndMonth(Map<String, Object> map);
	
}
