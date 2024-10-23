app.controller('QuanLyChungloaiCtrl',function($http, $scope){
	
	let host = "http://localhost:8080/api/ChungLoai"
	
	$scope.items = []
	
	$scope.load_all = function(){
		var url = `${host}`
		$http.get(url).then(resp =>{
			$scope.items = resp.data;
			console.log("Get all ChungLoai  success")
		}).catch(error =>{
			console.log("error get all ChungLoai", error)
		})
	}
	
	//Tự động chạy đầu tiên khi mở tab Quản lý chủng loại
	$scope.load_all()
	
})