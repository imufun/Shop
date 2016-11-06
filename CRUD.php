<?php 
//require_once(dirname(__FILE__).'/DbAdapter.php');
	require_once(__DIR__.'/DbAdapter.php');

	//require_once ("/DbAdapter.php");
	
	if($_SERVER['REQUEST_METHOD']=='save'){
		$dbAdapter = new DbAdapter();
		$name =$_POST['name'];
		$school =$_POST['school'];
		$tech =$_POST['tech'];
		
		$dbAdapter->insert(array($name,$school, $tech));
	}



?>