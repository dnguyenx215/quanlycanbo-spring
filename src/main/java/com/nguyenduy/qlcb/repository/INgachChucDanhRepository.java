package com.nguyenduy.qlcb.repository;

import com.nguyenduy.qlcb.models.HoSo;
import com.nguyenduy.qlcb.models.NgachChucDanh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public interface INgachChucDanhRepository extends JpaRepository<NgachChucDanh, String> {
    NgachChucDanh findNgachChucDanhByMaNgach(String maNgach);

    ArrayList<NgachChucDanh> findNgachChucDanhByLoai(String loai);
    ArrayList<NgachChucDanh> findDistinctFirstByLoai(String loai);
    ArrayList<NgachChucDanh> findDistincByNhomNgach(String nhom);

    @Query(value = "SELECT distinct loai FROM dm_ngach_bac_luong", nativeQuery = true)
    List<String> findAllLoaiNative();

    @Query(value = "select distinct * from dm_ngach_bac_luong n where n.nhom_ngach = ?1",
            nativeQuery = true)
    List<NgachChucDanh> findDistintcLoaiByNhomNative(String nhom);

    @Query(value = "SELECT distinct nhom_ngach FROM dm_ngach_bac_luong", nativeQuery = true)
    List<String> findAllNhomNgachNative();


    @Query(value = "select * FROM dm_ngach_bac_luong Where ma_ngach = :ma", nativeQuery = true)
    NgachChucDanh findHeSoByBacNgachNative(@Param("ma") String maNgach);
    ArrayList<NgachChucDanh> findByLoai(String loai);

    @Query(value = "SELECT :bac FROM dm_ngach_bac_luong Where ma_ngach = :ma", nativeQuery = true)
    List<HoSo> findHeSoBacByMaNgach(@Param("bac") String bac, @Param("ma") String maNgach);
}
