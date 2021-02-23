package com.primavera.www.vo;

import java.sql.Timestamp;

public class MemberVo {
	
	private int no;
	private String id;
	private String name;
	private String password;
	private String email;
	private String gender;
	private String tel;
	private Timestamp joinDate;
	
	public MemberVo() {
	}

	public MemberVo(String id, String name, String password, String email, String gender, String tel) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.gender = gender;
		this.tel = tel;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Timestamp getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Timestamp joinDate) {
		this.joinDate = joinDate;
	}

	
}//MemberVo
