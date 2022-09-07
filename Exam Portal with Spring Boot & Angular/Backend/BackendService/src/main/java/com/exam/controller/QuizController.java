 package com.exam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.modals.Exam.Quiz;
import com.exam.services.QuizService;

@RestController
@CrossOrigin
@RequestMapping("/quiz")
public class QuizController {

	@Autowired
	private QuizService quizService;

	@GetMapping("/test")
	public String testQuiz() {
		return "quiz test";
	}

	// add Quiz

	@PostMapping("/add")
	public ResponseEntity<?> addQuiz(@RequestBody Quiz q) {
		Quiz c = this.quizService.addQuiz(q);
		return ResponseEntity.ok(c);
	}

	// get mapping

	@GetMapping("/get/{id}")
	public Quiz getQuiz(@PathVariable("id") long id) {

		return this.quizService.getQuiz(id);
	}

	// get All Quiz
	@GetMapping("/get-all")
	public List<Quiz> getAllQuiz() {
		return this.quizService.getQuizzes();
	}

	// update Quiz
	@PutMapping("/update")
	public Quiz updateQuiz(@RequestBody Quiz category) {
		return this.quizService.updateQuiz(category);
	}

	// delete Quiz

	@DeleteMapping("/delete/{id}")
	public void deleteQuiz(@PathVariable("id") long id) {
		this.quizService.deleteQuiz(id);
	}

}
