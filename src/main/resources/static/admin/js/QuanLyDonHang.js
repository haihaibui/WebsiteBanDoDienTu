app.controller('QuanLyDonHangCtrl',function($http, $scope){
	
	attachOrderButtonEvents()
	
	$scope.items = []
	
	$scope.title = "tất cả đơn hàng"
	
	//Load tất cả đơn hàng có trong csdl
	$scope.load_all = function(){
		var url = `${host}/DonHang`
		$http.get(url).then(resp =>{
			$scope.items = resp.data
			$scope.title = "tất cả đơn hàng"
			console.log("Success load all DonHang")
		}).catch(error => {
			console.log("Error load all DonHang", error)
		})
	}
	
	//Load đơn hàng theo trang thái
	$scope.load_by_status = function(status){
		var url = `${host}/DonHang/TrangThai/${status}`
		$http.get(url).then(resp => {
			$scope.items = resp.data
			$scope.title = `đơn hàng ${status.toLowerCase()}`
			console.log("Success load DonHang by status")
		}).catch(error => {
			console.log("Error load DonHang by status")
		})
	}
	
	//Tự chạy đầu tiên khi chọn tab đơn hàng
	$scope.load_all()
	
})