package org.sjac.model;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service
public class GroupMemberServiceImpl implements GroupMemberService {
   @Resource(name="groupMemberDAOImpl")
   private GroupMemberDAO groupMemberDAO;

   @Override
   public List<GroupMemberVO> getMemberList(String gLeaderId) {
      return groupMemberDAO.getMemberList(gLeaderId);
   }
   
   @Override
   public void deleteAllMember(String gLeaderId) {
      groupMemberDAO.deleteAllMember(gLeaderId);
   }
   
}