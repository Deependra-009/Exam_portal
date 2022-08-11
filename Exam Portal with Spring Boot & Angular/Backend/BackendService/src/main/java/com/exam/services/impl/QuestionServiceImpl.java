package com.exam.services.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.modals.Exam.Question;
import com.exam.modals.Exam.Quiz;
import com.exam.repository.QuestionRepository;
import com.exam.services.QuestionService;
import com.exam.services.QuizService;

@Service
public class QuestionServiceImpl implements QuestionService {
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private QuizService quizService;

	@Override
	public Question addQuestion(Question q) {
		// TODO Auto-generated method stub
		return this.questionRepository.save(q);
	}

	@Override
	public Question updateQuestion(Question q) {
		// TODO Auto-generated method stub
		return this.questionRepository.save(q);
	}

	@Override
	public List<Question> getAllQuestions() {
		// TODO Auto-generated method stub
		return this.questionRepository.findAll();
	}

	@Override
	public Question getQuestion(long qid) {
		// TODO Auto-generated method stub
		return this.questionRepository.findById(qid).get();
	}

	@Override
	public List<Question> getQuestionOfQuiz(long qid) {
		// TODO Auto-generated method stub
//		Quiz q=new Quiz();
//		q.setQid(qid);
//		return this.questionRepository.findByQuiz(q);
		
		Quiz q = this.quizService.getQuiz(qid);
		Set<Question> questions = q.getQuestions();
		List<Question> list=new ArrayList<>(questions);
		
		if(list.size()>Integer.parseInt(q.getNoOfQuestions())) {
			list=list.subList(0, Integer.parseInt(q.getNoOfQuestions()+1));
		}
		Collections.shuffle(list);
		return list;
		
		
	}

	@Override
	public void deleteQuestion(long qid) {
		// TODO Auto-generated method stub
		Question q=new Question();
		q.setQuesId(qid);
		this.questionRepository.delete(q);
		
	}

}
