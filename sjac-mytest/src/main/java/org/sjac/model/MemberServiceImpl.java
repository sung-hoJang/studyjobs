package org.sjac.model;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
	@Resource
	private MemberDAO memberDAO;

	@Override
	public MemberVO findMemberById(String id) {
		return memberDAO.findMemberById(id);
	}

	@Override
	public MemberVO login(MemberVO vo) {
		return memberDAO.login(vo);
	}

	@Override
	public void register(MemberVO vo) {
		memberDAO.register(vo);
	}


	@Override
	public void updateMyInfo(MemberVO vo) {
		memberDAO.updateMyInfo(vo);
	}

	@Override
	public List<MemberVO> getAllMemberList() {
		return memberDAO.getAllMemberList();
	}

	@Override
	public List<StudyLocationVO> getAllStudyLocation() {
		return memberDAO.getAllStudyLocation();
	}

	@Override
	public int idcheck(String id) {
		int memberCount = 0;
		memberCount = memberDAO.idcheckFromDeleteMember(id);
		if (memberCount == 0) {
			memberCount = memberDAO.idcheck(id);
			if (memberCount == 0) {
				return memberCount;
			} else {
				memberCount = 1;
				return memberCount;
			}
		} else {
			return memberCount = 1;
		}
	}

	@Override
	public int allMemberCount() {
		return memberDAO.allMemberCount();
	}

	@Override
	public int allGroupCount() {
		return memberDAO.allGroupCount();
	}

	// ///////////////////////아이디 찾기, 비밀번호 찾기 ///////////////////////////
	@Override
	public MemberVO findIdForUser(MemberVO vo) {
		return memberDAO.findIdForUser(vo);
	}

	@Override
	public MemberVO findPasswordForUser(MemberVO vo) {
		return memberDAO.findPasswordForUser(vo);
	}
	
	   @Override
	   public int totalVisitor() {
	      return memberDAO.totalVisitor();
	   }

	   @Override
	   public void updateTotalVisitor() {
	      memberDAO.updateTotalVisitor();
	   }
	   
	   @Override
	   public void insertReason(Map<String, Object> map) {
	               memberDAO.insertReason(map);
	      
	   }

}
