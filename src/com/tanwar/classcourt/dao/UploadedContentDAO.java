package com.tanwar.classcourt.dao;

import java.util.List;

import com.tanwar.classcourt.bo.UploadContentBO;


public interface UploadedContentDAO {
	
	public void addContent(String chapterId, String contentName, String contentType, String chapterContentFileName, byte[] content, int uploadedByUser);
	public List<UploadContentBO> getAllContent(String chapterId);
	public List<UploadContentBO> getAllContent(String chapterId, String contentType);
	public List<UploadContentBO> getAllContent();
	public void deleteContent(int contentId);

}
