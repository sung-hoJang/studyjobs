package org.sjac.model;

import java.util.List;

public interface GroupMemberService {

   public List<GroupMemberVO> getMemberList(String gLeaderId);

   public void deleteAllMember(String gLeaderId);

}