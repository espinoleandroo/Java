package io.espinoleandroo.java.testing.movies.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import io.espinoleandroo.java.testing.movies.model.Genre;
import io.espinoleandroo.java.testing.movies.model.Movie;

public class MovieRepositoryJdbc implements MovieRepository {

	private JdbcTemplate jdbcTemplate;

	public MovieRepositoryJdbc(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Movie findById(long id) {
		// TODO Auto-generated method stub
		Object[] args = { id };

		return jdbcTemplate.queryForObject("SELECT * FROM movies WHERE id = ?", args, movieMapper);
	}

	@Override
	public Collection<Movie> findAll() {

		return jdbcTemplate.query("SELECT * FROM movies", movieMapper);
	}

	@Override
	public void saveOrUpdate(Movie movie) {
		
		jdbcTemplate.update("INSERT INTO movies (id, name, minutes, genre) values (?, ?, ?,)", movie.getId(), movie.getName(), movie.getMinutes(), movie.getGenre().toString());

	}

	private static RowMapper<Movie> movieMapper = (rs, rowNum) -> new Movie(rs.getInt("id"), rs.getString("name"),
			rs.getInt("minutes"), Genre.valueOf(rs.getString("genre")));

}
