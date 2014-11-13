package com.tanwar.classcourt.bo;

import java.io.Serializable;
import java.util.Arrays;

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
@Table(name = "chapter_master")
public class CopyOfChapterBO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3716479800406678656L;

	@Id
	@Column(name = "chapter_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int chapterId;

	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, targetEntity=SubjectBO.class, optional=false, fetch=FetchType.EAGER)
    @JoinColumn(name="subject_id", nullable=false, updatable=false,unique=false)
	private SubjectBO subjectBO;

	@Column(name = "chapter_title")
	private String chapterTitle;
	
	@Column(name = "chapter_content")
	private String chatperContent;


	public int getChapterId() {
		return chapterId;
	}

	public void setChapterId(int chapterId) {
		this.chapterId = chapterId;
	}

	public String getChapterTitle() {
		return chapterTitle;
	}

	public void setChapterTitle(String chapterTitle) {
		this.chapterTitle = chapterTitle;
	}

	public SubjectBO getSubjectBO() {
		return subjectBO;
	}

	public void setSubjectBO(SubjectBO subjectBO) {
		this.subjectBO = subjectBO;
	}

	public String getChatperContent() {
		return chatperContent;
	}

	public void setChatperContent(String chatperContent) {
		this.chatperContent = chatperContent;
	}

	@Override
	public String toString() {
		return "ChapterBO [chapterId=" + chapterId + ", chapterTitle=" + chapterTitle + ", chatperContent=" + chatperContent + ", subjectBO=" + subjectBO + "]";
	}

	
	
}
