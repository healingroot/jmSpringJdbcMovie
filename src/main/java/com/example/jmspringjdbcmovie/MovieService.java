package com.example.jmspringjdbcmovie;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
	@Autowired MovieRepository movieRepository;
	
	public List<Movie> findAll() {
		return movieRepository.findAll();
	}
	
	public Movie findOne(Integer id) {
		return movieRepository.findOne(id);
	}

	public List<Movie> findByActor(Integer id) {
		return movieRepository.findByActor(id);
	}
}
