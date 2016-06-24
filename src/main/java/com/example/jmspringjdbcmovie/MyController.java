package com.example.jmspringjdbcmovie;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@EnableAutoConfiguration
@ComponentScan
@Controller
public class MyController {
	@Autowired
	MovieService movieService;
	@Autowired
	ActorService actorService;
	
	@RequestMapping(value={"/","/movies"})
	public String moviesIndex(Model model) {
		Movie main_movie = movieService.findOne(10);
		List<Movie> movies = movieService.findAll();
		for(Movie movie: movies) {
			movie.setPlot( StringUtils.left(movie.getPlot(), 80)+"...");
		}
		model.addAttribute("main_movie", main_movie);
		model.addAttribute("movies", movies);
		return "moviesIndex";		
	}
	@RequestMapping("/movies/{id}")
	public String moviesShow(@PathVariable("id") Integer id, Model model) {
		Movie movie = movieService.findOne(id);
		List<Actor> actors = actorService.findByMovie(id);
		for(Actor actor: actors) {
			actor.setBio( StringUtils.left(actor.getBio(), 80)+"...");
		}
		model.addAttribute("movie", movie);
		model.addAttribute("actors", actors);
		return "moviesShow";
	}
	
	@RequestMapping("/actors")
	public String actorsIndex(Model model) {
		List<Actor> actors = actorService.findAll();
		for(Actor actor: actors) {
			actor.setBio( StringUtils.left(actor.getBio(), 80)+"...");
		}
		model.addAttribute("actors", actors);
		return "actorsIndex";
	}
	
	@RequestMapping("/actors/{id}")
	public String actorsShow(@PathVariable("id") Integer id, Model model) {
		Actor actor = actorService.findOne(id);
		List<Movie> movies = movieService.findByActor(id);
		for(Movie movie: movies) {
			movie.setPlot( StringUtils.left(movie.getPlot(), 80)+"...");
		}
		model.addAttribute("actor", actor);
		model.addAttribute("movies", movies);
		return "actorsShow";
	}
}