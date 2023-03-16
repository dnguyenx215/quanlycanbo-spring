package com.nguyenduy.qlcb.repository;

import com.nguyenduy.qlcb.models.DanToc;
import com.nguyenduy.qlcb.services.DanTocService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface IDanTocRepository extends JpaRepository<DanToc, Integer> {
    DanToc findByMaDanToc(int id);
    DanToc findByTenDanToc(String name);

}
