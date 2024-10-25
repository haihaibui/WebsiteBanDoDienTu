app.controller('QuanLySanPhamCtrl',function($http, $scope){
	
	$scope.items = []
	
	//Load tất cả sản phẩm
	$scope.load_all = function(){
		var url = `${host}/SanPham`
		$http.get(url).then(resp => {
			$scope.items = resp.data
			console.log("Success load all SanPham")
		}).catch(error => {
			console.log("Error load all SanPham",error)
		})
	}
	
	//Tự động chạy khi mở tab
	$scope.load_all()
	
})