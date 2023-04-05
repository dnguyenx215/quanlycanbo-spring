package com.nguyenduy.qlcb.repository;

import com.nguyenduy.qlcb.models.DonVi;
import com.nguyenduy.qlcb.models.HoSo;
import com.nguyenduy.qlcb.models.PhongBan;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IHoSoRepository extends JpaRepository<HoSo, Long> {


    HoSo findBySoHieuCBCCVC(String soHieuCBCCVC);

    @Query(value = "SELECT * FROM ho_so WHERE ho_va_ten LIKE %?1% or so_hieucbccvc LIKE %?1%", nativeQuery = true)
    List<HoSo> findByHoVaTen(String hoVaTen);

    List<HoSo> findHoSoByDonVi(DonVi maDV);
    List<HoSo> findHoSoByPhongBan(PhongBan maPB);
    HoSo findByIdHoSo(Long id);
}
