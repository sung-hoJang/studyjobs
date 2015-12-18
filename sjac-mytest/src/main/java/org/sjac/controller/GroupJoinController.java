package org.sjac.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.sjac.model.CartService;
import org.sjac.model.GroupJoinService;
import org.sjac.model.GroupJoinVO;
import org.sjac.model.GroupService;
import org.sjac.model.GroupVO;
import org.sjac.model.TransactionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GroupJoinController {
	@Resource
	private GroupJoinService groupJoinService;
	@Resource
	private TransactionService transactionService;
	@Resource
	private CartService cartService;
	@Resource
	private GroupService groupService;
	
	@RequestMapping("joinGroup.do")
	public String joinGroup(GroupJoinVO gjvo){
		transactionService.joinGroupTransaction(gjvo);
/*		List<GroupVO> list = cartService.getAllMyCart(gjvo.getMemberVO().getId());*/
		return "redirect:checkMyGroup.do?gLeaderId="+gjvo.getGroupVO().getMemberVO().getId();
	}
	
	@RequestMapping("joinGroupUpdate.do")
	   public String joinGroupUpdate(GroupJoinVO gjvo){
	      groupJoinService.joinGroupUpdate(gjvo);
	      return "redirect:checkMyGroup.do?gLeaderId="+gjvo.getGroupVO().getMemberVO().getId();
    }
	
	@RequestMapping("accept.do")
	   @ResponseBody
	   public Object acceptList(String[] acceptList, String gLeaderId, HttpSession session){
	      Map<String, Object> map = new HashMap<String, Object>();
	      
	      transactionService.joinTransaction(gLeaderId, acceptList);
	      
	      List<GroupJoinVO> list = groupJoinService.getAllJoinRequestList(gLeaderId);
	      GroupVO gvo = groupService.findGroupByLeaderId(gLeaderId);
	      map.put("joinRequestList", list);
	      map.put("gvo", gvo);
	      return map;
	   }
	   
	   @RequestMapping("reject.do")
	   @ResponseBody
	   public Object rejectList(String[] rejectList, String gLeaderId, HttpSession session){
	      Map<String, String> map = new HashMap<String, String>();
	      map.put("gLeaderId", gLeaderId);
	      for( String value : rejectList ){
	         map.put("id", value);
	         groupJoinService.deleteRequestGroup(map);
	      }
	      
	      List<GroupJoinVO> list = groupJoinService.getAllJoinRequestList(gLeaderId);
	      return list;
	   }
}
