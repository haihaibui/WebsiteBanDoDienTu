app.controller('thongKeCtrl',function($http, $scope){
	$scope.quantity_customer = null
	$scope.quantity_product = null
	$scope.quantity_bill = null
	
	//Đếm số lượng khách hàng
	$scope.count_customer = function(){
		var url = `${host}/NguoiDung/SoLuongKhachHang`
		$http.get(url).then(resp => {
			$scope.quantity_customer = resp.data
			console.log("Success count quantity customer",resp)
		}).catch(error => {
			console.log("Error count quantity customer",error)
		})
	}
	
	//Đếm số lượng sản phẩm
	$scope.count_product = function(){
		var url = `${host}/SanPham/SoLuong`
		$http.get(url).then(resp => {
			$scope.quantity_product = resp.data
			console.log("Success count quantity product",resp)
		}).catch(error => {
			console.log("Error count quantity product",error)
		})
	}
	
	//Đếm số lượng đơn hàng
	$scope.count_bill = function(){
		var url = `${host}/DonHang/SoLuong`
		$http.get(url).then(resp => {
			$scope.quantity_bill = resp.data
			console.log("Success count quantity bill",resp)
		}).catch(error => {
			console.log("Error count quantity bill",error)
		})
	}
	
	//Thống kê doanh thu theo tháng
	$scope.revenue_statistics = function(){
		var url = `${host}/ThongKe/DoanhThu`
		$http.get(url).then(resp => {
			var statistical_data = resp.data
			var labels = statistical_data.map(item => item.thang+"/"+item.nam)
			var data = statistical_data.map(item => item.doanhThu)
			//Khởi tạo biểu đồ bằng Chart.js 
			var ctx = document.getElementById("bieuDoDoanhThu").getContext("2d")
			new Chart(ctx,{
				type: "bar",
				data: {
					labels: labels,
					datasets: [{
						label: "Doanh thu theo tháng",
						data: data,
						backgroundColor: 'rgba(75, 192, 192, 0.6)',
	                    borderColor: 'rgba(75, 192, 192, 1)',
	                    borderWidth: 2
					}]
				},
				options: {
					scales: {
						y: {
							beginAtZero: true
						}
					}
				}
			})	
		})
	}
	
	//Tự động chạy khi mở tab
	$scope.count_customer()
	$scope.count_product()
	$scope.count_bill()
	$scope.revenue_statistics()
	
})