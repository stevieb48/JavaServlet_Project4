/*
 author: Stephen Bailey #970396252
 course: COP4856 201808
 assignment: Project 4
 date: 11/30/2018
 file name: callServlet.js
 version: 1.0
 
 Description:
 Purpose of this JS file is to call the servlet using JQuery-AJAX method. 
 */
function callServlet(value)
{
    // 
    $.ajax({
        type: "GET",
        url: "/SBailey_COP4856_201808_Project4_ver4/MovieKeywordSearch_Servlet",
        dataType: "text/html;charset=UTF-8",
        data: value,
        success: function(responseText){
            // process response
            $("#results").append(responseText);
        },
        error: function () {
            // notify user problem calling servlet
            $("#results").append("<h1 id='error'>**** ERROR - Problem Calling servlet ****");
        }
    });
}