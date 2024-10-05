package com.group4.entity;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "chung_loai")
public class ChungLoai {

    @Id
    @Column(name = "ma_chung_loai", nullable = false, length = 20)
    private String maChungLoai;

    @Column(name = "ten_chung_loai", nullable = false, length = 100)
    private String tenChungLoai;

    // Mối quan hệ với SanPham
    @OneToMany(mappedBy = "chungLoai", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<SanPham> sanPhams;
}