package com.nguyenduy.qlcb.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Table(name = "tmp_qua_trinh_dao_tao")
public class QuaTrinhDaoTaoBoiDuong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ho_so", foreignKey = @ForeignKey(name = "ma_ho_so_qua_trinh_dao_tao_Fk"))
    private HoSo hoSo;

    @Temporal(TemporalType.DATE)
    private Date tuNgay;
    @Temporal(TemporalType.DATE)
    private Date denNgay;

    private String tenChuyenNganhDaoTaoBoiDuong;
    private String trinhDoDaoTaoBoiDuong;
    private String coSoDaoTaoBoiDuong;
    private String trangThaiDaoTaoBoiDuong;

    public QuaTrinhDaoTaoBoiDuong() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public HoSo getHoSo() {
        return hoSo;
    }

    public void setHoSo(HoSo hoSo) {
        this.hoSo = hoSo;
    }

    public Date getTuNgay() {
        return tuNgay;
    }

    public void setTuNgay(Date tuNgay) {
        this.tuNgay = tuNgay;
    }

    public Date getDenNgay() {
        return denNgay;
    }

    public void setDenNgay(Date denNgay) {
        this.denNgay = denNgay;
    }

    public String getTenChuyenNganhDaoTaoBoiDuong() {
        return tenChuyenNganhDaoTaoBoiDuong;
    }

    public void setTenChuyenNganhDaoTaoBoiDuong(String tenChuyenNganhDaoTaoBoiDuong) {
        this.tenChuyenNganhDaoTaoBoiDuong = tenChuyenNganhDaoTaoBoiDuong;
    }

    public String getTrinhDoDaoTaoBoiDuong() {
        return trinhDoDaoTaoBoiDuong;
    }

    public void setTrinhDoDaoTaoBoiDuong(String trinhDoDaoTaoBoiDuong) {
        this.trinhDoDaoTaoBoiDuong = trinhDoDaoTaoBoiDuong;
    }

    public String getCoSoDaoTaoBoiDuong() {
        return coSoDaoTaoBoiDuong;
    }

    public void setCoSoDaoTaoBoiDuong(String coSoDaoTaoBoiDuong) {
        this.coSoDaoTaoBoiDuong = coSoDaoTaoBoiDuong;
    }

    public String getTrangThaiDaoTaoBoiDuong() {
        return trangThaiDaoTaoBoiDuong;
    }

    public void setTrangThaiDaoTaoBoiDuong(String trangThaiDaoTaoBoiDuong) {
        this.trangThaiDaoTaoBoiDuong = trangThaiDaoTaoBoiDuong;
    }
}
