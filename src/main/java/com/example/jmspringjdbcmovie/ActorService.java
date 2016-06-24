package com.example.jmspringjdbcmovie;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActorService {
	@Autowired
	ActorRepository actorRepository;
	
	public List<Actor> findAll() {
		return actorRepository.findAll();
	}
	
	public List<Actor> findByMovie(Integer movie_id) {
		return actorRepository.findByMovie(movie_id);
	}
	
	public Actor findOne(Integer id) {
		return actorRepository.findOne(id);
	}
}
