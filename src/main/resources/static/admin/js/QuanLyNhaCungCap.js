app.controller('QuanLyNhaCungCapCtrl',function($http, $scope){
		
	$scope.items = []
	
	$scope.update = false
	
	//Chức năng reset
	$scope.reset = function(){
		$scope.update = false
		$scope.form = {}
	}
	
	//load tất cả nhà cung cấp
	$scope.load_all = function(){
		var url = `${host}/NhaCungCap`
		$http.get(url).then(resp =>{
			$scope.items = resp.data
			console.log("Success load all NhaCungCap")
		}).catch(error =>{
			console.log("Erorr load all NhaCungCap",error)
		})
	}
	
	//load nhà cung cấp theo id
	$scope.load_by_id = function(maNcc){
		var url = `${host}/NhaCungCap/${maNcc}`
		$http.get(url).then(resp => {
			$scope.form = resp.data
			$scope.update = true
		}).catch(error => {
			console.log("Error load NhaCungCap by id", error)
		})
	}
	
	//Tự động chạy đầu tiên khi mở tab 
	$scope.load_all()
})