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
@Table(name="study_material_master")
public class StudyMaterialBO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6905749354944551656L;

	@Id
	@Column(name = "master_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int masterId;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, targetEntity=ChapterBO.class, optional=false, fetch=FetchType.EAGER)
    @JoinColumn(name="chapter_id", nullable=false, updatable=false,unique=false)
	private ChapterBO chapterBO;
	
	@Column(name="chapter_blob")
	private byte[] chapterBlob;
	
	
		public int getMasterId() {
		return masterId;
	}


	public void setMasterId(int masterId) {
		this.masterId = masterId;
	}


	public ChapterBO getChapterId() {
		return chapterBO;
	}


	public void setChapterId(ChapterBO chapterBO) {
		this.chapterBO = chapterBO;
	}


	public byte[] getChapterBlob() {
		return chapterBlob;
	}


	public void setChapterBlob(byte[] chapterBlob) {
		this.chapterBlob = chapterBlob;
	}


	@Override
	public String toString() {
		return "RevisionNotesBO [masterId=" + masterId + ", chapterBO=" + chapterBO + ", chapterBlob=" + chapterBlob + "]";
	}
	
}
