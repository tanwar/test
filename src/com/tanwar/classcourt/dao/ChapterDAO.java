package com.tanwar.classcourt.dao;

import java.util.List;

import com.tanwar.classcourt.bo.ChapterBO;


public interface ChapterDAO {
	
	public void addChatper(String subjectId, String chapterTitle, String chapterContent);
	public List<ChapterBO> getAllChapters(String subjectId);
	public void deleteChapter(int chapterId);

}
