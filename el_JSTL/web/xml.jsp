<%-- 
    Document   : xml
    Created on : Feb 23, 2010, 9:22:42 AM
    Author     : Administrator
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>XML Page</title>
    </head>
    <body>
        <h1>XML</h1>

        <fmt:formatNumber type="currency" value="100000.123456" maxFractionDigits="3" minFractionDigits="1" groupingUsed="true"/>
        <br />


        <c:import var="rss" url="http://feeds.reuters.com/reuters/topNews?format=xml"/>
        <x:parse varDom="dom" xml="${rss}" />

        <x:out select="$dom//*[name()='channel']/*[name()='title'][1]" escapeXml="false"/>

        <x:forEach select="$dom//*[name()='item']">
            <a href="<x:out select="./*[name()='link']"/>">
                <x:out select="./*[name()='title']" escapeXml="false" />
            </a><br />
        </x:forEach>
            
    </body>
</html>
