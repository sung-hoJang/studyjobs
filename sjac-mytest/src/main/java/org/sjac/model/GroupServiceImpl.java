package org.sjac.model;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service
public class GroupServiceImpl implements GroupService{
	@Resource
	private GroupDAO groupDAO;
	
	@Override
	public GroupVO findGroupByLeaderId(String id) {
		return groupDAO.findGroupByLeaderId(id);
	}

	@Override
	public boolean checkMyGroup(Map<String, String> map) {
		return groupDAO.checkMyGroup(map);
	}

	@Override
	public List<GroupVO> getAllMyGroup(String id) {
		return groupDAO.getAllMyGroup(id);
	}


	@Override
	public void createGroup(GroupVO vo) {
		groupDAO.createGroup(vo);
	}

	@Override
	public List<GroupVO> getAllGroupList() {	
		return groupDAO.getAllGroupList();
	}

	@Override
	public GroupVO createMyGroupInfo(String id) {
		return groupDAO.createMyGroupInfo(id);
	}

	@Override
	public List<GroupVO> findGroupListByCategory(Map<String, String> map) {
		return groupDAO.findGroupListByCategory(map);
	}

	@Override
	public List<GroupVO> findMyGroupListBySubject(Map<String, String> map) {
		return groupDAO.findMyGroupListBySubject(map);
	}

	@Override
	public List<GroupVO> findGroupList(GroupVO vo) {
		  String subject=vo.getSubjectVO().getSubject();
	      String subjectCategory=vo.getSubjectVO().getSubjectCategory();
	      String gLocation=vo.getgLocation();
	      String gName=vo.getgName();
	      List<GroupVO> list = null;
	      if(gName=="undefined"){
	         //location
	         if(subjectCategory.equals("undefined")&&subject.equals("undefined")){
	            list=groupDAO.findGroupListByLocation(vo);
	         }
	         //location+subject
	         if(!subject.equals("undefined")&&!subjectCategory.equals("undefined")&&!gLocation.equals("undefined")){
	            list=groupDAO.findGroupListByLocationAndSubject(vo);
	         }
	         //location+subjectCategory
	         if(subject.equals("undefined")&&!subjectCategory.equals("undefined")&&!gLocation.equals("undefined")){
	            list=groupDAO.findGroupListByLocationAndSubjectCategory(vo);
	         }
	         
	         //subjectCategory
	         if(subject.equals("undefined")&&gLocation.equals("undefined")){
	            
	            list=groupDAO.findGroupListBySubjectCategory(vo);
	         }
	         //subject
	         if(!subject.equals("undefined")&&!subjectCategory.equals("undefined")&&gLocation.equals("undefined")){
	            list=groupDAO.findGroupListBySubject(vo);
	         }
	      }else{
	         //location+gName
	         if(subjectCategory.equals("undefined")&&subject.equals("undefined")){
	            list=groupDAO.findGroupListByLocationAndGName(vo);
	         }
	         //location+subject+gName
	         if(!subject.equals("undefined")&&!subjectCategory.equals("undefined")&&!gLocation.equals("undefined")){
	            list=groupDAO.findGroupListByLocationAndSubjectAndGName(vo);
	         }
	         //location+subjectCategory+gName
	         if(subject.equals("undefined")&&!subjectCategory.equals("undefined")&&!gLocation.equals("undefined")){
	            list=groupDAO.findGroupListByLocationAndSubjectCategoryAndGName(vo);
	         }
	         
	         //subjectCategory+gName
	         if(subject.equals("undefined")&&gLocation.equals("undefined")){
	            
	            list=groupDAO.findGroupListBySubjectCategoryAndGName(vo);
	         }
	         //subject+gName
	         if(!subject.equals("undefined")&&!subjectCategory.equals("undefined")&&gLocation.equals("undefined")){
	            list=groupDAO.findGroupListBySubjectAndGName(vo);
	         }
	         if(subject.equals("undefined")&&subjectCategory.equals("undefined")&&gLocation.equals("undefined")){
	            list=groupDAO.findGroupListByGNameKeyword(vo);
	         }
	      }
	      
	      return list;
	}

	@Override
	public List<GroupVO> findMyJoinGroupListByCategory(Map<String, String> map) {
		return groupDAO.findMyJoinGroupListByCategory(map);
	}

	@Override
	public List<GroupVO> findMyJoinGroupListBySubject(Map<String, String> map) {
		return groupDAO.findMyJoinGroupListBySubject(map);
	}

	@Override
	public int MyGroupCount(String id) {
		return groupDAO.MyGroupCount(id);
	}
	
	@Override
	   public void deleteGroupByLeaderId(String gLeaderId) {
	      groupDAO.deleteGroupByLeaderId(gLeaderId);
	   }

	@Override
	public void updateGroup(GroupVO gvo) {
		groupDAO.updateGroup(gvo);
	}
	
	   @Override
	   public int allSearchCount() {
	      return groupDAO.allSearchCount();
	   }
	   
	   @Override
	public GroupVO findGroupById(String gLeaderId) {
		return groupDAO.findGroupByLeaderId(gLeaderId);
	}
	   
	 //그룹명과 그룹정보로 그룹 조회
	   @Override
	   public List<GroupVO> findGroupListByGNameAndGInfo(String keyText) {
	      return groupDAO.findGroupListByGNameAndGInfo(keyText);
	   }

}
