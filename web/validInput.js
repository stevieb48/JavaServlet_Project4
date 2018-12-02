/*
 author: Stephen Bailey #970396252
 course: COP4856 201808
 assignment: Project 4
 date: 11/30/2018
 file name: validInput.js
 version: 1.0
 
 Description:
 Purpose of this JS file validInput is to validate the users input. 
 */
function validInput(value)
{
    // setup pattern to be used to validate user input
    var validationPattern = /^[0-9a-zA-Z]+$/;

    // test if input at least 1 character or digit
    if ((value.length > 0) && (value.match(validationPattern))) {
        // validation passes
        return true;
    }
    else
    {
        // validation fails
        return false;
    }
}