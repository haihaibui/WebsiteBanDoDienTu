app.controller('QuanLyNguoiDungCtrl',function($http, $scope){
		
	$scope.items = []
	
	$scope.load_all = function(){
		var url = `${host}/NguoiDung`
		$http.get(url).then(resp =>{
			$scope.items = resp.data
			console.log("Success load all NguoiDung")
		}).catch(error =>{
			console.log("Error load all NguoiDung", error)
		})
	}
	
	//Tự động chạy khi chọn tab người dùng
	$scope.load_all()
	
})