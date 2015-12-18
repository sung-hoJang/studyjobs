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
	public abstract void joinGroupTransaction(GroupJoinVO gjvo);
	public abstract void joinTransaction(String gLeaderId, String[] acceptList);
	public abstract void getAwayGroupMemberTransaction(String id, String gLeaderId);
	public abstract void leaveThisGroupTransaction(String id, String gLeaderId);
}
