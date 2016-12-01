/*Author: Shannon TJ 10101385 Tutorial 1
  Version: April 15, 2015

  Features: Can access and change the values of Movies/MovieNodes in the linked list. 

  Limitations: Needs a Manager and Movie class in order to function properly. 

 */

public class MovieNode
{
    private Movie data;
    private MovieNode next;

    //Sets a movie's data and its node to null default values
    public MovieNode()
    {
	setData(null);
	setNext(null);
    }

    //Sets a movie's data to information contained in the movie's attributes. Sets its MovieNode to point to the next node. 
    public MovieNode(Movie data1, MovieNode nextNode)
    {
	setData(data1);
	setNext(nextNode);
    }

    /*getNext: Gets the address of the next MovieNode in the list
      Parameters: N/A
      Returns: The MovieNode of the next movie in the list
     */
    public MovieNode getNext()
    {
	return(next);
    }

    /*setNext: Sets the address of a MovieNode to the next node in the list
      Parameters: The MovieNode of the next movie in the list
      Returns: N/A
     */
    public void setNext(MovieNode nextNode)
    {
	next = nextNode;
    }

    /*getData: Gets the data associated with a movie
      Parameters: N/A
      Returns: A Movie and all of its associated information
     */
    public Movie getData()
    {
	return(data);
    }

    /*setData: Sets a movie's data to specified values
      Parameters: A Movie 
      Returns: N/A
     */
    public void setData(Movie data1)
    {
	data = data1;
    }

    /*toString: Displays information associated with a movie
      Parameters: N/A
      Returns: A string containing all of a movie's information
    */
    public String toString()
    {
	return(data.toString());
    }
}
