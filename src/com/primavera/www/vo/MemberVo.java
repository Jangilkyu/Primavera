package com.primavera.www.vo;

import java.sql.Timestamp;

public class MemberVo {
	
	private int no;
	private String id;
	private String name;
	private String password;
	private String email;
	private String gender;
	private String post1;
	private String post2;
	private String post3;
	private String tel1;
	private String tel2;
	private String tel3;
	private Timestamp joinDate;
	private String manager;
	
	public MemberVo() {
	}

	public MemberVo(int no, String id, String name, String password, String email, String gender, String post1,
			String post2, String post3, String tel1, String tel2, String tel3, Timestamp joinDate) {
		this.no = no;
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.gender = gender;
		this.post1 = post1;
		this.post2 = post2;
		this.post3 = post3;
		this.tel1 = tel1;
		this.tel2 = tel2;
		this.tel3 = tel3;
		this.joinDate = joinDate;
	}
	
	public MemberVo(String id, String name, String password, String email, String gender, String post1, String post2,
			String post3, String tel1, String tel2, String tel3) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.gender = gender;
		this.post1 = post1;
		this.post2 = post2;
		this.post3 = post3;
		this.tel1 = tel1;
		this.tel2 = tel2;
		this.tel3 = tel3;
	}

	public MemberVo(String id, String name, String email, String post1, String post2, String post3, String tel1,
			String tel2, String tel3) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.post1 = post1;
		this.post2 = post2;
		this.post3 = post3;
		this.tel1 = tel1;
		this.tel2 = tel2;
		this.tel3 = tel3;
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

	public String getTel1() {
		return tel1;
	}

	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}

	public String getTel2() {
		return tel2;
	}

	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}

	public String getTel3() {
		return tel3;
	}

	public void setTel3(String tel3) {
		this.tel3 = tel3;
	}

	public String getPost1() {
		return post1;
	}

	public void setPost1(String post1) {
		this.post1 = post1;
	}

	public String getPost2() {
		return post2;
	}

	public void setPost2(String post2) {
		this.post2 = post2;
	}

	public String getPost3() {
		return post3;
	}

	public void setPost3(String post3) {
		this.post3 = post3;
	}

	public Timestamp getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Timestamp joinDate) {
		this.joinDate = joinDate;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

}//MemberVo
