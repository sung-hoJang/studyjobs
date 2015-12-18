package org.sjac.model;

import java.util.List;
import java.util.Map;

public interface MemberDAO {
	/**
	 *  아이디를 통해 멤버 검색
	 * @param id
	 * @return
	 */
	public MemberVO findMemberById(String id);
	/**
	 * 아이디 패스워드 통해 로그인
	 * @param vo : 아이디, 패스워드
	 * @return
	 */
	public MemberVO login(MemberVO vo);
	/**
	 * 회원가입
	 * @param vo 
	 */
	public void register(MemberVO vo);
	/**
	 * 회원 개인 정보를 수정
	 * @param vo
	 */
	public void updateMyInfo(MemberVO vo);
	/**
	 * 모든 지역 리스트 가져오기
	 * @return
	 */
	public List<StudyLocationVO> getAllStudyLocation(); 
	/**
	 * 모든 회원의 수 가져오기
	 * @return
	 */
	public int allMemberCount(); 
	/**
	 * 모든 그룹의 수 가져오기
	 * @return
	 */
	public int allGroupCount(); 
	
	
	// 여기서부터 관리자만 가능. 시작!!
	
	/**
	 * 모든 멤버 리스트 가져오기
	 * @return
	 */
	public List<MemberVO> getAllMemberList();
	/**
	 * 기존 아이디가 존재하는지 체크
	 * @param id
	 * @return
	 */
	public int idcheck(String id); 
	/**
	 * 회원가입시 delete member table 에 아이디가 존재하는지 확인
	 * @param id
	 * @return
	 */
	public int idcheckFromDeleteMember(String id); 
	/**
	 * 회원 탈퇴나 회원삭제시 회원정보를 delete member table로 이동
	 * @param mvo
	 */
	public void moveToDeleteMemberTable(MemberVO mvo);
	/**
	 *  회원을 아이디로 삭제
	 * @param id
	 */
	public void deleteMemberById(String id);
	/**
	 *  회원이 아이디 찾기 (이름, 전화번호 이용)
	 * @param vo :이름, 전화번호
	 * @return
	 */
	public MemberVO findIdForUser(MemberVO vo);
	/**
	 * 회원이 비밀번호 찾기 (아이디, 전화번호 이용)
	 * @param vo : 아이디, 전화번호
	 * @return
	 */
	public MemberVO findPasswordForUser(MemberVO vo);
	/**
	 * 메인 페이지에 접속하는 횟수 
	 * @return
	 */
	public int totalVisitor();
	/**
	 * 메인 페이지에 접속하는 횟수 업데이트
	 */
	public void updateTotalVisitor();
	/**
	 * 회원 탈퇴시 이유를 DB에 저장 
	 * @param map
	 */
	public void insertReason(Map<String, Object> map);
}



