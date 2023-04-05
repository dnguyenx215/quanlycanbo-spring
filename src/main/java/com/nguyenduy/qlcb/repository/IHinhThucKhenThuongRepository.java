package com.nguyenduy.qlcb.repository;

import com.nguyenduy.qlcb.models.HinhThucKhenThuong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface IHinhThucKhenThuongRepository extends JpaRepository<HinhThucKhenThuong, Integer> {
    HinhThucKhenThuong findQuyetDinhKhenThuongByIdHT(int id);

}