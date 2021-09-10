package io.espinoleandroo.java.testing.movies.service;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import io.espinoleandroo.java.testing.movies.data.MovieRepository;
import io.espinoleandroo.java.testing.movies.model.Genre;
import io.espinoleandroo.java.testing.movies.model.Movie;

public class MovieServiceShould {
	MovieRepository movieRepository;
	MovieService movieService;
	
	@Before
	public void setUp() throws Exception {
		movieRepository = Mockito.mock(MovieRepository.class);

		Mockito.when(movieRepository.findAll())
				.thenReturn(Arrays.asList(new Movie(1, "Dark Knight", 152, Genre.ACTION),
						new Movie(2, "Memento", 113, Genre.THRILLER),
						new Movie(3, "There's Something About Mary", 119, Genre.COMEDY),
						new Movie(4, "Super 8", 112, Genre.THRILLER), new Movie(5, "Scream", 111, Genre.HORROR),
						new Movie(6, "Home Alone", 103, Genre.COMEDY)));
		
		movieService = new MovieService(movieRepository);

	}

	@Test
	public void return_movies_by_genre() {

		
		Collection<Movie> movies = movieService.findMoviesByGenre(Genre.COMEDY);

		List<Integer> moviesIds = getMoviesIds(movies);

		assertThat(moviesIds, CoreMatchers.is(Arrays.asList(3, 6)));
	}

	@Test
	public void return_movies_by_duration() {
		Collection<Movie> movies = movieService.findMoviesByLength(119);
		List<Integer> moviesIds = getMoviesIds(movies);

		assertThat(moviesIds, CoreMatchers.is(Arrays.asList(2, 3, 4, 5, 6)));
	}

	private List<Integer> getMoviesIds(Collection<Movie> movies) {
		List<Integer> moviesIds = movies.stream().map(movie -> movie.getId()).collect(Collectors.toList());
		return moviesIds;
	}

}
