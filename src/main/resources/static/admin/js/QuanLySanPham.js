app.controller('QuanLySanPhamCtrl', function($http, $scope) {

	$scope.items = []

	$scope.list_cl = []

	$scope.list_ncc = []

	$scope.list_ttdb = []

	$scope.update = false;

	$scope.default_image_src = "/api/file/SanPham/defaultProductPhoto.png"

	$scope.temp_image_data = null

	$scope.file = null

	//Reset lại form
	$scope.reset = function() {
		$scope.form = {}
		$scope.update = false
		$scope.temp_image_data = null
		$scope.file = null
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
			$scope.reset()
			$scope.form = resp.data
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
			$scope.file = input.files[0];
			var fileName = $scope.file.name; // Tên file bao gồm cả đuôi, ví dụ: "example.png"
			console.log("File name choose:", fileName);
			// Đọc file để hiển thị ảnh base64
			var reader = new FileReader()
			reader.onload = function(e) {
				$scope.$apply(function() {
					$scope.temp_image_data = e.target.result; // Cập nhật hiển thị tạm thời
				})
			}
			reader.readAsDataURL(input.files[0]);
		}
	})

	//Upload ảnh lên server
	$scope.upload_image = function() {
		// Nếu thành công, gọi resolve() hoặc reject() nếu có lỗi
		return new Promise((resolve, reject) => {
			//Kiểm tra xem thử có chọn hình không (Không tính hình hiển thị sẵn)
			if ($scope.temp_image_data && $scope.file) {
				//Tạo ra param có tên là "file" và dữ liệu là $scope.file
				var formData = new FormData()
				formData.append("file", $scope.file)
				//Gửi file lên server qua post
				var url = `${host}/file/SanPham`
				$http.post(url, formData, {
					transformRequest: angular.identity, // Tắt tuần tự hóa mặc định
					headers: { 'Content-Type': undefined } // Để trình duyệt tự đặt Content-Type
				}).then(resp => {
					$scope.form.hinhAnh = $scope.file.name; // Tên file bao gồm cả đuôi, ví dụ: "example.png
					console.log("Success upload file")
					resolve() //gọi resolve khi upload thành công
				}).catch(error => {
					console.error("Error upload file", error)
					reject() //gọi reject khi có lỗi
				})
			} else {
				resolve()
			}
		})

	}

	//Thêm sản phẩm mới
	$scope.create = function() {
		// Chờ $scope.upload_image() hoàn tất trước khi thực hiện POST
		$scope.upload_image().then(() => {
			var url = `${host}/SanPham`
			$http.post(url, $scope.form).then(resp => {
				$scope.update = true
				$scope.load_all()
				swal("Thành công !", "Bạn đã thêm sản phẩm thành công", "success")
			}).catch(error => {
				console.log("Error create SanPham", error)
			})
		}).catch(error => {
			console.log(error)
		})
	}

	//Xóa sản phẩm theo id
	$scope.delete = function(maSp) {
		swal({
			title: "Bạn có chắc chắn không ?",
			text: "Khi đã xóa thì bạn không thể khôi phục lại được",
			icon: "warning",
			buttons: true,
			dangerMode: true,
		}).then((willDelete) => {
			if (willDelete) {
				var url = `${host}/SanPham/${maSp}`
				$http.delete(url).then(resp => {
					$scope.load_all()
					swal("Xóa thành công", {
						icon: "success",
					});
				}).catch(error => {
					console.log("Error delete SanPham", error)
				})
			} else {
				swal("Không thực hiện thao tác xóa")
			}
		})



	}

	//Tự động chạy khi mở tab
	$scope.load_all()
	$scope.load_list_cl()
	$scope.load_list_ncc()
	$scope.load_list_ttdb()
})