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
@Table(name="class_master")
public class ClassBO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6905749354944551656L;

	@Id
	@Column(name = "class_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int classId;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, targetEntity=BoardBO.class, optional=false, fetch=FetchType.EAGER)
    @JoinColumn(name="board_id", nullable=false, updatable=false,unique=false)
	private BoardBO boardBO;
	
	@Column(name="class_name")
	private String className;
	
	@Column(name="created_on")
	private Date createdOn;

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public BoardBO getBoardBO() {
		return boardBO;
	}

	public void setBoardBO(BoardBO boardBO) {
		this.boardBO = boardBO;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	@Override
	public String toString() {
		return "ClassBO [boardBO=" + boardBO + ", classId=" + classId + ", className=" + className + ", createdOn=" + createdOn + "]";
	}
	
}
