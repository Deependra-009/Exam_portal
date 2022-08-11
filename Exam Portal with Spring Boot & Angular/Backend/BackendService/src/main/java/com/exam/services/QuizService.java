package com.exam.services;

import java.util.List;

import com.exam.modals.Exam.Quiz;

public interface QuizService {
	
	public Quiz addQuiz(Quiz quiz);
	public Quiz updateQuiz(Quiz quiz);
	public List<Quiz> getQuizzes();
	public Quiz getQuiz(long qid);
	public void deleteQuiz(long qid);

}
