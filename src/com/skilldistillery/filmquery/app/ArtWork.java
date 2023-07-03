package com.skilldistillery.filmquery.app;

import java.util.concurrent.TimeUnit;

public class ArtWork {

	public void artOne() {
clearScreen();
System.out.println("\t\t\t        ___________________        ____....-----....____      ");
System.out.println("\t\t\t		(________________LL_)   ============================== ");
System.out.println("\t\t\t			    ______\\   \\_______.--'.  `---..._____...---' ");
System.out.println("\t\t\t			    `-------..__            ` ,/                   ");
System.out.println("\t\t\t			                `-._ -  -  - |                     ");
delay(1);
clearScreen();
System.out.println("\t\t\t\t\t        ___________________        ____....-----....____      ");
System.out.println("\t\t\t\t\t		(________________LL_)   ============================== ");
System.out.println("\t\t\t\t\t     		    ______\\   \\_______.--'.  `---..._____...---' ");
System.out.println("\t\t\t\t\t			    `-------..__            ` ,/                   ");
System.out.println("\t\t\t\t\t			                `-._ -  -  - |                     ");
delay(1);
clearScreen();
System.out.println("\t\t\t\t\t\t\t\t        ___________________        ____....-----....____      ");
System.out.println("\t\t\t\t\t\t\t\t		(________________LL_)   ============================== ");
System.out.println("\t\t\t\t\t\t\t\t			    ______\\   \\_______.--'.  `---..._____...---' ");
System.out.println("\t\t\t\t\t\t\t\t			    `-------..__            ` ,/                   ");
System.out.println("\t\t\t\t\t\t\t\t			                `-._ -  -  - |                     ");
System.out.println("\t\t\t\t\t\t\t\t			                    `-------'                      ");
delay(1);
clearScreen();
System.out.println("\t\t\t\t\t\t\t\t\t\t\t         ___________________        ____....-----....____      ");
System.out.println("\t\t\t\t\t\t\t\t\t\t\t		(________________LL_)   ============================== ");
System.out.println("\t\t\t\t\t\t\t\t\t\t\t			    ______\\   \\_______.--'.  `---..._____...---' ");
System.out.println("\t\t\t\t\t\t\t\t\t\t\t			    `-------..__            ` ,/                   ");
System.out.println("\t\t\t\t\t\t\t\t\t\t\t			                `-._ -  -  - |                     ");
System.out.println("\t\t\t\t\t\t\t\t\t\t\t			                    `-------'                      ");
delay(1);
clearScreen();
System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t         ___________________        ____....-----....____      ");
System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t		(________________LL_)   ============================== ");
System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t        	    ______\\   \\_______.--'.  `---..._____...---' ");
System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t			    `-------..__            ` ,/                   ");
System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t			                `-._ -  -  - |                     ");
System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t			                    `-------'                      ");
delay(1);
clearScreen();
System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t         ___________________        ____....-----....____      ");
System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t		(________________LL_)   ============================== ");
System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t			    ______\\   \\_______.--'.  `---..._____...---' ");
System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t			    `-------..__            ` ,/                   ");
System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t			                `-._ -  -  - |                     ");
System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t			                    `-------'                      ");
delay(1);
clearScreen();
	}

	
	public void clearScreen() {
	System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
}
	public void delay(int t) {

		try {
			TimeUnit.SECONDS.sleep(t);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
