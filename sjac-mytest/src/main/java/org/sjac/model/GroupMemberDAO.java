package org.sjac.model;

import java.util.List;

public interface GroupMemberDAO {
	
	/**
	 * 그룹원 추가
	 * @param gmvo
	 */
	public void addGroupMember(GroupMemberVO gmvo);
	
	/**
	 * 그룹원 리스트 받아오기
	 * @param gLeaderId
	 * @return
	 */
	public List<GroupMemberVO> getMemberList(String gLeaderId);
	
	/**
	 * 그룹장 ID로 그룹원 삭제
	 * @param id
	 */
	public void deleteGroupMemberByGroupLeaderId(String id);
	
	/**
	 * 자신의 ID로 그룹원 삭제
	 * @param id
	 */
	public void deleteGroupMemberById(String id);

	/**
	 * 그룹원 강퇴
	 * @param id
	 * @param gLeaderId
	 */
	public void getAwayGroupMember(String id, String gLeaderId);
	
	/**
	 * 모든 그룹원 삭제
	 * @param gLeaderId
	 */
	public void deleteAllMember(String gLeaderId);
}
