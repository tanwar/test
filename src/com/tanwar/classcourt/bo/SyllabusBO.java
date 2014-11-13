package com.tanwar.classcourt.bo;

import java.io.Serializable;

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
@Table(name="syllabus")
public class SyllabusBO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6905749354944551656L;

	@Id
	@Column(name = "syllabus_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int syllabusId;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, targetEntity=SubjectBO.class, optional=false, fetch=FetchType.EAGER)
    @JoinColumn(name="subject_id", nullable=false, updatable=false,unique=false)
	private SubjectBO subjectBO;
	
	@Column(name="syllabus_content")
	private byte[] syllabusBlob;

	public int getSyllabusId() {
		return syllabusId;
	}

	public void setSyllabusId(int syllabusId) {
		this.syllabusId = syllabusId;
	}

	public SubjectBO getSubjectBO() {
		return subjectBO;
	}

	public void setSubjectBO(SubjectBO subjectBO) {
		this.subjectBO = subjectBO;
	}

	public byte[] getSyllabusBlob() {
		return syllabusBlob;
	}

	public void setSyllabusBlob(byte[] syllabusBlob) {
		this.syllabusBlob = syllabusBlob;
	}

	@Override
	public String toString() {
		return "SyllabusBO [subjectBO=" + subjectBO + ", syllabusBlob=" + syllabusBlob + ", syllabusId=" + syllabusId + "]";
	}
	
}
