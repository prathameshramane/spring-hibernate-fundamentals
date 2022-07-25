package com.prathamesh.DemoHibAnnotations;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="alien_table")
public class Alien {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int aid;
	@Column(name="alien_name")
	private String aname;
	// @Transient // Doesn't Save in database
	private String color;
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
}
