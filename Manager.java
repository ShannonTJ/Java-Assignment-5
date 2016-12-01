/*Author: Shannon TJ 10101385 Tutorial 1
  Version: April 15, 2015

  Features: Prompts the user for information associated with a movie (i.e. its title, the names of the first three cast members, its genre and its rating (an integer value)). Adds movies and their 
  associated information to the list in the order in which the user adds them. The user can either enter a blank value for the genre or a negative value for the rating to cancel addition of a new movie. The
  user will be prompted to enter correct values for the genre and rating for invalid input. Displays the list of movies by displaying all of the information associated with each movie. After every 4 movies 
  have been displayed, the user is prompted to hit enter to continue displaying the list.Searches for movies in the list by first getting the title via user input and then searching by  title. Removes 
  movies in the list by getting the title via user input, searching by title, and then removing the first match that is found.  

  Limitations: The user cannot exit out of the display, remove, and search options prematurely. Setting the movie's rating does not error check for non-integer values. The remove option only removes the 
  first match that is found. The search option does not find multiples of the same movie or indicate that multiples exist in the list. The add option only adds movies to the end of the list. The list
  is not saved or written to any file. Every time the user opens the program, the list will be empty. 

 */

import java.util.Scanner;

public class Manager
{
    private MovieNode head;
    private Scanner in = new Scanner(System.in);

    public static final int MATCH = 0;

    //Sets head pointer to a null default value 
    public Manager()
    {
	head = null;
    }

    /*addInfo: Prompts the user for a movie's title, the names of its first three cast members, its genre, and its rating. Creates a new movie containing this data and a movie node that points to null 
      (the new movie is inserted at the end of the list). Calls a method to add the new movie to the list.
      Parameters: N/A
      Returns: N/A
     */
    public void addInfo()
    {
	String newName;
	String newCast [] = new String [3];
	String newGenre;
	int newRating;

	Movie newMovie;
	MovieNode newNode;

	//Gets user input for the movie title
	System.out.println("Enter the Following Information...");
	System.out.print("Title of New Movie: ");
	newName = in.nextLine();

	//Gets user input for the names of the cast members
	System.out.print("First Cast Member: ");
	newCast [0] = in.nextLine();
	System.out.print("Second Cast Member: ");
	newCast [1] = in.nextLine();
	System.out.print("Third Cast Member: ");
	newCast [2] = in.nextLine();

	//Gets user input for the genre
	newGenre = checkGenre();
	//Cancels the addition of the movie if a blank value is entered
	if (newGenre.equals(""))
	    {
		System.out.println();
		System.out.println("BLANK VALUE ENTERED:\nCancelling addition of new movie...");
		return;
	    }
	//Gets user input for the rating
	newRating = checkRating();
	//Cancels the addition of the movie if a negative value is entered
	if (newRating < 0)
	    {
		System.out.println();
		System.out.println("NEGATIVE VALUE ENTERED:\nCancelling addition of new movie...");
		return;
	    }

	//Creates a new movie with title, cast member names, genre, and rating specified by the user
	newMovie = new Movie(newName, newCast, newGenre, newRating);
	//Creates a new movie node, which points to null
	newNode = new MovieNode(newMovie, null);

	//Adds the new movie to the end of the list
	add(newMovie, newNode);
    }

    /*checkGenre: Compares user input to pre-defined genres. If the user input does not match any of the genres, it will prompt the user to enter another string.
      Parameters: N/A
      Returns: A string that defines a movie's genre
     */
    public String checkGenre()
    {
	boolean validGenre = false;
	String userInput = null;
	do
	    {
		//Gets user input
		System.out.print("Genre of New Movie: ");
		userInput = in.nextLine();

		//Compares user input to pre-defined genres
		if(userInput.compareToIgnoreCase("Action") == MATCH)
			validGenre = true;
		else if(userInput.compareToIgnoreCase("Drama") == MATCH)
			validGenre = true;
		else if(userInput.compareToIgnoreCase("Comedy") == MATCH)
			validGenre = true;
		else if(userInput.compareToIgnoreCase("Horror") == MATCH)
			validGenre = true;
		else if(userInput.compareToIgnoreCase("Martial Arts") == MATCH)
			validGenre = true;
		else if(userInput.compareToIgnoreCase("Science Fiction") == MATCH)
			validGenre = true;
		else if(userInput.compareToIgnoreCase("Other") == MATCH)
			validGenre = true;

		//Accounts for the user entering a blank value (to cancel addition of a movie)
		else if(userInput.equals(""))
		    validGenre = true;
		//Prompts the user for further input if the genre is invalid
		else		   
		    System.out.println("ERROR: Invalid genre. Enter another genre.");	         
	    }
	while(validGenre == false);
	return(userInput);
    }

    /*checkRating: Checks if user input is valid. Does not error check for non-integer input. 
      Parameters: N/A
      Returns: An integer that defines a movie's rating
     */
    public int checkRating()
    {
	boolean validRating = false;
	int input = 0;

	while(validRating == false)
	    {
		//Gets user input
		System.out.print("Rating of New Movie: ");
		input = in.nextInt();

		//Checks if the user enters a valid rating between 1 and 5
		if (input >= 1 && input <= 5)
		    validRating = true;
		//Checks if the user enters a negative value (to cancel the addition of a movie)
		else if (input < 0)
		    validRating = true;
		//Otherwise prompts the user to enter another value
		else
		    System.out.println("ERROR: Invalid input. Enter an integer between 1 and 5.");
	    }
	in.nextLine();
	return(input);
    }

