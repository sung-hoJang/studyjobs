package org.sjac.model;

public class BoardVO {
	private int no;
	private String category;
	private String content;
	private String title;
	private MemberVO memberVO;
	private String myDate;
	private int hits;
	private int ref; 
	private int restep;
	private int relevel;
	private int parent;
	
	public BoardVO() {
		super();
	}
	
	public BoardVO(int no, String category, String content, String title,
			MemberVO memberVO, String myDate, int hits, int ref, int restep,
			int relevel, int parent) {
		super();
		this.no = no;
		this.category = category;
		this.content = content;
		this.title = title;
		this.memberVO = memberVO;
		this.myDate = myDate;
		this.hits = hits;
		this.ref = ref;
		this.restep = restep;
		this.relevel = relevel;
		this.parent = parent;
	}
	
	public int getNo() {
		return no;
	}
	
	public void setNo(int no) {
		this.no = no;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public MemberVO getMemberVO() {
		return memberVO;
	}
	
	public void setMemberVO(MemberVO memberVO) {
		this.memberVO = memberVO;
	}
	
	public String getMyDate() {
		return myDate;
	}
	
	public void setMyDate(String myDate) {
		this.myDate = myDate;
	}
	
	public int getHits() {
		return hits;
	}
	
	public void setHits(int hits) {
		this.hits = hits;
	}
	
	public int getRef() {
		return ref;
	}

	public void setRef(int ref) {
		this.ref = ref;
	}

	public int getRestep() {
		return restep;
	}

	public void setRestep(int restep) {
		this.restep = restep;
	}

	public int getRelevel() {
		return relevel;
	}

	public void setRelevel(int relevel) {
		this.relevel = relevel;
	}
	
	public int getParent() {
		return parent;
	}
	public void setParent(int parent) {
		this.parent = parent;
	}
	
	@Override
	public String toString() {
		return "BoardVO [no=" + no + ", category=" + category + ", content="
				+ content + ", title=" + title + ", memberVO=" + memberVO
				+ ", myDate=" + myDate + ", hits=" + hits + ", ref=" + ref
				+ ", restep=" + restep + ", relevel=" + relevel + ", parent="
				+ parent + "]";
	}
	
}
