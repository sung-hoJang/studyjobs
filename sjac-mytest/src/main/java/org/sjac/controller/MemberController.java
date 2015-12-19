package org.sjac.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.sjac.model.CartService;
import org.sjac.model.GroupJoinService;
import org.sjac.model.GroupJoinVO;
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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberController {
	@Resource
	private MemberService memberService;
	@Resource
	private GroupService groupService;
	@Resource
	private GroupJoinService groupJoinService;
	@Resource
	private SubjectService subjectService;
	@Resource
	private ScheduleService scheduleService;
	@Resource
	private TransactionService transactionService;
	@Resource
	private CartService cartService;

	@RequestMapping(value = "login.do", method = RequestMethod.POST)
	public ModelAndView login(MemberVO vo, HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		MemberVO mvo = memberService.login(vo);
		if (mvo != null) {
			session.setAttribute("mvo", mvo);
			return new ModelAndView("redirect:home.do");
		} else {
			return new ModelAndView("redirect:member_login.do?id=" + vo.getId());
		}
	}

	@RequestMapping("logout.do")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session != null)
			session.invalidate();
		return "redirect:home.do";
	}

	
	@RequestMapping("auth_mypage_info.do")
	public String myPage(HttpServletRequest request, MemberVO vo) {
		HttpSession session = request.getSession(false);
		return "mypage_info";
	}

	// 마이페이지 내정보 수정 페이지로 이동
	@RequestMapping("auth_mypage_update.do")
	public ModelAndView myInfoUpdate(MemberVO vo) {
		ModelAndView mav = new ModelAndView();
		List<StudyLocationVO> locationList = memberService
				.getAllStudyLocation();
		mav.setViewName("mypage_update");
		mav.addObject("locationList", locationList);
		return mav;
	}

	// 마이페이지 내정보 수정 페이지
	@RequestMapping("auth_mypage_updateInfo.do")
	public ModelAndView myInfoUpdate1(HttpServletRequest request, MemberVO vo) {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession(false);
		memberService.updateMyInfo(vo);
		mav.setViewName("mypage_info");
		session.setAttribute("mvo", vo);
		return mav;
	}

	// 마이페이지 내가 가입한 그룹리스트 출력 페이지
	@RequestMapping("auth_mypage_grouplist.do")
	public ModelAndView myPageGroupList(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession(false);
		MemberVO vo = (MemberVO) session.getAttribute("mvo");
		List<GroupVO> myGroupList = groupService.getAllMyGroup(vo.getId());
		int MyGroupCount = groupService.MyGroupCount(vo.getId());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("myGroupList", myGroupList);
		map.put("MyGroupCount", MyGroupCount);
		mav.setViewName("mypage_grouplist");
		mav.addObject("map", map);
		return mav;
	}

	@RequestMapping("auth_mypage_grouplist_grid.do")
	public ModelAndView myPageGroupListGrid(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession(false);
		MemberVO vo = (MemberVO) session.getAttribute("mvo");
		List<GroupVO> myGroupListGrid = groupService.getAllMyGroup(vo.getId());
		int MyGroupCount = groupService.MyGroupCount(vo.getId());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("myGroupListGrid", myGroupListGrid);
		map.put("MyGroupCount", MyGroupCount);
		mav.setViewName("mypage_grouplist_grid");
		mav.addObject("map", map);
		return mav;
	}

	// 마이페이지 현재 가입요청중인 그룹리스트 출력 페이지
	@RequestMapping("auth_mypage_join_grouplist.do")
	public ModelAndView myPageJoinGroupList(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession(false);
		MemberVO vo = (MemberVO) session.getAttribute("mvo");
		List<GroupVO> joinList = groupJoinService.getAllJoinRequestGroup(vo
				.getId());
		int joinCount = groupJoinService.MyRequestGroupCount(vo.getId());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("joinList", joinList);
		map.put("joinCount", joinCount);
		mav.setViewName("mypage_join_grouplist");
		mav.addObject("map", map);
		return mav;
	}

	@RequestMapping("auth_mypage_join_grouplist_grid.do")
	public ModelAndView myPageJoinGroupListGrid(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession(false);
		MemberVO vo = (MemberVO) session.getAttribute("mvo");
		List<GroupVO> joinList = groupJoinService.getAllJoinRequestGroup(vo
				.getId());
		int joinCount = groupJoinService.MyRequestGroupCount(vo.getId());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("joinList", joinList);
		map.put("joinCount", joinCount);
		mav.setViewName("mypage_join_grouplist_grid");
		mav.addObject("map", map);
		return mav;
	}

	// 마이페이지 내 스케줄 출력 페이지
	@RequestMapping("auth_mypage_schedule.do")
	public ModelAndView myPageSchedule(HttpServletRequest request)
			throws Exception {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession(false);
		MemberVO vo = (MemberVO) session.getAttribute("mvo");
		List<ScheduleVO> scheduleList = transactionService.ScheduleTransaction(vo.getId());
		mav.setViewName("mypage_schedule");
		mav.addObject("scheduleList", scheduleList);
		return mav;
		
	}

	// 마이페이지 내가 만든 그룹 출력 페이지
	@RequestMapping("auth_mypage_mycreating_group.do")
	public ModelAndView myPageMyCreatingGroup(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession(false);
		MemberVO vo = (MemberVO) session.getAttribute("mvo");
		GroupVO gvo = groupService.createMyGroupInfo(vo.getId());
		mav.setViewName("mypage_mycreating_group_grid");
		mav.addObject("gvo", gvo);
		return mav;
	}

	

	// 마이페이지 대분류, 중분류 셀렉트하는 메서드 -> 카테고리로 서브젝트 검색
	@RequestMapping("auth_mypage_subject_category.do")
	@ResponseBody
	public List<SubjectVO> myPageSubjectCategory(String category) {
		List<SubjectVO> subjectList = subjectService.getAllSubject(category);
		return subjectList;
	}

	// 대분류로 내 그룹검색
	@RequestMapping("auth_mypage_getListByCategory.do")
	@ResponseBody
	public List<GroupVO> getListByCategory(HttpServletRequest request,
			String category) {
		HttpSession session = request.getSession(false);
		MemberVO vo = (MemberVO) session.getAttribute("mvo");
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", vo.getId());
		map.put("category", category);
		List<GroupVO> categoryGroupList = null; 
		
		if (!category.equals("전체")) {
			categoryGroupList = groupService.findGroupListByCategory(map);
		} else {
			categoryGroupList = groupService.getAllMyGroup(vo.getId());
		}
		
		return categoryGroupList;
	}

	// 마이페이지 대분류, 중분류 셀렉트했을 때, 관련된 그룹 나타내는 메서드
	@RequestMapping("auth_mypage_grouplist_select.do")
	@ResponseBody
	public List<GroupVO> myPageGroupListSelect(HttpServletRequest request,
			String subject, String category) {
		HttpSession session = request.getSession(false);
		MemberVO vo = (MemberVO) session.getAttribute("mvo");
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", vo.getId());
		List<GroupVO> groupList = null;
		if (!subject.equals("전체")) {
			map.put("subject", subject);
			groupList = groupService.findMyGroupListBySubject(map);
		} else {
			map.put("category", category);
			groupList = groupService.findGroupListByCategory(map);
		}

		return groupList;
	}

	// 로그인 페이지
	@RequestMapping("member_login.do")
	public ModelAndView login(String id) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("basic_member_login");
		mav.addObject("id", id);
		return mav;
	}

	@RequestMapping("group_nonmember_home.do")
	public String nonmemberHome() {
		return "nonMember";
	}

	// 내 아이디가 그룹원에 속해 있는지 확인 (내 아이디와 그룹장 아이디로 그룹멤버에서 검색)
	@RequestMapping("checkMyGroup.do")
	public ModelAndView checkMyGroup(HttpServletRequest request,
			String gLeaderId) {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession(false);
		MemberVO vo = (MemberVO) session.getAttribute("mvo");
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", vo.getId());
		map.put("gLeaderId", gLeaderId);
		boolean check = groupService.checkMyGroup(map);
		if (check == true) {
			mav.setViewName("redirect:group_member_home.do?gLeaderId="
					+ gLeaderId);
		} else {
			GroupVO groupInfo = groupService.findGroupById(gLeaderId);
			GroupJoinVO groupJoinVO = groupJoinService.getMyJoinRequest(map);
			boolean flag = cartService.checkCart(gLeaderId, vo.getId());
			Map<String, Object> map2 = new HashMap<String, Object>();
			map2.put("groupInfo", groupInfo);
			map2.put("groupJoinVO", groupJoinVO);
			if (flag) // 카트에 들어있으면 찜하기 불가능 하기 때문에 fail
				map2.put("flag", "fail");
			else
				// 카트에 안드가있으면 찜하기 가능하기 때문에 ok
				map2.put("flag", "ok");

			mav.setViewName("nonMember");
			mav.addObject("map", map2);
		}
		return mav;
	}

	

	// 그룹 생성 페이지로 이동
	@RequestMapping("auth_member_create_group.do")
	   public ModelAndView createGroup(HttpSession session) {
	      ModelAndView mav = new ModelAndView();
	      List<StudyLocationVO> locationList = memberService.getAllStudyLocation();
	      Map<String, Object> map = new HashMap<String, Object>();
	      MemberVO mvo = (MemberVO) session.getAttribute("mvo");
	      String gLeaderId = mvo.getId();

	      List<SubjectVO> categoryList = subjectService.getAllCategory();
	      map.put("gLeaderId", gLeaderId);
	      map.put("locationList", locationList);
	      map.put("categoryList", categoryList);
	      mav.setViewName("mypage_update");
	      mav.addObject("map", map);
	      return new ModelAndView("basic2_member_create_group", "map", map);
	   }

	// 그룹 생성
	@RequestMapping("auth_createNewGroup.do")
	   public ModelAndView createNewGroup(GroupVO gvo, HttpServletRequest request)
	         throws Exception {
	      ModelAndView mav = new ModelAndView();
	      HttpSession session = request.getSession(false);
	      MemberVO memberVO = (MemberVO) session.getAttribute("mvo");
	      gvo.setMemberVO(memberVO);
	      GroupMemberVO gmvo = new GroupMemberVO();
	      gmvo.setGroupVO(gvo);
	      gmvo.setMemberVO(memberVO);
	      transactionService.TransactionAll(gvo, gmvo);
		  mav.setViewName("redirect:home.do");
	      return mav;
	   }

	// 그룹 검색 페이지
	@RequestMapping("member_find_group.do")
	public ModelAndView findGroup() {
		return new ModelAndView("member_find_group", "gvo",
				(List<GroupVO>) groupService.getAllGroupList());
	}

	// 서브젝트카테고리로로 서브젝트검색
	@RequestMapping("findSubjectBySubjectCategory.do")
	@ResponseBody
	public Object findSubjectBySubjectCategory(String subjectCategory) {
		return subjectService.findSubjectBySubjectCategory(subjectCategory);
	}

	// 그룹장id로 그룹검색
	@RequestMapping("findGroupByLeaderId.do")
	@ResponseBody
	public Object findGroupByLeaderId(String id) {
		GroupVO vo = groupService.findGroupByLeaderId(id);
		if (vo != null) {
			return vo;
		} else {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("flag", "false");
			return map;
		}
	}

	@RequestMapping("findGroupList.do")
	@ResponseBody
	public Object findGroupList(GroupVO vo) {
		String subject = vo.getSubjectVO().getSubject();
		String subjectCategory = vo.getSubjectVO().getSubjectCategory();
		String gLocation = vo.getgLocation();
		String gName = vo.getgName();
		if (subject == null) {
			vo.getSubjectVO().setSubject("undefined");
		}
		if (subjectCategory == null) {
			vo.getSubjectVO().setSubjectCategory("undefined");
		}
		if (gLocation == null) {
			vo.setgLocation("undefined");
		}
		if (gName == null) {
			vo.setgName("undefined");
		}
		subject = vo.getSubjectVO().getSubject();
		subjectCategory = vo.getSubjectVO().getSubjectCategory();
		gLocation = vo.getgLocation();
		gName = vo.getgName();
		if (gLocation.equals("전체") || subjectCategory.equals("전체")) {
			return groupService.getAllGroupList();
		} else {
			return groupService.findGroupList(vo);
		}
	}

	/*
	 * 내 가입요청 그룹 찾기 시작
	 */
	@RequestMapping("auth_mypage_getJoinGroupListByCategory.do")
	@ResponseBody
	public List<GroupVO> getJoinGroupListByCategory(HttpServletRequest request,
			String category) {
		HttpSession session = request.getSession(false);
		MemberVO vo = (MemberVO) session.getAttribute("mvo");
		Map<String, String> map = new HashMap<String, String>();
		List<GroupVO> groupList;
		map.put("id", vo.getId());
		map.put("category", category);

		if (!category.equals("전체")) {
			groupList = groupService.findMyJoinGroupListByCategory(map);
		} else {
			groupList = groupJoinService.getAllJoinRequestGroup(vo.getId());
		}
		return groupList;
	}

	@RequestMapping("auth_mypage_MyJoinGroupList_select.do")
	@ResponseBody
	public List<GroupVO> myPageJoinGroupListSelect(HttpServletRequest request,
			String subject, String category) {
		HttpSession session = request.getSession(false);
		MemberVO vo = (MemberVO) session.getAttribute("mvo");
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", vo.getId());
		List<GroupVO> groupList = null;
		if (!subject.equals("전체")) {
			map.put("subject", subject);
			groupList = groupService.findMyJoinGroupListBySubject(map);
		} else {
			map.put("category", category);
			groupList = groupService.findMyJoinGroupListByCategory(map);
		}
		return groupList;
	}

	/*
	 * 내 가입요청 그룹 찾기 끝
	 */

	@RequestMapping("lastSchedule.do")
	@ResponseBody
	public List<ScheduleVO> lastSchedule(HttpServletRequest request,
			String scheduleSelect) {
		HttpSession session = request.getSession(false);
		MemberVO vo = (MemberVO) session.getAttribute("mvo");
		List<ScheduleVO> lastScheduleList = null;
		if (scheduleSelect.equals("지난 스케줄")) {
			lastScheduleList = scheduleService.findMyLastScheduleById(vo.getId());
		} else {
			lastScheduleList = scheduleService.findMyScheduleById(vo.getId());
		}
		return lastScheduleList;
	}

	@RequestMapping("deleteRequestGroup.do")
	public ModelAndView deleteRequestGroup(String id, String gLeaderId,
			HttpServletRequest request, String parentURL) {
		ModelAndView mav = new ModelAndView();
		id = request.getParameter("id");
		gLeaderId = request.getParameter("gLeaderId");
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("gLeaderId", gLeaderId);
		groupJoinService.deleteRequestGroup(map);
		List<GroupVO> joinList = groupJoinService.getAllJoinRequestGroup(id);
		int joinCount = groupJoinService.MyRequestGroupCount(id);
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("joinList", joinList);
		map2.put("joinCount", joinCount);

		String urlParse[] = parentURL.split("/");
		for (String value : urlParse) {
			if (value.contains(".")) {
				parentURL = value;
				break;
			}
		}
		if (parentURL.equals("home.do")) {
			mav.setViewName("redirect:home.do");
		} else {
			mav.setViewName("mypage_join_grouplist");
			mav.addObject("map", map2);
		}

		return mav;
	}

	@RequestMapping("auth_mypage_cart.do")
	public ModelAndView cart(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession(false);
		MemberVO vo = (MemberVO) session.getAttribute("mvo");
		List<GroupVO> cartList = cartService.getAllMyCart(vo.getId());
		int cartCount = cartService.MyCartCount(vo.getId());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("cartList", cartList);
		map.put("cartCount", cartCount);
		mav.setViewName("mypage_cart");
		mav.addObject("map", map);
		return mav;
	}

	@RequestMapping("auth_mypage_cart_grid.do")
	public ModelAndView cartGrid(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession(false);
		MemberVO vo = (MemberVO) session.getAttribute("mvo");
		List<GroupVO> cartList = cartService.getAllMyCart(vo.getId());
		int cartCount = cartService.MyCartCount(vo.getId());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("cartList", cartList);
		map.put("cartCount", cartCount);
		mav.setViewName("mypage_cart_grid");
		mav.addObject("map", map);
		return mav;
	}

	@RequestMapping("auth_mypage_getCartListByCategory.do")
	@ResponseBody
	public List<GroupVO> getCartListByCategory(HttpServletRequest request,
			String category) {
		HttpSession session = request.getSession(false);
		MemberVO vo = (MemberVO) session.getAttribute("mvo");
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", vo.getId());
		map.put("category", category);
		List<GroupVO> categoryCartList = null;
		if (!category.equals("전체")) {
			categoryCartList = cartService.findMyCartListByCategory(map);
		} else {
			categoryCartList = cartService.getAllMyCart(vo.getId());
		}
		return categoryCartList;
	}

	@RequestMapping("auth_mypage_cart_select.do")
	@ResponseBody
	public List<GroupVO> myPageCartListSelect(HttpServletRequest request,
			String subject, String category) {
		HttpSession session = request.getSession(false);
		MemberVO vo = (MemberVO) session.getAttribute("mvo");
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", vo.getId());
		List<GroupVO> cartList = null;
		if (!subject.equals("전체")) {
			map.put("subject", subject);
			cartList = cartService.findMyCartListBySubject(map);
		} else {
			map.put("category", category);
			cartList = cartService.findMyCartListByCategory(map);
		}
		return cartList;
	}

	@RequestMapping("idcheck.do")
	@ResponseBody
	public String idcheckJSON(String id) {
		String idComp = "";
		int memberCount = memberService.idcheck(id);
		if (memberCount == 0) {
			idComp = "ok";
		} else {
			idComp = "fail";
		}
		return idComp;
	}

	@RequestMapping("register.do")
	public String register(HttpServletRequest request, MemberVO vo) {
		HttpSession session = request.getSession(false);
		memberService.register(vo);
		session.setAttribute("mvo", vo);
		return "redirect:home.do";
	}

	@RequestMapping("member_register.do")
	public ModelAndView register() {
		List<StudyLocationVO> gvo = memberService.getAllStudyLocation();
		return new ModelAndView("basic_member_register", "gvo", gvo);
	}

	// 관리자: 회원검색 페이지
	@RequestMapping("auth_admin_getAllMemberList.do")
	public ModelAndView getAllMemberList() {
		return new ModelAndView("admin_membermgr", "list",
				(List<MemberVO>) memberService.getAllMemberList());
	}

	// 관리자: 회원정보검색
	@RequestMapping("auth_admin_getMemberInfo.do")
	@ResponseBody
	public Object adminGetMemberInfo(String id) {
		MemberVO vo = memberService.findMemberById(id);
		if (vo != null) {
			return vo;
		} else {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("flag", "false");
			return map;
		}

	}

	// 관리자: 그룹검색 페이지
	@RequestMapping("auth_admin_getAllGroupList.do")
	public ModelAndView adminGetAllGroupList() {
		return new ModelAndView("admin_groupmgr", "list",
				(List<GroupVO>) groupService.getAllGroupList());
	}

	// 관리자: 그룹정보검색
	@RequestMapping("auth_admin_getGroupInfo.do")
	@ResponseBody
	public Object adminGetGroupInfo(String id) {

		GroupVO vo = groupService.findGroupByLeaderId(id);
		if (vo != null) {
			return vo;
		} else {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("flag", "false");
			return map;
		}

	}

	// 관리자: 회원삭제
	@RequestMapping("auth_admin_deleteMemberById.do")
	public ModelAndView deleteMemberById(String id) {
		GroupVO gvo = groupService.findGroupByLeaderId(id);
		if (gvo != null) {// 그룹장이라면
			transactionService.deleteGroupTransaction(id);
			transactionService.deleteMemberTransaction(id);
		} else {// 일반회원이라면
			transactionService.deleteMemberTransaction(id);
		}
		ModelAndView mv = new ModelAndView(
				"redirect:auth_admin_getAllMemberList.do");
		return mv;
	}

	// 관리자: 그룹삭제
	@RequestMapping("auth_admin_deleteGroupById.do")
	public ModelAndView deleteGroupById(String id) {
		transactionService.deleteGroupTransaction(id);
		return new ModelAndView("redirect:auth_admin_getAllGroupList.do");
	}

	@RequestMapping("deleteCart.do")
	public ModelAndView deleteCart(String gLeaderId, String id, String parentURL) {
		ModelAndView mav = new ModelAndView();
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("gLeaderId", gLeaderId);

		cartService.deleteMyCart(map);

		int cartCount = cartService.MyCartCount(id);
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("cartCount", cartCount);
		List<GroupVO> cartList = cartService.getAllMyCart(id);
		map2.put("cartList", cartList);

		String urlParse[] = parentURL.split("/");

		for (String value : urlParse) {
			if (value.contains(".")) {
				parentURL = value;
				break;
			}
		}
		String compareText = "checkMyGroup.do?gLeaderId=" + gLeaderId;
		if (parentURL.equals(compareText)) {
			mav.setViewName("mypage_cart");
			mav.addObject("map", map2);
		} else {
			mav.setViewName("redirect:home.do");
		}
		return mav;
	}

	// ////////////////////////////////아이디 찾기, 비밀번호 찾기//////////////////////////
	@RequestMapping("findIdView.do")
	public ModelAndView findIdView(MemberVO vo) {
		return new ModelAndView("member_find_id");
	}

	@RequestMapping("findId.do")
	@ResponseBody
	public Map<String, Object> findIdForUser(MemberVO vo) {
		MemberVO mvo = memberService.findIdForUser(vo);
		String check = null;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("mvo", mvo);
		if (mvo != null) {
			check = "ok";
		} else {
			check = "fail";
		}
		map.put("check", check);
		return map;
	}

	@RequestMapping("findPasswordView.do")
	public ModelAndView findPasswordView(MemberVO vo) {
		return new ModelAndView("member_find_password");
	}

	@RequestMapping("findPassword.do")
	@ResponseBody
	public Map<String, Object> findPasswordForUser(MemberVO vo) {
		MemberVO mvo = memberService.findPasswordForUser(vo);
		String check = null;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("mvo", mvo);
		if (mvo != null) {
			check = "ok";
		} else {
			check = "fail";
		}
		map.put("check", check);
		return map;
	}
	
	@RequestMapping("existMyGroup.do")
	   @ResponseBody
	   public String existMyGroup(String gLeaderId){
	      GroupVO vo = groupService.findGroupById(gLeaderId);
	      String message = "";
	      if( vo != null )
	         message ="exist";
	      else
	         message = "nothing";
	      
	      return message;
	   }
	
	
	// 그룹명 + 그룹정보로 그룹 검색
    @RequestMapping("findGroupByGNameAndGInfo.do")
    public ModelAndView findGroupByGNameAndGInfo(String keyText) {
       return new ModelAndView("member_find_group", "gvo",
             (List<GroupVO>) groupService.findGroupListByGNameAndGInfo(keyText));
    }
		
    @RequestMapping("leave.do")
 public ModelAndView leaveMyself(HttpSession session){
    return new ModelAndView("mypage_leave_myself");
 }
    
    
    @RequestMapping(value = "passwordcheck.do", method = RequestMethod.POST)
    @ResponseBody
    public String passwordcheck(HttpServletRequest request, String password) {
       HttpSession session = request.getSession(false);
       MemberVO vo = (MemberVO) session.getAttribute("mvo");
       vo.setPassword(password);
       MemberVO mmvo = memberService.login(vo);
       String passComp =null;
       if (mmvo != null) {
             passComp = "ok";
          } else {
             passComp = "fail";
          }
          return passComp;
       
    }	
    
    @RequestMapping("auth_member_deleteMemberById.do")
    public ModelAndView deleteMyselfById(HttpServletRequest request, String reason, String detailreason) {
       HttpSession session = request.getSession(false);
       MemberVO vo = (MemberVO)session.getAttribute("mvo");
       String id = vo.getId();
       String reason1 = request.getParameter("reason");
       String detailreason1 = request.getParameter("detailreason");
       Map<String, Object> map = new HashMap<String, Object>();
       map.put("reason", reason1);
       map.put("detailreason", detailreason1);
       memberService.insertReason(map);
       System.out.println("컨트롤러: 탈퇴이유");
       GroupVO gvo = groupService.findGroupByLeaderId(id);
       System.out.println("gvo:" + gvo);
       if (gvo != null) {// 그룹장이라면
          transactionService.deleteGroupTransaction(id);
          transactionService.deleteMemberTransaction(id);
       } else {// 일반회원이라면
          transactionService.deleteMemberTransaction(id);
          System.out.println("일반회원탈퇴 : 컨트롤러");
       }
       session.invalidate();
       
       ModelAndView mv = new ModelAndView("redirect:home.do");
       return mv;
    }

}
