app.controller('QuanLyNguoiDungCtrl', function($http, $scope) {

	$scope.items = []

	$scope.update = false

	$scope.file = null

	$scope.temp_image_data = null

	//Ham reset
	$scope.reset = function() {
		$scope.temp_image_data = null
		$scope.file = null
		$scope.update = false
		$scope.form = {ngayDangKy: new Date()}
	}

	//load tat ca nguoi dung
	$scope.load_all = function() {
		var url = `${host}/NguoiDung`
		$http.get(url).then(resp => {
			$scope.items = resp.data
			console.log("Success load all NguoiDung")
		}).catch(error => {
			console.log("Error load all NguoiDung", error)
		})
	}

	//load nguoi dung theo id
	$scope.load_by_id = function(maNd) {
		var url = `${host}/NguoiDung/${maNd}`
		$http.get(url).then(resp => {
			$scope.reset()
			$scope.form = resp.data
			$scope.form.ngayDangKy = new Date(resp.data.ngayDangKy) //Vì input có type là date nên phải truyền vào 1 Date
			$scope.form.ngaySinh = new Date(resp.data.ngaySinh)
			$scope.update = true
		}).catch(error => {
			console.log("Error load NguoiDung by id", error)
		})
	}

	//Bắt sự kiện khi nhấp vào hình
	$scope.image_click = function() {
		document.getElementById("fileHinh").click()
	}

	//Bắt sự kiện để hình ảnh thay đổi theo được chọn
	document.getElementById('fileHinh').addEventListener('change', function(event) {
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

	//Lưu ảnh về
	$scope.save_image = function() {
		// Nếu thành công, gọi resolve() hoặc reject() nếu có lỗi
		return new Promise((resolve, reject) => {
			//Kiểm tra xem có chọn hình không (Không tính hình hiển thị sẵn)
			if ($scope.file && $scope.temp_image_data) {
				//Tạo ra param có tên là "file" và dữ liệu là $scope.file
				var formData = new FormData()
				formData.append("file", $scope.file)
				//Gửi file lên server qua api
				var url = `${host}/file/NguoiDung`
				$http.post(url, formData, {
					transformRequest: angular.identity, // Tắt tuần tự hóa mặc định
					headers: { 'Content-Type': undefined } // Để trình duyệt tự đặt Content-Type
				}).then(resp => {
					$scope.form.hinhAnh = $scope.file.name
					console.log("Success upload image file")
					resolve()
				}).catch(error => {
					console.log("Error upload image file", error)
					reject()
				})
			} else {
				resolve()
			}
		})
	}


	//Thêm người dùng mới
	$scope.create = function() {
		$scope.save_image().then(() => {
			var url = `${host}/NguoiDung`
			$http.post(url, $scope.form).then(resp => {
				$scope.load_all()
				$scope.update=true
				swal("Thành công !","Thêm người dùng thành công","success")
			}).catch(error => {
				console.log("Error create NguoiDung", error)
			})
		}).catch(error => {
			console.log("Error save image NguoiDung",error)
		})
	}
	
	//Xóa người dùng
	$scope.delete = function(maNd){
		swal({
			title: "Bạn có chắc chắn không ?",
			text: "Khi đã xóa thì bạn không thể khôi phục lại được",
			icon: "warning",
			buttons: true,
			dangerMode: true,
		}).then((willDelete) => {
			if (willDelete) {
				var url = `${host}/NguoiDung/${maNd}`
				$http.delete(url).then(resp => {
					$scope.load_all()
					swal("Xóa thành công", {icon: "success",});
				}).catch(error => {
					console.log("Error delete NguoiDung", error)
				})
			} else {
				swal("Không thực hiện thao tác xóa")
			}
		})
	}

	//Tự động chạy khi chọn tab người dùng
	$scope.load_all()

})