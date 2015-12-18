package org.sjac.model;

import java.util.List;
import java.util.Map;

public interface GroupJoinService {
	
	
	//가입 요청 정보 게시글 리스트 얻어오기
	public List<GroupJoinVO> getAllJoinRequestList(String gLeaderId);
	
	
	// 내가 가입 요청 중인 그룹 개수
	public int MyRequestGroupCount(String id);
	
	
	//자신의 아이디로 가입 요청한 그룹 리스트 받아오기
	public List<GroupVO> getAllJoinRequestGroup(String id);
	
	// 가입신청 테이블로 추가
	public void joinGroup(GroupJoinVO gjvo);
	
	// 가입 신청 취소
	public void deleteRequestGroup(Map<String, String> map);

	public void joinGroupUpdate(GroupJoinVO gjvo);

	public GroupJoinVO getMyJoinRequest(Map<String, String> map);
}
