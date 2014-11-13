package com.tanwar.classcourt.bo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="revision_notes")
public class RevisionNotesBO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6905749354944551656L;

	@Id
	@Column(name = "revision_notes_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int revisionNotesId;
	
	@Column(name="revision_blob")
	private byte[] revisionBlob;
	
	
	public int getRevisionNotesId() {
		return revisionNotesId;
	}

	public void setRevesionNotesId(int revisionNotesId) {
		this.revisionNotesId = revisionNotesId;
	}

	public byte[] getRevisionBlob() {
		return revisionBlob;
	}

	public void setRevisionBlob(byte[] revisionBlob) {
		this.revisionBlob = revisionBlob;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "RevisionNotesBO [revisionNotesId=" + revisionNotesId + ", revisionBlob=" + revisionBlob + "]";
	}
	
}
