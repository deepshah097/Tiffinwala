package com.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tiffinwala")
public class TiffinVo {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="tiffin_id")
	private int tiffin_id;
	
	@Column(name="tiffin_address")
	private String tiffin_address;
	
	@Column(name="tiffin_email")
	private String tiffin_email;
	
	public TiffinVo() {
		super();
	}

	public TiffinVo(String tiffin_address, String tiffin_email, int tiffin_flag, String tiffin_mobile,
			String tiffin_name, String image, int tiffin_pincode, CityVo cityvo, UserVo uservo) {
		super();
		this.tiffin_address = tiffin_address;
		this.tiffin_email = tiffin_email;
		this.tiffin_flag = tiffin_flag;
		this.tiffin_mobile = tiffin_mobile;
		this.tiffin_name = tiffin_name;
		this.image = image;
		this.tiffin_pincode = tiffin_pincode;
		this.cityvo = cityvo;
		this.uservo = uservo;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Column(name="tiffin_flag")
	private int tiffin_flag;
	
	@Column(name="tiffin_mobile")
	private String tiffin_mobile;
	
	@Column(name="tiffin_name")
	private String tiffin_name;
	
	@Column(name="image")
	private String image;
	
	@Column(name="tiffin_pincode")
	private int tiffin_pincode;
	
	@ManyToOne
	private CityVo cityvo;
	
	@ManyToOne
	private UserVo uservo;
	

	public int getTiffin_id() {
		return tiffin_id;
	}

	public void setTiffin_id(int tiffin_id) {
		this.tiffin_id = tiffin_id;
	}

	public String getTiffin_name() {
		return tiffin_name;
	}

	public void setTiffin_name(String tiffin_name) {
		this.tiffin_name = tiffin_name;
	}

	public String getTiffin_address() {
		return tiffin_address;
	}

	public void setTiffin_address(String tiffin_address) {
		this.tiffin_address = tiffin_address;
	}

	public int getTiffin_pincode() {
		return tiffin_pincode;
	}

	public void setTiffin_pincode(int tiffin_pincode) {
		this.tiffin_pincode = tiffin_pincode;
	}

	public String getTiffin_mobile() {
		return tiffin_mobile;
	}

	public void setTiffin_mobile(String tiffin_mobile) {
		this.tiffin_mobile = tiffin_mobile;
	}

	public String getTiffin_email() {
		return tiffin_email;
	}

	public void setTiffin_email(String tiffin_email) {
		this.tiffin_email = tiffin_email;
	}

	public int getTiffin_flag() {
		return tiffin_flag;
	}

	public void setTiffin_flag(int tiffin_flag) {
		this.tiffin_flag = tiffin_flag;
	}

	public UserVo getUservo() {
		return uservo;
	}

	public void setUservo(UserVo uservo) {
		this.uservo = uservo;
	}

	public CityVo getCityvo() {
		return cityvo;
	}

	public void setCityvo(CityVo cityvo) {
		this.cityvo = cityvo;
	}
	
}
