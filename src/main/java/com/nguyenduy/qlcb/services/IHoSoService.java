package com.nguyenduy.qlcb.services;

import com.nguyenduy.qlcb.models.DonVi;
import com.nguyenduy.qlcb.models.HoSo;
import com.nguyenduy.qlcb.models.PhongBan;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface IHoSoService {
    public List<HoSo> getAllHoSo();
    List<HoSo> searchAllHoSoByName(String name);
    List<HoSo> searchAllHoSoByDonVi(DonVi maDV);
    List<HoSo> searchAllHoSoByPhongBan(PhongBan maPB);
    HoSo updateDanhGia(Date ngayDG, String danhGia, long id);
    HoSo updateQTDTBD(Date ngayGuiDaoTaoBoiDuong, String tenChuyenNganhDaoTaoBoiDuong, String trangThaiDaoTaoBoiDuong, long id);
    HoSo updateKhenThuong(String soQD, Date ngayQD, String hinhThuc, long id);
    HoSo updateKyLuat(String soQD, Date ngayQD, String hinhThuc, long id);

    void delete(long id);

    public HoSo updateMucLuong(int bac, double heSo, long maCB);
    public HoSo getByIdHoSo(long id);

    HoSo update(long id, HoSo t);

    HoSo insert(HoSo t);

    HoSo uploadImage(long id, MultipartFile file) throws IOException;

    public byte[] downloadFile(long fileID);
}
