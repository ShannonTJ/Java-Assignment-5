/*Author: Shannon TJ 10101385 Tutorial 1
  Version: April 15, 2015

  Features: Displays program instructions. Repeats the program until the user quits. Displays menu options. Gets user input and error checks for invalid input. Calls methods of class Manager.  

  Limitations: Only displays the program instructions once. The program cannot be quit directly once a method from class Manager has been called.

 */

import java.util.Scanner;

public class UserInterface
{
    private StringBuffer userSelect = new StringBuffer();
    private boolean repeatProgram = true;
    private Manager manager1 = new Manager();

    public UserInterface()
    {
	//Displays the program's instructions
	showInstructions();

	//Repeats the program until the user quits
	do
	    {
		//Displays the menu options
		showMenu();
		//Gets user input
		menuInput();
	    }
	while(repeatProgram == true);
    }

    /*showInstructions: Displays the program's instructions
      Parameters: N/A
      Returns: N/A
     */
    public void showInstructions()
    {
	System.out.println("PROGRAM INSTRUCTIONS:");
	System.out.println("This program allows you to add, search, remove, and display movies in your");
	System.out.println("collection. To select an option, enter the character that corresponds");
	System.out.println("to that option. You can cancel the addition of a movie by entering");
	System.out.println("a blank value when prompted for the genre or entering a negative value"); 
	System.out.println("value when prompted for the rating. All prompts are string-based,");
	System.out.println("except for the rating, which takes an integer value.");
    }

    /*showMenu: Displays the menu options
      Parameters: N/A
      Returns: N/A
     */
    public void showMenu ()
    {
	System.out.println();
	System.out.println("MENU OPTIONS:");
	System.out.println("(A)dd a movie to your collection");
	System.out.println("(D)isplay");
	System.out.println("(R)emove a movie from your collection");
	System.out.println("(S)earch");
	System.out.println("(Q)uit program");
	System.out.println();
	System.out.print("Enter selection: ");
    }

    /*menuInput: Allows the user to select an option on the menu. Error checks for invalid input.
      Parameters: N/A
      Returns: N/A
     */
    public void menuInput ()
    {
	Scanner in = new Scanner(System.in);
	userSelect.delete(0, userSelect.length());
	userSelect = userSelect.append(in.nextLine());

	//Error checks for no selection
	while (userSelect.length()== 0)
	    {
		System.out.print("Error. Choose a selection: ");
		userSelect.delete(0, userSelect.length());
	     	userSelect = userSelect.append(in.nextLine());
	    }
	char input = userSelect.charAt(0);

	//Calls the Manager class to execute methods associated with the list
	switch (input)
	    {
	    case 'a':
	    case 'A':
		manager1.addInfo();
		break;

	    case 'd':
	    case 'D':
		manager1.display();
		break;

	    case 'r':
	    case 'R':
		manager1.remove();
		break;

	    case 's':
	    case 'S':
		manager1.search();
		break;

	    case 'q':
	    case 'Q':
		System.out.println("Quitting program...");
		repeatProgram = false;
		break;

	    default:
		//Error checks for invalid input
		System.out.println();
		System.out.print("Error: Invalid input. Enter a valid selection: ");
		menuInput();
	    }
    }
}
