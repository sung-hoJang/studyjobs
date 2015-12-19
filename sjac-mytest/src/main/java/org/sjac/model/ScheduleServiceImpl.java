package org.sjac.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service
public class ScheduleServiceImpl implements ScheduleService{
	@Resource
	private ScheduleDAO scheduleDAO;
	
	@Resource
	private GroupDAO groupDAO;
	
	@Override
	public List<ScheduleVO> findMyScheduleById(String id) {
		List<GroupVO> groupList = groupDAO.getAllMyGroup(id);
		List<ScheduleVO> list = new ArrayList<ScheduleVO>();
		List<ScheduleVO> tempList = new ArrayList<ScheduleVO>();

		for (GroupVO vo : groupList) {
			tempList = scheduleDAO.findMyScheduleById(vo.getMemberVO().getId());
			for (ScheduleVO svo : tempList) {
				list.add(svo);
			}
		}
		
		Collections.sort(list, new Comparator<ScheduleVO>() {
			public int compare(ScheduleVO s1, ScheduleVO s2) {
				return s1.getScheduleDate().compareTo(s2.getScheduleDate());
			}
		});
		
		System.out.println("리스트 씨쓰아웃 : " + list);
		
		
		return list;
	}

	@Override
	public List<ScheduleVO> findMyLastScheduleById(String id) {
		List<GroupVO> groupList = groupDAO.getAllMyGroup(id);
		List<ScheduleVO> list = new ArrayList<ScheduleVO>();
		List<ScheduleVO> tempList = new ArrayList<ScheduleVO>();

		for (GroupVO vo : groupList) {
			tempList = scheduleDAO.findMyLastScheduleById(vo.getMemberVO().getId());
			for (ScheduleVO svo : tempList) {
				list.add(svo);
			}
		}

		Collections.sort(list, new Comparator<ScheduleVO>() {
			public int compare(ScheduleVO s1, ScheduleVO s2) {
				return s1.getScheduleDate().compareTo(s2.getScheduleDate());
			}
		});
		
		System.out.println("리스트 씨쓰아웃 : " + list);
		return list;
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

	@Override
	public int existDate(HashMap<String, String> map) {
		return scheduleDAO.existDate(map);
	}
}
