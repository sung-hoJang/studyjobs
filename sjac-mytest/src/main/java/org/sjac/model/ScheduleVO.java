package org.sjac.model;

public class ScheduleVO {
	private int no;
	private String id;
	private String gLeaderId;
	private String scheduleDate;
	private String scheduleInfo;
	private int deadline;    // 남은 날짜 나타내는 변수
	private GroupVO groupVO;
	
	public ScheduleVO() {
		super();
	}

	public ScheduleVO(int no, String id, String gLeaderId, String scheduleDate,
			String scheduleInfo, int deadline, GroupVO groupVO) {
		super();
		this.no = no;
		this.id = id;
		this.gLeaderId = gLeaderId;
		this.scheduleDate = scheduleDate;
		this.scheduleInfo = scheduleInfo;
		this.deadline = deadline;
		this.groupVO = groupVO;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getgLeaderId() {
		return gLeaderId;
	}

	public void setgLeaderId(String gLeaderId) {
		this.gLeaderId = gLeaderId;
	}

	public String getScheduleDate() {
		return scheduleDate;
	}

	public void setScheduleDate(String scheduleDate) {
		this.scheduleDate = scheduleDate;
	}

	public String getScheduleInfo() {
		return scheduleInfo;
	}

	public void setScheduleInfo(String scheduleInfo) {
		this.scheduleInfo = scheduleInfo;
	}

	public int getDeadline() {
		return deadline;
	}

	public void setDeadline(int deadline) {
		this.deadline = deadline;
	}

	public GroupVO getGroupVO() {
		return groupVO;
	}

	public void setGroupVO(GroupVO groupVO) {
		this.groupVO = groupVO;
	}

	@Override
	public String toString() {
		return "ScheduleVO [no=" + no + ", id=" + id + ", gLeaderId="
				+ gLeaderId + ", scheduleDate=" + scheduleDate
				+ ", scheduleInfo=" + scheduleInfo + ", deadline=" + deadline
				+ ", groupVO=" + groupVO + "]";
	}



	
	
}
