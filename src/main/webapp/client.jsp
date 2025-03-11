<%@ page import="java.util.List" %>
<%@ page import="com.example.jakartaee.Client" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Client</title>
</head>
<body>
<h1>Client</h1>

<div style="display: flex; justify-content: space-evenly">
    <form action="client-servlet" method="post" style="display: grid">
        <h2>Insertion des clients</h2>

        <label for="name">Name of the client</label>
        <input id="name" name="name" type="text">

        <label for="city">City of the client</label>
        <input id="city" name="city" type="text">

        <label for="code">Code of the client</label>
        <input id="code" name="code" type="number">

        <button type="submit">Submit</button>
    </form>

    <div>
        <h2>Affichage des clients</h2>

        <%
            List<Client> clientList = (List<Client>) request.getAttribute("client-list");

            if (clientList != null && !clientList.isEmpty()) {
                out.println("<ul style='list-style: none'>");

                for (Client client : clientList) {
                    out.println(
                            "<li>" +
                                "Client : " + client.getName() +
                                "<ul>" +
                                    "<li>City: " + client.getCity() + "</li>" +
                                    "<li>Code: " + client.getCode() + "</li>" +
                                "</ul>" +
                            "</li>"
                    );
                }

                out.println("</ul>");
            }
        %>
    </div>
</div>
</body>
</html>
