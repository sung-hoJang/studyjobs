package org.sjac.aop.model;

public class ReportVO {
	private String keyword;
	private int count;

	public ReportVO() {
	}

	public ReportVO(String keyword, int count) {
		this.keyword = keyword;
		this.count = count;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "ReportVO [keyword=" + keyword + ", count=" + count + "]";
	}

}