    /*add: Determines whether the list is empty or nonempty. Adds a new movie to the end of the list.  
      Parameters: A movie and a movie node
      Returns: N/A
     */
    public void add(Movie newMovie, MovieNode newNode)
    {
	//Adds a movie to an empty list. Sets the new movie as the head of the list.
	if(head == null)
	    head = newNode;

	//Adds a movie to a nonempty list. 
	else
	    {
		//Creates two pointers
		MovieNode current = head;
		MovieNode previous = null;
		//Moves the pointers along the list until the end is reached
		while(current != null)
		    {
			previous = current;
			current = current.getNext();
		    }
		//The new movie is added to the end of the list. The pointer of the second-last item now points to the newly added movie. 
		previous.setNext(newNode);
	    }
    }

    /*display: Displays the list.
      Parameters: N/A
      Returns: N/A
     */
    public void display()
    {
	MovieNode temp = head;
	int count = 0;

	//Displays a message if the list is empty
	if(temp == null)
	    System.out.println("List is empty. Nothing to display.");

	//Displays a nonempty list
	while(temp != null)
	    {
		//Prints information associated with a movie
		System.out.println(temp);
		//Increases a count
		count++;

		//Every four movies, the user will be prompted to hit enter to continue displaying the list
		if (count % 4 == 0)
		    {
			System.out.println();
			System.out.print("Hit enter to continue: ");
			in.nextLine();
		    }
		//Pointer points to the next movie
		temp = temp.getNext();
	    }
    }

    /*remove: Determines whether the list is empty or nonempty.
      Parameters: N/A
      Returns: N/A
     */
    public void remove()
    {
	//Displays a message when the list is empty. 
	if (head == null)
	    System.out.println("List is empty. Nothing to remove.");
	//Calls another method to remove items from nonempty lists
	else
	    removeNonEmpty();
    }

    /*removeNonEmpty: Prompts the user for the name of the movie to be removed. Searches for the movie title and (if found) removes that movie from the list. If not found, displays an appropriate message. 
      Parameters: N/A
      Returns: N/A
     */
    public void removeNonEmpty()
    {
	MovieNode previous = null; 
	MovieNode current = head;

	String searchTitle = null;
	String currentTitle;

	boolean found = false;

	//Gets user input
	System.out.print("Enter the movie title to be removed: ");
	searchTitle = in.nextLine();

	//Searches the list while the end has not been reached and the movie has not been found
	while((current != null) && (found == false))
	    {
		currentTitle = current.getData().getMovieName();

		//Compares movie title in list to user input
		if(searchTitle.compareToIgnoreCase(currentTitle) == MATCH)
		    found = true;
		else
		    {
			//Continues searching if not found
			previous = current;
			current = current.getNext();
		    }
	    }

	//Removes the movie if found
	if (found == true)
	    {
		System.out.println("Removing the movie called " + searchTitle+"...");

		//Special case accounts for the removed movie being the list's head
		if (previous == null)
		    head = head.getNext();
		//Handles cases where the removed movie is in any other position in the list
		else
		    previous.setNext(current.getNext());
	    }
	//If the movie is not found, prints an appropriate message
	else
	    System.out.println("No movie called "+searchTitle+" in your collection.");
    }

    /*search: Determines whether the list is empty or nonempty
      Parameters: N/A
      Returns: N/A
     */
    public void search()
    {
	//Displays a message if the list is empty
	if (head == null)
	    System.out.println("List is empty. Nothing to search for.");
	//Searches a nonempty list
	else
	    searchNonEmpty();
    }

    /*searchNonEmpty: Prompts the user for the name of the movie to search for. Searches the list for that movie. If found, displays a message that it has been found and displays the movie's info. 
      If not found, displays an appropriate message. 
      Parameters: N/A
      Returns: N/A
     */
    public void searchNonEmpty()
    {
	MovieNode previous = null; 
	MovieNode current = head;

	String searchTitle = null;
	String currentTitle;

	boolean found = false;

	Scanner in = new Scanner(System.in);

	//Gets user input
	System.out.print("Enter the movie title to search for: ");
	searchTitle = in.nextLine();

	//Searches while the end of the list has not been reached and the movie has not been found
	while((current != null) && (found == false))
	    {
		//Gets the title of a movie in the list
		currentTitle = current.getData().getMovieName();
		//Compares the movie's title to the user input
		if(searchTitle.compareToIgnoreCase(currentTitle) == MATCH)
		    found = true;
		else
		    {
			//Continues searching if the titles do not match
			previous = current;
			current = current.getNext();
		    }
	    }
	//Displays a message if the movie has been found. Displays the movie's info.
	if (found == true)
	    {
		System.out.println("Found the movie called " + searchTitle);
		System.out.println("FURTHER INFO:");
		System.out.println();
		System.out.print(current);
	    }
	//Displays a message if the movie is not found
	else
	    System.out.println("No movie called "+searchTitle+" in your collection.");
    }
}
