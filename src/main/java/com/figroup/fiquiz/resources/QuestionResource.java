package com.figroup.fiquiz.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.figroup.fiquiz.entities.Option;
import com.figroup.fiquiz.entities.Question;
import com.figroup.fiquiz.services.QuestionService;
	
@RestController
@RequestMapping(value="/questions")
public class QuestionResource {

	@Autowired
	private QuestionService service;
	
	@GetMapping
	public ResponseEntity<List<Question>> findAll(){
		List<Question> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Question> findById(@PathVariable Long id){
		Question obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value = "/right/{id}")
	public ResponseEntity<Option> findRightOption(@PathVariable Long id){
		Option obj = service.getRight(id);
		return ResponseEntity.ok().body(obj);
	}
	
	
	/*
	@GetMapping(value="/random")
	public Question getQuestion(){
		Optional<Question> question = service.getQuestion();
		return question.get();
	}
	*/
	
	@PostMapping(value = "/save")
	public ResponseEntity<Question> insertQuestion(@RequestBody Question question){
		service.insertQuestion(question);
		return ResponseEntity.ok().body(question);
	}
	
	@DeleteMapping(value="/delete/{id}")
	public ResponseEntity<String> deleteQuestion(@PathVariable Long id){
		service.deleteQuestion(id);
		return new ResponseEntity<String>("Question "+ id+ " deleted!",HttpStatus.OK);
	}
	
	@PostMapping(value = "/update")
	public ResponseEntity<Question> updateQuestion(@RequestBody Question question){
		service.insertQuestion(question);
		return ResponseEntity.ok().body(question);
	}
	
		
}