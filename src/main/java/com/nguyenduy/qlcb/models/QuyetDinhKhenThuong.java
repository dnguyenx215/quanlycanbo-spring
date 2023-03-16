package com.nguyenduy.qlcb.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Table(name = "quyet_dinh_khen_thuong")
public class QuyetDinhKhenThuong implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "id_qd_khen_thuong")
	private int idQdKhenThuong;
	@JoinColumn(name = "don_vi", foreignKey = @ForeignKey(name = "donViChucNangQdkt_pk"))
	private String donVi;

	@JoinColumn(name = "ho_so", foreignKey = @ForeignKey(name = "canBoQdkt_pk"))
	private long hoSo;
	private String soQuyetDinh;
	private String tenQuyetDinh;
	private String noiDungQuyetDinh;
	@Temporal(TemporalType.DATE)
	private Date ngayKy;
	private String nguoiKy;
	@Lob
	private byte[] fileKy;
	private String tenFile;

	public QuyetDinhKhenThuong() {
	}


	public int getIdQdKhenThuong() {
		return idQdKhenThuong;
	}

	public void setIdQdKhenThuong(int idQdKhenThuong) {
		this.idQdKhenThuong = idQdKhenThuong;
	}

	public String getDonVi() {
		return donVi;
	}

	public void setDonVi(String donVi) {
		this.donVi = donVi;
	}

	public long getHoSo() {
		return hoSo;
	}

	public void setHoSo(long hoSo) {
		this.hoSo = hoSo;
	}

	public String getSoQuyetDinh() {
		return soQuyetDinh;
	}

	public void setSoQuyetDinh(String soQuyetDinh) {
		this.soQuyetDinh = soQuyetDinh;
	}

	public String getTenQuyetDinh() {
		return tenQuyetDinh;
	}

	public void setTenQuyetDinh(String tenQuyetDinh) {
		this.tenQuyetDinh = tenQuyetDinh;
	}

	public String getNoiDungQuyetDinh() {
		return noiDungQuyetDinh;
	}

	public void setNoiDungQuyetDinh(String noiDungQuyetDinh) {
		this.noiDungQuyetDinh = noiDungQuyetDinh;
	}

	public Date getNgayKy() {
		return ngayKy;
	}

	public void setNgayKy(Date ngayKy) {
		this.ngayKy = ngayKy;
	}

	public String getNguoiKy() {
		return nguoiKy;
	}

	public void setNguoiKy(String nguoiKy) {
		this.nguoiKy = nguoiKy;
	}

	public byte[] getFileKy() {
		return fileKy;
	}

	public void setFileKy(byte[] fileKy) {
		this.fileKy = fileKy;
	}

	public String getTenFile() {
		return tenFile;
	}

	public void setTenFile(String tenFile) {
		this.tenFile = tenFile;
	}
}
