package org.sjac.model;

public class GroupMemberVO {
	private MemberVO memberVO;
	private GroupVO groupVO;
	
	public GroupMemberVO() {
		super();
	}
	public GroupMemberVO(MemberVO memberVO, GroupVO groupVO) {
		super();
		this.memberVO = memberVO;
		this.groupVO = groupVO;
	}
	public MemberVO getMemberVO() {
		return memberVO;
	}
	public void setMemberVO(MemberVO memberVO) {
		this.memberVO = memberVO;
	}
	public GroupVO getGroupVO() {
		return groupVO;
	}
	public void setGroupVO(GroupVO groupVO) {
		this.groupVO = groupVO;
	}
	@Override
	public String toString() {
		return "GroupMemberVO [memberVO=" + memberVO + ", groupVO=" + groupVO
				+ "]";
	}
	
	
	
}
