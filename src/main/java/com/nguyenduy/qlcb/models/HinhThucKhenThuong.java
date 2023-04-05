package com.nguyenduy.qlcb.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Table(name = "hinh_thuc_khen_thuong")
public class HinhThucKhenThuong implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idHT;
	private String tenHT;
	private String ghiChu;

	public HinhThucKhenThuong() {
	}

	public int getIdHT() {
		return idHT;
	}

	public void setIdHT(int idHT) {
		this.idHT = idHT;
	}

	public String getTenHT() {
		return tenHT;
	}

	public void setTenHT(String tenHT) {
		this.tenHT = tenHT;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
}
