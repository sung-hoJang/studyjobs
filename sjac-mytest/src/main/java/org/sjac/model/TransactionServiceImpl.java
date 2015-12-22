package org.sjac.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
//		List<ScheduleVO> scheduleList = scheduleDAO.findMyScheduleById(id);
		List<GroupVO> groupList = groupDAO.getAllMyGroup(id);
		List<ScheduleVO> list= new ArrayList<ScheduleVO>();
		List<ScheduleVO> tempList = new ArrayList<ScheduleVO>();
		
		for( GroupVO vo : groupList ){
			tempList = scheduleDAO.findMyScheduleByGroupLeaderId(vo.getMemberVO().getId());
			for( ScheduleVO svo : tempList ){
				list.add(svo);
			}
		}
		
		// list에는 회원이 가입한 그룹의 모든 쉐쥴이 들어감
		
		
		for( ScheduleVO vo : list){
			vo.setId(vo.getgLeaderId());
			if( vo.getDeadline() < 0 ){
				scheduleDAO.addLastSchedule(vo);
				scheduleDAO.deleteLastSchedule(vo);
			}
		}
//		scheduleList = scheduleDAO.findMyScheduleById(id);
		List<ScheduleVO> scheduleList = new ArrayList<ScheduleVO>();
		
		for( GroupVO vo : groupList ){
			tempList = scheduleDAO.findMyScheduleByGroupLeaderId(vo.getMemberVO().getId());
			for( ScheduleVO svo : tempList ){
				scheduleList.add(svo);
			}
		}
		
		Collections.sort(scheduleList, new Comparator<ScheduleVO>() {
			public int compare(ScheduleVO s1, ScheduleVO s2) {
				return s1.getScheduleDate().compareTo(s2.getScheduleDate());
			}
		});	
		return scheduleList;
	}

	
	@Transactional
	@Override
	public void joinGroupTransaction(GroupJoinVO gjvo){
		Map<String, String> map = new HashMap<String, String> ();
		map.put("id", gjvo.getMemberVO().getId());
		map.put("gLeaderId", gjvo.getGroupVO().getMemberVO().getId());
		groupJoinDAO.joinGroup(gjvo);		//원하는 그룹에 가입 요청
		
		//가입요청을 하면 찜하기가 삭제되어야 하기 때문에 
		//cart 테이블에서 삭제처리
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
       System.out.println("찜하기 삭제");
       System.out.println("id : " + id);
     //그룹멤버 테이블에서 그룹멤버 삭제(회원 아이디로 검색)
      groupMemberDAO.deleteGroupMemberById(id);
       System.out.println("그룹멤버삭제");
         //그룹 조인 테이블에서 삭제(회원 아이디로 검색)
       groupJoinDAO.deleteGroupJoinById(id);
       System.out.println("그룹조인 삭제");
      
       
      //DELETE멤버 테이블로 회원정보 이동(회원 아이디로 검색)
       MemberVO mvo=memberDAO.findMemberById(id);
       memberDAO.moveToDeleteMemberTable(mvo);
       System.out.println("삭제멤버테이블로 이동");
       //멤버 테이블에서 회원정보 삭제(회원 아이디로 검색) 
       memberDAO.deleteMemberById(id);
       System.out.println("멤버테이블 삭제");
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
