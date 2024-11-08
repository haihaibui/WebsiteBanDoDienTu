app.controller('QuanLyDonHangCtrl', function($http, $scope) {

	attachOrderButtonEvents()

	$scope.time_instruction = 0;

	$scope.items = []

	$scope.list_dhct = []

	$scope.sum_money = 0

	$scope.title = "tất cả đơn hàng"

	//Load tất cả đơn hàng có trong csdl
	$scope.load_all = function() {
		var url = `${host}/DonHang`
		$http.get(url).then(resp => {
			$scope.items = resp.data
			$scope.title = "tất cả đơn hàng"
			console.log("Success load all DonHang")
		}).catch(error => {
			console.log("Error load all DonHang", error)
		})
	}

	//Load đơn hàng theo trang thái
	$scope.load_by_status = function(status) {
		var url = `${host}/DonHang/TrangThai/${status}`
		$http.get(url).then(resp => {
			$scope.items = resp.data
			$scope.title = `đơn hàng ${status.toLowerCase()}`
			console.log("Success load DonHang by status")
		}).catch(error => {
			console.log("Error load DonHang by status")
		})
	}

	//Load đơn hàng theo id
	$scope.load_by_id = function(maDh) {
		$scope.time_instruction = 0
		var url = `${host}/DonHang/${maDh}`
		var url_dhct = `${host}/DonHangChiTiet/TimTheoMaDonHang/${maDh}`
		$http.get(url).then(resp => {
			$scope.form = resp.data
			console.log("Success load DonHang by Id")
		}).catch(error => {
			console.log("Error load DonHang by Id", error)
		})
		$http.get(url_dhct).then(resp => {
			$scope.list_dhct = resp.data
			$scope.sum_money = 0
			for (const item of $scope.list_dhct) {
				$scope.sum_money += item.soLuong * item.giaTien
			}
			console.log("Success load DonHangChiTiet")
		}).catch(error => {
			console.log("Error load DonHangChiTiet", error)
		})
	}

	//Chạy khi ấn vào những trường khác trạng thái
	$scope.instruction = function() {
		if ($scope.time_instruction == 0) {
			$scope.time_instruction++
			swal("Bạn chỉ có thể cập nhật trạng thái đơn hàng !")
		}
	}

	//Cập nhật đơn hàng
	$scope.update = function(maDh) {
		var url = `${host}/DonHang/${maDh}`
		$http.put(url, $scope.form).then(resp => {
			console.log("Success update DonHang")
			swal("Thành công !", "Bạn đã cập nhật đơn hàng thành công", "success")
		}).catch(error => {
			console.log("Error update DonHang", error)
		})
	}

	//Xóa đơn hàng
	$scope.delete = function(maDh) {
		swal({
			title: "Bạn đã chắc chưa ?",
			text: "Khi đã xóa thì bạn không thể khôi phục lại được !",
			icon: "warning",
			buttons: true,
			dangerMode: true,
		}).then((willDelete) => {
			if (willDelete) {
				var url = `${host}/DonHang/${maDh}`
				$http.delete(url).then(resp => {
					swal("Đã xóa đơn hàng thành công !", {
						icon: "success",
					});
				}).catch(error => {
					console.log("Error delete DonHang", error)
				})
			} else {
				swal("Không thực hiện thao tác xóa đơn hàng !");
			}
		});
	}

	//Tự chạy đầu tiên khi chọn tab đơn hàng
	$scope.load_all()

})