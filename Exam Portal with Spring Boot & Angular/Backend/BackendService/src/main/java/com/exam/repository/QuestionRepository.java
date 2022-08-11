package com.exam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam.modals.Exam.Question;
import com.exam.modals.Exam.Quiz;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
	
	 public List<Question> findByQuiz(Quiz q);

}
