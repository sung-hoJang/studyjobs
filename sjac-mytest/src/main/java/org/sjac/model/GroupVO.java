package org.sjac.model;

public class GroupVO {
//	private String gLeaderId;
	private MemberVO memberVO;
	private String gName;
	private SubjectVO subjectVO;
	private String gInfo;
	private int gCount;
	private String gLocation;
	private String gDate;
	private int curMember;
	
	public GroupVO() {
		super();
	}

	public GroupVO(MemberVO memberVO, String gName, SubjectVO subjectVO,
			String gInfo, int gCount, String gLocation, String gDate,
			int curMember) {
		super();
		this.memberVO = memberVO;
		this.gName = gName;
		this.subjectVO = subjectVO;
		this.gInfo = gInfo;
		this.gCount = gCount;
		this.gLocation = gLocation;
		this.gDate = gDate;
		this.curMember = curMember;
	}

	public MemberVO getMemberVO() {
		return memberVO;
	}

	public void setMemberVO(MemberVO memberVO) {
		this.memberVO = memberVO;
	}

	public String getgName() {
		return gName;
	}

	public void setgName(String gName) {
		this.gName = gName;
	}

	public SubjectVO getSubjectVO() {
		return subjectVO;
	}

	public void setSubjectVO(SubjectVO subjectVO) {
		this.subjectVO = subjectVO;
	}

	public String getgInfo() {
		return gInfo;
	}

	public void setgInfo(String gInfo) {
		this.gInfo = gInfo;
	}

	public int getgCount() {
		return gCount;
	}

	public void setgCount(int gCount) {
		this.gCount = gCount;
	}

	public String getgLocation() {
		return gLocation;
	}

	public void setgLocation(String gLocation) {
		this.gLocation = gLocation;
	}

	public String getgDate() {
		return gDate;
	}

	public void setgDate(String gDate) {
		this.gDate = gDate;
	}

	public int getCurMember() {
		return curMember;
	}

	public void setCurMember(int curMember) {
		this.curMember = curMember;
	}

	@Override
	public String toString() {
		return "GroupVO [memberVO=" + memberVO + ", gName=" + gName
				+ ", subjectVO=" + subjectVO + ", gInfo=" + gInfo + ", gCount="
				+ gCount + ", gLocation=" + gLocation + ", gDate=" + gDate
				+ ", curMember=" + curMember + "]";
	}

	
	
 }
