package org.sjac.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.sjac.model.CartService;
import org.sjac.model.GroupBoardService;
import org.sjac.model.GroupBoardVO;
import org.sjac.model.GroupJoinService;
import org.sjac.model.GroupJoinVO;
import org.sjac.model.GroupMemberService;
import org.sjac.model.GroupMemberVO;
import org.sjac.model.GroupService;
import org.sjac.model.GroupVO;
import org.sjac.model.MemberService;
import org.sjac.model.MemberVO;
import org.sjac.model.ScheduleService;
import org.sjac.model.ScheduleVO;
import org.sjac.model.StudyLocationVO;
import org.sjac.model.SubjectService;
import org.sjac.model.SubjectVO;
import org.sjac.model.TransactionService;
import org.sjac.model.cart.CartReportService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GroupController {
   @Resource(name="groupBoardServiceImpl")
   private GroupBoardService groupBoardService;
   
   @Resource(name="groupMemberServiceImpl")
   private GroupMemberService groupMemberService;
   
   @Resource(name="scheduleServiceImpl")
   private ScheduleService scheduleService;
   
   @Resource(name="groupServiceImpl")
   private GroupService groupService;
   
   @Resource(name="memberServiceImpl")
   private MemberService memberService;
   
   @Resource(name="cartServiceImpl")
   private CartService cartService;
   
   @Resource(name="groupJoinServiceImpl")
   private GroupJoinService groupJoinService;
   
   @Resource(name="transactionServiceImpl")
   private TransactionService transactionService;
   
   @Resource(name="cartReportServiceImpl")
   private CartReportService cartReportService;
   
   @Resource(name="subjectServiceImpl")
   private SubjectService subjectService;
   
   // 그룹페이지 메인 화면
   @RequestMapping("group_member_home.do")
   public ModelAndView groupHome(String gLeaderId, HttpSession session) {
      ModelAndView mav = new ModelAndView();
      Map<String, Object> map = new HashMap<String, Object>();
      map = getGroupHomeInfo(gLeaderId, session);
      List<GroupBoardVO> list = groupBoardService.getGroupBoardTest(gLeaderId); // 그룹페이지 메인화면에 그룹보드리스트를 받아옴
      map.put("list", list);
      mav.setViewName("group");
      mav.addObject("map", map);
      return mav;
   }
   
   
   @RequestMapping("group_schedule.do")
   public ModelAndView GroupSchedule(String gLeaderId, HttpSession session){
	   ModelAndView mav = new ModelAndView();
	   mav.setViewName("group_schedule");
	   mav.addObject("map", getGroupHomeInfo(gLeaderId, session));
	   return mav;
   }
   
   @RequestMapping("submit_schedule.do")
   public ModelAndView SubmitSchedule(HttpServletRequest request,ScheduleVO schvo, String gLeaderId, HttpSession session){
	   ModelAndView mav = new ModelAndView();
	   System.out.println("이거왜안나오니");
	   	System.out.println(schvo);
	      MemberVO mvo = (MemberVO)session.getAttribute("mvo");
	      schvo.setId(mvo.getId());
	      schvo.setgLeaderId(gLeaderId);
	      schvo.setScheduleDate(schvo.getScheduleDate() + " " +  request.getParameter("scheduleTime"));
	      scheduleService.submitSchedule(schvo);
	      mav.setViewName("redirect:goGroupSchedule.do?gLeaderId="+gLeaderId);
	      return mav;
   }
   
   @RequestMapping("goGroupSchedule.do")
   public ModelAndView goGroupSchedule(String gLeaderId, HttpSession session){
      ModelAndView mav = new ModelAndView();
      mav.addObject("map", getGroupHomeInfo(gLeaderId, session));
      mav.setViewName("group_schedule");
      return mav;
   }
   
   @RequestMapping("waitlist.do")
   public ModelAndView Waitlist(HttpServletRequest request, String parentURL) {
	  ModelAndView mav = new ModelAndView();
      String gleaderId = request.getParameter("gleaderId");
      String id="";
      HttpSession session=request.getSession(false);
         if(session!=null){
            MemberVO mvo=(MemberVO) session.getAttribute("mvo");
            id = mvo.getId();
         }
     cartService.waitlist(gleaderId, id);
     cartReportService.saveCartReport(gleaderId);
     String urlParse[] = parentURL.split("/");
     for( String value : urlParse ){
   	  if( value.contains(".") ){
   		  parentURL = value;
   		  break;
   	   }
     }
     if(parentURL.equals("home.do")){
    	 mav.setViewName("redirect:home.do");
     }else{
   	  	mav.setViewName("member_find_group");
   	  	mav.addObject("gvo", (List<GroupVO>) groupService.getAllGroupList());
     }
     return mav;
     }
   
   @RequestMapping("checkCart.do")
   public void CheckCart(HttpServletRequest request, HttpServletResponse response) throws IOException {
      response.setContentType("text/html;charset=utf-8");
      PrintWriter out = response.getWriter();
      String gleaderId = request.getParameter("gleaderId");
      String id = request.getParameter("id");
     boolean flag = cartService.checkCart(gleaderId, id);
     out.print(flag);
     out.close();
    }
   
   /*
    * 그룹가입신청 리스트 보기 그룹장만
    */
   @RequestMapping("getRequestList.do")
   public ModelAndView getRequestList(String gLeaderId, HttpSession session){
      ModelAndView mav = new ModelAndView();
      List<GroupJoinVO> list = groupJoinService.getAllJoinRequestList(gLeaderId);
      Map<String, Object> map = getGroupHomeInfo(gLeaderId, session);
      map.put("joinList", list);
      mav.setViewName("group_leader_join_list");
      mav.addObject("map", map);
      return mav;
   }
   
   

 //그룹장의 그룹원 강퇴
   @RequestMapping("getAwayGroupMember.do")
   public ModelAndView getAwayGroupMember(String id, String gLeaderId, HttpSession session){
      ModelAndView mav = new ModelAndView();
      transactionService.getAwayGroupMemberTransaction(id, gLeaderId);
      mav.setViewName("redirect:group_show_info.do?gLeaderId="+gLeaderId);
      return mav;
   }
   
   // 그룹원의 그룹탈퇴
   @RequestMapping("leaveThisGroup.do")
   public ModelAndView leaveThisGroup(String gLeaderId, HttpSession session){
      ModelAndView mav = new ModelAndView();
      MemberVO vo = (MemberVO) session.getAttribute("mvo");
      transactionService.leaveThisGroupTransaction(vo.getId(), gLeaderId);
         GroupVO groupInfo = groupService.findGroupByLeaderId(gLeaderId);
         Map<String, String> map = new HashMap<String, String>();
      map.put("id", vo.getId());
      map.put("gLeaderId", gLeaderId);
      GroupJoinVO groupJoinVO = groupJoinService.getMyJoinRequest(map);
      Map<String, Object> map2 = new HashMap<String, Object>();
      map2.put("groupInfo", groupInfo);
      map2.put("groupJoinVO", groupJoinVO);
      mav.setViewName("nonMember");
      mav.addObject("map", map2);
      return mav;
   }

   
   
   @RequestMapping("group_show_info.do")
   public ModelAndView groupShowInfo(String gLeaderId, HttpSession session) {
      ModelAndView mav = new ModelAndView();

      //그룹원 정보 받아오기
      List<GroupMemberVO> list = groupMemberService.getMemberList(gLeaderId);
      Map<String, Object> map = getGroupHomeInfo(gLeaderId, session);
      map.put("list", list);
      mav.setViewName("group_memberlist");
      mav.addObject("map", map);
      return mav;
   }
   
   /*
    * 그룹홈에서 필요한 정보들을 모두 갖고오는 메서드
    */
   public Map<String, Object> getGroupHomeInfo(String gLeaderId, HttpSession session){
	   Map<String, Object> map = new HashMap<String, Object>();
	      MemberVO mvo = (MemberVO) session.getAttribute("mvo");
	      // 그룹 정보 갖고오기
	      GroupVO vo = groupService.findGroupById(gLeaderId);

	      // 내가 가입한 그룹 리스트 받아오기
	      List<GroupVO> list = groupService.getAllMyGroup(mvo.getId());  

	      if (gLeaderId.equals(mvo.getId()))
	         map.put("checkLeader", "OK");

	      map.put("gLeaderId", gLeaderId);
	      map.put("groupList", list);
	      map.put("gvo", vo);
	      
	      /*
	       * 스케줄 리스트 받아오기
	       * 
	       */
	      List<ScheduleVO> scheduleList = scheduleService.getGroupScheduleListBygLeaderId(gLeaderId);
	      List<ScheduleVO> responseScheduleList = new ArrayList<ScheduleVO>();
	      List<ScheduleVO> tempList = new ArrayList<ScheduleVO>();
	      SimpleDateFormat trans = new SimpleDateFormat("yyyy/MM/dd hh:mm");
	      java.util.Date today = new java.util.Date();     //오늘 날짜 
	      String today1 = trans.format(today); //오늘 날짜를 스트링으로 변환 
	      for ( ScheduleVO svo : scheduleList ){
	         if ( svo.getDeadline() < 0 ){
	            tempList.add(svo);
	         }
	         else if ( svo.getScheduleDate().substring(0, 7).equals(today1.substring(0, 7)) ){
	            responseScheduleList.add(svo);
	         }
	      }
	         
	      for( ScheduleVO svo : tempList ){
	         responseScheduleList.add(svo);
	      }
	      map.put("scheduleList", responseScheduleList);
	      /*
	       * 스케줄리스트 받아오기 끝
	       */
	      return map;
   }
   
   @RequestMapping("deleteGroup.do")
   public ModelAndView deleteGroup(String gLeaderId, HttpServletRequest request){
	   HttpSession session = request.getSession(false);
	   MemberVO memberVO = (MemberVO)session.getAttribute("mvo");
	   transactionService.deleteGroupTransaction(gLeaderId);
	   return new ModelAndView("group_leader_delete");
   }
   
// 마이페이지 내 스케줄 출력 페이지
		@RequestMapping("groupPageSchedule.do")
		@ResponseBody
		public List<ScheduleVO> groupPageSchedule(String gLeaderId){
			List<ScheduleVO> scheduleList = scheduleService.getGroupScheduleListBygLeaderId(gLeaderId);
			return scheduleList;
		}
		
		
		@RequestMapping("updateGroupInfo.do")
		   public ModelAndView updateGroupInfo(String gLeaderId, HttpSession session, GroupVO gvo){
		      ModelAndView mav = new ModelAndView();
		      Map<String, Object> map = getGroupHomeInfo(gLeaderId, session);
		      
		      List<SubjectVO> categoryList = subjectService.getAllCategory(); 
		      
		      List<StudyLocationVO> location = memberService.getAllStudyLocation();
		      
		      List<SubjectVO> subject = subjectService.getAllSubject(((GroupVO)map.get("gvo")).getSubjectVO().getSubjectCategory());
		      map.put("categoryList", categoryList);
		      map.put("lvo", location);
		      map.put("subjectList", subject);
		      mav.setViewName("group_leader_update");
		      mav.addObject("map", map);
		      return mav;
		   }
		   
		   
		   @RequestMapping("updateGroup.do")
		   public ModelAndView updateGroup(GroupVO gvo, HttpSession session){
		      ModelAndView mav = new ModelAndView();
		      
		      String gLeaderId = gvo.getMemberVO().getId();
		      Map<String, Object> map = getGroupHomeInfo(gLeaderId, session);
		      
		      groupService.updateGroup(gvo);
		      map.put("gvo", gvo);
		      mav.setViewName("group_leader_update_result");
		      mav.addObject("map", map);
		      return mav;
		   }	
		   
		   @RequestMapping("getGroupScheduleListByGLeaderId.do")
		   @ResponseBody
		   public List<ScheduleVO> getGroupScheduleListByGLeaderId(String gLeaderId){
			   List<ScheduleVO> scheduleList = scheduleService.getGroupScheduleListBygLeaderId(gLeaderId);
			      List<ScheduleVO> list = new ArrayList<ScheduleVO>();
			      List<ScheduleVO> tempList = new ArrayList<ScheduleVO>();
			      
			      
			      SimpleDateFormat trans = new SimpleDateFormat("yyyy/MM/dd hh:mm");
			      java.util.Date today = new java.util.Date();     //오늘 날짜 
			      String today1 = trans.format(today); //오늘 날짜를 스트링으로 변환 
			      
			      
			      for ( ScheduleVO vo : scheduleList ){
			         if ( vo.getDeadline() < 0 ){
			            tempList.add(vo);
			         }
			         else if ( vo.getScheduleDate().substring(0, 7).equals(today1.substring(0, 7)) )
			            list.add(vo);
			      }
			      
			      for( ScheduleVO vo : tempList ){
			         list.add(vo);
			      }
			      
		      scheduleList = scheduleService.getGroupScheduleListBygLeaderId(gLeaderId);

			      return list;
		   }
		   
		   @RequestMapping("find_scheduleByScheduleDate.do")
		   public ModelAndView findScheduleByScheduleDate(HttpServletRequest request,HttpSession session, String scheduleDate, String gLeaderId){
		      ModelAndView mav = new ModelAndView();
		      ScheduleVO schvo=new ScheduleVO();
		      schvo.setgLeaderId(gLeaderId);
		      schvo.setScheduleDate(scheduleDate);
		      Map<String, Object> map = getGroupHomeInfo(gLeaderId, session);
		      map.put("schvo", scheduleService.findScheduleByScheduleDate(schvo));
		      mav.addObject("map", map);
		      mav.setViewName("group_updateschedule");
		      return mav;
		   }
		   
		   @RequestMapping(value="update_schedule.do", method=RequestMethod.POST)
		      public ModelAndView UpdateSchedule(HttpServletRequest request,ScheduleVO schvo, String gLeaderId, String orgScheduleDate,HttpSession session){
		         ModelAndView mav = new ModelAndView();
		         if(session!=null){
		            MemberVO mvo=(MemberVO) session.getAttribute("mvo");
		            if(mvo!=null){
		               schvo.setId(mvo.getId());
		            }
		         }
		         schvo.setgLeaderId(gLeaderId);
		         schvo.setScheduleDate(schvo.getScheduleDate() + " " +  request.getParameter("scheduleTime"));
		         System.out.println(schvo);
		         scheduleService.updateSchedule(schvo,orgScheduleDate);
		         mav.addObject("map", getGroupHomeInfo(gLeaderId, session));
		         mav.setViewName("group_schedule");
		         return mav;
		      }
		   
		    //스케쥴 삭제
			@RequestMapping("delete_scheduleByScheduleDate.do")
			public ModelAndView deleteScheduleByScheduleDate(HttpServletRequest request,HttpSession session, ScheduleVO schvo, String gLeaderId){
				ModelAndView mav = new ModelAndView();
				schvo.setgLeaderId(gLeaderId);
				schvo.setScheduleDate(schvo.getScheduleDate() + " " +  request.getParameter("scheduleTime"));
				scheduleService.deleteScheduleByScheduleDate(schvo);
				mav.setViewName("group_schedule");
				mav.addObject("map", getGroupHomeInfo(gLeaderId, session));
				return mav;
           }	   
			
	@RequestMapping("findGroupPageScheduleByYearAndMonth.do")
	@ResponseBody
	public List<ScheduleVO> findGroupPageScheduleByYearAndMonth(String gLeaderId, String selectedYearMonth){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("gLeaderId", gLeaderId);
		map.put("selectedYearMonth", selectedYearMonth);
		List<ScheduleVO> scheduleList = scheduleService.findGroupPageScheduleByYearAndMonth(map);
		return scheduleList;
	}
		   
	@RequestMapping("checkDuplicatedDate.do")
	@ResponseBody
	public String existDate(String gLeaderId, String scheduleDate){
		System.out.println("---------");
		System.out.println("드루와");
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("gLeaderId", gLeaderId);
		map.put("scheduleDate", scheduleDate);
		System.out.println("scheduleDate= " + scheduleDate);
		int flag = scheduleService.existDate(map);
		System.out.println("flag = " + flag);
		if( flag > 0 )
			return "exist";
		else
			return "nothing";
	}
		   
}


