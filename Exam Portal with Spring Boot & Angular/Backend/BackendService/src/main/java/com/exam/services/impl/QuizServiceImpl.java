package com.exam.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.modals.Exam.Quiz;
import com.exam.repository.QuizRepository;
import com.exam.services.QuizService;
@Service
public class QuizServiceImpl implements QuizService {
	
	@Autowired
	private QuizRepository quizRepository;

	@Override
	public Quiz addQuiz(Quiz quiz) {
		// TODO Auto-generated method stub
		return this.quizRepository.save(quiz);
	}

	@Override
	public Quiz updateQuiz(Quiz quiz) {
		// TODO Auto-generated method stub
		return this.quizRepository.save(quiz);
	}

	@Override
	public List<Quiz> getQuizzes() {
		// TODO Auto-generated method stub
		return this.quizRepository.findAll();
	}

	@Override
	public Quiz getQuiz(long qid) {
		// TODO Auto-generated method stub
		return this.quizRepository.findById(qid).get();
	}

	@Override
	public void deleteQuiz(long qid) {
		// TODO Auto-generated method stub
		Quiz q=new Quiz();
		q.setQid(qid);
		this.quizRepository.delete(q);
		
	}

}
