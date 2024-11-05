app.controller('QuanLyNguoiDungCtrl',function($http, $scope){
		
	$scope.items = []
	
	$scope.update = false
	
	$scope.file = null
	
	$scope.temp_image_data = null
	
	//Ham reset
	$scope.reset = function(){
		$scope.temp_image_data = null
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
			$scope.temp_image_data = null
			$scope.form = resp.data
			$scope.update = true
		}).catch(error => {
			console.log("Error load NguoiDung by id",error)
		})
	}
	
	//Bắt sự kiện khi nhấp vào hình
	$scope.image_click = function(){
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
	
	//Tự động chạy khi chọn tab người dùng
	$scope.load_all()
	
})