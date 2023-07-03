package com.skilldistillery.filmquery.entities;

import java.util.List;
import java.util.Objects;

public class Film {
	private int filmId;
	private String title;
	private String description;
	private short releaseYear;
	private String language;
	private int rentalDuration;
	private double rate;
	private int length;
	private double replacementCost;
	private String rating;
	private String features;
	private List<Film> films;
	private List<Actor> actors;

	protected Film(int filmId, String title, String description, short releaseYear, String language, int rentalDuration,
			double rate, int length, double replacementCost, String rating, String features, List<Film> films,
			List<Actor> actors) {
		super();
		this.filmId = filmId;
		this.title = title;
		this.description = description;
		this.releaseYear = releaseYear;
		this.language = language;
		this.rentalDuration = rentalDuration;
		this.rate = rate;
		this.length = length;
		this.replacementCost = replacementCost;
		this.rating = rating;
		this.features = features;
		this.films = films;
		this.actors = actors;
	}

	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}

	public Film() {

	}

	public int getFilmId() {
		return filmId;
	}

	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDesc() {
		return description;
	}

	public void setDesc(String description) {
		this.description = description;
	}

	public String getLanguage() {
		return language;
	}

	public short getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(short releaseYear) {
		this.releaseYear = releaseYear;
	}


	public String setLanguage() {
			return language;
	}
	public void setLanguage(String language) {
	    this.language = language;
	}

	


	public int getRentDur() {
		return rentalDuration;
	}

	public void setRentDur(int rentalDuration) {
		this.rentalDuration = rentalDuration;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public double getRepCost() {
		return replacementCost;
	}

	public void setRepCost(double replacementCost) {
		this.replacementCost = replacementCost;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getFeatures() {
		return features;
	}

	public void setFeatures(String features) {
		this.features = features;
	}

	public List<Film> getFilms() {
		return films;
	}

	public void setFilms(List<Film> films) {
		this.films = films;
	}

	public Film(int filmId, String title, String description, short releaseYear, int languageId, int rentalDuration, double rate,
			int length, double replacementCost, String rating, String features) {
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, features, filmId, films, language, length, rate, rating, releaseYear, rentalDuration, replacementCost,
				title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Film)) {
			return false;
		}
		Film other = (Film) obj;
		return Objects.equals(description, other.description) && Objects.equals(features, other.features) && filmId == other.filmId
				&& Objects.equals(films, other.films) && language == other.language && length == other.length
				&& Double.doubleToLongBits(rate) == Double.doubleToLongBits(other.rate)
				&& Objects.equals(rating, other.rating) && releaseYear == other.releaseYear && rentalDuration == other.rentalDuration
				&& Double.doubleToLongBits(replacementCost) == Double.doubleToLongBits(other.replacementCost)
				&& Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return "\n\n\nFilm ID: " + filmId + "\n" + (title != null ? "Title: " + title + "\n" : "")
				+ (description != null ? "Description: " + description + " " : "") + "\nRelease Year:" + releaseYear + "\n "
				+ (rating != null ? "Rating: " + rating + " " : "") + (language != null ? "\nLanguage: " + language : " ") + (actors != null ? "\nActors: " + actors : "") ;
	}

	

}
