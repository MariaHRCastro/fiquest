package com.figroup.fiquiz.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.figroup.fiquiz.entities.Option;
import com.figroup.fiquiz.services.OptionService;

@RestController
@RequestMapping(value="/options")
public class OptionResource {

	@Autowired
	private OptionService service;
	
	@GetMapping
	public ResponseEntity<List<Option>> findAll(){
		List<Option> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Option> findById(@PathVariable Long id){
		Option obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	

}