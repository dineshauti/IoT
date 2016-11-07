<?php
$con = mysqli_connect("localhost","root","");
mysqli_select_db($con,"sensors");

if(!empty($_POST))
{

        


	$usr=$_POST["garagedoor1"];

$status = 0;
if ($usr == "true")
$status = 1;

if ($usr  == "false")
$status = 0;

mysqli_query($con,"UPDATE `garagedoor1` SET `door_status`= $status WHERE id = 1");


	


}

mysqli_close($con);


?>	