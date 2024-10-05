package com.group4.entity;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "don_hang_chi_tiet")
public class DonHangChiTiet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_don_hang_chi_tiet", nullable = false)
    private Integer maDonHangChiTiet;

    @Column(name = "so_luong", nullable = false)
    private Integer soLuong;

    @Column(name = "gia_tien", nullable = false)
    private Float giaTien;

    @Column(name = "ma_sp", nullable = false, length = 20)
    private String maSp;

    @Column(name = "ma_dh", nullable = false)
    private Integer maDh;

    // Mối quan hệ với SanPham
    @ManyToOne
    @JoinColumn(name = "ma_sp", insertable = false, updatable = false)
    private SanPham sanPham;

    // Mối quan hệ với DonHang
    @ManyToOne
    @JoinColumn(name = "ma_dh", insertable = false, updatable = false)
    private DonHang donHang;
}
