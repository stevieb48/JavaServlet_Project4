/**
 * @author: Stephen Bailey #970396252
 * course: COP4856 201808
 * assignment: Project 4
 * @since: 11/30/2018 file name: Movie.java
 * @version: 2.0
 */
package MODEL;

/**
 * Description: Purpose of this Java class Movie is to 
 * DEFINE movie record from a keyword search query results, 
 * DISPLAY contents to the user, 
 * CONTAINS JavaDocs Annotations.
 */
public class Movie {

    // CONSTANT
    private final String NOT_FOUND = "NOT FOUND";

    // instance variables
    public String userKeyword;
    public int iD;
    public String title;
    public String directorName;
    public String directorBdate;
    public int minutesruntime;
    public String filmstudio;
    public String imdbref;
    public String year;
    public int metascore;
    public int rottentomatoes;
    public String keyword1;
    public String keyword2;
    public String keyword3;
    public String keyword4;
    public String keyword5;

    /**
     * Description: Purpose of this constructor is to set the keyword variable
     * from the user input and set the remaining variables to null or 0.
     *
     * @param keyword represents the users input movie keyword search
     */
    public Movie(String keyword) {
        this.userKeyword = keyword;
        this.iD = 0;
        this.title = NOT_FOUND;
        this.directorName = null;
        this.directorBdate = null;
        this.minutesruntime = 0;
        this.filmstudio = null;
        this.imdbref = null;
        this.year = null;
        this.metascore = 0;
        this.rottentomatoes = 0;
        this.keyword1 = null;
        this.keyword2 = null;
        this.keyword3 = null;
        this.keyword4 = null;
        this.keyword5 = null;
    }

    /**
     * Description: Purpose of this toString is to output the searchResults
     * instance variables.
     *
     * @return toString returns a string representing the contents of a search
     * result.
     */
    @Override
    public String toString() {
        return ("<h1 id='mTitle'>" + this.title + "</h1><p>" 
                + "<table border='1'><tr bgcolor='#9acd32'><th>Year</th><th>Run Time</th><th>Production Company</th></tr><tr bgcolor='#FFFFFF'><td>"
                + this.year + "</td><td>" 
                + this.minutesruntime + "</td><td>" 
                + this.filmstudio + "</td></tr></table></p><p> IMDB reference - " 
                + "<a href='https://www.imdb.com/title/" + this.imdbref + "'>" + this.imdbref + "</a>"
                + "</a></p><p><br></p><h2 id='mDirector'>Director</h2><table border='1'><tr bgcolor='#FFFF00'><th>Name</th><th>Birth Date</th></tr><tr bgcolor='#FFFFFF'><td>"
                + this.directorName + "</td><td>" 
                + this.directorBdate + "</td></tr></table><p><br></p><h3 class='mRatings'>Metascore = " 
                + this.metascore + "</h3><h3 class='mRatings'>Rotten Tomatoes = " 
                + this.rottentomatoes + "%</h3><p><br></p><p>Movie Keywords<ul class='mKeywords'><li><keyword>"
                + this.keyword1 + "</keyword></li><li><keyword>"
                + this.keyword2 + "</keyword></li><li><keyword>"
                + this.keyword3 + "</keyword></li><li><keyword>"
                + this.keyword4 + "</keyword></li><li><keyword>"
                + this.keyword5 + "</keyword></li></ul></p>");
    }
}
