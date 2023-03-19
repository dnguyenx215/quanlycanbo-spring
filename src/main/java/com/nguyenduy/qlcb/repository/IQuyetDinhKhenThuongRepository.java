package com.nguyenduy.qlcb.repository;

import com.nguyenduy.qlcb.models.QuyetDinhKhenThuong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface IQuyetDinhKhenThuongRepository extends JpaRepository<QuyetDinhKhenThuong, Integer> {
    QuyetDinhKhenThuong findQuyetDinhKhenThuongByIdQdKhenThuong(int id_qdKhenThuong);
    ArrayList<QuyetDinhKhenThuong> findQuyetDinhKhenThuongByDonVi(String dv);

    @Query(value = "SELECT * FROM quyet_dinh_khen_thuong INNER JOIN ho_so ON quyet_dinh_khen_thuong.ho_so = ho_so.id;",
            nativeQuery = true)
    List<?> findAllQuyetDinhInnerJoin();
}