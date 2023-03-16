package com.nguyenduy.qlcb.repository;

import com.nguyenduy.qlcb.models.QuyetDinhKhenThuong;
import com.nguyenduy.qlcb.models.QuyetDinhKyLuat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface IQuyetDinhKyLuatRepository extends JpaRepository<QuyetDinhKyLuat, Integer> {
    QuyetDinhKyLuat findQuyetDinhKyLuatByIdQdkl(int id);

    ArrayList<QuyetDinhKyLuat> findQuyetDinhKyLuatByDonVi(String dv);


}
