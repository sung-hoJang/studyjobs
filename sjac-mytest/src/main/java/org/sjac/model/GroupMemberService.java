package org.sjac.model;

import java.util.List;

public interface GroupMemberService {
   
	/**
    * 그룹원 리스트 받아오기 
    * @param gLeaderId
    * @return
    */
   public List<GroupMemberVO> getMemberList(String gLeaderId);
   
   /**
    * 모든 그룹원 삭제
    * @param gLeaderId
    */
   public void deleteAllMember(String gLeaderId);

}