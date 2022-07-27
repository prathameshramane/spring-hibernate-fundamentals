<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "https://www.w3.org/TR/html4/loose.dtd">
    <html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
        <title>First JSP</title>
    </head>

    <body>
        <h3>Add Alien</h3>
        <form action="addAlien">
            <input type="text" name="aid" /><br>
            <input type="text" name="aname" /><br>
            <input type="submit" value="Submit" />
        </form>
        <h3>Get Alien</h3>
        <form action="getAlien">
            <input type="text" name="id" /><br>
            <input type="submit" value="Submit" />
        </form>

    </body>

    </html>