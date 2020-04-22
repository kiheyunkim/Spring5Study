package com.kiheyunkim.kim.Course;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
<<<<<<< HEAD
@Entity
@Table(name = "COURSE")
=======

@Entity
@Table(name="COURSE")
>>>>>>> 7693aa97cb6c3669f9353477d86af0ee08591440
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
<<<<<<< HEAD
	@Column(name = "TITLE", length = 100, nullable = false)
=======
	@Column(name = "TITLE", length = 100, nullable = true)
>>>>>>> 7693aa97cb6c3669f9353477d86af0ee08591440
	private String title;
	
	@Column(name = "BEGIN_DATE")
	private Date beginDate;
	
	@Column(name = "END_DATE")
	private Date endDate;
	
	@Column(name = "FEE")
	private int fee;
	
	public Course() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}	
}