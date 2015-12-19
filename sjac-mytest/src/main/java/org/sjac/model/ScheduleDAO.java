package org.sjac.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ScheduleDAO {
	/**
	 * 자신의 아이디로 자신이 가입한 그룹의 모든 스케줄 리스트 받아오기 
	 * @param id
	 * @return
	 */
	public List<ScheduleVO> findMyScheduleById(String id);
	
	
	/**
	 * 
	 * 지난 스케줄을 지난스케줄 테이블(CU_LAST_SCHEDULE)에 추가 
	 * @param vo 
	 */
	public void addLastSchedule(ScheduleVO vo);
	
	/**
	 * CU_SCHEDULE에 있는 지난 스케줄을 CU_SCHEDULE에서 삭제 
	 * @param vo
	 */
	public void deleteLastSchedule(ScheduleVO vo);
	
	/**
	 * 자신의 아이디로 자신이 가입한 그룹의 지난 스케줄 리스트 받아오기
	 * @param id
	 * @return
	 */
	public List<ScheduleVO> findMyLastScheduleById(String id); 
	
	/**
	 * 스케줄 입력하기
	 * @param schvo : 입력된 스케줄 정보
	 */
    public void submitSchedule(ScheduleVO schvo);

    /**
     * 
     * @param id
     * @return
     */
    public List<ScheduleVO> findMyLastScheduleByGroupLeaderId(String id); 
    
    /**
     * CU_LAST_SCHEDULE에서 그룹장의 아이디에 해당하는 스케줄 삭제하기
     * @param id : 그룹장 아이디
     */
    public void deleteLastGroupScheduleByGroupLeaderId(String id);
    
    /**
     * CU_SCHEDULE에서 그룹장의 아이디에 해당하는 스케줄 삭제하기
     * @param id
     */
    public void deleteGroupScheduleByGroupLeaderId(String id); 
    
    /**
     * 그룹장 아이디로 그룹장에 해당하는 스케줄 리스트 받아오기
     * @param gLeaderId : 그룹장 아이디
     * @return
     */
	public List<ScheduleVO> getGroupScheduleListBygLeaderId(String gLeaderId); 
	
	/**
	 * 그룹장아이디 + 스케줄날짜에 해당하는 스케줄 찾기
	 * @param schvo : 그룹장 아이디 + 스케줄 날짜
	 * @return
	 */
	public ScheduleVO findScheduleByScheduleDate(ScheduleVO schvo);
	
	/**
	 * 스케줄 수정 
	 * @param schvo : 그룹장 아이디 + 스케줄 날짜(변경될 스케줄)
	 * @param orgScheduleDate : 수정 전 스케줄 날짜
	 */
	public void updateSchedule(ScheduleVO schvo, String orgScheduleDate); 
	
	/**
	 * 스케줄 삭제
	 * @param schvo : 그룹장 아이디 + 스케줄 날짜
	 */
	public void deleteScheduleByScheduleDate(ScheduleVO schvo);
	
	/**
	 * 그룹페이지에서 필요한 스케줄 리스트
	 * 연,월 + 그룹장 아이디로 그룹의 스케줄 리스트 받아오기
	 * ex) 2015/12 + 그룹장아이디로 검색을 하면 해당 그룹장의 그룹의 2015년 12월의 모든 스케줄을 받아옴
	 * 1월이면 1월의 모든 스케줄 리스트를 받아옴 
	 * @param map
	 * @return
	 */
	public List<ScheduleVO> findGroupPageScheduleByYearAndMonth(Map<String, Object> map);


	public int existDate(HashMap<String, String> map);
	
}
