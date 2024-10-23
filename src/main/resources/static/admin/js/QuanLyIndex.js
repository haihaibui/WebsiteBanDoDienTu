//Angular Js code
var app = angular.module('myApp', ['ngRoute']);
app.controller('myCtrl', function ($http, $scope) {
    
})
app.config(function ($routeProvider) {
    $routeProvider
        .when('/ThongKe', {
            templateUrl: '/admin/html/layout/ThongKe.html',
            controller: 'thongKeCtrl'
        })
        .when('/QuanLyDonHang', {
            templateUrl: '/admin/html/layout/QuanLyDonHang.html',
            controller: 'QuanLyDonHangCtrl'
        })
        .when('/QuanLyNguoiDung', {
            templateUrl: '/admin/html/layout/QuanLyNguoiDung.html',
            controller: 'QuanLyNguoiDungCtrl'
        })
        .when('/QuanLySanPham', {
            templateUrl: '/admin/html/layout/QuanLySanPham.html',
            controller: 'QuanLySanPhamCtrl'
        })
        .when('/QuanLyChungloai', {
            templateUrl: '/admin/html/layout/QuanLyChungloai.html',
            controller: 'QuanLyChungloaiCtrl'
        })
        .when('/QuanLyNhaCungCap', {
            templateUrl: '/admin/html/layout/QuanLyNhaCungCap.html',
            controller: 'QuanLyNhaCungCapCtrl'
        })
        .when('/QuanLyThuocTinhDacBiet', {
            templateUrl: '/admin/html/layout/QuanLyThuocTinhDacBiet.html',
            controller: 'QuanLyThuocTinhDacBietCtrl'
        })
        .otherwise({
            templateUrl: '/admin/html/layout/ThongKe.html',
            controller: 'thongKeCtrl'
        })
})
app.controller('thongKeCtrl',function($http, $scope){

})
app.controller('QuanLyNguoiDungCtrl',function($http, $scope){
	
})
app.controller('QuanLyDonHangCtrl',function($http, $scope){
	attachOrderButtonEvents()
})
app.controller('QuanLySanPhamCtrl',function($http, $scope){
	
})



// Đảm bảo các sự kiện được gắn khi trang lần đầu tải
document.addEventListener("DOMContentLoaded", function() {
	//Bắt sự kiện khi bấm vào button bên menuAside
	const buttionElementMenu = document.querySelectorAll('.menuAside button')
	buttionElementMenu.forEach(
		button => {
			button.addEventListener('click', function() {
				buttionElementMenu.forEach(btn => btn.classList.remove('buttonMenuSelected'))
				this.classList.add('buttonMenuSelected')
			})
		}
	)

	//Gắn sự kiện cho các nút tab dơn hàng
	attachOrderButtonEvents();
})

// Hàm gắn sự kiện cho các nút trong tab Đơn hàng
function attachOrderButtonEvents() {
   //Bắt sự kiện khi bấm vào các thẻ theo dõi đơn hàng
	//Lấy tất cả các thẻ con của titleDonHangText
	const divElementDonHang = document.querySelectorAll('.titleDonHangText>div');

	//Thêm sự kiện click cho từng thẻ
	divElementDonHang.forEach(
		div => {
			div.addEventListener('click', function() {
				//Xóa class selected từ tất cả các thẻ
				divElementDonHang.forEach(el => el.classList.remove('selectedTitleDonHang'))

				//Thêm class selected cho thẻ được nhấn
				this.classList.add('selectedTitleDonHang')
			})
		}
	)
}

/*
function loadContent(url) {
	// Sử dụng AJAX để gửi yêu cầu GET tới server
	fetch(url, {
		method: 'GET',
		headers: {
			'X-Requested-With': 'XMLHttpRequest' // Đảm bảo request là AJAX
		}
	})
		.then(response => response.text()) // Lấy nội dung từ response
		.then(html => {
			// Cập nhật nội dung của phần tử có id="content"
			document.getElementById('content').innerHTML = html;
			// Gắn lại sự kiện sau khi nội dung được tải lại
        	attachOrderButtonEvents();
		})
		.catch(error => {
			console.error('Lỗi khi tải nội dung:', error);
		});
}
*/
