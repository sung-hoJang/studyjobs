   package org.sjac.controller;
   
   
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.sjac.model.GListVO;
import org.sjac.model.GroupBoardService;
import org.sjac.model.GroupBoardVO;
import org.sjac.model.GroupService;
import org.sjac.model.GroupVO;
import org.sjac.model.MemberVO;
import org.sjac.model.ScheduleService;
import org.sjac.model.ScheduleVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
   
   @Controller
   public class GroupBoardController {
      @Resource(name="groupBoardServiceImpl")
      private GroupBoardService groupBoardService;
      @Resource
      private GroupService groupService;
      @Resource
      private ScheduleService scheduleService;
      @Resource(name="uploadPath")
      private String path;
      
      public Map<String, Object> getGroupHomeInfo(String gLeaderId,
            HttpSession session) {
         Map<String, Object> map = new HashMap<String, Object>();
         MemberVO mvo = (MemberVO) session.getAttribute("mvo");
         // 그룹 정보 갖고오기
         GroupVO vo = groupService.findGroupByLeaderId(gLeaderId);
         // 내가 가입한 그룹 리스트 받아오기
         List<GroupVO> list = groupService.getAllMyGroup(mvo.getId());
         if (gLeaderId.equals(mvo.getId())){
            map.put("checkLeader", "OK");
         }
         map.put("gLeaderId", gLeaderId);
         map.put("groupList", list);
         map.put("gvo", vo);
         List<ScheduleVO> scheduleList = scheduleService.getGroupScheduleListBygLeaderId(gLeaderId);
         map.put("scheduleList", scheduleList);
         return map;
      }
     
      
   // 자유게시판 글쓰기로 이동
      @RequestMapping("group_board_show_write.do")
      public ModelAndView boardShowWrite(String gLeaderId, HttpSession session) {
         ModelAndView mav = new ModelAndView();
         Map<String, Object> map = getGroupHomeInfo(gLeaderId, session);
         mav.setViewName("group_board_write");
         mav.addObject("map", map);
         return mav;
      }

      // 자유게시판 글쓰기 + 파일 업로드
      @RequestMapping(value = { "group_board_write.do", "/fileupload.do" }, method = RequestMethod.POST)
      public ModelAndView boardWrite(HttpServletRequest request,
            GroupBoardVO gbvo, String gLeaderId) {
         ModelAndView mav = new ModelAndView();
         Map<String, Object> gbmap = new HashMap<String, Object>();
         HttpSession session = request.getSession(false);
         if (session != null) {
            MemberVO mvo = (MemberVO) session.getAttribute("mvo");
            if (mvo != null) {
               gbvo.setMemberVO(mvo);
            }
         }
         gbmap.put("gbtable", gLeaderId);
         List<MultipartFile> list = gbvo.getFile();
         for (int i = 0; i < list.size(); i++) {
            // 만약 업로드 파일이 없으면 파일명은 공란처리된다
            String fileName = list.get(i).getOriginalFilename();
            gbvo.setFname(fileName);
            String extension = "";
            if( !fileName.equals("") )
               extension = fileName.substring(fileName.lastIndexOf("."));
            
            gbmap.put("gbvo", gbvo);
            groupBoardService.write(gbmap);
            // 업로드 파일이 있으면 파일을 특정경로로 업로드한다
            if (!fileName.equals("")) {
               try {
                  list.get(i).transferTo(
                        new File(path + gbmap.get("gbtable") + "_"
                              + gbmap.get("no") + extension));
               } catch (Exception e) {
                  e.printStackTrace();
               }
            }
            mav.setViewName("redirect:group_board_showContentNoHit.do?no="+ gbmap.get("no")+"&gLeaderId="+gLeaderId);
         }
         return mav;
      }

      // GroupBoardDAO (updateChildBeforeDelete 수정했음)
      @RequestMapping("group_board_deleteBoard.do")
      public ModelAndView deleteBoard(String no, String gLeaderId, HttpSession session) {
         ModelAndView mav = new ModelAndView();
         Map<String, Object> map = getGroupHomeInfo(gLeaderId, session);
         Map<String, Object> gbmap = new HashMap<String, Object>();
         gbmap.put("gbtable", gLeaderId);
         gbmap.put("no", no);
         groupBoardService.deleteBoard(gbmap);
         gbmap.put("page", "1");
         GListVO glvo = groupBoardService.getBoardList(gbmap);
         map.put("glvo", glvo);
         mav.setViewName("group_board_list");
         mav.addObject("map", map);
         return mav;
      }

      @RequestMapping("group_board_updateView.do")
      public ModelAndView updateView(String no, String gLeaderId, HttpSession session) {
         ModelAndView mav = new ModelAndView();
         Map<String, Object> map = getGroupHomeInfo(gLeaderId, session);
         Map<String, Object> gbmap = new HashMap<String, Object>();
         gbmap.put("gbtable", gLeaderId);
         gbmap.put("no", no);
         GroupBoardVO gbvo =groupBoardService.showContentNoHit(gbmap);
         map.put("gbvo", gbvo);
         mav.setViewName("group_board_update");
         mav.addObject("map", map);
         return mav;   
      }

      // 자유 게시판 글 수정
      @RequestMapping("group_board_update.do")
      public ModelAndView updateBoard(GroupBoardVO gbvo, String gLeaderId, HttpSession session) {
         ModelAndView mav = new ModelAndView();
         Map<String, Object> map = getGroupHomeInfo(gLeaderId, session);
         Map<String, Object> gbmap = new HashMap<String, Object>();
         gbmap.put("no", gbvo.getGbNo());
         gbmap.put("gbtable", gLeaderId);
         gbmap.put("gbvo", gbvo);
         groupBoardService.updateBoard(gbmap);
         gbvo =groupBoardService.showContentNoHit(gbmap);
         map.put("gbvo", gbvo);
         mav.setViewName("group_board_show_content");
         mav.addObject("map", map);
         return mav;
      }

      // 게시판 글 보기
      @RequestMapping("group_board_show_content.do")
      public ModelAndView showContent(
            int no,
            @CookieValue(value = "sjacgboard", required = false) String cookieValue, String gLeaderId, HttpSession session,
            HttpServletResponse response) {
         ModelAndView mav = new ModelAndView();
         Map<String, Object> map = getGroupHomeInfo(gLeaderId, session);
         GroupBoardVO gbvo = null;
         Map<String, Object> gbmap = new HashMap<String, Object>();
         gbmap.put("no", no);
         gbmap.put("gbtable", gLeaderId);
         if (cookieValue == null) {
            response.addCookie(new Cookie("sjacgboard", "|" + no + "|"));
            gbvo = groupBoardService.showContent(gbmap);
         } else if (cookieValue.indexOf("|" + no + "|") == -1) {
            cookieValue += "|" + no + "|";
            // 글번호를 쿠키에 추가
            response.addCookie(new Cookie("sjacgboard", cookieValue));
            gbvo = groupBoardService.showContent(gbmap);
         } else {
            gbvo = groupBoardService.showContentNoHit(gbmap);
         }
         map.put("gbvo", gbvo);
         mav.setViewName("group_board_show_content");
         mav.addObject("map", map);
         return mav;
      }
            // 파일 다운로드 뷰
            @RequestMapping("fileDownLoad.do")
            public ModelAndView fileDownload(String filename){
               HashMap<String, String> map = new HashMap<String, String>();
               map.put("path", path);
               return new ModelAndView("downloadView", map);
            }   


            @RequestMapping("group_board_showContentNoHit.do")
            public ModelAndView showContentNoHit(int no, String gLeaderId, HttpSession session) {
               ModelAndView mav = new ModelAndView();
               Map<String, Object > map = getGroupHomeInfo(gLeaderId, session);
               Map<String, Object> gbmap = new HashMap<String, Object>();
               gbmap.put("no", no);
               gbmap.put("gbtable", gLeaderId);
               GroupBoardVO gbvo = groupBoardService.showContentNoHit(gbmap);
               map.put("gbvo", gbvo);
               mav.addObject("map", map);
               mav.setViewName("group_board_show_content");
               return mav;
            }

            // 자유 게시판 글 리스트 보기
            @RequestMapping("group_board_list.do")
            public ModelAndView boardList(String pageNo, String gLeaderId,
                  HttpSession session) {
               ModelAndView mav = new ModelAndView();
               Map<String, Object> gbmap = new HashMap<String, Object>();
               gbmap.put("page", pageNo);
               gbmap.put("gbtable", gLeaderId);
               GListVO glvo = groupBoardService.getBoardList(gbmap);
               Map<String, Object> map2 = getGroupHomeInfo(gLeaderId, session);
               map2.put("glvo", glvo);
               mav.setViewName("group_board_list");
               mav.addObject("map", map2);
               return mav;
            }

            /**
             * 답변 폼을 보여 준다 client가 show_content.jsp에서 글을 보고 답변버튼을 클릭하면 답변할 폼을 보여준다. 
             * 1. Client로 부터 답변할 글 번호(no)를 받는다. 
             * 2. groupBoardService의 showContentNoHit(no) 를 호출하여 답변 원본 글의 데이터를 가진 
             *    BoardVO 객체를 받아온다. 
             * 3. BoardVO객체(bvo)를 requestScope에 넣고 reply_form.jsp로 수행을 넘긴다. 
             */
            
            @RequestMapping("group_board_replyView.do")
            public ModelAndView replyView(int no, String gLeaderId, HttpSession session) {
               ModelAndView mav = new ModelAndView();
               Map<String, Object> map = getGroupHomeInfo(gLeaderId, session);
               Map<String, Object> gbmap = new HashMap<String, Object>();
               gbmap.put("no", no);
               gbmap.put("gbtable", gLeaderId);
               GroupBoardVO gbvo = groupBoardService.showContentNoHit(gbmap);
               map.put("gbvo", gbvo);
               mav.setViewName("group_board_reply_form");
               mav.addObject("map", map);
               return mav;
            }

            /**
             * 답변을 처리 
             * 1. Client로 부터 답변할 글의 데이터들을 BoardVO로 받는다. 
             * 2. groupBoardService의 reply(bvo)를 호출하여 답변처리를 한다. 
             * 3. BoardVO객체를 request scope에 넣고 show_content.jsp로 수행을 넘긴다.
             */
            @RequestMapping(value = "group_board_reply.do", method = RequestMethod.POST)
            public ModelAndView reply(HttpServletRequest request, GroupBoardVO gbvo, String gLeaderId, HttpSession session)
                  throws Exception {
               if (session != null) {
                  MemberVO mvo = (MemberVO) session.getAttribute("mvo");
                  if (mvo != null) {
                     gbvo.setMemberVO(mvo);
                  }
               }
               ModelAndView mav = new ModelAndView();
               Map<String, Object> gbmap = new HashMap<String, Object>();
               gbmap.put("gbvo", gbvo);
               gbmap.put("gbtable", gLeaderId);
               groupBoardService.reply(gbmap);
               mav.setViewName("redirect:group_board_showContentNoHit.do?no="
                     + gbmap.get("no")+"&gLeaderId="+gLeaderId);
               return mav;
            }
            
            //그룹 게시판 검색
            @RequestMapping("group_board_findList.do")
            public ModelAndView findboardListTitleAndContent(String pageNo, String gLeaderId,
                 String keyText, HttpSession session) {
               ModelAndView mav = new ModelAndView();
               Map<String, Object> gbmap = new HashMap<String, Object>();
               gbmap.put("page", pageNo);
               gbmap.put("gbtable", gLeaderId);
               gbmap.put("keyText", keyText);
               GListVO glvo = groupBoardService.findboardListTitleAndContent(gbmap);
               Map<String, Object> map2 = getGroupHomeInfo(gLeaderId, session);
               map2.put("hidden", "find");
               map2.put("keyText", keyText);
               map2.put("glvo", glvo);
               mav.setViewName("group_board_list");
               mav.addObject("map", map2);
               return mav;
            }
            
          //그룹 게시판 카테고리별로
            @RequestMapping("group_board_findListByCategory.do")
            public ModelAndView findBoardListByCategory(String pageNo,String category, String gLeaderId,
                  HttpSession session) {
               ModelAndView mav = new ModelAndView();
               Map<String, Object> gbmap = new HashMap<String, Object>();
               gbmap.put("page", pageNo);
               gbmap.put("category", category);
               gbmap.put("gbtable", gLeaderId);
               GListVO glvo = groupBoardService.findBoardListByCategory(gbmap);
               Map<String, Object> map2 = getGroupHomeInfo(gLeaderId, session);
               map2.put("hidden", "category");
               map2.put("category", category);
               map2.put("glvo", glvo);
               mav.setViewName("group_board_list");
               mav.addObject("map", map2);
               return mav;
            }
            
            
            
               //그룹 게시판 카테고리별 키워드 검색
                @RequestMapping("group_board_findCategorizedList.do")
                public ModelAndView group_board_findCategorizedList(String pageNo,String category, String gLeaderId, String keyText, HttpSession session) {
                   ModelAndView mav = new ModelAndView();
                   Map<String, Object> gbmap = new HashMap<String, Object>();
                   gbmap.put("page", pageNo);
                   gbmap.put("category", category);
                   gbmap.put("gbtable", gLeaderId);
                   gbmap.put("keyText", keyText);
                   GListVO glvo = groupBoardService.findCategorizedList(gbmap);
                   Map<String, Object> map2 = getGroupHomeInfo(gLeaderId, session);
                   map2.put("hidden", "categoryfind");
                   map2.put("keyText", keyText);
                   map2.put("category", category);
                   map2.put("glvo", glvo);
                   mav.setViewName("group_board_list");
                   mav.addObject("map", map2);
                   return mav;
                }
            
            
   }