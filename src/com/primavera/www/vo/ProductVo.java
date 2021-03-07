package com.primavera.www.vo;

import java.sql.Timestamp;

public class ProductVo {
	private int no;
	private String title;
	private String name;
	private String content;
	private String tel;
	private int price;
	private String address;
	private String fname;
	private int m_no;
	private Timestamp write_date;
	private Timestamp update_date;

	private String id;

	public ProductVo() {
		super();
	}

	public ProductVo(int no, String name, String content, String tel, int price, String address,int m_no ,String fname,
			 String id) {
		this.no = no;
		this.name = name;
		this.content = content;
		this.tel = tel;
		this.price = price;
		this.address = address;
		this.fname = fname;
		this.m_no = m_no;
		this.id = id;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public int getM_no() {
		return m_no;
	}

	public void setM_no(int m_no) {
		this.m_no = m_no;
	}

	public Timestamp getWrite_date() {
		return write_date;
	}

	public void setWrite_date(Timestamp write_date) {
		this.write_date = write_date;
	}

	public Timestamp getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(Timestamp update_date) {
		this.update_date = update_date;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
