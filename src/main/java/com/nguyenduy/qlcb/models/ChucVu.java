package com.nguyenduy.qlcb.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Table(name = "dm_chuc_danh")
public class ChucVu implements Serializable {
    @Id
    private String maChucDanh;
    private String tenChucDanh;
    private String ghiChu;
    private String nhomChucDanh;

    public String getMaChucDanh() {
        return maChucDanh;
    }

    public void setMaChucDanh(String maChucDanh) {
        this.maChucDanh = maChucDanh;
    }

    public String getTenChucDanh() {
        return tenChucDanh;
    }

    public void setTenChucDanh(String tenChucDanh) {
        this.tenChucDanh = tenChucDanh;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getNhomChucDanh() {
        return nhomChucDanh;
    }

    public void setNhomChucDanh(String nhomChucDanh) {
        this.nhomChucDanh = nhomChucDanh;
    }
}
