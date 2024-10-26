app.controller('QuanLyNguoiDungCtrl',function($http, $scope){
		
	$scope.items = []
	
	$scope.update = false
	
	//Ham reset
	$scope.reset = function(){
		$scope.update = false
		$scope.form = {}
	}
	
	//load tat ca nguoi dung
	$scope.load_all = function(){
		var url = `${host}/NguoiDung`
		$http.get(url).then(resp =>{
			$scope.items = resp.data
			console.log("Success load all NguoiDung")
		}).catch(error =>{
			console.log("Error load all NguoiDung", error)
		})
	}
	
	//load nguoi dung theo id
	$scope.load_by_id = function(maNd){
		var url = `${host}/NguoiDung/${maNd}`
		$http.get(url).then(resp => {
			$scope.form = resp.data
			$scope.update = true
		}).catch(error => {
			console.log("Error load NguoiDung by id",error)
		})
	}
	
	//Tự động chạy khi chọn tab người dùng
	$scope.load_all()
	
})