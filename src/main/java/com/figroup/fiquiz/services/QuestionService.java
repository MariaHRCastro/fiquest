package com.figroup.fiquiz.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.figroup.fiquiz.entities.Option;
import com.figroup.fiquiz.entities.Question;
import com.figroup.fiquiz.repositories.OptionRepository;
import com.figroup.fiquiz.repositories.QuestionRepository;

@Service
public class QuestionService {

	@Autowired
	private QuestionRepository repository;
	
	@Autowired
	private OptionRepository oRepository;
	
	public List<Question> findAll() {
		return repository.findAll();
	}

	public Question findById(Long id) {
		Optional<Question> obj = repository.findById(id);
		return obj.get();
	}

	public Option getRight(Long id) {
		Optional<Question> obj = repository.findById(id);
		List<Option> options = obj.get().getOptions();
		Option right = null;
		boolean comparation = true;
		for (Option op : options) {
			if (op.isResult() == comparation) {
				right = op;
			}
		}
		return right;
	}
	
	//O MÉTODO RANDOM AINDA NÃO ESTÁ FUNCIONANDO PARA BUSCAR AS QUESTÕES DE FORMA ALEATÓRIA NO BANCO DE DADOS
	/*public Optional<Question> getQuestion() {
		Random random = new Random();
		List<Question> questions = repository.findAll();
		int max = questions.size();
		Long choose = random.nextLong(max);
		return repository.findById(choose);
	}
	*/
	
	public void insertQuestion(Question question) {
		repository.save(question);
		oRepository.saveAll(question.getOptions());
	}
	
	public String deleteQuestion(Long id) {
		repository.deleteById(id);
		return "Question "+ id +" deleted!";
	}
		
}

