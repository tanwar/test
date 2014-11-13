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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="uploaded_item")
public class UploadContentBO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4172497396914394138L;

	@Id
	@Column(name = "content_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int contentId;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch=FetchType.EAGER, targetEntity=ChapterBO.class)
	@JoinColumn(name="chapter_id",nullable=false, updatable=false,unique=false)
	private ChapterBO chapterBO;
	
	@Column(name = "content_name")
	private String contentName;
	
	@Column(name = "content_filename")
	private String contentFileName;
	
	@Column(name = "content_type")
	private String contentType;
	

	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, targetEntity=UserBO.class, optional=false, fetch=FetchType.EAGER)
    @JoinColumn(name="user_id", nullable=false, updatable=false,unique=false)
	private UserBO addedbyUserId;
	
	@Column(name = "content")
	private byte[] content;

	public int getContentId() {
		return contentId;
	}

	public void setContentId(int contentId) {
		this.contentId = contentId;
	}

	public ChapterBO getChapterBO() {
		return chapterBO;
	}

	public void setChapterBO(ChapterBO chapterBO) {
		this.chapterBO = chapterBO;
	}

	public String getContentName() {
		return contentName;
	}

	public void setContentName(String contentName) {
		this.contentName = contentName;
	}

	public String getContentFileName() {
		return contentFileName;
	}

	public void setContentFileName(String contentFileName) {
		this.contentFileName = contentFileName;
	}

	public UserBO getAddedbyUserId() {
		return addedbyUserId;
	}

	public void setAddedbyUserId(UserBO addedbyUserId) {
		this.addedbyUserId = addedbyUserId;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	@Override
	public String toString() {
		return "UploadContentBO [addedbyUserId=" + addedbyUserId + ", chapterBO=" + chapterBO + ", content=" + Arrays.toString(content) + ", contentFileName=" + contentFileName + ", contentId=" + contentId + ", contentName=" + contentName + ", contentType=" + contentType + "]";
	}

}
