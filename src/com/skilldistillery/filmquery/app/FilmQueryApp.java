package com.skilldistillery.filmquery.app;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

	DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) throws SQLException {
		FilmQueryApp app = new FilmQueryApp();
		// app.test();
		app.launch();
	}

	private void test() {
		List<Actor> film;
		try {
			film = db.findActorsByFilmId(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(" ");
	}

	private void launch() throws SQLException {
				System.out.println("\n\n3.....");
				delay(1);
				System.out.println("2.....");
				delay(1);
				System.out.println("1.....");
				delay(1);
				System.out.println("Launching.....");
				delay(3);
		Scanner input = new Scanner(System.in);
		startUserInterface(input);
	}

	private void startUserInterface(Scanner input) throws SQLException {
	    System.out.println("\nPlease enter a selection: (1) (2) (3)");
	    System.out.println("1. Look up a film by its ID.");
	    System.out.println("2. Look up a film by a keyword.");
	    System.out.println("3. Exit the application");

	    int selection = input.nextInt();
	    input.nextLine();

	    switch (selection) {
	        case 1:
	            System.out.println("Please enter the ID to look up the film.");
	            int filmId = input.nextInt();
	            input.nextLine();
	            Film filmById = db.findFilmById(filmId);
	            if (filmById != null) {
	                System.out.println(filmById);
	            } else {
	                notFound();
	            }
	            break;

	        case 2:
	            System.out.println("Please enter the film keyword");
	            String filmKeyword = input.nextLine();
	            List<Film> filmKey = db.findFilmByKeyword(filmKeyword);
	            if (!filmKey.isEmpty()) {
	                for (Film film : filmKey) {
	                    System.out.println(film);
	                   
	                }
	            } else {
	                notFound();
	            }
	            break;

	        case 3:
	            System.out.println("Thank you for flying with BlockBuster! ");
	            break;

	        default:
	            System.out.println("Invalid selection. Please try again.");
	            break;
	    }
	    startUserInterface(input);
	}

//	  System.out.println(selection);
public void delay(int t) {

	try {
		TimeUnit.SECONDS.sleep(t);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
}

public void notFound() {
	ArtWork art = new ArtWork();
	art.artOne();
	delay(1);
	System.out.println("Captains Log:  ");
	delay(1);
		System.out.println("Stardate: 3939.39");
	delay(1);
	System.out.println("We've searched the great expanses far beyond the Federation's reaches and we cannot find that movie.");
	delay(3);
}
public void wrongInput() {
	System.out.println("I love what you were typing there but...");
	delay(2);
	System.out.println("...");
	delay(1);
	System.out.println("\nIt doesn't belong here...");
	delay(2);
}

}


