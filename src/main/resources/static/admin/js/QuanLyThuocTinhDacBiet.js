app.controller('QuanLyThuocTinhDacBietCtrl',function($http, $scope){
		
	$scope.items = []
	
	$scope.load_all = function(){
		var url = `${host}/ThuocTinhDacBiet`
		$http.get(url).then(resp => {
			$scope.items = resp.data
			console.log("Success load all TTDB")
		}).catch(error =>{
			console.log("Erorr load all TTDB", error)
		})
	}
	
	//Tự động chạy đầu tiên khi chọn tab
	$scope.load_all()
	
})