package org.sjac.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionServiceImpl implements TransactionService {
	@Resource
	private GroupDAO groupDAO;
	@Resource
	private GroupMemberDAO groupMemberDAO;
	@Resource
	private GroupBoardDAO groupBoardDAO;
	@Resource
	private ScheduleDAO scheduleDAO;
	@Resource
	private GroupJoinDAO groupJoinDAO;
	@Resource
	private CartDAO cartDAO;
	@Resource
	private MemberDAO memberDAO;
	
	@Transactional
	@Override
	public void TransactionAll(GroupVO gvo, GroupMemberVO gmvo) throws Exception {
		groupDAO.createGroup(gvo);
		groupMemberDAO.addGroupMember(gmvo);
		groupBoardDAO.createGroupBoard(gmvo.getMemberVO().getId());
		groupBoardDAO.createSequence(gmvo.getMemberVO().getId());
	}
	
	@Transactional
	@Override
	public List<ScheduleVO> ScheduleTransaction(String id) throws Exception {
		List<ScheduleVO> scheduleList = scheduleDAO.findMyScheduleById(id);
		for( ScheduleVO vo : scheduleList){
			vo.setId(id);
			if( vo.getDeadline() < 0 ){
				scheduleDAO.addLastSchedule(vo);
				scheduleDAO.deleteLastSchedule(vo);
			}
		}
		scheduleList = scheduleDAO.findMyScheduleById(id);
		return scheduleList;
	}

	
	@Transactional
	@Override
	public void joinGroupTransaction(GroupJoinVO gjvo){
		Map<String, String> map = new HashMap<String, String> ();
		map.put("id", gjvo.getMemberVO().getId());
		map.put("gLeaderId", gjvo.getGroupVO().getMemberVO().getId());
		groupJoinDAO.joinGroup(gjvo);
		cartDAO.deleteMyCart(map);
	}

	
	@Override
	public void joinTransaction(String gLeaderId, String[] acceptList) {
		Map<String, String> map = new HashMap<String, String>();
	      map.put("gLeaderId", gLeaderId);
	      
	      
	      // 가입요청글을 테이블에서 삭제
	      for(String value : acceptList){
	         map.put("id", value);
	         groupJoinDAO.deleteRequestGroup(map);
	      }
	      
	      
	      // 그룹 맴버에 추가
	      GroupMemberVO vo = new GroupMemberVO();
	      GroupVO temp = new GroupVO();
	      temp.setMemberVO(new MemberVO(gLeaderId));
	      vo.setGroupVO(temp);
	      for(String value : acceptList){
	         vo.setMemberVO(new MemberVO(value));
	         groupMemberDAO.addGroupMember(vo);
	      }
	      
	      //해당 그룹의 현재 인원 증가
	      for(int i = 0; i < acceptList.length; i++)
	         groupDAO.updateCurMember(gLeaderId);
	    
		
	}
	
	
	@Transactional
    @Override
    public void deleteGroupTransaction(String id) {
      //찜하기 삭제(그룹장 아이디로 검색)
      cartDAO.deleteMyCartByGroupLeaderId(id);
      
       //그룹게시판 시퀀스 삭제(그룹장 아이디로 검색) 
       groupBoardDAO.dropGroupBoardSequence(id);
       
       //그룹보드 삭제(그룹장 아이디로 검색)
       groupBoardDAO.dropGroupBoard(id);
       
       
       
       //라스트 쉐쥴 테이블에서 라스트 그룹스케쥴 삭제(그룹장 아이디로 검색)
       scheduleDAO.deleteLastGroupScheduleByGroupLeaderId(id);
       
       scheduleDAO.deleteGroupScheduleByGroupLeaderId(id);
          
       //그룹 조인 테이블에서 삭제(그룹장 아이디로 검색)
       List<GroupVO> list=groupJoinDAO.getGroupJoinListByGroupLeaderId(id);
       if(list.size()!=0){groupJoinDAO.deleteGroupJoinByGroupLeaderId(id);}
       
       
       
       //그룹멤버 테이블에서 그룹멤버 삭제(그룹장 아이디로 검색)
       groupMemberDAO.deleteGroupMemberByGroupLeaderId(id);
       
       //그룹테이블에서 그룹삭제(그룹장 아이디로 검색)
       groupDAO.deleteGroupByLeaderId(id);
       

    }//deleteGroupTransaction
   
    @Transactional
    @Override
    public void deleteMemberTransaction(String id) {
       
       //찜하기 삭제(회원 아이디로 검색)
       cartDAO.deleteMyCartById(id);

     //그룹멤버 테이블에서 그룹멤버 삭제(회원 아이디로 검색)
      groupMemberDAO.deleteGroupMemberById(id);
       
         //그룹 조인 테이블에서 삭제(회원 아이디로 검색)
       groupJoinDAO.deleteGroupJoinById(id);

      
       
      //DELETE멤버 테이블로 회원정보 이동(회원 아이디로 검색)
       MemberVO mvo=memberDAO.findMemberById(id);
       memberDAO.moveToDeleteMemberTable(mvo);
       
       //멤버 테이블에서 회원정보 삭제(회원 아이디로 검색) 
       memberDAO.deleteMemberById(id);
    }

 // 그룹원 강퇴
    @Override
    public void getAwayGroupMemberTransaction(String id, String gLeaderId) {
       groupMemberDAO.getAwayGroupMember(id, gLeaderId);
       groupDAO.downCurMember(gLeaderId);
    }
    
    // 그룹 탈퇴 
    @Override
    public void leaveThisGroupTransaction(String id, String gLeaderId) {
       groupMemberDAO.getAwayGroupMember(id, gLeaderId);
       groupDAO.downCurMember(gLeaderId);
       
    }
	

}
