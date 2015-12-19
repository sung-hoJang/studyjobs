package org.sjac.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ScheduleDAOImpl implements ScheduleDAO{
	@Resource
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List<ScheduleVO> findMyScheduleById(String id) {
		return sqlSessionTemplate.selectList("member.findMyScheduleById", id);
	}

	@Override
	public void addLastSchedule(ScheduleVO vo) {
		sqlSessionTemplate.insert("member.addLastSchedule", vo);
	}
	
	@Override
	public void deleteLastSchedule(ScheduleVO vo) {
		sqlSessionTemplate.delete("member.deleteLastSchedule", vo);
	}

	@Override
	public List<ScheduleVO> findMyLastScheduleById(String id) {
		return sqlSessionTemplate.selectList("member.findMyLastScheduleById", id);
	}
	
	  @Override
	   public void submitSchedule(ScheduleVO schvo) {
		  
	      sqlSessionTemplate.insert("schedule.submitSchedule", schvo);
    }
	  
	  @Override
	   public List<ScheduleVO> findMyLastScheduleByGroupLeaderId(String id) {
	      return sqlSessionTemplate.selectList("member.findMyLastScheduleByGroupLeaderId", id);
    }  
	
	  @Override
	   public void deleteLastGroupScheduleByGroupLeaderId(String id) {
	      sqlSessionTemplate.delete("member.deleteLastGroupScheduleByGroupLeaderId", id);
	      
	 }
	  
	  @Override
	   public void deleteGroupScheduleByGroupLeaderId(String id) {
	      sqlSessionTemplate.delete("member.deleteGroupScheduleByGroupLeaderId", id);
	      
	   }
	  

	@Override
	public List<ScheduleVO> getGroupScheduleListBygLeaderId(String gLeaderId) {
		return sqlSessionTemplate.selectList("schedule.getGroupScheduleListBygLeaderId", gLeaderId);
	}
	
	@Override
	   public ScheduleVO findScheduleByScheduleDate(ScheduleVO schvo) {
	      return sqlSessionTemplate.selectOne("schedule.findScheduleByScheduleDate", schvo);
	   }
	
	@Override
    public void updateSchedule(ScheduleVO schvo,String orgScheduleDate) {
      String orgDate=orgScheduleDate.replace("-", "/");
      Map<String, Object> map = new HashMap<String, Object>();
      map.put("schvo", schvo);
      map.put("orgDate", orgDate);
      sqlSessionTemplate.update("schedule.updateSchedule", map);
    } 
	
	@Override
    public void deleteScheduleByScheduleDate(ScheduleVO schvo) {
      sqlSessionTemplate.delete("schedule.deleteScheduleByScheduleDate", schvo);
    }

	@Override
	public List<ScheduleVO> findGroupPageScheduleByYearAndMonth(Map<String, Object> map) {
		return sqlSessionTemplate.selectList("schedule.findGroupPageScheduleByYearAndMonth", map);
	}
	
	@Override
	public int existDate(HashMap<String, String> map) {
		return sqlSessionTemplate.selectOne("schedule.existDate", map);
	}
}
