package org.sjac.model;

public class GroupJoinVO {
	private int gjNo;
	private MemberVO memberVO;
	private String gjTitle;
	private String gjContent;
	private GroupVO groupVO;
	
	public GroupJoinVO() {
		super();
	}
	public GroupJoinVO(int gjNo, MemberVO memberVO, String gjTitle,
			String gjContent, GroupVO groupVO) {
		super();
		this.gjNo = gjNo;
		this.memberVO = memberVO;
		this.gjTitle = gjTitle;
		this.gjContent = gjContent;
		this.groupVO = groupVO;
	}
	public int getGjNo() {
		return gjNo;
	}
	public void setGjNo(int gjNo) {
		this.gjNo = gjNo;
	}
	public MemberVO getMemberVO() {
		return memberVO;
	}
	public void setMemberVO(MemberVO memberVO) {
		this.memberVO = memberVO;
	}
	public String getGjTitle() {
		return gjTitle;
	}
	public void setGjTitle(String gjTitle) {
		this.gjTitle = gjTitle;
	}
	public String getGjContent() {
		return gjContent;
	}
	public void setGjContent(String gjContent) {
		this.gjContent = gjContent;
	}
	public GroupVO getGroupVO() {
		return groupVO;
	}
	public void setGroupVO(GroupVO groupVO) {
		this.groupVO = groupVO;
	}
	@Override
	public String toString() {
		return "GroupJoinVO [gjNo=" + gjNo + ", memberVO=" + memberVO
				+ ", gjTitle=" + gjTitle + ", gjContent=" + gjContent
				+ ", groupVO=" + groupVO + "]";
	}
	
	
	
}
