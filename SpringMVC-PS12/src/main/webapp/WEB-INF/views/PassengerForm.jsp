<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Passenger Registration Form</title>
</head>
<body>
    <h2>Passenger Registration Form</h2>
    <form action="/passenger/register" method="post">
        Passenger Name: <input type="text" name="passengerName"><br>
        Passenger DOB: <input type="text" name="passengerDob"><br>
        Passenger Phone: <input type="text" name="passengerPhone"><br>
        Passenger Email: <input type="text" name="passengerEmail"><br>
        <input type="submit" value="Register">
    </form>
</body>
</html>
