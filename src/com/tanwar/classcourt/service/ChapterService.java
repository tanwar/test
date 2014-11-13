package com.tanwar.classcourt.service;

import java.util.List;

import com.tanwar.classcourt.bo.ChapterBO;


public interface ChapterService {
	
	public void addChatper(String subjectId, String chapterTitle, String chapterContent);
	public List<ChapterBO> getAllChapters(String subjectId);
	public void deleteChapter(int chapterId);

}
