app.controller('QuanLyDonHangCtrl',function($http, $scope){
	
	attachOrderButtonEvents()
	
	$scope.items = []
	
	$scope.load_all = function(){
		var url = `${host}/DonHang`
		$http.get(url).then(resp =>{
			$scope.items = resp.data
			console.log("Success load all DonHang")
		}).catch(error => {
			console.log("Error load all DonHang", error)
		})
	}
	
	//Tự chạy đầu tiên khi chọn tab đơn hàng
	$scope.load_all()
	
})