package org.sjac.model;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAOImpl implements MemberDAO {
	@Resource
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public MemberVO findMemberById(String id) {
		return sqlSessionTemplate.selectOne("member.findMemberById", id);
	}

	@Override
	public MemberVO login(MemberVO vo) {
		return sqlSessionTemplate.selectOne("member.login", vo);
	}

	@Override
	public void register(MemberVO vo) {
		sqlSessionTemplate.insert("member.register", vo);
	}

	@Override
	public void updateMyInfo(MemberVO vo) {
		sqlSessionTemplate.update("member.updateMyInfo", vo);

	}

	@Override
	public List<MemberVO> getAllMemberList() {
		return sqlSessionTemplate.selectList("member.getAllMemberList");
	}

	@Override
	public List<StudyLocationVO> getAllStudyLocation() {
		return sqlSessionTemplate.selectList("member.getAllStudyLocation");
	}

	@Override
	public int idcheck(String id) {
		return sqlSessionTemplate.selectOne("member.idcheck", id);
	}

	@Override
	public int allMemberCount() {
		return sqlSessionTemplate.selectOne("member.allMemberCount");
	}

	@Override
	public int allGroupCount() {
		return sqlSessionTemplate.selectOne("group.allGroupCount");
	}

	@Override
	public int idcheckFromDeleteMember(String id) {
		return sqlSessionTemplate.selectOne("member.idcheckFromDeleteMember",
				id);
	}

	@Override
	public void moveToDeleteMemberTable(MemberVO mvo) {// 회원 삭제 테이블로 정보 이동
		sqlSessionTemplate.insert("member.moveToDeleteMemberTable", mvo);
	}

	@Override
	public void deleteMemberById(String id) {// 회원 삭제
		sqlSessionTemplate.delete("member.deleteMemberById", id);
	}

	@Override
	public MemberVO findIdForUser(MemberVO vo) {
		return sqlSessionTemplate.selectOne("member.findIdForUser", vo);
	}

	@Override
	public MemberVO findPasswordForUser(MemberVO vo) {
		return sqlSessionTemplate.selectOne("member.findPasswordForUser", vo);
	}
	
	@Override
	   public int totalVisitor() {
	      return sqlSessionTemplate.selectOne("report.totalVisitor");
	   }

	   @Override
	   public void updateTotalVisitor() {
	         sqlSessionTemplate.update("report.updateTotalVisitor");
	   }
	   
	   @Override
	   public void insertReason(Map<String, Object> map) {
	      sqlSessionTemplate.insert("member.insertReason",map);
	      
	   }

}
