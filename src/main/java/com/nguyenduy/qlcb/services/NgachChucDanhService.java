package com.nguyenduy.qlcb.services;

import com.nguyenduy.qlcb.models.NgachChucDanh;
import com.nguyenduy.qlcb.repository.INgachChucDanhRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class NgachChucDanhService {
    private final INgachChucDanhRepository ngachChucDanhRepository;

    @Autowired
    public NgachChucDanhService(INgachChucDanhRepository ngachChucDanhRepository) {
        this.ngachChucDanhRepository = ngachChucDanhRepository;
    }

    public List<NgachChucDanh> getAllNgach() {
        return ngachChucDanhRepository.findAll();
    }

    public List<NgachChucDanh> getAllNgachByLoai(String loai) {
        List<NgachChucDanh> listNgachChucDanhByLoai = ngachChucDanhRepository.findDistinctFirstByLoai(loai);
        if (listNgachChucDanhByLoai.isEmpty()) {
            return null;
        } else {
            return listNgachChucDanhByLoai;
        }
    }

    public List<String> findAllLoai() {
        List<String> listNgachChucDanhByLoai = ngachChucDanhRepository.findAllLoaiNative();
        if (listNgachChucDanhByLoai.isEmpty()) {
            return null;
        } else {
            return listNgachChucDanhByLoai;
        }
    }

    public List<String> findAllNhomNgach() {
        List<String> ds = ngachChucDanhRepository.findAllNhomNgachNative();
        if (ds.isEmpty()) {
            return null;
        } else {
            return ds;
        }
    }

    public List<NgachChucDanh> getAllNgachByNhom(String nhom) {
        List<NgachChucDanh> listNgachChucDanhByNhom = ngachChucDanhRepository.findDistintcLoaiByNhomNative(nhom);
        if (listNgachChucDanhByNhom.isEmpty()) {
            return null;
        } else {
            return listNgachChucDanhByNhom;
        }
    }


    public NgachChucDanh getNgachByID(String id) {
        return ngachChucDanhRepository.findNgachChucDanhByMaNgach(id);
    }

    public NgachChucDanh insert(NgachChucDanh t) {
        NgachChucDanh newItem = ngachChucDanhRepository.findNgachChucDanhByMaNgach(t.getMaNgach());
        if (newItem == null) {
            return ngachChucDanhRepository.save(t);
        } else {
            return null;
        }
    }

    public NgachChucDanh update(String id, NgachChucDanh t) {
        NgachChucDanh edit = ngachChucDanhRepository.findNgachChucDanhByMaNgach(id);
        edit.setTenNgach(t.getTenNgach());
        edit.setNhomNgach(t.getNhomNgach());
        edit.setLoai(t.getLoai());
        edit.setSoNamNangBacLuong(t.getSoNamNangBacLuong());
        edit.setBac1(t.getBac1());
        edit.setBac2(t.getBac2());
        edit.setBac3(t.getBac3());
        edit.setBac4(t.getBac4());
        edit.setBac5(t.getBac5());
        edit.setBac6(t.getBac6());
        edit.setBac7(t.getBac7());
        edit.setBac8(t.getBac8());
        edit.setBac9(t.getBac9());
        edit.setBac10(t.getBac10());
        edit.setBac11(t.getBac11());
        edit.setBac12(t.getBac12());
        edit.setGhiChu(t.getGhiChu());
        return ngachChucDanhRepository.save(edit);
    }

    public void delete(String id) {
        ngachChucDanhRepository.deleteById(id);
    }



    public NgachChucDanh findHeSoByBacNgach(String bac, String maNgach) {
        return ngachChucDanhRepository.findHeSoByBacNgachNative(maNgach);
    }

    public void setHeSoByLoai(String loai, ArrayList<Float> heSo) {
        ArrayList<NgachChucDanh> listNgachChucDanhByLoai = ngachChucDanhRepository.findByLoai(loai);
        if (!listNgachChucDanhByLoai.isEmpty()) {
            for (NgachChucDanh item : listNgachChucDanhByLoai) {
                item.setBac1(heSo.get(0));
                item.setBac2(heSo.get(1));
                item.setBac3(heSo.get(2));
                item.setBac4(heSo.get(3));
                item.setBac5(heSo.get(4));
                item.setBac6(heSo.get(5));
                item.setBac7(heSo.get(6));
                item.setBac8(heSo.get(7));
                item.setBac9(heSo.get(8));
                item.setBac10(heSo.get(9));
                item.setBac11(heSo.get(10));
                item.setBac12(heSo.get(11));
                ngachChucDanhRepository.save(item);
            }
        }
    }
}
