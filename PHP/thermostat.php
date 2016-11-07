<?php
$con = mysqli_connect("localhost","root","");
mysqli_select_db($con,"sensors");

if(!empty($_POST))
{

        


	$usr=$_POST["desired"];



mysqli_query($con,"UPDATE `thermostat` SET `desired`= $usr WHERE id = 1");


	


}

mysqli_close($con);


?>	