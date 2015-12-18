package org.sjac.model;

public class StudyLocationVO {
	private String gLocation;

	public StudyLocationVO() {
		super();
	}

	public StudyLocationVO(String gLocation) {
		super();
		this.gLocation = gLocation;
	}

	public String getgLocation() {
		return gLocation;
	}

	public void setgLocation(String gLocation) {
		this.gLocation = gLocation;
	}

	@Override
	public String toString() {
		return "StudyLocationVO [gLocation=" + gLocation + "]";
	}
	
	
}
