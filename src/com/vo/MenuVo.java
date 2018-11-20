package com.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tiffin_menu")
public class MenuVo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="menu_id")
	private int menu_id;
	
	@Column(name="menu_desc")
	private String menu_desc;
	
	@Column(name="menu_items")
	private String menu_items;
	
	@Column(name="menu_price")
	private int menu_price;
	@Column(name="current")
	private int current;
	
	
	@ManyToOne
	TiffinVo tiffinvo;

	public int getCurrent() {
		return current;
	}

	public void setCurrent(int current) {
		this.current = current;
	}

	@ManyToOne
	TypeVo typevo;
	
	public int getMenu_id() {
		return menu_id;
	}

	public void setMenu_id(int menu_id) {
		this.menu_id = menu_id;
	}

	public String getMenu_items() {
		return menu_items;
	}

	public void setMenu_items(String menu_items) {
		this.menu_items = menu_items;
	}

	public int getMenu_price() {
		return menu_price;
	}

	public void setMenu_price(int menu_price) {
		this.menu_price = menu_price;
	}

	public String getMenu_desc() {
		return menu_desc;
	}

	public void setMenu_desc(String menu_desc) {
		this.menu_desc = menu_desc;
	}

	public TypeVo getTypevo() {
		return typevo;
	}

	public void setTypevo(TypeVo typevo) {
		this.typevo = typevo;
	}

	public TiffinVo getTiffinvo() {
		return tiffinvo;
	}

	public void setTiffinvo(TiffinVo tiffinvo) {
		this.tiffinvo = tiffinvo;
	}
	
	
	
	

}
