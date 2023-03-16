package com.nguyenduy.qlcb.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Table(name = "dm_don_vi")
public class DonVi implements Serializable {
    @Id
    private String maDonVi;
    private String tenDonVi;
    private String maCapTren;
    private String loaiDonVi;
    private String tenThuTruongDonVi;
    private String diaChi;
    private String soDienThoai;
    private String ghiChu;

    public DonVi() {
    }

    public DonVi(String maDonVi, String tenDonVi, String maCapTren, String loaiDonVi, String tenThuTruongDonVi, String diaChi, String soDienThoai, String ghiChu) {
        this.maDonVi = maDonVi;
        this.tenDonVi = tenDonVi;
        this.maCapTren = maCapTren;
        this.loaiDonVi = loaiDonVi;
        this.tenThuTruongDonVi = tenThuTruongDonVi;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.ghiChu = ghiChu;
    }

    public String getMaDonVi() {
        return maDonVi;
    }

    public void setMaDonVi(String maDonVi) {
        this.maDonVi = maDonVi;
    }

    public String getTenDonVi() {
        return tenDonVi;
    }

    public void setTenDonVi(String tenDonVi) {
        this.tenDonVi = tenDonVi;
    }

    public String getLoaiDonVi() {
        return loaiDonVi;
    }

    public void setLoaiDonVi(String loaiDonVi) {
        this.loaiDonVi = loaiDonVi;
    }

    public String getTenThuTruongDonVi() {
        return tenThuTruongDonVi;
    }

    public void setTenThuTruongDonVi(String tenThuTruongDonVi) {
        this.tenThuTruongDonVi = tenThuTruongDonVi;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getMaCapTren() {
        return maCapTren;
    }

    public void setMaCapTren(String maCapTren) {
        this.maCapTren = maCapTren;
    }
}
