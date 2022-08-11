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

import com.exam.modals.Exam.Category;
import com.exam.modals.Exam.Question;
import com.exam.modals.Exam.Quiz;
import com.exam.services.CategoryService;
import com.exam.services.QuestionService;

@RestController
@CrossOrigin
@RequestMapping("/question")
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;
	
	@GetMapping("/test")
	public String categoryTest() {
		return "category test";
	}
	
	// add category
	
	@PostMapping("/add")
	public ResponseEntity<?> addCategory(@RequestBody Question q){
		Question c=this.questionService.addQuestion(q);
		return ResponseEntity.ok(c);
	}
	
	// get mapping
	
	@GetMapping("/get/{id}")
	public Question getCategory(@PathVariable("id") long id){

		return this.questionService.getQuestion(id);
	}
	
	// get All Categories
	@GetMapping("/get-all")
	public List<Question> getAllCategory(){
		return this.questionService.getAllQuestions();
	}
	
	// update category
	@PutMapping("/update")
	public Question updateCategory(@RequestBody Question q){
		return this.questionService.updateQuestion(q);
	}
	
	@GetMapping("/quiz/{qid}")
	public List<Question> getQuestionsofQuiz(@PathVariable("qid") long qid){
		return this.questionService.getQuestionOfQuiz(qid);
	}
	
	
	
	
	


}
