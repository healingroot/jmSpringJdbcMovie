package com.example.jmspringjdbcmovie;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class MovieRepository {
	@Autowired NamedParameterJdbcTemplate jdbcTemplate;

	private static final RowMapper<Movie> movieRowMapper = (rs, i) -> {
		Integer id = rs.getInt("id");
		String title = rs.getString("title");
		String image = rs.getString("image");
		Integer year = rs.getInt("year");
		String plot = rs.getString("plot");
		return new Movie(id, title, image, year, plot);
	};

	public List<Movie> findAll() {
		return jdbcTemplate.query("SELECT id, title, image, year, plot FROM movie", movieRowMapper);

	}
	public Movie findOne(Integer id) {
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		return jdbcTemplate.queryForObject("SELECT id, title, image, year, plot FROM movie WHERE id = :id", param, movieRowMapper);
	}
	public List<Movie> findByActor(Integer actor_id) {
		SqlParameterSource param = new MapSqlParameterSource().addValue("actor_id", actor_id);
		return jdbcTemplate.query("SELECT m.*"
				+ " FROM movie m, part p"
				+ " WHERE p.movie_id = m.id"
				+ " AND p.actor_id = :actor_id", param, movieRowMapper);
	}
}
