app.controller('QuanLySanPhamCtrl', function($http, $scope) {

	$scope.items = []

	$scope.list_cl = []

	$scope.list_ncc = []

	$scope.list_ttdb = []

	$scope.update = false;

	$scope.default_image_src = "/api/file/SanPham/defaultProductPhoto.png"

	//Reset lại form
	$scope.reset = function() {
		$scope.form = {}
		$scope.update = false
		$scope.temp_image_src = null
	}

	//Load tất cả sản phẩm
	$scope.load_all = function() {
		var url = `${host}/SanPham`
		$http.get(url).then(resp => {
			$scope.items = resp.data
			console.log("Success load all SanPham")
		}).catch(error => {
			console.log("Error load all SanPham", error)
		})
	}

	//Load san pham theo id
	$scope.load_by_id = function(maSp) {
		var url = `${host}/SanPham/${maSp}`
		$http.get(url).then(resp => {
			$scope.form = resp.data
			$scope.temp_image_src = null
			$scope.update = true;
		}).catch(error => {
			console.log("Error load SanPham By Id", error)
		})
	}

	//Load danh sách chủng loại
	$scope.load_list_cl = function() {
		var url = `${host}/ChungLoai`
		$http.get(url).then(resp => {
			$scope.list_cl = resp.data
		}).catch(error => {
			console.log("Error load list Chung Loai", error)
		})
	}

	//Load danh sách nhà cung cấp 
	$scope.load_list_ncc = function() {
		var url = `${host}/NhaCungCap`
		$http.get(url).then(resp => {
			$scope.list_ncc = resp.data
		}).catch(error => {
			console.log("Error load list NhaCungCAp", error)
		})
	}

	//Load danh sách thuộc tính đặc biệt
	$scope.load_list_ttdb = function() {
		var url = `${host}/ThuocTinhDacBiet`
		$http.get(url).then(resp => {
			$scope.list_ttdb = resp.data
		}).catch(error => {
			console.log("Error load list TTDB", error)
		})
	}

	//Bắt sự kiện khi nhấp vào ảnh
	$scope.image_click = function() {
		document.getElementById('inputFile').click()
	}

	// Hiển thị ảnh đã chọn từ file
	document.getElementById('inputFile').addEventListener('change', function(event) {
		var input = event.target;
		if (input.files && input.files[0]) {
			var file = input.files[0];
        	var fileName = file.name; // Tên file bao gồm cả đuôi, ví dụ: "example.png"
       	 	console.log("File name:", fileName);
			// Đọc file để hiển thị ảnh base64
			var reader = new FileReader()
			reader.onload = function(e) {
				$scope.$apply(function() {
					$scope.temp_image_src = e.target.result; // Cập nhật hiển thị tạm thời
				})
			}
			reader.readAsDataURL(input.files[0]);
		}
	})

	//Tự động chạy khi mở tab
	$scope.load_all()
	$scope.load_list_cl()
	$scope.load_list_ncc()
	$scope.load_list_ttdb()
})