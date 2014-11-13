package com.tanwar.classcourt.bo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "board_master")
public class BoardBO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3716479800406678656L;

	@Id
	@Column(name = "board_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int boardId;

	@Column(name = "board_name")
	private String boardName;

	@Column(name = "created_on")
	private Date createdOn;

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public String getBoardName() {
		return boardName;
	}

	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "BoardBO [boardId=" + boardId + ", boardName=" + boardName + ", createdOn=" + createdOn + "]";
	}

}
