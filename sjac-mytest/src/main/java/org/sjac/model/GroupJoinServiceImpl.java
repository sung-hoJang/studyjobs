package org.sjac.model;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
@Service
public class GroupJoinServiceImpl implements GroupJoinService{
	
	@Resource
	private GroupJoinDAO groupJoinDAO;
	
	@Override
	public List<GroupJoinVO> getAllJoinRequestList(String gLeaderId) {
		return groupJoinDAO.getAllJoinRequestList(gLeaderId);
	}

	
	
	
	@Override
	public List<GroupVO> getAllJoinRequestGroup(String id) {
		return groupJoinDAO.getAllJoinRequestGroup(id);
	}

	@Override
	public void joinGroup(GroupJoinVO gjvo) {
		groupJoinDAO.joinGroup(gjvo);
	}

	@Override
	public void deleteRequestGroup(Map<String, String> map) {
		groupJoinDAO.deleteRequestGroup(map);
	}

	@Override
	public void joinGroupUpdate(GroupJoinVO gjvo) {
		groupJoinDAO.joinGroupUpdate(gjvo);		
	}

	@Override
	public GroupJoinVO getMyJoinRequest(Map<String, String> map) {
		return groupJoinDAO.getMyJoinRequest(map);
	}

	@Override
	public int MyRequestGroupCount(String id) {
		return groupJoinDAO.MyRequestGroupCount(id);
	}

}
