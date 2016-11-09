<?php 
 
 
 if($_SERVER['REQUEST_METHOD'] == 'POST'){
	 require_once(__DIR__.'/Constance.php');
	 UserLogin();
 } 
 
 
 function UserLogin(){
	 global $con;
	 $email = $_POST['email'];
	 $password = $_POST['password'];
	 
	 $query = "SELECT email, password from where email like '".$email."' AND password like '".$password."';";
	 
	 $result =mysqli_query($con, $query);
	 $response = array();
	 if(mysqli_num_rows($result)>0){
		$row = mysqli_fetch_row($result);
		$email = row[0];
		$password = row[1];
		$code ="login_Success";
		array_push($response, array("code"=>$code, "email"=>$email, "password"=>$password));
		echo json_encode($response);	
	 }else{
		$code="login_faild"; 	
		$message="User not found. Please try again";
		array_push($response, array("code"=>$code, "message"=>$message));
		echo json_encode(response);
	 }
	 mysqli_close();
 }
?>