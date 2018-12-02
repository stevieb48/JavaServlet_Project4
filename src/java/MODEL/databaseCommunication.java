/**
 * @author: Stephen Bailey #970396252
 * course: COP4856 201808
 * assignment: Project 4
 * @since: 11/30/2018 file name: databaseCommunication.java
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
 * Description: Purpose of this Java class databaseCommunication is to 
 * REGISTER a MYSQL driver, 
 * BUILD a database connection, 
 * EXECUTE a search query, 
 * CONTAINS JavaDocs Annotations.
 */
public class databaseCommunication {

    // Private CONSTANTS
    private final String DATABASE_NAME = "seb48";
    private final String TABLE_NAME = "PlaylistSEB48";

    // create new connection object
    private Connection connection1;

    /**
     * Description: Purpose of this default constructor is to 
     * REGISTER the database driver for use,
     * ESTABLISH a connection to the database.
     */
    public databaseCommunication() {
        // prepare connection
        try {
            // set connection object to null
            connection1 = null;

            // mysql connector driver
            String driver = "com.mysql.cj.jdbc.Driver";

            // register driver
            Class.forName(driver).newInstance();

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
     * Description: Purpose of this private method is to 
     * CREATE a connection to a MYSQL database.
     */
    private void createConnection() {
        // URL
        String protocol = "jdbc:mysql://localhost:3306/";

        // CONSTANTS user credentials
        final String USER_NAME = "root";
        final String PASSWORD = "";

        // check if connection is not null
        if (this.connection1 != null) {
            // notify user connection could not be made
            System.out.println("\nERROR ***** Can't create a connection");
        } else {
            // when connection is null create a new connection
            try {
                // Creating a Connection to seb48 database
                this.connection1 = DriverManager.getConnection(protocol + DATABASE_NAME, USER_NAME, PASSWORD);

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
    }

    /**
     * Description: Purpose of this public method is to 
     * REQUEST a record from the MYSQL database based on user input (keyword).
     *
     * @param keyword is the user input keyword value.
     * @return searchResults returns results object containing the movie values.
     */
    public searchResults requestRecord(String keyword) {
        // create new results object using the keyword input
        searchResults newSearchResults = new searchResults(keyword);

        // create query string
        String queryString = ("SELECT * FROM " + DATABASE_NAME + "." + TABLE_NAME + " WHERE mKeyword1 = '" + keyword + "' or mKeyword2 = '" + keyword + "' or mKeyword3 = '" + keyword + "' or mKeyword4 = '" + keyword + "' or mKeyword5 = '" + keyword + "';");

        // try to search database with connection
        try {
            // prepare prepared statement to be exceuted
            PreparedStatement preparedStatement1 = this.connection1.prepareStatement(queryString);

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
            this.connection1.close();

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

        // return results object
        return newSearchResults;
    }
}
