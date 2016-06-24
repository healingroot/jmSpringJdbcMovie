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
public class ActorRepository {
	@Autowired NamedParameterJdbcTemplate jdbcTemplate;

	private static final RowMapper<Actor> actorRowMapper = (rs, i) -> {
		Integer id = rs.getInt("id");
		String name = rs.getString("name");
		String image = rs.getString("image");
		String bio = rs.getString("bio");
		return new Actor(id, name, image, bio);
	};

	public List<Actor> findAll() {
		return jdbcTemplate.query("SELECT id, name, image, bio"
				+ " FROM actor", actorRowMapper);

	}
	public List<Actor> findByMovie(Integer movie_id) {
		SqlParameterSource param = new MapSqlParameterSource().addValue("movie_id", movie_id);
		return jdbcTemplate.query("SELECT a.*"
				+ " FROM part p, actor a"
				+ " WHERE p.actor_id=a.id"
				+ " AND p.movie_id=:movie_id", param, actorRowMapper);
	}
	public Actor findOne(Integer id) {
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		return jdbcTemplate.queryForObject("SELECT id, name, image, bio"
				+ " FROM actor"
				+ " WHERE id=:id", param, actorRowMapper);
	}
}
