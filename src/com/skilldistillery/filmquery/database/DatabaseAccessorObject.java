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

	public DatabaseAccessorObject() {
	}

	@Override
	public Film findFilmById(int filmId) throws SQLException {
		Film film = null;
		Connection conn = DriverManager.getConnection(URL, userName, password);

		String sql = "SELECT film.id, film.title, film.release_year, film.rating, film.description, language.name, actor.first_name, actor.last_name\n"
				+ "FROM film\n" + "JOIN language\n" + "ON language.id = film.language_id\n" + "JOIN film_actor\n"
				+ "ON film.id = film_actor.film_id\n" + "JOIN actor\n" + "ON film_actor.actor_id = actor.id\n"
				+ "WHERE film.id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		stmt.setInt(1, filmId);

		ResultSet filmResult = stmt.executeQuery();

		if (filmResult.next()) {
			film = new Film(); // Create the object

			film.setFilmId(filmResult.getInt("id"));
			film.setTitle(filmResult.getString("title"));
			film.setReleaseYear(filmResult.getShort("release_year"));
			film.setRating(filmResult.getString("rating"));
			film.setDesc(filmResult.getString("description"));
			film.setLanguage(filmResult.getString("name"));
			
		}

		filmResult.close();
		stmt.close();
		conn.close();
	
		return film;
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
	public List<Film> findFilmByKeyword(String keyword) {
	    List<Film> films = new ArrayList<>();

	    try {
	        Connection conn = DriverManager.getConnection(URL, userName, password);

	        String sql = "SELECT film.id, film.title, film.release_year, film.rating, film.description, language.name, actor.first_name, actor.last_name\n"
	                + "FROM film\n" + "JOIN language\n" + "ON language.id = film.language_id\n" + "JOIN film_actor\n"
	                + "ON film.id = film_actor.film_id\n" + "JOIN actor\n" + "ON film_actor.actor_id = actor.id\n"
	                + "WHERE film.title LIKE ? OR film.description LIKE ?";

	        PreparedStatement stmt = conn.prepareStatement(sql);

	        stmt.setString(1, "%" + keyword + "%");
	        stmt.setString(2, "%" + keyword + "%");

	        ResultSet rs = stmt.executeQuery();

	        String lastTitle = null; 
	        Film film = null;

	        while (rs.next()) {
	            int filmId = rs.getInt("id");
	            String title = rs.getString("title");

	            if (!title.equals(lastTitle)) {
	                if (film != null) {
	                    films.add(film);
	                }

	                film = new Film();
	                film.setFilmId(filmId);
	                film.setTitle(title);
	                film.setReleaseYear(rs.getShort("release_year"));
	                film.setRating(rs.getString("rating"));
	                film.setDesc(rs.getString("description"));
	                film.setLanguage(rs.getString("name"));
	                film.setActors(new ArrayList<>());
	                lastTitle = title;
	            }

	            Actor actor = new Actor();
	            actor.setFirstName(rs.getString("first_name"));
	            actor.setLastName(rs.getString("last_name"));
	            film.getActors().add(actor);
	        }

	        if (film != null) {
	            films.add(film);
	        }

	        rs.close();
	        stmt.close();
	        conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    for (Film film : films) {
//	        System.out.println("Film Id: " + film.getFilmId() + "  Title: " + film.getTitle() + "  Description: "
//	                + film.getDesc() + "  Release Year: " + film.getReleaseYear() + "  Rating: " + film.getRating() + " Language: " + film.getLanguage() 
//	                + "  Actors: " + getFormattedActorList(film.getActors()));
	    }

	    return films;
	}

	private String getFormattedActorList(List<Actor> actors) {
	    StringBuilder sb = new StringBuilder();
	    for (Actor actor : actors) {
	        sb.append(actor.getFirstName()).append(" ").append(actor.getLastName()).append(", ");
	    }
	    if (sb.length() > 0) {
	        sb.setLength(sb.length() - 2);
	    }
	    return sb.toString();
	}

	private void printActors(List<Actor> actors) {
	    if (actors.isEmpty()) {
	        System.out.println("N/A");
	        return;
	    }

	    for (int i = 0; i < actors.size(); i++) {
	        Actor actor = actors.get(i);
	        System.out.print(actor.getFirstName() + " " + actor.getLastName());

	        // Add comma and space if not the last actor
	        if (i < actors.size() - 1) {
	            System.out.print(" ");
	        }
	    }
	    System.out.println();
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
		List<Actor> actors = new ArrayList<>();
		String sql = "SELECT film.id, film.title, film.release_year, film.rating, film.description, language.name, actor.first_name, actor.last_name\n"
				+ "FROM film\n" + "JOIN language\n" + "ON language.id = film.language_id\n" + "JOIN film_actor\n"
				+ "ON film.id = film_actor.film_id\n" + "JOIN actor\n" + "ON film_actor.actor_id = actor.id\n"
				+ "WHERE film.id = ?";

		Connection conn = DriverManager.getConnection(URL, userName, password);

		PreparedStatement stmt = conn.prepareStatement(sql);

		stmt.setInt(1, filmId);

		ResultSet actorByFilmIdResult = stmt.executeQuery();

		if (actorByFilmIdResult.next()) {
			int id = actorByFilmIdResult.getInt("id");
			String firstName = actorByFilmIdResult.getString("first_name");
			String lastName = actorByFilmIdResult.getString("last_name");
			Actor actor = new Actor(id, firstName, lastName);
			actors.add(actor);

		}

		actorByFilmIdResult.close();
		stmt.close();
		conn.close();

		return actors;
	}

}
