package com.store.rule.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rule")
public class Rule {

	private Long id;
	private String name;
	private String conf1;
	private String conf2;
	private String conf3;
	private Date publishedOn;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	@Column(nullable = false)
	public String getName() {
		return name;
	}

	@Column(length = 15, nullable = false)
	public String getConf1() {
		return conf1;
	}

	@Column(length = 10)
	public String getConf2() {
		return conf2;
	}

	@Column(nullable = false)
	public String getConf3() {
		return conf3;
	}

	@Column(name = "published_date")
	public Date getPublishedOn() {
		return publishedOn;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setConf1(String conf1) {
		this.conf1 = conf1;
	}

	public void setConf2(String conf2) {
		this.conf2 = conf2;
	}

	public void setConf3(String conf3) {
		this.conf3 = conf3;
	}

	public void setPublishedOn(Date publishedOn) {
		this.publishedOn = publishedOn;
	}
	
	 @Override
	    public String toString() {
	        return "Rule [id=" + id + ", Name=" + name + "]";
	    }
}
