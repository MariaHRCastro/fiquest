package com.figroup.fiquiz.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.figroup.fiquiz.entities.Option;
import com.figroup.fiquiz.repositories.OptionRepository;

@Service
public class OptionService {

	@Autowired
	private OptionRepository repository;
		
	public List<Option> findAll(){
		return repository.findAll();
	}
	
	public Option findById(Long id) {
		Optional<Option> obj =  repository.findById(id);
		return obj.get();
	}
	
	
}
