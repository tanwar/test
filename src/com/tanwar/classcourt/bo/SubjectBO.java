package com.tanwar.classcourt.bo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="subject_master")
public class SubjectBO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3038687766851716391L;

	@Id
	@Column(name = "subject_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int subjectId;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, targetEntity=ClassBO.class, optional=false, fetch=FetchType.EAGER)
    @JoinColumn(name="class_id", nullable=false, updatable=false,unique=false)
	private ClassBO classBO;
	
	@Column(name="subject_name")
	private String subjectName;
	
	@Column(name="created_on")
	private Date createdOn;

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public ClassBO getClassBO() {
		return classBO;
	}

	public void setClassBO(ClassBO classBO) {
		this.classBO = classBO;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	@Override
	public String toString() {
		return "SubjectBO [classBO=" + classBO + ", createdOn=" + createdOn + ", subjectId=" + subjectId + ", subjectName=" + subjectName + "]";
	}
	
}
