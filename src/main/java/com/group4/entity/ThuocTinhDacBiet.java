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
@Table(name = "thuoc_tinh_dac_biet")
public class ThuocTinhDacBiet {

    @Id
    @Column(name = "ma_thuoc_tinh_dac_biet", nullable = false, length = 20)
    private String maThuocTinhDacBiet;

    @Column(name = "ten_thuoc_tinh_dac_biet", nullable = false, length = 100)
    private String tenThuocTinhDacBiet;

    // Mối quan hệ với SanPham
    @JsonIgnore
    @OneToMany(mappedBy = "thuocTinhDacBiet", cascade = CascadeType.ALL)
    private Set<SanPham> sanPhams;
}
