package com.skilldistillery.filmquery.app;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {
  
  DatabaseAccessor db = new DatabaseAccessorObject();

  public static void main(String[] args) {
    FilmQueryApp app = new FilmQueryApp();
  // app.test();
 app.launch();
  }

  private void test() {
    List<Actor> film;
	try {
		film = db.findActorsByFilmId(1);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    System.out.println(" ");
  }

  private void launch() {
    Scanner input = new Scanner(System.in);
    startUserInterface(input);
    input.close();
  }

  private void startUserInterface(Scanner input) {
	  System.out.println(" Please enter a selection: 1. , 2. or 3. ");
	  System.out.println("1. Look up a film by its ID.");
	  System.out.println("2. Look up a film by a key word. ");
	  System.out.println("3. Exit the application ");
	  int selection = input.nextInt();
//	  System.out.println(selection);
	  
	  
  
	  
	  
	  
	  
	  

  }

}
