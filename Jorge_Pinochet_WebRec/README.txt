webrecdb.sql is a dump of the database i created. Holds information about
	users, websites and a rating with a composite primary key of 
	user_id, website_id that are from 2 other tables. Also holds 
	information that i added while testing my site.

Inside the WebRec EE app I seperated the functionality from the actual 
	front end as much as possible. WebRec-ejb holds all the calls to 
	the database inside a stateless bean called DBManager. I created 
	a class to hold the information about a website and my session 
	holds an arraylist of this class, just easier to manipulate. 
	Most of my db connections are handled by the EntityManager inside
	the DBManager bean with the exception of the adding rates, for some
	reason i couldn't get the entity manager to persist properly the 
	composite primary key in the table. index.jps is the login page, 
	register can be accessed through that page and users.jsp 
	and admin.jsp can be accessed through login in index.jsp. 
	Everything works as far as I read in the assignment, calls from the
	jsp page go to controller which then call the appropriate functions
	into action.

	So structure wise i suppose it goes:
	jsp > Controller > DManager then back to jsp.