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
@Table(name="question_master")
public class QuestionBO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6905749354944551656L;

	@Id
	@Column(name = "question_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int questionId;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, targetEntity=SubjectBO.class, optional=false, fetch=FetchType.EAGER)
    @JoinColumn(name="subject_id", nullable=false, updatable=false,unique=false)
	private SubjectBO subjectBO;
	
	@Column(name="question_text")
	private String questionText;
	
	@Column(name="option_1")
	private String option1;
	
	@Column(name="option_2")
	private String option2;
	
	@Column(name="option_3")
	private String option3;
	
	@Column(name="option_4")
	private String option4;
	
	@Column(name="correct_answer")
	private String correctAnswer;
	
	@Column(name="question_type")
	private String questionType;


	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public SubjectBO getSubjectId() {
		return subjectBO;
	}

	public void setSubjectId(SubjectBO subjectBO) {
		this.subjectBO = subjectBO;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public String getOption3() {
		return option3;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}

	public String getOption4() {
		return option4;
	}

	public void setOption4(String option4) {
		this.option4 = option4;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	public String getQuestionType() {
		return questionType;
	}

	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "QuestionBO [questionId=" + questionId + ", subjectBO=" + subjectBO + ", questionText=" + questionText + ", option1=" + option1 
		+ ", option1=" + option2 + ", option3=" + option3 + ", option4=" + option4 + ", correctAnswer=" + correctAnswer + ", questionType=" + questionType + "]";
	}
	
}
