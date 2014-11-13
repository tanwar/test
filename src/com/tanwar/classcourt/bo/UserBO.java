package com.tanwar.classcourt.bo;

import java.io.Serializable;
import java.util.Arrays;
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
@Table(name="user_master")
public class UserBO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2764876371362745472L;

	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="name")
	private String name;
	
	@Column(name="user_image")
	private byte[] userImage;
	
	@Column(name="email_id")
	private String emailId;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, targetEntity=ClassBO.class, optional=false, fetch=FetchType.EAGER)
    @JoinColumn(name="class_id", nullable=false, updatable=false,unique=false)
	private ClassBO classBO;
	
	@Column(name="user_type")
	private String userType;
	
	@Column(name="mobile")
	private String mobile;
	
	@Column(name="created_on")
	private Date createdOn;
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public byte[] getUserImage() {
		return userImage;
	}

	public void setUserImage(byte[] userImage) {
		this.userImage = userImage;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public ClassBO getClassBO() {
		return classBO;
	}

	public void setClassBO(ClassBO classBO) {
		this.classBO = classBO;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserBO [classBO=" + classBO + ", createdOn=" + createdOn + ", emailId=" + emailId + ", mobile=" + mobile + ", name=" + name + ", password=" + password + ", userId=" + userId + ", userImage=" + Arrays.toString(userImage) + ", userType=" + userType + ", username=" + username + "]";
	}

}
