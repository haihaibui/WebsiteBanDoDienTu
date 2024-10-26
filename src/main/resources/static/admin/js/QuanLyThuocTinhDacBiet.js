app.controller('QuanLyThuocTinhDacBietCtrl',function($http, $scope){
		
	$scope.items = []
	
	$scope.update = false
	
	//Hàm reset
	$scope.reset = function(){
		$scope.form = {}
		$scope.update = false
	}
	
	//load tất cả thuộc tính đặc biệt
	$scope.load_all = function(){
		var url = `${host}/ThuocTinhDacBiet`
		$http.get(url).then(resp => {
			$scope.items = resp.data
			console.log("Success load all TTDB")
		}).catch(error =>{
			console.log("Erorr load all TTDB", error)
		})
	}
	
	//load thuộc tính đặc biệt theo id
	$scope.load_by_id = function(maTtdb){
		var url = `${host}/ThuocTinhDacBiet/${maTtdb}`
		$http.get(url).then(resp => {
			$scope.form = resp.data
			$scope.update = true
		}).catch(error => {
			console.log("Error load TTDB by id", error)
		})
	}
	
	
	//Tự động chạy đầu tiên khi chọn tab
	$scope.load_all()
	
})