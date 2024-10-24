app.controller('thongKeCtrl',function($http, $scope){
	$scope.quantity_customer = null
	$scope.quantity_product = null
	$scope.quantity_bill = null
	
	//Đếm số lượng khách hàng
	$scope.count_customer = function(){
		var url = `${host}/NguoiDung/SoLuongKhachHang`
		$http.get(url).then(resp => {
			$scope.quantity_customer = resp.data
			console.log("Success count quantity customer",resp)
		}).catch(error => {
			console.log("Error count quantity customer",error)
		})
	}
	
	//Đếm số lượng sản phẩm
	$scope.count_product = function(){
		var url = `${host}/SanPham/SoLuong`
		$http.get(url).then(resp => {
			$scope.quantity_product = resp.data
			console.log("Success count quantity product",resp)
		}).catch(error => {
			console.log("Error count quantity product",error)
		})
	}
	
	//Đếm số lượng đơn hàng
	$scope.count_bill = function(){
		var url = `${host}/DonHang/SoLuong`
		$http.get(url).then(resp => {
			$scope.quantity_bill = resp.data
			console.log("Success count quantity bill",resp)
		}).catch(error => {
			console.log("Error count quantity bill",error)
		})
	}
	
	//Tự động chạy khi mở tab
	$scope.count_customer()
	$scope.count_product()
	$scope.count_bill()
	
})