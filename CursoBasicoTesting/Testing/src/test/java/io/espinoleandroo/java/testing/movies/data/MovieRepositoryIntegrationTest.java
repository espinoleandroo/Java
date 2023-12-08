package io.espinoleandroo.java.testing.movies.data;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Collection;

import javax.sql.DataSource;

import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ScriptException;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import io.espinoleandroo.java.testing.movies.model.Genre;
import io.espinoleandroo.java.testing.movies.model.Movie;

public class MovieRepositoryIntegrationTest {

	private MovieRepositoryJdbc movieRepository;
	private DataSource dataSource;
	
	@Before
	public void setUp() throws ScriptException, SQLException {
		dataSource = new DriverManagerDataSource("jdbc:h2:mem:test;MODE=MYSQL", "sa", "sa");

		ScriptUtils.executeSqlScript(dataSource.getConnection(), new ClassPathResource("sql-scripts/test-data.sql"));

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		movieRepository = new MovieRepositoryJdbc(jdbcTemplate);

	}
	
	@After
	public void tearDown() throws Exception{
		// Remove H2 files -- https://stackoverflow.com/a/51809831/1121497
        final Statement s = dataSource.getConnection().createStatement();
        s.execute("drop all objects delete files"); // "shutdown" is also enough for mem db
	}

	@Test
	public void load_all_movies() throws ScriptException, SQLException {

		Collection<Movie> movies = movieRepository.findAll();

		assertThat(movies, CoreMatchers.is(
				Arrays.asList(
						new Movie(1, "Dark Knight", 152, Genre.ACTION),
						new Movie(2, "Memento", 113, Genre.THRILLER), 
						new Movie(3, "Matrix", 136, Genre.ACTION))));
	}

	@Test
	public void load_movie_by_id() throws ScriptException, SQLException {

		Movie movie = movieRepository.findById(2);

		assertThat(movie, CoreMatchers.is(new Movie(2, "Memento", 113, Genre.THRILLER)));
	}


	@Test
	public void inset_a_movie() throws ScriptException, SQLException {

		Movie movie = new Movie(3, "Matrix", 136, Genre.ACTION);
		
		movieRepository.saveOrUpdate(movie);
		
		Movie movieFromDB= movieRepository.findById(3);

		assertThat(movieFromDB, CoreMatchers.is(movie));
	}
}
