<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="add" method="post">
TrainNo :<input type="text" name="tno"><br>

Train Name : <input type="text" name="tname"><br>
From Station :<input type="text" name="fstation"><br>
To Station :<input type="text" name="tstation"><br>
Dept Time :<input type="text" name="dtime"><br>
Arrival Time :<input type="text" name="atime"><br>
Fare :<input type="text" name="price"><br>
Tickit Available :<input type="text" name="avl"><br>

<input type="submit" value="AddTrain">
</form>

</body>
</html>