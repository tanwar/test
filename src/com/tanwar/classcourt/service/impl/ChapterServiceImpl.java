package com.tanwar.classcourt.service.impl;

import java.util.List;

import com.tanwar.classcourt.bo.ChapterBO;
import com.tanwar.classcourt.dao.ChapterDAO;
import com.tanwar.classcourt.service.ChapterService;

public class ChapterServiceImpl implements ChapterService {

	private ChapterDAO chapterDAO;
	

	public void setChapterDAO(ChapterDAO chapterDAO) {
		this.chapterDAO = chapterDAO;
	}

	@Override
	public void addChatper(String subjectId, String chapterTitle, String chapterContent) {
		chapterDAO.addChatper(subjectId, chapterTitle, chapterContent);
	}

	@Override
	public List<ChapterBO> getAllChapters(String subjectId) {
		return chapterDAO.getAllChapters(subjectId);
	}


	@Override
	public void deleteChapter(int chapterId) {
		chapterDAO.deleteChapter(chapterId);
		
	}
	

}
