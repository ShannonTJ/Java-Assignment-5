/*Author: Shannon TJ 10101385 Tutorial 1
  Version: April 15, 2015

  Features: Contains all information associated with a movie (i.e. title, cast names, genre, and rating). Contains mutator methods to change these values. Contains a toString method that prints these values.

  Limitations: Only the title has an accessor method. The genre and rating do not have default values of "No Genre" and "No Rating" in the toString method because of the Manager class's error checking. 

 */

public class Movie
{
    private String movieName;
    private String [] castNames = new String [3];
    private String movieGenre;
    private int movieRating;

    //Sets a movie's attributes to specified values
    public Movie(String movieName1, String [] castNames1, String movieGenre1, int movieRating1)
    {
	setMovieName(movieName1);
	setCastNames(castNames1);
	setMovieGenre(movieGenre1);
	setMovieRating(movieRating1);
    }

    /*getMovieName: Returns a movie's name
      Parameters: N/A
      Returns: A string containing the movie's name
     */
    public String getMovieName()
    {
	return(movieName);
    }

    /*setMovieName: Sets a movie's name to a new value
      Parameters: A string containing the movie's new title
      Returns: N/A
     */
    public void setMovieName(String movieName1)
    {
	movieName = movieName1;
    }

    /*setCastNames: Sets a movie's cast names to new values
      Parameters: An array of strings containing the movie's new cast members
      Returns: N/A
     */
    public void setCastNames(String [] castNames1)
    {
	castNames [0] = castNames1 [0];
	castNames [1] = castNames1 [1];
	castNames [2] = castNames1 [2];
    }

    /*setMovieGenre: Sets a movie's genre to a new value
      Parameters: A string containing the movie's new genre
      Returns: N/A
     */
    public void setMovieGenre(String movieGenre1)
    {
	movieGenre = movieGenre1;
    }

    /*setMovieRating: Sets a movie's rating to a new value
      Parameters: An integer containing the movie's new rating
      Returns: N/A
     */
    public void setMovieRating(int movieRating1)
    {
	movieRating = movieRating1;
    }

    /*toString: Displays all of the information associated with a movie
      Parameters: N/A
      Returns: A string containing all of the movie's attributes
     */
    public String toString()
    {
	//Sets a default movie title if no name is entered
	String printName;
	if(movieName == null || movieName.equals(""))
	    printName = "No Name";
	else
	    printName = movieName;

	//Sets default cast names if no names are entered
	String printCast [] = new String [3];
	for(int i = 0; i < 3; i++)
	    {
		if(castNames [i] == null || castNames[i].equals(""))
		    printCast [i] = "No Cast Name";
		else
		    printCast [i] = castNames [i];
	    }

	//Prints the movie's information with each attribute on a separate line
	String s = "";
	s = s+printName+"\n"+printCast[0]+"\n"+printCast[1]+"\n"+printCast[2]+"\n"+movieGenre+"\n"+movieRating+"\n*****************";
	return s;
    }
}
