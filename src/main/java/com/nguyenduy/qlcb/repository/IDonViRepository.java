package com.nguyenduy.qlcb.repository;

import com.nguyenduy.qlcb.models.DonVi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDonViRepository extends JpaRepository<DonVi, String> {
    DonVi findByMaDonVi(String maDonVi);
    List<DonVi> findDonViByTenDonVi(String ten);
}
