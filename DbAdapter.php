<?php 

//require_once ("/constant.php");
//require_once (dirname(__FILE__) .'/Constance.php');

//require_once(__DIR__.'/Constance.php');
 
 if($_SERVER['REQUEST_METHOD'] == 'POST'){
	 require_once(__DIR__.'/Constance.php');
	 createUser();
 } 
 
 function createUser(){
	 global $con;
	 
	 $name = $_POST['name'];
	 $address = $_POST['address'];
	 $city = $_POST['city'];
	 $country = $_POST['country'];
	 $email = $_POST['email'];
	 $password = $_POST['password'];
	 $zip = $_POST['zip'];
	 $phone = $_POST['phone'];
	 
	 $pass_md5 =md5($password);
	 
	 
	  if (	empty($name) || 
			empty($address)|| 
			empty($city) || 
			empty($country) || 
			empty($email)||
			empty($password) || 
			empty($zip) ||
			empty($phone)){
				
			echo "Field must not be empty";
 }else{
	 
	 //$query = "INSERT INTO tbl_customer(name, address,city, country, email,password, zip, phone) VALUES ("$name", "$address", "$city", "$country", "$email", "$password", "$zip", "$phone")";
	 $query = "INSERT INTO tbl_customer (name,address,city,country,email,password,zip,phone)values('$name','$address','$city','$country',' $email','$pass_md5','$zip','$phone')";
	 $result = mysqli_query($con, $query) or die(mysqli_error($con));
	 json_encode($result);
	 if($result){
		 echo "Insert data successfully"; 
	 }else{
		echo "Something wrong"; 
	 }
	 
 }
	 
	 
	         
        

	 mysqli_close($con);	
	 
	 
 }
   

?>