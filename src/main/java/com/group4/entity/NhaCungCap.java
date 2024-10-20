package com.group4.entity;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "nha_cung_cap")
public class NhaCungCap {

    @Id
    @Column(name = "ma_nha_cung_cap", nullable = false, length = 20)
    private String maNhaCungCap;

    @Column(name = "ten_nha_cung_cap", nullable = false, length = 100)
    private String tenNhaCungCap;

    // Mối quan hệ với SanPham
    @JsonIgnore
    @OneToMany(mappedBy = "nhaCungCap", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<SanPham> sanPhams;
}
