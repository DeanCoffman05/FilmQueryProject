package com.skilldistillery.filmquery.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class DatabaseAccessorObject implements DatabaseAccessor {
	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=US/Mountain";
	private static final String userName = "student";
	private static final String password = "student";

	static {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Film findFilmById(int filmId) {
		return null;
	}

	@Override
	public List<Film> findFilmByActorId(int actorId) {
		List<Film> films = new ArrayList<>();
		try {
			Connection conn = DriverManager.getConnection(URL, userName, password);
			String sql = "SELECT id, title, description, release_year, language_id, rental_duration, ";
			sql += " rental_rate, length, replacement_cost, rating, special_features "
					+ " FROM film JOIN film_actor ON film.id = film_actor.film_id " + " WHERE actor_id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, actorId);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int filmId = rs.getInt("id");
				String title = rs.getString("title");
				String desc = rs.getString("description");
				short releaseYear = rs.getShort("release_year");
				int langId = rs.getInt("language_id");
				int rentDur = rs.getInt("rental_duration");
				double rate = rs.getDouble("rental_rate");
				int length = rs.getInt("length");
				double repCost = rs.getDouble("replacement_cost");
				String rating = rs.getString("rating");
				String features = rs.getString("special_features");
				Film film = new Film(filmId, title, desc, releaseYear, langId, rentDur, rate, length, repCost, rating,
						features);
				films.add(film);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return films;

	}

	@Override
	public Actor findActorById(int actorId) throws SQLException {

		// 0 write the SQL statement
		Actor actor = null;
		String sql = "SELECT * FROM actor WHERE id = ?";

		// 1 connect to the database.
		Connection conn = DriverManager.getConnection(URL, userName, password);

		// 2 prepare the SQL statement (compile/ optimize)
		PreparedStatement stmt = conn.prepareStatement(sql);

		// 2a debug
		// System.out.println(stmt);

		// 3bind the value actorID to the bind variable.
		stmt.setInt(1, actorId);

		// 4 run the SQL
		ResultSet actorResult = stmt.executeQuery();

		// 5
		// If using a primary key then it can only return 1 row because the primary key
		// must be unique to the table. If you can return multiple rows you would need
		// to use a while loop to iterate through the returns.

		if (actorResult.next()) {
			actor = new Actor(); // Create the object
			// Here is our mapping of query columns to our object fields:
			// Dont use NUMBERS in the arguments! She wants the actual SQL statments!!
			// for good reason too. just don't forget.
			actor.setId(actorResult.getInt("id"));
			actor.setFirstName(actorResult.getString("first_name"));
			actor.setLastName(actorResult.getString("last_name"));
		}

		actorResult.close();
		stmt.close();
		conn.close();

		return null;

	}

	@Override
	public List<Actor> findActorsByFilmId(int filmId) throws SQLException {
		Actor actor = null;
		String sql = "SELECT film.id, actor.first_name, actor.last_name " + " FROM actor " + " JOIN film_actor "
				+ " ON actor.id = film_actor.actor_id " + " JOIN film " + " ON film_actor.film_id = film.id "
				+ " WHERE film.id = ? ";

		Connection conn = DriverManager.getConnection(URL, userName, password);

		PreparedStatement stmt = conn.prepareStatement(sql);

//		 2a debug
	System.out.println(stmt);

		stmt.setInt(1, filmId);

		ResultSet actorByFilmIdResult = stmt.executeQuery();

		if (actorByFilmIdResult.next()) {
			actor = new Actor(); // Create the object
			// Here is our mapping of query columns to our object fields:
			// Dont use NUMBERS in the arguments! She wants the actual SQL statments!!
			// for good reason too. just don't forget.
			actor.setId(actorByFilmIdResult.getInt("id"));
			actor.setFirstName(actorByFilmIdResult.getString("first_name"));
			actor.setLastName(actorByFilmIdResult.getString("last_name"));
		}

		actorByFilmIdResult.close();
		stmt.close();
		conn.close();

		return null;
	}

}
