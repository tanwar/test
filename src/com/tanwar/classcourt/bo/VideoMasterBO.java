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
@Table(name="video_master")
public class VideoMasterBO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6905749354944551656L;

	@Id
	@Column(name = "video_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int videoId;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, targetEntity=ChapterBO.class, optional=false, fetch=FetchType.EAGER)
    @JoinColumn(name="chapter_id", nullable=false, updatable=false,unique=false)
	private ChapterBO chapterBO;
	
	@Column(name="video_name")
	private String videoName;
	
	@Column(name="video_link")
	private String videoLink;
	
	@Column(name="video_blob")
	private byte[] videoBlob;

	public int getVideoId() {
		return videoId;
	}

	public void setVideoId(int videoId) {
		this.videoId = videoId;
	}

	public ChapterBO getChapterBO() {
		return chapterBO;
	}

	public void setChapterBO(ChapterBO chapterBO) {
		this.chapterBO = chapterBO;
	}

	public String getVideoName() {
		return videoName;
	}

	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}

	public String getVideoLink() {
		return videoLink;
	}

	public void setVideoLink(String videoLink) {
		this.videoLink = videoLink;
	}

	public byte[] getVideoBlob() {
		return videoBlob;
	}

	public void setVideoBlob(byte[] videoBlob) {
		this.videoBlob = videoBlob;
	}

	@Override
	public String toString() {
		return "VideoMasterBO [chapterBO=" + chapterBO + ", videoBlob=" + videoBlob + ", videoId=" + videoId + ", videoLink=" + videoLink + ", videoName=" + videoName + "]";
	}
	
}
