package org.sjac.model;

import java.util.List;
import java.util.Map;

public interface GroupService {
	//그룹장 아이디로 그룹정보 조회
	public GroupVO findGroupByLeaderId(String id);
	
	
	//내가 속한 그룹인지 확인, 앞 쪽 스트링은 "memberId" 혹은 "groupLeaderId" 입력, 뒷 쪽 스트링은 해당 id 삽입
	public boolean checkMyGroup(Map<String, String> map);
	
	//내가 속한 모든 그룹 보기(마이페이지)
	public List<GroupVO> getAllMyGroup(String id);
	
	
	// 내가 가입한 그룹 중에서 카테고리로 그룹 찾기
	public List<GroupVO> findGroupListByCategory(Map<String, String> map);
	
	// 내가 가입한 그룹 중에서 과목명으로 그룹 찾기
	public List<GroupVO> findMyGroupListBySubject(Map<String, String> map);
	
	// 그룹 리스트 찾기
	public List<GroupVO> findGroupList(GroupVO vo);
	
	// 마이페이지 내가 가입한 그룹 개수 받아오기
	public int MyGroupCount(String id);
	
	public int allSearchCount();
	
	
	/** 내가 만든 그룹 보기 (내가 그룹장인 그룹) --> 혜진 */
	
	// 내가 만든 그룹 보기(내가 그룹장인 그룹)
	public GroupVO createMyGroupInfo(String id);
	
	//그룹 생성
	public void createGroup(GroupVO vo);
	
	
	
	/**관리자만 가능 */
	
	//그룹장 아이디를 통해 그룹삭제
	public void deleteGroupByLeaderId(String id);
	
	//그룹 정보 리스트 조회
	public List<GroupVO> getAllGroupList();

	public List<GroupVO> findMyJoinGroupListByCategory(Map<String, String> map);

	public List<GroupVO> findMyJoinGroupListBySubject(Map<String, String> map);

	public void updateGroup(GroupVO gvo);


	public GroupVO findGroupById(String gLeaderId);
	
	   //능
	   public List<GroupVO> findGroupListByGNameAndGInfo(String keyText);
}
