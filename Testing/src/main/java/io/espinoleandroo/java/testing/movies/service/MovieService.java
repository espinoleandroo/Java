package io.espinoleandroo.java.testing.movies.service;

import java.util.Collection;
import java.util.stream.Collectors;

import io.espinoleandroo.java.testing.movies.data.MovieRepository;
import io.espinoleandroo.java.testing.movies.model.Genre;
import io.espinoleandroo.java.testing.movies.model.Movie;

public class MovieService {

	private MovieRepository movieRepository;

	public MovieService(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}

	public Collection<Movie> findMoviesByGenre(Genre genre) {
		Collection<Movie> allMovies = movieRepository.findAll().stream()
				.filter(movie -> movie.getGenre() == genre)
				.collect(Collectors.toList());
		return allMovies;
	}

}
