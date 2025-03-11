<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Checkerboard</title>
</head>
<body>
<h1>Checkerboard</h1>

<form action="checker-servlet" method="get">
    <label for="rows">Amount of rows</label>
    <input id="rows" name="rows" type="number" value="5">

    <label for="columns">Amount of columns</label>
    <input id="columns" name="columns" type="number" value="5">

    <button type="submit">Submit</button>
</form>

<%
    int rows = (request.getAttribute("rows") != null) ? (int) request.getAttribute("rows") : 0;
    int columns = (request.getAttribute("columns") != null) ? (int) request.getAttribute("columns") : 0;

    if (rows != 0 && columns != 0) {
        out.println("<table style=\"margin-top: 1rem; border: 1px solid black\">");

        String[] colours = {"black", "white"};

        for (int i = 0; i < rows; i++) {
            out.println("<tr>");
            for (int j = 0; j < columns; j++) {
                String colour = colours[(i + j) % 2];
                out.println("<td style='padding: 20px; background-color: " + colour + "'></td>");
            }
            out.println("</tr>");
        }

        out.println("</table>");
    }
%>
</body>
</html>
