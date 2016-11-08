<?php 
 
 define("hostname", "localhost" );
 define("user", "root" );
 define("password", "" );
 define("databse", "store" );

	$con = mysqli_connect(hostname,user,password,databse);
	if(mysqli_connect_error(!$con)){
		echo "faild " . mysqli_error();
	}else{
	  //echo "success";
	 }
 
?>