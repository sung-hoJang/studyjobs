package org.sjac.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.sjac.aop.model.ReportService;
import org.sjac.model.GroupService;
import org.sjac.model.GroupVO;
import org.sjac.model.MemberService;
import org.sjac.model.cart.CartReportService;
import org.sjac.model.cart.CartReportVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
   @Resource(name="groupServiceImpl")
   private GroupService groupService; 
   
   @Resource(name="reportServiceImpl")
   private ReportService reportService;
   
   @Resource(name="memberServiceImpl")
   private MemberService memberService;
   
   @Resource(name="cartReportServiceImpl")
   private CartReportService cartReportService;
   
   @RequestMapping("home.do")
   public ModelAndView home(){
      ModelAndView mv = new ModelAndView();
      Map map = new HashMap();      //main에 뿌려줄 데이터는 grouplist와 검색 chart 부분
      List<GroupVO> list = groupService.getAllGroupList();
      map.put("groupList", list);
      
      
  
      // report 수행부
      
      List<CartReportVO> cartReportList = cartReportService.showCountCart();
      map.put("cartReportList", cartReportList);
      
      
      // counter 수행부
      memberService.updateTotalVisitor();
     
     
	  //검색횟수 
	  int allSearchCount = groupService.allSearchCount();
	  map.put("allSearchCount",allSearchCount);
	  //토탈방문자수
	  int totalVisitor = memberService.totalVisitor();
	  map.put("totalVisitor", totalVisitor);
     
     
      int allMemberCount = memberService.allMemberCount();
      map.put("allMemberCount", allMemberCount);
      int allGroupCount = memberService.allGroupCount();
      map.put("allGroupCount", allGroupCount);
      
      mv.setViewName("home");
      mv.addObject("map", map);
      return mv;
   }
   
   @RequestMapping("admin.do")
   public ModelAndView admin(){
      ModelAndView mv = new ModelAndView();
      List<GroupVO> list = groupService.getAllGroupList();
      mv.setViewName("home");
      mv.addObject("groupList", list);
      return mv;
   }
}