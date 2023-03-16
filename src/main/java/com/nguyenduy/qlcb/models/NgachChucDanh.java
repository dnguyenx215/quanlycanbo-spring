package com.nguyenduy.qlcb.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Table(name = "dm_ngach_bac_luong")
public class NgachChucDanh implements Serializable {
    @Id
    private String maNgach;
    private String tenNgach;
    private String nhomNgach;
    private String loai;
    private int soNamNangBacLuong;

    private float bac1 = 0;
    private float bac2 = 0;
    private float bac3 = 0;
    private float bac4 = 0;
    private float bac5 = 0;
    private float bac6 = 0;
    private float bac7 = 0;
    private float bac8 = 0;
    private float bac9 = 0;
    private float bac10 = 0;
    private float bac11 = 0;
    private float bac12 = 0;
    private String ghiChu;

    public NgachChucDanh() {
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public String getMaNgach() {
        return maNgach;
    }

    public void setMaNgach(String maNgach) {
        this.maNgach = maNgach;
    }

    public String getTenNgach() {
        return tenNgach;
    }

    public void setTenNgach(String tenNgach) {
        this.tenNgach = tenNgach;
    }

    public int getSoNamNangBacLuong() {
        return soNamNangBacLuong;
    }

    public void setSoNamNangBacLuong(int soNamNangBacLuong) {
        this.soNamNangBacLuong = soNamNangBacLuong;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public float getBac1() {
        return bac1;
    }

    public void setBac1(float bac1) {
        this.bac1 = bac1;
    }

    public float getBac2() {
        return bac2;
    }

    public void setBac2(float bac2) {
        this.bac2 = bac2;
    }

    public float getBac3() {
        return bac3;
    }

    public void setBac3(float bac3) {
        this.bac3 = bac3;
    }

    public float getBac4() {
        return bac4;
    }

    public void setBac4(float bac4) {
        this.bac4 = bac4;
    }

    public float getBac5() {
        return bac5;
    }

    public void setBac5(float bac5) {
        this.bac5 = bac5;
    }

    public float getBac6() {
        return bac6;
    }

    public void setBac6(float bac6) {
        this.bac6 = bac6;
    }

    public float getBac7() {
        return bac7;
    }

    public void setBac7(float bac7) {
        this.bac7 = bac7;
    }

    public float getBac8() {
        return bac8;
    }

    public void setBac8(float bac8) {
        this.bac8 = bac8;
    }

    public float getBac9() {
        return bac9;
    }

    public void setBac9(float bac9) {
        this.bac9 = bac9;
    }

    public float getBac10() {
        return bac10;
    }

    public void setBac10(float bac10) {
        this.bac10 = bac10;
    }

    public float getBac11() {
        return bac11;
    }

    public void setBac11(float bac11) {
        this.bac11 = bac11;
    }

    public float getBac12() {
        return bac12;
    }

    public void setBac12(float bac12) {
        this.bac12 = bac12;
    }

    public String getNhomNgach() {
        return nhomNgach;
    }

    public void setNhomNgach(String nhomNgach) {
        this.nhomNgach = nhomNgach;
    }
}
