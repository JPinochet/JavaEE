<%-- 
    Document   : index
    Created on : Mar 18, 2010, 12:08:53 PM
    Author     : Administrator
--%>
<%@page import="java.util.ArrayList" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Game</title>
    </head>
    <body>
        <h1>Guessing Game</h1><br />
        <form action="GuessingGame" method="POST">
            Enter your guess (1-50)
            <input type="text" name="guess" />
            <input type="submit" value="Guess" />
        </form>
        <%
            String message = request.getParameter("message");
            if(message != null)
            {
                if(message.equals("That's it!!"))
                {
                    int numGuess = (Integer)session.getAttribute("numberOfGuesses");
                    ArrayList<Integer> guesses = (ArrayList<Integer>) session.getAttribute("guessList");
                    out.println(message);
                    out.print("You got it in " + numGuess + " guesses. Guesses: [");
                    for(int i = 0; i < guesses.size(); i++)
                    {
                        out.print(guesses.get(i));
                    }
                    out.print("]");
                }
                else
                {
                    out.println(message + "\n");
                }
            }
        %>
        <%
            int numGuess = (Integer)session.getAttribute("numberOfGuesses");
            if(numGuess != 0)
                out.println("Number of guesses: " + numGuess + "\n");
        %>
    </body>
</html>
