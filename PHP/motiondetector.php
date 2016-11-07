<?php
$con = mysqli_connect("localhost","root","");
mysqli_select_db($con,"sensors");

if(!empty($_POST))
{

        


	$usr=$_POST["motiondetector"];

$status = 0;
if ($usr == "true")
$status = 1;

if ($usr  == "false")
$status = 0;

mysqli_query($con,"UPDATE `motiondetector` SET `door_status`= $status WHERE id = 1");


	


}

mysqli_close($con);


?>	