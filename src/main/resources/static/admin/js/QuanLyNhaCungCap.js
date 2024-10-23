app.controller('QuanLyNhaCungCapCtrl',function($http, $scope){
		
	$scope.items = []
	
	$scope.load_all = function(){
		var url = `${host}/NhaCungCap`
		$http.get(url).then(resp =>{
			$scope.items = resp.data
			console.log("Success load all NhaCungCap")
		}).catch(error =>{
			console.log("Erorr load all NhaCungCap",error)
		})
	}
	
	//Tự động chạy đầu tiên khi mở tab 
	$scope.load_all()
})