/**
 * 
 */
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


