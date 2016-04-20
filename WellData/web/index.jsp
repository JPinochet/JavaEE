<%-- 
    Document   : index
    Created on : Apr 20, 2010, 10:00:33 AM
    Author     : Administrator
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="author" content="Jorge Pinochet" />
        <meta name="description" content="Website that rates other websites! Voted on by you." />
        <meta name="keywords" content="site, rate, user managed" />
        <title>Well Information</title>
        <link rel="stylesheet" type="text/css" href="css/style.css" media="screen" />
        <link rel="shortcut icon" href="nyansapo.gif" />
        <script type="text/javascript" src="js/textsizer.js"></script>
        <script type="text/javascript" src="js/rel.js"></script>
    </head>
    <body>
        <div id="wrap">
            <div id="top">
                <h2>Well Data</h2>
            </div>
            <div id="context" align="center">
                <h3>Search Wells: </h3>
                <form action="Controller" method="POST">
                    Well Location: <input type="text" name="search" />
                    <input type="submit" value="Search" />
                </form>
                <c:if test="${!empty param.search}">
                    <br /><br /><hr /><br />
                    <h2>Well Information</h2>
                    <br />
                    <table border="1">
                        <tr>
                            <th>Location:</th>
                            <th>Depth (m):</th>
                            <th>Perforation Depth (m):</th>
                            <th>Perforation Zone (m):</th>
                            <th>Pump Stroke Length (m):</th>
                            <th>Pump Strokes Per Minute:</th>
                        </tr>
                        <c:forEach var="well" items="${sessionScope.wellDataInfo}">
                            <c:if test="${well.location == param.search}">
                                <tr>
                                    <td><c:out value="${well.location}" /></td>
                                    <td><c:out value="${well.depth}" /></td>
                                    <td><c:out value="${well.perforationDepth}" /></td>
                                    <td><c:out value="${well.perforationZone}" /></td>
                                    <td><c:out value="${well.pumpStrokeLength}" /></td>
                                    <td><c:out value="${well.pumpStrokesPerMinute}" /></td>
                                </tr>
                            </c:if>
                        </c:forEach>
                    </table><br /><br />
                    <h2>Well Production Information</h2>
                    <br />
                    <table border="1">
                        <tr>
                            <th>Location:</th>
                            <th>Date (yyyy-MM-dd):</th>
                            <th>Oil Production (m<sup>3</sup>/day):</th>
                            <th>Water Production (m<sup>3</sup>/day):</th>
                            <th>Gas Production (m<sup>3</sup>/day):</th>
                        </tr>
                        <c:forEach var="well" items="${sessionScope.wellProdInfo}">
                            <c:if test="${well.location == param.search}">
                                <tr>
                                    <td><c:out value="${well.location}" /></td>
                                    <td><c:out value="${well.date}" /></td>
                                    <td><c:out value="${well.oilProduction}" /></td>
                                    <td><c:out value="${well.waterProduction}" /></td>
                                    <td><c:out value="${well.gasProduction}" /></td>
                                </tr>
                            </c:if>
                        </c:forEach>
                    </table><br /><br />
                </c:if>
            </div>
        </div>
    </body>
</html>
