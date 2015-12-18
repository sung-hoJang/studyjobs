package org.sjac.model;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service
public class ScheduleServiceImpl implements ScheduleService{
	@Resource
	private ScheduleDAO scheduleDAO;
	
	@Override
	public List<ScheduleVO> findMyScheduleById(String id) {
		return scheduleDAO.findMyScheduleById(id);
	}

	@Override
	public List<ScheduleVO> findMyLastScheduleById(String id) {
		return scheduleDAO.findMyLastScheduleById(id);
	}
	   @Override
	   public void submitSchedule(ScheduleVO schvo) {
	      scheduleDAO.submitSchedule(schvo);
	   }

	@Override
	public List<ScheduleVO> getGroupScheduleListBygLeaderId(String gLeaderId) {
		return scheduleDAO.getGroupScheduleListBygLeaderId(gLeaderId);
	}
	
	@Override
	   public ScheduleVO findScheduleByScheduleDate(ScheduleVO schvo) {
	      return scheduleDAO.findScheduleByScheduleDate(schvo);
	   }
	
	@Override
    public void updateSchedule(ScheduleVO schvo,String orgScheduleDate) {
       scheduleDAO.updateSchedule(schvo,orgScheduleDate);
    }
	
	@Override
    public void deleteScheduleByScheduleDate(ScheduleVO schvo) {
       scheduleDAO.deleteScheduleByScheduleDate(schvo);
    }

	@Override
	public List<ScheduleVO> findGroupPageScheduleByYearAndMonth(
			Map<String, Object> map) {
		return scheduleDAO.findGroupPageScheduleByYearAndMonth(map);
	}

}
