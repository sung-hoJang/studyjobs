package org.sjac.model;

import java.util.List;
import java.util.Map;

public interface GroupDAO {
	//그룹장 아이디로 그룹정보 조회
	public GroupVO findGroupByLeaderId(String id);
		
	// 지역으로 그룹찾기
	public List<GroupVO> findGroupListByLocation(GroupVO vo);
	
	// 과목 카테고리로 그룹찾기
	public List<GroupVO> findGroupListBySubjectCategory(GroupVO vo);
	
	// 과목으로 그룹찾기
	public List<GroupVO> findGroupListBySubject(GroupVO vo);
	
	// 내가 속한 그룹들 중에서 과목으로 그룹찾기
	public List<GroupVO> findMyGroupListBySubject(Map<String, String> map);
	
	// 내가 속한 그룹들 중에서 카테고리로 그룹찾기
	public List<GroupVO> findGroupListByCategory(Map<String, String> map);
	
	//내가 속한 그룹인지 확인, 앞 쪽 스트링은 "memberId" 혹은 "groupLeaderId" 입력, 뒷 쪽 스트링은 해당 id 삽입
	public boolean checkMyGroup(Map<String, String> map);
	
	//내가 속한 모든 그룹 보기(마이페이지)
	public List<GroupVO> getAllMyGroup(String id);
	
	
	// 내가 만든 그룹 보기(내가 그룹장인 그룹)
	public GroupVO createMyGroupInfo(String id);
	
	
    // 지역과 대분류로 검색
	public List<GroupVO> findGroupListByLocationAndSubjectCategory(GroupVO vo);     
	
	// 지역과 소분류로 검색
    public List<GroupVO> findGroupListByLocationAndSubject(GroupVO vo);                
    
    // 마이페이지 내가 가입한 그룹 개수 받아오기
 	public int MyGroupCount(String id);
	
    
    /**-----------gName 함께 검색하는 메소드들----------------------------------------- */
    //지역과 그룹네임으로 검색
    public List<GroupVO> findGroupListByLocationAndGName(GroupVO vo);    
    
    //지역, 소분류, 그룹네임으로 검색
    public List<GroupVO> findGroupListByLocationAndSubjectAndGName(GroupVO vo); 
    
    //지역, 대분류, 그룹네임으로 검색
    public List<GroupVO> findGroupListByLocationAndSubjectCategoryAndGName(GroupVO vo);   
    
    // 대분류, 그룹네임으로 검색
    public List<GroupVO> findGroupListBySubjectCategoryAndGName(GroupVO vo);   
    
    // 소분류, 그룹네임으로 검색
    public List<GroupVO> findGroupListBySubjectAndGName(GroupVO vo);         
    
    // 그룹네임으로 검색
    public List<GroupVO> findGroupListByGNameKeyword(GroupVO vo);                                 
    
    
    /** 관리자만 가능 */
	//그룹장 아이디를 통해 그룹삭제
	public void deleteGroupByLeaderId(String id);	
	
	//그룹 생성
	public void createGroup(GroupVO vo);
	
	//그룹 정보 리스트 조회
	public List<GroupVO> getAllGroupList();

	public List<GroupVO> findMyJoinGroupListByCategory(Map<String, String> map);

	public List<GroupVO> findMyJoinGroupListBySubject(Map<String, String> map);

	public void updateCurMember(String gLeaderId);

	public int getCurMember(String gLeaderId);

	public void downCurMember(String gLeaderId);

	public void updateGroup(GroupVO gvo);
	
	public int allSearchCount();

    public void updateSearchCount();
    
    public List<GroupVO> findGroupListByGNameAndGInfo(String keyText);
	
}
