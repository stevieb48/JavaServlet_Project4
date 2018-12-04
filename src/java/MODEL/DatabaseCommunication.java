/**
 * @author: Stephen Bailey #970396252
 * course: COP4856 201808
 * assignment: Project 4
 * @since: 11/30/2018 file name: DatabaseCommunication.java
 * @version: 2.0
 */
package MODEL;

// SQL LIBRARIES
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

/**
 * Description: Purpose of this Java class DatabaseCommunication is to 
 * REGISTER a MYSQL driver, 
 * BUILD a database connection, 
 * EXECUTE a search query, 
 * CONTAINS JavaDocs Annotations.
 */
public class DatabaseCommunication {

    // mysql connector driver
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";

    // create new static connection object
    private static Connection currentConnection;

    // URL
    private final String PROTOCOL = "jdbc:mysql://localhost:3306/";

    // database information
    private final String DATABASE_NAME = "seb48";
    private final String TABLE_NAME = "PlaylistSEB48";

    // user credentials
    private final String USER_NAME = "root";
    private final String PASSWORD = "";

    /**
     * Description: Purpose of this default constructor is to register the
     * database driver for use.
     */
    public DatabaseCommunication() {
        // prepare connection
        try {
            // register driver
            Class.forName(DRIVER).newInstance();

            // notify user Database driver was loaded successfully
            System.out.println("\nDatabase driver loaded Successfully");

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException err) {
            // notify user loading driver was NOT successful
            System.err.println("\nERROR ***** During database Instantiation/loading Database driver/AccessDenied");

            // show the error
            err.printStackTrace(System.err);

            // exit program
            System.exit(0);
        }

        // call private method to createConnection
        createConnection();
    }

    /**
     * Description: Purpose of this private method to create connection to a
     * MYSQL database.
     */
    private void createConnection() {

        // check if connection is not null
        try {
            // Creating a Connection to seb48 database
            currentConnection = DriverManager.getConnection(PROTOCOL + DATABASE_NAME, USER_NAME, PASSWORD);

            // notify user connection was made successfully
            System.out.println("\nConnection created Successfully");

        } catch (SQLException err) {
            // notify user connection was NOT successfull
            System.out.println("\nERROR ***** Can't create a connection");

            // show the error
            System.out.println(err.toString());

            // exit program
            System.exit(0);
        }
    }

    /**
     * Description: Purpose of this public method is to request a record from
     * the MYSQL database.
     *
     * @param keyword is the user input keyword value.
     * @return searchResults returns results object containing the movie values.
     */
    public Movie requestRecord(String keyword) {
        // create new results object using the keyword input
        Movie newSearchResults = new Movie(keyword);

        // query string
        String queryString = ("SELECT * FROM " + DATABASE_NAME + "." + TABLE_NAME + " WHERE mKeyword1 = '" + keyword + "' or mKeyword2 = '" + keyword + "' or mKeyword3 = '" + keyword + "' or mKeyword4 = '" + keyword + "' or mKeyword5 = '" + keyword + "';");

        // try to search database with connection
        try {
            // prepare statement to be exceuted
            PreparedStatement preparedStatement1 = currentConnection.prepareStatement(queryString);

            // excute query, return resultset into blank resultset object
            try (ResultSet resultSet1 = preparedStatement1.executeQuery(queryString)) {
                // while resultset has results put values into blank results object
                while (resultSet1.next()) {
                    newSearchResults.iD = resultSet1.getInt("PlaylistSEB48ID");
                    newSearchResults.title = resultSet1.getString("mTitle");
                    newSearchResults.directorName = resultSet1.getString("mDirectorName");
                    newSearchResults.directorBdate = (resultSet1.getString("mDirectorBdate"));
                    newSearchResults.minutesruntime = resultSet1.getInt("mMinutesruntime");
                    newSearchResults.filmstudio = resultSet1.getString("mFilmstudio");
                    newSearchResults.imdbref = resultSet1.getString("mImdbref");
                    newSearchResults.year = resultSet1.getString("mYear");
                    newSearchResults.metascore = resultSet1.getInt("mMetascore");
                    newSearchResults.rottentomatoes = resultSet1.getInt("mRottentomatoes");
                    newSearchResults.keyword1 = resultSet1.getString("mKeyword1");
                    newSearchResults.keyword2 = resultSet1.getString("mKeyword2");
                    newSearchResults.keyword3 = resultSet1.getString("mKeyword3");
                    newSearchResults.keyword4 = resultSet1.getString("mKeyword4");
                    newSearchResults.keyword5 = resultSet1.getString("mKeyword5");
                }
            }

            // close database connection
            currentConnection.close();

            // return results object
            return newSearchResults;

        } catch (SQLException err) {
            // notify user error executing query
            System.err.println("\nERROR ***** executing search query");

            // show the error
            err.printStackTrace(System.err);

            // exit program
            System.exit(0);
        }

        // return resultset
        return newSearchResults;
    }
}
