app.controller('QuanLySanPhamCtrl',function($http, $scope){
	
	$scope.items = []
	
	$scope.list_cl = []
	
	$scope.list_ncc = []
	
	$scope.list_ttdb = []
	
	$scope.update = false;
	
	//Reset lại form
	$scope.reset = function(){
		$scope.form = {}
		$scope.update = false
	}
	
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
	
	//Load san pham theo id
	$scope.load_by_id = function(maSp){
		var url = `${host}/SanPham/${maSp}`
		$http.get(url).then(resp => {
			$scope.form = resp.data
			$scope.update = true;
		}).catch(error => {
			console.log("Error load SanPham By Id", error)
		})
	}
	
	//Load danh sách chủng loại
	$scope.load_list_cl = function(){
		var url = `${host}/ChungLoai`
		$http.get(url).then(resp => {
			$scope.list_cl = resp.data
		}).catch(error => {
			console.log("Error load list Chung Loai", error)
		})
	}
	
	//Load danh sách nhà cung cấp 
	$scope.load_list_ncc = function(){
		var url = `${host}/NhaCungCap`
		$http.get(url).then(resp => {
			$scope.list_ncc = resp.data
		}).catch(error => {
			console.log("Error load list NhaCungCAp", error)
		})
	}
	
	//Load danh sách thuộc tính đặc biệt
	$scope.load_list_ttdb = function(){
		var url = `${host}/ThuocTinhDacBiet`
		$http.get(url).then(resp => {
			$scope.list_ttdb = resp.data
		}).catch(error => {
			console.log("Error load list TTDB",error)
		})
	}
	
	
	//Tự động chạy khi mở tab
	$scope.load_all()
	$scope.load_list_cl()
	$scope.load_list_ncc()
	$scope.load_list_ttdb()
})