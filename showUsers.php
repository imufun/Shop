<?php 

	if($_SERVER['REQUEST_METHOD'] == 'POST'){
	 require_once(__DIR__.'/Constance.php');
	 showUSer();
} 

	function showUSer(){
		
		global $con;
		
		$query = "SELECT *FROM tbl_customer";
		$result = mysqli_query($con, $query);
		$num_of_rows = mysqli_num_rows($result);
		$temp_array = array();
		if($num_of_rows> 0){
			while($row = mysqli_fetch_assoc($result)){
				$temp_array[] = $row;
			}
		}
		header('Content-Type : application/json');
		echo json_encode(array("tbl_customer" => $temp_array));
		mysqli_close($con);
	}

?>