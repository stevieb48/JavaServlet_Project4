/*
author: Stephen Bailey #970396252
course: COP4856 201808
assignment: project 4
date: 11/02/2018
file name: prj4_crtDBSEB48_crtTBLPlaylist.sql
version: 1.0

Description: The purpose of this MySQL script is to 
CREATE a database called 'SEB48',
CREATE a table called 'PlaylistSEB48',
INSERT data into the 'PlaylistSEB48' table,
The primary key 'PlaylistSEB48ID' is auto incremented,
CREATE user seb48,
GRANT seb48 SELECT priviledges.
*/

/*************   CREATE SEB48 DATABASE    *************/
DROP DATABASE IF EXISTS SEB48;CREATE DATABASE SEB48;

/************* CREATE PlaylistSEB48 TABLE *************/
CREATE TABLE SEB48.PlaylistSEB48 (
    PlaylistSEB48ID INT NOT NULL AUTO_INCREMENT,
    mTitle VARCHAR(50),
    mDirectorName VARCHAR(50),
    mDirectorBdate VARCHAR(9),
    mMinutesruntime INT,
    mFilmstudio VARCHAR(50),
    mImdbref VARCHAR(12),
    mYear VARCHAR(5),
    mMetascore INT,
    mRottentomatoes INT,
    mKeyword1 VARCHAR(25),
    mKeyword2 VARCHAR(25),
    mKeyword3 VARCHAR(25),
    mKeyword4 VARCHAR(25),
    mKeyword5 VARCHAR(25),
    PRIMARY KEY (PlaylistSEB48ID)
);

/************* INSERT MOVIE1 WITH VALUES *************/
INSERT INTO
  SEB48.PlaylistSEB48 (
    mTitle,
    mDirectorName,
    mDirectorBdate,
    mMinutesruntime,
    mFilmstudio,
    mImdbref,
    mYear,
    mMetascore,
    mRottentomatoes,
    mKeyword1,
    mKeyword2,
    mKeyword3,
    mKeyword4,
    mKeyword5
  )
VALUES
  (
    'Star Wars: Episode IV - A New Hope',
    'George Lucas',
    '19440514',
    '121',
    'Twentieth Century Fox',
    'tt0076759',
    '1977',
    '90',
    '93',
    'starwars',
    'darthvader',
    'georgelucas',
    'force',
    'skywalker'
  );

/************* INSERT MOVIE2 WITH VALUES *************/
INSERT INTO
  SEB48.PlaylistSEB48 (
    mTitle,
    mDirectorName,
    mDirectorBdate,
    mMinutesruntime,
    mFilmstudio,
    mImdbref,
    mYear,
    mMetascore,
    mRottentomatoes,
    mKeyword1,
    mKeyword2,
    mKeyword3,
    mKeyword4,
    mKeyword5
  )
VALUES
  (
    'Harry Potter and the Chamber of Secrets',
    'Chris Columbus',
    '19580910',
    '161',
    'Warner Bros',
    'tt0295297',
    '2002',
    '63',
    '82',
    'harrypotter',
    'jkrowling',
    'hogwarts',
    'basilisk',
    'dumbledore'
  );

/************* INSERT MOVIE3 WITH VALUES *************/
INSERT INTO
  SEB48.PlaylistSEB48 (
    mTitle,
    mDirectorName,
    mDirectorBdate,
    mMinutesruntime,
    mFilmstudio,
    mImdbref,
    mYear,
    mMetascore,
    mRottentomatoes,
    mKeyword1,
    mKeyword2,
    mKeyword3,
    mKeyword4,
    mKeyword5
  )
VALUES
  (
    'The Hobbit: An Unexpected Journey',
    'Peter Jackson',
    '19611031',
    '169',
    'MGM',
    'tt0903624',
    '2012',
    '58',
    '65',
    'hobbit',
    'peterjackson',
    'gandalf',
    'bilbo',
    'thorin'
  );
