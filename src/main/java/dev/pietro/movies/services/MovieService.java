package dev.pietro.movies.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.pietro.movies.POJO.Movie;
import dev.pietro.movies.repos.MovieRepository;

@Service
public class MovieService {
	
	@Autowired
	private MovieRepository movieRepo;
	
	
	public List<Movie> allMovies() 
	{
		return movieRepo.findAll();
	}
}
