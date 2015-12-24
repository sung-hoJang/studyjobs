package org.sjac.model;

import java.util.List;


public interface TransactionService {
	
	/**
	 * 그룹 생성 (그룹 테이블에 추가)
	 * 그룹원 테이블에 추가
	 * 그룹 보드 생성 (자신의 ID로)
	 * 그룹 보드 시퀀스 생성 (자신의 ID로)
	 * @param gvo
	 * @param gmvo
	 * @throws Exception
	 */
	public abstract void TransactionAll(GroupVO gvo, GroupMemberVO gmvo) throws Exception;
	
	/**
	 * 내가 가입한 그룹의 리스트를 받아온 후 그 그룹의 모든 스케줄을 출력
	 * 일정이 지난 스케줄을 CU_SCHEDULE에서 삭제
	 * 일정이 지난 스케줄을 CU_LAST_SCHEDULE에 추가
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public abstract List<ScheduleVO> ScheduleTransaction(String id) throws Exception;
	
	/**
	 * 	<그룹 삭제>
	 * 찜하기 삭제(그룹장 아이디로 검색)
	 * 그룹게시판 시퀀스 삭제(그룹장 아이디로 검색) 
	 * 그룹보드 삭제(그룹장 아이디로 검색)
	 * 라스트 쉐쥴 테이블에서 라스트 그룹스케쥴 삭제(그룹장 아이디로 검색)
	 * 그룹 조인 테이블에서 삭제(그룹장 아이디로 검색)
	 * 그룹멤버 테이블에서 그룹멤버 삭제(그룹장 아이디로 검색)
	 * 그룹테이블에서 그룹삭제(그룹장 아이디로 검색)
	 * @param id
	 */
	public abstract void deleteGroupTransaction(String id);
	
	/**
	 * 	<회원삭제>
	 * 	찜하기 삭제(회원 아이디로 검색)
	 * 그룹멤버 테이블에서 그룹멤버 삭제(회원 아이디로 검색)
	 * 그룹 조인 테이블에서 삭제(회원 아이디로 검색)
	 * DELETE멤버 테이블로 회원정보 이동(회원 아이디로 검색)
	 * 멤버 테이블에서 회원정보 삭제(회원 아이디로 검색) 
	 * @param id
	 */
	public abstract void deleteMemberTransaction(String id);
	
	/**
	 * <가입요청>
	 * 원하는 그룹에 가입 요청
	 * 해당 그룹이 찜되어있으면 찜 리스트에서 삭제
	 * @param gjvo
	 */
	public abstract void joinGroupTransaction(GroupJoinVO gjvo);
	
	
	/**
	 * <그룹원 승인>
	 * 가입 요청글을 가입요청 테이블에서 삭제
	 * 가입 요청을 한 회원을 해당 그룹의 멤버로 추가
	 * 해당 그룹의 현재인원을 증가  
	 * @param gLeaderId : 그룹장 아이디
	 * @param acceptList : 가입 요청 리스트
	 */
	public abstract void joinTransaction(String gLeaderId, String[] acceptList);
	
	/**
	 * <그룹원 강퇴>
	 * 강퇴할 그룹원을 그룹맴버에서 삭제
	 * 해당 그룹의 현재인원을 감소
	 * @param id : 강퇴할 회원 아이디
	 * @param gLeaderId : 
	 */
	public abstract void getAwayGroupMemberTransaction(String id, String gLeaderId);
	
	/**
	 * <그룹 탈퇴>
	 * 회원이 그룹에서 탈퇴
	 * 해당 그룹의 현재인원 1 감소
	 * @param id : 탈퇴할 회원 아이디
	 * @param gLeaderId
	 */
	public abstract void leaveThisGroupTransaction(String id, String gLeaderId);
}
