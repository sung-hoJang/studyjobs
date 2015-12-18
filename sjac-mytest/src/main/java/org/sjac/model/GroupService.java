package org.sjac.model;

import java.util.List;
import java.util.Map;

public interface GroupService {
	
	/**
	 * 그룹장 아이디로 그룹 정보 조회
	 * @param id
	 * @return
	 */
	public GroupVO findGroupByLeaderId(String id);
	
	
	
	/**
	 * 내가 속한 그룹인지 확인, 앞 쪽 스트링은 "memberId" 혹은 "groupLeaderId" 입력, 뒷 쪽 스트링은 해당 id 삽입
	 * @param map
	 * @return
	 */
	public boolean checkMyGroup(Map<String, String> map);
	
	
	/**
	 * 내가 속한 모든 그룹 보기(마이페이지)
	 * @param id
	 * @return
	 */
	public List<GroupVO> getAllMyGroup(String id);
	
	
	
	/**
	 *  내가 가입한 그룹 중에서 카테고리로 그룹 찾기
	 * @param map
	 * @return
	 */
	public List<GroupVO> findGroupListByCategory(Map<String, String> map);
	
	
	/**
	 *  내가 가입한 그룹 중에서 과목명으로 그룹 찾기
	 * @param map
	 * @return
	 */
	public List<GroupVO> findMyGroupListBySubject(Map<String, String> map);
	
	
	/**
	 * 그룹 리스트 찾기
	 * @param vo
	 * @return
	 */
	public List<GroupVO> findGroupList(GroupVO vo);
	
	/**
	 * 마이페이지 내가 가입한 그룹 개수 받아오기
	 * @param id
	 * @return
	 */
	public int MyGroupCount(String id);
	
	/**
	 * 검색어 카운트
	 * @return
	 */
	public int allSearchCount();
	
	
	
	
	/**
	 * 내가 만든 그룹 보기(내가 그룹장인 그룹)
	 * @param id
	 * @return
	 */
	public GroupVO createMyGroupInfo(String id);
	
	
	/**
	 * 그룹 생성
	 * @param vo
	 */
	public void createGroup(GroupVO vo);
	
	
	
	/**관리자만 가능 */
	
	
	/**
	 * 그룹장 아이디를 통해 그룹삭제하기
	 * @param id
	 */
	public void deleteGroupByLeaderId(String id);
	
	
	/**
	 * 그룹 리스트 모두 받아오기
	 * @return
	 */
	public List<GroupVO> getAllGroupList();

	/**
	 * 가입요청 중인 가입 리스트를 카테고리로 찾기
	 * @param map
	 * @return
	 */
	public List<GroupVO> findMyJoinGroupListByCategory(Map<String, String> map);
	
	/**
	 * 가입요청 중인 가입 리스트를 서브젝트로 찾기
	 * @param map
	 * @return
	 */
	public List<GroupVO> findMyJoinGroupListBySubject(Map<String, String> map);
	
	/**
	 * 그룹정보 수정
	 * @param gvo
	 */
	public void updateGroup(GroupVO gvo);

	/**
	 * 아이디로 그룹 찾기
	 * @param gLeaderId
	 * @return
	 */
	public GroupVO findGroupById(String gLeaderId);
	
	   /**
	    * 그룹장아이디(gname)와 그룹정보(ginfo)로 그룹 찾기(포함검색)
	    * @param keyText
	    * @return
	    */
	   public List<GroupVO> findGroupListByGNameAndGInfo(String keyText);
}
