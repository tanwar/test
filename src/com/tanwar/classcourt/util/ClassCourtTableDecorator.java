package com.tanwar.classcourt.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.displaytag.decorator.TableDecorator;

import com.tanwar.classcourt.bo.BoardBO;
import com.tanwar.classcourt.bo.ChapterBO;
import com.tanwar.classcourt.bo.ClassBO;
import com.tanwar.classcourt.bo.SubjectBO;
import com.tanwar.classcourt.bo.UploadContentBO;

public class ClassCourtTableDecorator extends TableDecorator {
	public String getClassLink() {
		ClassBO classBO = (ClassBO) getCurrentRowObject();
		String link = "<a href=\"deleteClass.htm?classId=" + classBO.getClassId() + "&boardId=" + classBO.getBoardBO().getBoardId() + "\">delete</a>";
		return link;
	}

	public String getSubjectLink() {
		SubjectBO subjectBO = (SubjectBO) getCurrentRowObject();
		String link = "<a href=\"deleteSubject.htm?classId=" + subjectBO.getClassBO().getClassId() + "&subjectId=" + subjectBO.getSubjectId() + "\">delete</a>";
		return link;
	}

	public String getChapterLink() {
		ChapterBO chapterBO = (ChapterBO) getCurrentRowObject();
		String link = "<a href=\"deleteChapter.htm?chapterId=" + chapterBO.getChapterId() + "&subjectId=" + chapterBO.getSubjectBO().getSubjectId() + "\">delete</a>";
		return link;
	}
	
	public String getDeleteContentLink() {
		UploadContentBO uploadContentBO = (UploadContentBO) getCurrentRowObject();
		String link = "<a href=\"deleteContent.htm?chapterId=" + uploadContentBO.getChapterBO().getChapterId() + "&contentId=" + uploadContentBO.getContentId() + "\">delete</a>";
		return link;
	}

	public String getContentFileDownloadLink() {
		UploadContentBO uploadContentBO = (UploadContentBO) getCurrentRowObject();
		String link = "<a target='_blank' href=\"downloadContent.htm?contentId=" + uploadContentBO.getContentId() + "&chapterId=" + uploadContentBO.getChapterBO().getChapterId()+ "\">Download</a>";
		return link;
	}
	
	/*public String getChapterFileSize() {
		ChapterBO chapterBO = (ChapterBO) getCurrentRowObject();
		//ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(chapterBO.getChatperContent());
		FileInputStream f;
		String link=null;
		try {
			f = new FileInputStream(chapterBO.getChatperContent());
		
		double fileSize = f.available()/1024.0;
		
		 
		link = String.valueOf(fileSize);
		//link = link.substring(0, link.indexOf(".")+3)+"KB";
		
		
			f.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return link;
	}*/

	public String getBoardUpdateLink() {
		BoardBO boardBO = (BoardBO) getCurrentRowObject();
		String link = "<a href=javascript:updateBoard('" + boardBO.getBoardId() + "','" + boardBO.getBoardName().replaceAll(" ", "__") + "');>Update</a>";
		return link;
	}
}
