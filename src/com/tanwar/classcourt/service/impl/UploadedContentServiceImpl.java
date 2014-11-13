package com.tanwar.classcourt.service.impl;

import java.util.List;

import com.tanwar.classcourt.bo.UploadContentBO;
import com.tanwar.classcourt.dao.UploadedContentDAO;
import com.tanwar.classcourt.service.UploadedContentService;

public class UploadedContentServiceImpl implements UploadedContentService {

	private UploadedContentDAO uploadDAO;

	public UploadedContentDAO getUploadDAO() {
		return uploadDAO;
	}

	public void setUploadDAO(UploadedContentDAO uploadDAO) {
		this.uploadDAO = uploadDAO;
	}

	@Override
	public void addContent(String chapterId, String contentName, String contentType, String chapterContentFileName, byte[] content, int uploadedByUser) {
		uploadDAO.addContent(chapterId, contentName, contentType, chapterContentFileName, content, uploadedByUser);
	}

	@Override
	public List<UploadContentBO> getAllContent(String chapterId) {
		return uploadDAO.getAllContent(chapterId);
	}
	
	@Override
	public List<UploadContentBO> getAllContent(String chapterId, String contentType) {
		return uploadDAO.getAllContent(chapterId, contentType);
	}
	
	@Override
	public List<UploadContentBO> getAllContent() {
		return uploadDAO.getAllContent();
	}

	@Override
	public void deleteContent(int chapterId) {
		uploadDAO.deleteContent(chapterId);

	}

}
