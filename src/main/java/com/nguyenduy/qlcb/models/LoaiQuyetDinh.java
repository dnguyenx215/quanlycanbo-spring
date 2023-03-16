package com.nguyenduy.qlcb.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Table(name = "loai_quyet_dinh")
public class LoaiQuyetDinh implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_loaiQuyetDinh;
	private String tenLoaiQuyetDinh;

	public LoaiQuyetDinh() {
	}


	public Integer getId_loaiQuyetDinh() {
		return id_loaiQuyetDinh;
	}

	public void setId_loaiQuyetDinh(Integer id_loaiQuyetDinh) {
		this.id_loaiQuyetDinh = id_loaiQuyetDinh;
	}

	public String getTenLoaiQuyetDinh() {
		return tenLoaiQuyetDinh;
	}

	public void setTenLoaiQuyetDinh(String tenLoaiQuyetDinh) {
		this.tenLoaiQuyetDinh = tenLoaiQuyetDinh;
	}


}
