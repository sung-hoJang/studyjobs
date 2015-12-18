package org.sjac.model;

import java.util.List;

public interface GroupMemberDAO {
	public void addGroupMember(GroupMemberVO gmvo);

	public List<GroupMemberVO> getMemberList(String gLeaderId);
	
	public void deleteGroupMemberByGroupLeaderId(String id);

	public void deleteGroupMemberById(String id);

	public void getAwayGroupMember(String id, String gLeaderId);

	public void deleteAllMember(String gLeaderId);
}
