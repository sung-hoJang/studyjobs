package org.sjac.model.cart;

public class CartReportVO {
	private String gleaderId;
	private int count;
	public CartReportVO() {
	
	}
	public CartReportVO(String gleaderId, int count) {
		super();
		this.gleaderId = gleaderId;
		this.count = count;
	}
	public String getGleaderId() {
		return gleaderId;
	}
	public void setGleaderId(String gleaderId) {
		this.gleaderId = gleaderId;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "CartReportVO [gleaderId=" + gleaderId + ", count=" + count
				+ "]";
	}
	
}
