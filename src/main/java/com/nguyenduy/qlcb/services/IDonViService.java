package com.nguyenduy.qlcb.services;

import com.nguyenduy.qlcb.models.DonVi;

import java.util.List;

public interface IDonViService {
    public List<DonVi> getAllDonVi();
    DonVi getDonViByName(String ten);

    void delete(String id);

    public DonVi getByIdDonVi(String id);

    DonVi update(String id, DonVi t);

    DonVi insert(DonVi t);
}
