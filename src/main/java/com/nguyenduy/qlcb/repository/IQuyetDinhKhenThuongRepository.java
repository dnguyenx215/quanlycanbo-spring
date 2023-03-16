package com.nguyenduy.qlcb.repository;

import com.nguyenduy.qlcb.models.QuyetDinhKhenThuong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface IQuyetDinhKhenThuongRepository extends JpaRepository<QuyetDinhKhenThuong, Integer> {
    QuyetDinhKhenThuong findQuyetDinhKhenThuongByIdQdKhenThuong(int id_qdKhenThuong);
    ArrayList<QuyetDinhKhenThuong> findQuyetDinhKhenThuongByDonVi(String dv);

}
