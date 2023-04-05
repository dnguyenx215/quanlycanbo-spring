package com.nguyenduy.qlcb.repository;

import com.nguyenduy.qlcb.models.HinhThucKyLuat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface IHinhThucKyLuatRepository extends JpaRepository<HinhThucKyLuat, Integer> {
    HinhThucKyLuat findQuyetDinhKyLuatByIdHT(int id);



}
