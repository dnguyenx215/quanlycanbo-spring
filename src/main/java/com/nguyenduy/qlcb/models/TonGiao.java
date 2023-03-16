package com.nguyenduy.qlcb.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Table(name = "dm_ton_giao")
public class TonGiao implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long maTonGiao;
    private String tenTonGiao;
    private String ghiChu;

    public TonGiao() {
    }

    public long getMaTonGiao() {
        return maTonGiao;
    }

    public void setMaTonGiao(long maTonGiao) {
        this.maTonGiao = maTonGiao;
    }

    public String getTenTonGiao() {
        return tenTonGiao;
    }

    public void setTenTonGiao(String tenTonGiao) {
        this.tenTonGiao = tenTonGiao;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }


}
