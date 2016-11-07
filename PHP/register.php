<?php
//$con = mysql_connect("localhost","root","");
$con = mysqli_connect("localhost","root","");

if (!$con){ die('Could not connect: ' . mysqlic_error());}


if (mysqli_select_db($con,"users")) {

	$name = $_POST["username"];
	$pwd = $_POST["password"];
	$fname = $_POST["firstname"];
	$lname = $_POST["lastname"];

	
	$q = mysqli_query($con,"SELECT EXISTS(SELECT * FROM userlist WHERE username = '$name')");
	
	
	
	
		$result = mysqli_query($con,"INSERT INTO userlist (username, password, firstname, lastname)
		VALUES ('$name','$pwd','$fname','$lname')");
		if($result)
			print("true");
		else
			print("false");
	
}	
mysqli_close($con);
?>