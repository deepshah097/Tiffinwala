package com.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ValueGenerationType;

@Entity
@Table(name="order_item")
public class OrderVo {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="order_id")
	private int order_id;
	
	@ManyToOne
	TiffinVo tiffinvo;
	
	@ManyToOne
	UserVo uservo;
	
	
	@ManyToOne
	MenuVo menuvo;

	@Column(name="quantity")
	private int quantity;
	
	@Column(name="amount")
	private int amount;
	
	
	@Column(name="date")
	private String date;
	
	@Column(name="order_flag")
	private int order_flag;

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getOrder_qty() {
		return quantity;
	}

	public void setOrder_qty(int quantity) {
		this.quantity = quantity;
	}

	public int getOrder_amount() {
		return amount;
	}

	public void setOrder_amount(int amount) {
		this.amount = amount;
	}

	public String getOrder_date() {
		return date;
	}

	public void setOrder_date(String date) {
		this.date = date;
	}

	public int getOrder_flag() {
		return order_flag;
	}

	public void setOrder_flag(int order_flag) {
		this.order_flag = order_flag;
	}

	public TiffinVo getTiffinvo() {
		return tiffinvo;
	}

	public void setTiffinvo(TiffinVo tiffinvo) {
		this.tiffinvo = tiffinvo;
	}

	public UserVo getUservo() {
		return uservo;
	}

	public void setUservo(UserVo uservo) {
		this.uservo = uservo;
	}

	public MenuVo getMenuvo() {
		return menuvo;
	}

	public void setMenuvo(MenuVo menuvo) {
		this.menuvo = menuvo;
	}	
	
	
}
