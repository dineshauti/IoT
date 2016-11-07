<?php
$con = mysqli_connect("localhost","root","");
mysqli_select_db($con,"sensors");

if(!empty($_POST))
{

        


	$usr=$_POST["security"];

$status = 0;
if ($usr == "0")
$status = 0;

if ($usr  == "1")
$status = 1;

if ($usr  == "2")
$status = 2;
mysqli_query($con,"UPDATE `securitysystem` SET `door_status`= $status WHERE id = 1");


	


}

mysqli_close($con);


?>	