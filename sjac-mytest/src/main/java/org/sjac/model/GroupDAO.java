package org.sjac.model;

import java.util.List;
import java.util.Map;

public interface GroupDAO {
	/**
	 * 그룹장 아이디로 그룹정보 조회
	 * @param id
	 * @return
	 */
	public GroupVO findGroupByLeaderId(String id);
		
	/**
	 * location으로 그룹찾기
	 * @param vo
	 * @return
	 */
	public List<GroupVO> findGroupListByLocation(GroupVO vo);
	
	/**
	 * SubjectCategory로 그룹찾기
	 * @param vo
	 * @return
	 */
	public List<GroupVO> findGroupListBySubjectCategory(GroupVO vo);
	
	/**
	 * Subject로 그룹찾기
	 * @param vo
	 * @return
	 */
	public List<GroupVO> findGroupListBySubject(GroupVO vo);
	
	/**
	 * 내가 속한 그룹들 중에서 subject으로 그룹찾기
	 * @param map
	 * @return
	 */
	public List<GroupVO> findMyGroupListBySubject(Map<String, String> map);
	
	/**
	 * SubjectCategory로 그룹찾기
	 * @param map
	 * @return
	 */
	public List<GroupVO> findGroupListByCategory(Map<String, String> map);
	
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
	 * 내가 만든 그룹 보기(내가 그룹장인 그룹)
	 * @param id
	 * @return
	 */
	public GroupVO createMyGroupInfo(String id);
	
	
	/**
	 * location과 subjectCategory로 검색
	 * @param vo
	 * @return
	 */
	public List<GroupVO> findGroupListByLocationAndSubjectCategory(GroupVO vo);     
	
	/**
	 * location과 subject로 검색
	 * @param vo
	 * @return
	 */
    public List<GroupVO> findGroupListByLocationAndSubject(GroupVO vo);                
    
    /**
     * 마이페이지 내가 가입한 그룹 개수 받아오기
     * @param id
     * @return
     */
 	public int MyGroupCount(String id);
	
    
    /**-----------gName 함께 검색하는 메소드들----------------------------------------- */
 	
 	
 	/**
 	 * location 과 그룹네임으로 그룹 검색
 	 * @param vo
 	 * @return
 	 */
    public List<GroupVO> findGroupListByLocationAndGName(GroupVO vo);    
    
    /**
     * location + subject +gname 으로 그룹 찾기
     * @param vo
     * @return
     */
    public List<GroupVO> findGroupListByLocationAndSubjectAndGName(GroupVO vo); 
    
    /**
     *  location + subjectCategory +gname 으로 그룹 찾기
     * @param vo
     * @return
     */
    public List<GroupVO> findGroupListByLocationAndSubjectCategoryAndGName(GroupVO vo);   
    
    /**
     * subjectCategory +gname 으로 그룹 찾기
     * @param vo
     * @return
     */
    public List<GroupVO> findGroupListBySubjectCategoryAndGName(GroupVO vo);   
    
    /**
     * subject + gname 으로 그룹 찾기
     * @param vo
     * @return
     */
    public List<GroupVO> findGroupListBySubjectAndGName(GroupVO vo);         
    
    /**
     * gname 으로 그룹 찾기
     * @param vo
     * @return
     */
    public List<GroupVO> findGroupListByGNameKeyword(GroupVO vo);                                 
    
    
    /** 관리자만 가능 */
    /**
     * 그룹장아이디로 그룹삭제
     * @param id
     */
	public void deleteGroupByLeaderId(String id);	
	
	/**
	 * 그룹 생성
	 * @param vo
	 */
	public void createGroup(GroupVO vo);
	
	/**
	 * 모든 그룹 리스트 받아오기
	 * @return
	 */
	public List<GroupVO> getAllGroupList();
	/**
	 * 가입요청 중인 그룹리스트 category로 받아오기
	 * @param map
	 * @return
	 */
	public List<GroupVO> findMyJoinGroupListByCategory(Map<String, String> map);
	/**
	 * 가입요청 중인 그룹리스트 subject로 받아오기
	 * @param map
	 * @return
	 */
	public List<GroupVO> findMyJoinGroupListBySubject(Map<String, String> map);
	/**
	 * 그룹의 현재 인원 증가
	 * : 그룹 원이 늘었을 때 인원 수 +1 씩 증가
	 * @param gLeaderId
	 */
	public void updateCurMember(String gLeaderId);
	
	/**
	 * 그룹의 현재 인원 받기
	 * @param gLeaderId
	 * @return
	 */
	public int getCurMember(String gLeaderId);

	/**
	 * 그룹의 현재 인원 감소
	 * : 그룹원 삭제 또는 탈퇴 시 -1 씩 감소
	 * @param gLeaderId
	 */
	public void downCurMember(String gLeaderId);

	/**
	 * 그룹정보 수정
	 * @param gvo
	 */
	public void updateGroup(GroupVO gvo);
	
	/**
	 * 검색어 카운트
	 * @return
	 */
	public int allSearchCount();
	
	/**
	 * 검색어 증가시 +1 씩 count 증가 
	 */
    public void updateSearchCount();
    
    /**
     * 그룹장아이디(gname)와 그룹정보(ginfo)로 그룹 찾기(포함검색)
     * @param keyText
     * @return
     */
    public List<GroupVO> findGroupListByGNameAndGInfo(String keyText);
	
}
