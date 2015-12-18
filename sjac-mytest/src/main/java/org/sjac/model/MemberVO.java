package org.sjac.model;

public class MemberVO {
private String id;
private String password;
private String name;
private String location;
private String tel;
private String gender;
private String birthdate;

public MemberVO() {
	super();
}

public MemberVO(String id){
	   super();
	   this.id = id;
}

public MemberVO(String id, String password, String name, String location,
		String tel, String gender, String birthdate) {
	super();
	this.id = id;
	this.password = password;
	this.name = name;
	this.location = location;
	this.tel = tel;
	this.gender = gender;
	this.birthdate = birthdate;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}
public String getTel() {
	return tel;
}
public void setTel(String tel) {
	this.tel = tel;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getBirthdate() {
	return birthdate;
}
public void setBirthdate(String birthdate) {
	this.birthdate = birthdate;
}
@Override
public String toString() {
	return "MemberVO [id=" + id + ", password=" + password + ", name=" + name
			+ ", location=" + location + ", tel=" + tel + ", gender=" + gender
			+ ", birthdate=" + birthdate + "]";
}



}
