<?php 

	require_once "json_representation/oneclick_register_data_json.php";

	class OneClickJsonBuilder{
		
		public function newOneClickRegister($oneclickRegisterData){
			$jsonOneClickRegister = new OneclickRegisterDataJson($oneclickRegisterData);

			return $jsonOneClickRegister;
		}
	}

 ?>