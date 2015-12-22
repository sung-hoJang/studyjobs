package org.sjac.controller;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.sjac.model.BoardService;
import org.sjac.model.BoardVO;
import org.sjac.model.MemberVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {

	@Resource(name = "boardServiceImpl")
	private BoardService boardService;

	// 자유게시판 글쓰기로 이동
	@RequestMapping("auth_board_show_write.do")
	public String boardShowWrite() {
		return "board_write";
	}

	// 자유게시판 글쓰기
	@RequestMapping(value = "auth_board_write.do", method = RequestMethod.POST)
	public ModelAndView boardWrite(HttpServletRequest request, BoardVO bvo) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			MemberVO mvo = (MemberVO) session.getAttribute("mvo");
			if (mvo != null) {
				bvo.setMemberVO(mvo);
			}
		}
		boardService.write(bvo);
		return new ModelAndView("redirect:auth_board_showContentNoHit.do?no="
				+ bvo.getNo());
	}

	// 글삭제
	@RequestMapping("auth_board_deleteBoard.do")
	public ModelAndView deleteBoard(String no) {
		boardService.deleteBoard(no);
		return new ModelAndView("board_list", "map",
				boardService.getBoardList("1"));
	}

	@RequestMapping("auth_board_updateView.do")
	public ModelAndView updateView(int no) {
		return new ModelAndView("board_update", "bvo",
				boardService.showContentNoHit(no));
	}

	// 자유 게시판 글 수정
	@RequestMapping("auth_board_update.do")
	public ModelAndView updateBoard(BoardVO bvo) {
		boardService.updateBoard(bvo);
		return new ModelAndView("board_show_content", "bvo",
				boardService.showContentNoHit(bvo.getNo()));
	}

	@RequestMapping("auth_board_show_content.do")
	public ModelAndView showContent(
			int no,
			@CookieValue(value = "sjacboard", required = false) String cookieValue,
			HttpServletResponse response) {
		BoardVO bvo = null;
		if (cookieValue == null) {
			response.addCookie(new Cookie("sjacboard", "|" + no + "|"));
			bvo = boardService.showContent(no);
		} else if (cookieValue.indexOf("|" + no + "|") == -1) {
			cookieValue += "|" + no + "|";
			// 글번호를 쿠키에 추가
			response.addCookie(new Cookie("sjacboard", cookieValue));
			bvo = boardService.showContent(no);
		} else {
			bvo = boardService.showContentNoHit(no);
		}
		return new ModelAndView("board_show_content", "bvo", bvo);
	}

	@RequestMapping("auth_board_showContentNoHit.do")
	public ModelAndView showContentNoHit(int no) {
		return new ModelAndView("board_show_content", "bvo",
				boardService.showContentNoHit(no));
	}

	// 자유 게시판 글 리스트 보기
	@RequestMapping("auth_board_list.do")
	public ModelAndView boardList(String pageNo) {
		return new ModelAndView("board_list", "map",
				boardService.getBoardList(pageNo));
	}

	/**
	 * 답변 폼을 보여 준다 client가 show_content.jsp에서 글을 보고 답변버튼을 클릭하면 답변할 폼을 보여준다. 
	 * 1. Client로 부터 답변할 글 번호(no)를 받는다. 
	 * 2. BoardService의 showContentNoHit(no) 를 호출하여 답변 원본 글의 데이터를 가진
	 *    BoardVO 객체를 받아온다. 
	 * 3. BoardVO객체(bvo)를 request scope에 넣고 reply_form.jsp로 수행을 넘긴다.
	 */
	@RequestMapping("auth_board_replyView.do")
	public ModelAndView replyView(int no) {
		return new ModelAndView("board_reply_form", "bvo",
				boardService.showContentNoHit(no));
	}

	/**
	 * 답변을 처리 
	 * 1. Client로 부터 답변할 글의 데이터들을 BoardVO로 받는다. 
	 * 2. BoardService의 reply(bvo)를 호출하여 답변처리를 한다. 
	 * 3. BoardVO객체를 request scope에 넣고 show_content.jsp로 수행을 넘긴다.
	 */
	@RequestMapping(value = "auth_board_reply.do", method = RequestMethod.POST)
	public ModelAndView reply(HttpServletRequest request, BoardVO bvo)
			throws Exception {
		HttpSession session = request.getSession(false);
		if (session != null) {
			MemberVO mvo = (MemberVO) session.getAttribute("mvo");
			if (mvo != null) {
				bvo.setMemberVO(mvo);
			}
		}
		boardService.reply(bvo);
		return new ModelAndView("redirect:auth_board_showContentNoHit.do?no="
				+ bvo.getNo());
	}


	// 자유 게시판 검색(제목+내용)
	@RequestMapping("auth_board_findBoardListByTitleAndContent.do")
	public ModelAndView findBoardListByTitleAndContent(String pageNo,
			String keyText) {
		return new ModelAndView("board_list", "map",
				boardService.findBoardListByTitleAndContent(pageNo, keyText));
	}

}