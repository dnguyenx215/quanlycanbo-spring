package com.nguyenduy.qlcb.repository;

import com.nguyenduy.qlcb.models.TonGiao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITonGiaoRepository extends JpaRepository<TonGiao, Long> {
    TonGiao findByMaTonGiao(long id);

}
