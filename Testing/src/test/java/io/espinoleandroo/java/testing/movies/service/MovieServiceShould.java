package io.espinoleandroo.java.testing.movies.service;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.mockito.Mockito;

import io.espinoleandroo.java.testing.movies.data.MovieRepository;
import io.espinoleandroo.java.testing.movies.model.Genre;
import io.espinoleandroo.java.testing.movies.model.Movie;

public class MovieServiceShould {

	@Test
	public void return_movies_by_genre() {
		MovieRepository movieRepository = Mockito.mock(MovieRepository.class);

		Mockito.when(movieRepository.findAll())
				.thenReturn(Arrays.asList(
						new Movie(1, "Dark Knight", 152, Genre.ACTION),
						new Movie(2, "Memento", 113, Genre.THRILLER),
						new Movie(3, "There's Something About Mary", 119, Genre.COMEDY),
						new Movie(4, "Super 8", 112, Genre.THRILLER),
						new Movie(5, "Scream", 111, Genre.HORROR),
						new Movie(6, "Home Alone", 103, Genre.COMEDY)
						));

		MovieService movieService = new MovieService(movieRepository);

		Collection<Movie> movies = movieService.findMoviesByGenre(Genre.COMEDY);
		
		List<Integer> moviesIds =  movies.stream().map(movie -> movie.getId()).collect(Collectors.toList());
		
		assertThat(moviesIds, CoreMatchers.is(Arrays.asList(3, 6)));
	}

}
