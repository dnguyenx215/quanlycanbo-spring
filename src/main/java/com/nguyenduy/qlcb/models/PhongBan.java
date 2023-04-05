package com.nguyenduy.qlcb.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Table(name = "dm_phong_ban")
public class PhongBan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long maPhongBan;

    private String tenPhongBan;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ma_don_vi", foreignKey = @ForeignKey(name = "ma_don_vi_phong_ban_Fk"))
    private DonVi maDonVi;

    private String ghiChu;

    public long getMaPhongBan() {
        return maPhongBan;
    }

    public void setMaPhongBan(long maPhongBan) {
        this.maPhongBan = maPhongBan;
    }

    public String getTenPhongBan() {
        return tenPhongBan;
    }

    public void setTenPhongBan(String tenPhongBan) {
        this.tenPhongBan = tenPhongBan;
    }

    public DonVi getMaDonVi() {
        return maDonVi;
    }

    public void setMaDonVi(DonVi maDonVi) {
        this.maDonVi = maDonVi;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
}
