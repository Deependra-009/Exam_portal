package com.exam.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.exam.modals.Exam.Question;
import com.exam.modals.Exam.Quiz;

public interface QuestionService {
	
	public Question addQuestion(Question q);
	public Question updateQuestion(Question q);
	public List<Question> getAllQuestions();
	public Question getQuestion(long qid);
	public List<Question> getQuestionOfQuiz(long qid);
	public void deleteQuestion(long qid);
	

}
