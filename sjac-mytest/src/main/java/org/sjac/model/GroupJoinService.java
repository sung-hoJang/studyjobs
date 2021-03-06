package org.sjac.model;

import java.util.List;
import java.util.Map;

public interface GroupJoinService {
	
	/**
	 * 가입 요청 정보 게시글 리스트 얻어오기
	 * @param gLeaderId
	 * @return
	 */
	public List<GroupJoinVO> getAllJoinRequestList(String gLeaderId);
	
	/**
	 * 내가 가입 요청 중인 그룹 개수
	 * @param id
	 * @return
	 */
	public int MyRequestGroupCount(String id);
	
	/**
	 * 자신의 아이디로 가입 요청한 그룹 리스트 받아오기
	 * @param id
	 * @return
	 */
	public List<GroupVO> getAllJoinRequestGroup(String id);
	
	/**
	 * 가입 신청 테이블로 추가
	 * @param gjvo
	 */
	public void joinGroup(GroupJoinVO gjvo);
	
	/**
	 * 가입 신청 취소
	 * @param map
	 */
	public void deleteRequestGroup(Map<String, String> map);
	
	/**
	 * 가입 신청 수정
	 * @param gjvo
	 */
	public void joinGroupUpdate(GroupJoinVO gjvo);
	
	/**
	 * 자신이 요청한 그룹 정보 받아오기
	 * @param map
	 * @return
	 */
	public GroupJoinVO getMyJoinRequest(Map<String, String> map);
}
