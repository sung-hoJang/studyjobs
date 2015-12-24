package org.sjac.model;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public int write(BoardVO bvo) {
		return (Integer) sqlSessionTemplate.insert("board.write", bvo);
	}

	@Override
	public HashMap<String, List<BoardVO>> getBoardList(String pageNo) {
		HashMap<String, List<BoardVO>> map = new HashMap<String, List<BoardVO>>();
		List<BoardVO> announcementList = sqlSessionTemplate.selectList("board.getAnnouncementList");
		map.put("announcementList", announcementList);
		List<BoardVO> generalList = sqlSessionTemplate.selectList("board.getBoardList", pageNo);
		map.put("generalList", generalList);
		return map;
	}

	@Override
	public BoardVO showContent(int no) {
		BoardVO bvo = (BoardVO) sqlSessionTemplate.selectOne("board.showContent", no);
		return (BoardVO) sqlSessionTemplate.selectOne("board.showContent", no);
	}

	@Override
	public void updateCount(int no) {
		sqlSessionTemplate.update("board.updateCount", no);
	}

	@Override
	public void deleteBoard(String no) {
		sqlSessionTemplate.delete("board.deleteBoard", no);
	}

	@Override
	public void updateBoard(BoardVO bvo) {
		sqlSessionTemplate.update("board.updateBoard", bvo);
	}

	@Override
	public int totalContent() {
		return sqlSessionTemplate.selectOne("board.totalContent");
	}

	@Override
	public void updateRestep(int ref, int restep) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("ref", ref);
		map.put("restep", restep);
		sqlSessionTemplate.update("board.updateRestep", map);
	}

	@Override
	public void insertRefContent(BoardVO bvo) {
		sqlSessionTemplate.insert("board.writeReply", bvo);
	}

	@Override
	public void getCategory(BoardVO bvo) {
		bvo.setCategory((String) sqlSessionTemplate.selectOne(
				"board.getCategory", bvo));
	}

	@Override
	public void updateChildBeforeDelete(String no) {
		BoardVO bvo = sqlSessionTemplate.selectOne("board.getBoard", no);
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("ref", bvo.getRef());
		map.put("restep", bvo.getRestep());
		map.put("relevel", bvo.getRelevel()); 
		if(bvo.getRelevel()==0){
			sqlSessionTemplate.update("board.updateChild1", map);
		} else {
			List<Object> restepList = sqlSessionTemplate.selectList("board.findNextSibling", map);
			if(restepList.isEmpty()){
				sqlSessionTemplate.update("board.updateChild2", map);
			}else{
				map.put("siblingRestep", restepList.get(0));
				sqlSessionTemplate.update("board.updateChild3", map);
			}
		}
	}
	
	   @Override
	   public HashMap<String, List<BoardVO>> findBoardListByTitleAndContent(
	         String pageNo, String keyText) {
	      HashMap<String, List<BoardVO>> map = new HashMap<String, List<BoardVO>>();
	      List<BoardVO> announcementList = sqlSessionTemplate.selectList("board.getAnnouncementList");
	      map.put("announcementList", announcementList);
	      HashMap<String, String> paramMap = new HashMap<String, String>();
	      paramMap.put("pageNo", pageNo);
	      paramMap.put("keyText", keyText);
	      List<BoardVO> generalList = sqlSessionTemplate.selectList("board.findBoardListByTitleAndContent", paramMap);
	      map.put("generalList", generalList);
	      return map;
	   }
}