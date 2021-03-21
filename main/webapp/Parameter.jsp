<%--
  Created by IntelliJ IDEA.
  User: yotov
  Date: 20.3.2021 г.
  Time: 16:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Get Parameter</title>
</head>
<body>

<h1>Twitter Post Timing </h1>
<form method="post" action="gettimeservlet">
    <label fo="number">How often do you want to post on Twitter(in minutes)</label>
    <input type="number" id="timer" name="timer">

    <button type="submit">Submit</button>
</form>

</body>
</html>
