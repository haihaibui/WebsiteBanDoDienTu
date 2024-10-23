app.controller('QuanLyChungloaiCtrl',function($http, $scope){
	
	$scope.form = {}
	$scope.items = []
	$scope.work_type = "ThemMoi"
	
	//reset lại form
	$scope.reset = function(){
		$scope.form = {}
		$scope.work_type = "ThemMoi"
	}
	
	//load lên toàn bộ bảng chủng loại
	$scope.load_all = function(){
		var url = `${host}/ChungLoai`
		$http.get(url).then(resp =>{
			$scope.items = resp.data;
			console.log("Get all ChungLoai  success")
		}).catch(error =>{
			console.log("error get all ChungLoai", error)
		})
	}
	
	//Hiện chi tiết chủng loại theo id
	$scope.load_by_id = function(maCl){
		var url = `${host}/ChungLoai/${maCl}`
		$http.get(url).then(resp => {
			$scope.form = resp.data
			$scope.work_type = "CapNhat"
			console.log("Success edit ChungLoai by id",resp)
		}).catch(error => {
			console.log("Error edit ChungLoai by id",error)
		})
	}
	
	//Tự động chạy đầu tiên khi mở tab Quản lý chủng loại
	$scope.load_all()
	
})