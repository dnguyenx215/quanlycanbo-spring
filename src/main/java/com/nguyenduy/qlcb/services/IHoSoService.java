package com.nguyenduy.qlcb.services;

import com.nguyenduy.qlcb.models.HoSo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface IHoSoService {
    public List<HoSo> getAllHoSo();
    List<HoSo> searchAllHoSoByName(String name);
    List<HoSo> searchAllHoSoByDonVi(String maDV);
    HoSo updateDanhGia(Date ngayDG, String danhGia, long id);

    void delete(long id);

    public HoSo updateMucLuong(int bac, double heSo, long maCB);
    public HoSo getByIdHoSo(long id);

    HoSo update(long id, HoSo t);

    HoSo insert(HoSo t);

}
