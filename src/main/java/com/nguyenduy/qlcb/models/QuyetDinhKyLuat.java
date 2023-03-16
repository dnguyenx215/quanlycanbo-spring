package com.nguyenduy.qlcb.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Table(name = "quyet_dinh_ky_luat")
public class QuyetDinhKyLuat implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name= "id_qdkl")
	private int idQdkl;

	@JoinColumn(name = "don_viqdkl_pk", foreignKey = @ForeignKey(name = "donViQDKL_pk"))
	private String donVi;

	@JoinColumn(name = "can_boqdkl_pk", foreignKey = @ForeignKey(name = "canBoQDKL_pk"))
	private long hoSo;

	private String soQuyetDinh;
	private String tenQuyetDinh;
	private String noiDungQuyetDinh;
	@Temporal(TemporalType.DATE)
	private Date ngayKy;
	private String nguoiKy;
	@Temporal(TemporalType.DATE)
	private Date tuNgay;
	@Temporal(TemporalType.DATE)
	private Date denNgay;
	@Lob
	private byte[] fileKy;
	private String tenFile;


	public QuyetDinhKyLuat() {
	}

	public Integer getIdQdkl() {
		return idQdkl;
	}

	public void setIdQdkl(Integer idQdkl) {
		this.idQdkl = idQdkl;
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

	public void setIdQdkl(int idQdkl) {
		this.idQdkl = idQdkl;
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
