package org.sjac.model;

import java.util.List;
import java.util.Map;

public interface MemberService {
	public MemberVO findMemberById(String id);// 아이디를 통해 멤버 검색
	public MemberVO login(MemberVO vo);// 아이디 패스워드 통해 로그인
	public void register(MemberVO vo);// 회원가입
	public void updateMyInfo(MemberVO vo);// 회원 개인 정보를 수정
	public List<StudyLocationVO> getAllStudyLocation();  // 모든 지역 정보 가져오기
	public int allMemberCount(); // 모든 회원의 수 가져오기
	public int allGroupCount();  // 모든 그룹의 수 가져오기
	
	// 여기서부터 관리자만 가능. 시작!!
	public List<MemberVO> getAllMemberList();//모든 멤버 리스트 가져오기.
	public int idcheck(String id);
	public MemberVO findIdForUser(MemberVO vo);
	public MemberVO findPasswordForUser(MemberVO vo);
	
    public int totalVisitor();
	public void updateTotalVisitor();
	public void insertReason(Map<String, Object> map);
	
}
