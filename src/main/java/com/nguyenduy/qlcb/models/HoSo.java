package com.nguyenduy.qlcb.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Table(name = "ho_so")
public class HoSo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long idHoSo;
    private String soHieuCBCCVC;

    @JoinColumn(name = "ma_don_vi", foreignKey = @ForeignKey(name = "maDonVi"))
    private String maDonVi;

    @Lob
    private byte[] imageUrl;
    private String hoVaTen;
    @Temporal(TemporalType.DATE)
    private Date ngaySinh;
    private String gioiTinh;
    private String noiSinh;
    private String hoKhauThuongTru;
    private String noiOHienTai;

    @JoinColumn(name = "dan_toc", foreignKey = @ForeignKey(name = "maDanToc"))
    private int danToc;

    @JoinColumn(name = "ton_giao", foreignKey = @ForeignKey(name = "maTonGiao"))
    private long tonGiao;
    private String soCmnd;

    @JoinColumn(name = "chuc_vu", foreignKey = @ForeignKey(name = "maChucVu"))
    private String chucVu;

    @Temporal(TemporalType.DATE)
    private Date ngayBoNhiem;

    @JoinColumn(name = "ma_ngach", foreignKey = @ForeignKey(name = "maNgachChucDanh"))
    private String maNgach;

    private int bacLuong;
    private double heSoLuong;
    private double PhuCapThamNienVuotKhung;
    private double heSoPhuCapChucVu;

    @Temporal(TemporalType.DATE)
    private Date ngayVaoDcsvn;
    private String soTheDang;
    private String trinhDoGDPT;
    private String trinhDoChuyenMon;
    private String hocVi;
    private String hocHam;
    private String ngoaiNgu;
    private String tinHoc;
    private String soBaoHiemXh;

    private String danhGia;
    @Temporal(TemporalType.DATE)
    private Date ngayDanhGia;
    public HoSo() {
    }

    public long getIdHoSo() {
        return idHoSo;
    }

    public void setIdHoSo(long idHoSo) {
        this.idHoSo = idHoSo;
    }

    public String getSoHieuCBCCVC() {
        return soHieuCBCCVC;
    }

    public void setSoHieuCBCCVC(String soHieuCBCCVC) {
        this.soHieuCBCCVC = soHieuCBCCVC;
    }

    public String getMaDonVi() {
        return maDonVi;
    }

    public void setMaDonVi(String maDonVi) {
        this.maDonVi = maDonVi;
    }

    public byte[] getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(byte[] imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getHoVaTen() {
        return hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getNoiSinh() {
        return noiSinh;
    }

    public void setNoiSinh(String noiSinh) {
        this.noiSinh = noiSinh;
    }

    public String getHoKhauThuongTru() {
        return hoKhauThuongTru;
    }

    public void setHoKhauThuongTru(String hoKhauThuongTru) {
        this.hoKhauThuongTru = hoKhauThuongTru;
    }

    public String getNoiOHienTai() {
        return noiOHienTai;
    }

    public void setNoiOHienTai(String noiOHienTai) {
        this.noiOHienTai = noiOHienTai;
    }

    public int getDanToc() {
        return danToc;
    }

    public void setDanToc(int danToc) {
        this.danToc = danToc;
    }

    public long getTonGiao() {
        return tonGiao;
    }

    public void setTonGiao(long tonGiao) {
        this.tonGiao = tonGiao;
    }

    public String getSoCmnd() {
        return soCmnd;
    }

    public void setSoCmnd(String soCmnd) {
        this.soCmnd = soCmnd;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public Date getNgayBoNhiem() {
        return ngayBoNhiem;
    }

    public void setNgayBoNhiem(Date ngayBoNhiem) {
        this.ngayBoNhiem = ngayBoNhiem;
    }

    public String getMaNgach() {
        return maNgach;
    }

    public void setMaNgach(String maNgach) {
        this.maNgach = maNgach;
    }

    public int getBacLuong() {
        return bacLuong;
    }

    public void setBacLuong(int bacLuong) {
        this.bacLuong = bacLuong;
    }

    public double getHeSoLuong() {
        return heSoLuong;
    }

    public void setHeSoLuong(double heSoLuong) {
        this.heSoLuong = heSoLuong;
    }

    public double getPhuCapThamNienVuotKhung() {
        return PhuCapThamNienVuotKhung;
    }

    public void setPhuCapThamNienVuotKhung(double phuCapThamNienVuotKhung) {
        PhuCapThamNienVuotKhung = phuCapThamNienVuotKhung;
    }

    public double getHeSoPhuCapChucVu() {
        return heSoPhuCapChucVu;
    }

    public void setHeSoPhuCapChucVu(double heSoPhuCapChucVu) {
        this.heSoPhuCapChucVu = heSoPhuCapChucVu;
    }

    public Date getNgayVaoDcsvn() {
        return ngayVaoDcsvn;
    }

    public void setNgayVaoDcsvn(Date ngayVaoDcsvn) {
        this.ngayVaoDcsvn = ngayVaoDcsvn;
    }

    public String getSoTheDang() {
        return soTheDang;
    }

    public void setSoTheDang(String soTheDang) {
        this.soTheDang = soTheDang;
    }

    public String getTrinhDoGDPT() {
        return trinhDoGDPT;
    }

    public void setTrinhDoGDPT(String trinhDoGDPT) {
        this.trinhDoGDPT = trinhDoGDPT;
    }

    public String getTrinhDoChuyenMon() {
        return trinhDoChuyenMon;
    }

    public void setTrinhDoChuyenMon(String trinhDoChuyenMon) {
        this.trinhDoChuyenMon = trinhDoChuyenMon;
    }

    public String getHocVi() {
        return hocVi;
    }

    public void setHocVi(String hocVi) {
        this.hocVi = hocVi;
    }

    public String getHocHam() {
        return hocHam;
    }

    public void setHocHam(String hocHam) {
        this.hocHam = hocHam;
    }

    public String getNgoaiNgu() {
        return ngoaiNgu;
    }

    public void setNgoaiNgu(String ngoaiNgu) {
        this.ngoaiNgu = ngoaiNgu;
    }

    public String getTinHoc() {
        return tinHoc;
    }

    public void setTinHoc(String tinHoc) {
        this.tinHoc = tinHoc;
    }

    public Date getNgayDanhGia() {
        return ngayDanhGia;
    }

    public void setNgayDanhGia(Date ngayDanhGia) {
        this.ngayDanhGia = ngayDanhGia;
    }

    public String getSoBaoHiemXh() {
        return soBaoHiemXh;
    }

    public void setSoBaoHiemXh(String soBaoHiemXh) {
        this.soBaoHiemXh = soBaoHiemXh;
    }

    public String getDanhGia() {
        return danhGia;
    }

    public void setDanhGia(String danhGia) {
        this.danhGia = danhGia;
    }
}
