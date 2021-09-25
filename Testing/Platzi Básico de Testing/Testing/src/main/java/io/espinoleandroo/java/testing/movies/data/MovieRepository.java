package io.espinoleandroo.java.testing.movies.data;

import java.util.Collection;

import io.espinoleandroo.java.testing.movies.model.Movie;

public interface MovieRepository {

	Movie findById(long id);
	Collection<Movie> findAll();
	void saveOrUpdate(Movie movie);
}
