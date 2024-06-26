package com.nguyenduy.qlcb.services;

import com.nguyenduy.qlcb.models.DonVi;
import com.nguyenduy.qlcb.models.HoSo;
import com.nguyenduy.qlcb.models.PhongBan;
import com.nguyenduy.qlcb.repository.IHoSoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@Service
public class HoSoServiceImpl implements IHoSoService {
    IHoSoRepository hoSoRepository;

    @Autowired
    public HoSoServiceImpl(IHoSoRepository hoSoRepository) {
        this.hoSoRepository = hoSoRepository;
    }

    @Override
    public List<HoSo> getAllHoSo() {
        return hoSoRepository.findAll();
    }

    public List<HoSo> searchAllHoSoByName(String name) {
        return hoSoRepository.findByHoVaTen(name);
    }

    public List<HoSo> searchAllHoSoByDonVi(DonVi maDV) {
        return hoSoRepository.findHoSoByDonVi(maDV);
    }

    @Override
    public List<HoSo> searchAllHoSoByPhongBan(PhongBan maPB) {
        return hoSoRepository.findHoSoByPhongBan(maPB);
    }

    @Override
    public void delete(long id) {
        hoSoRepository.deleteById(id);
    }

    @Override
    public HoSo getByIdHoSo(long id) {
        return hoSoRepository.findByIdHoSo(id);
    }

    @Override
    public HoSo update(long id, HoSo hoSo) {
        if (hoSo != null) {
            HoSo editItem = hoSoRepository.findByIdHoSo(id);
            if (editItem != null) {
                editItem.setSoHieuCBCCVC(hoSo.getSoHieuCBCCVC());
                editItem.setDonVi(hoSo.getDonVi());
                editItem.setPhongBan(hoSo.getPhongBan());
                editItem.setHoVaTen(hoSo.getHoVaTen());
                editItem.setNgaySinh(hoSo.getNgaySinh());
                editItem.setGioiTinh(hoSo.getGioiTinh());
                editItem.setNoiSinh(hoSo.getNoiSinh());
                editItem.setHoKhauThuongTru(hoSo.getHoKhauThuongTru());
                editItem.setNoiOHienTai(hoSo.getNoiOHienTai());
                editItem.setDanToc(hoSo.getDanToc());
                editItem.setTonGiao(hoSo.getTonGiao());
                editItem.setSoCmnd(hoSo.getSoCmnd());
                editItem.setChucVu(hoSo.getChucVu());
                editItem.setNgayBoNhiem(hoSo.getNgayBoNhiem());
                editItem.setMaNgach(hoSo.getMaNgach());
                editItem.setBacLuong(hoSo.getBacLuong());
                editItem.setHeSoLuong(hoSo.getHeSoLuong());
                editItem.setPhuCapThamNienVuotKhung(hoSo.getPhuCapThamNienVuotKhung());
                editItem.setHeSoPhuCapChucVu(hoSo.getHeSoPhuCapChucVu());
                editItem.setNgayVaoDcsvn(hoSo.getNgayVaoDcsvn());
                editItem.setSoTheDang(hoSo.getSoTheDang());
                editItem.setTrinhDoGDPT(hoSo.getTrinhDoGDPT());
                editItem.setTrinhDoChuyenMon(hoSo.getTrinhDoChuyenMon());
                editItem.setHocVi(hoSo.getHocVi());
                editItem.setHocHam(hoSo.getHocHam());
                editItem.setNgoaiNgu(hoSo.getNgoaiNgu());
                editItem.setTinHoc(hoSo.getTinHoc());
                editItem.setSoBaoHiemXh(hoSo.getSoBaoHiemXh());
                editItem.setTrangThaiHoSo(hoSo.getTrangThaiHoSo());
                return hoSoRepository.save(editItem);
            }
        }
        return null;
    }

    public HoSo updateMucLuong(int bac, double heSo, long maCB) {
        HoSo edt = hoSoRepository.findByIdHoSo(maCB);
        if (edt != null) {
            edt.setBacLuong(bac);
            edt.setHeSoLuong(heSo);
            return hoSoRepository.save(edt);
        }
        return null;
    }

    public HoSo updatePhuCap(int phuCapVuotKhung, double phuCapChucVu, long maCB) {
        HoSo edt = hoSoRepository.findByIdHoSo(maCB);
        if (edt != null) {
            edt.setPhuCapThamNienVuotKhung(phuCapVuotKhung);
            edt.setHeSoPhuCapChucVu(phuCapChucVu);
            return hoSoRepository.save(edt);
        }
        return null;
    }


    public HoSo updateDanhGia(Date ngayDG, String danhGia, long id) {
        HoSo edt = hoSoRepository.findByIdHoSo(id);
        if (edt != null) {
            edt.setDanhGia(danhGia);
            edt.setNgayDanhGia(ngayDG);
            return hoSoRepository.save(edt);
        }
        return null;
    }

    @Override
    public HoSo updateQTDTBD(Date ngayGuiDaoTaoBoiDuong, String tenChuyenNganhDaoTaoBoiDuong,
                             String trangThaiDaoTaoBoiDuong, long id) {
        HoSo edt = hoSoRepository.findByIdHoSo(id);
        if (edt != null) {
            edt.setNgayGuiDaoTaoBoiDuong(ngayGuiDaoTaoBoiDuong);
            edt.setTenChuyenNganhDaoTaoBoiDuong(tenChuyenNganhDaoTaoBoiDuong);
            edt.setTrangThaiDaoTaoBoiDuong(trangThaiDaoTaoBoiDuong);
            return hoSoRepository.save(edt);
        }
        return null;
    }


    @Override
    public HoSo updateKhenThuong(String soQD, Date ngayQD, String hinhThuc, long id) {
        HoSo edt = hoSoRepository.findByIdHoSo(id);
        if (edt != null) {
            edt.setSoQuyetDinhKhenThuong(soQD);
            edt.setHinhThucKhenThuong(hinhThuc);
            edt.setNgayKhenThuong(ngayQD);
            return hoSoRepository.save(edt);
        }
        return null;
    }

    @Override
    public HoSo updateKyLuat(String soQD, Date ngayQD, String hinhThuc, long id) {
        HoSo edt = hoSoRepository.findByIdHoSo(id);
        if (edt != null) {
            edt.setSoQuyetDinhKyLuat(soQD);
            edt.setHinhThucKyLuat(hinhThuc);
            edt.setNgayKyLuat(ngayQD);
            if(hinhThuc.equals("Buộc thôi việc")) {
                edt.setTrangThaiHoSo("Buộc thôi việc");
            }
            else if(hinhThuc.equals("Bãi nhiệm")) {
                edt.setTrangThaiHoSo("Bãi nhiệm");

            }
            return hoSoRepository.save(edt);
        }
        return null;
    }

    @Override
    public HoSo updateNghiHuu(String hinhThucNghiHuu, Date ngayNH, long id) {
        HoSo edt = hoSoRepository.findByIdHoSo(id);
        if (edt != null) {
            edt.setNgayNghiHuu(ngayNH);
            edt.setHinhThucNghiHuu(hinhThucNghiHuu);
            if(hinhThucNghiHuu.equals("Tinh giản biên chế")) {
                edt.setTrangThaiHoSo("Tinh giản biên chế");
            }
            else {
                edt.setTrangThaiHoSo("Về hưu");
            }
            return hoSoRepository.save(edt);
        }
        return null;
    }

    @Override
    public HoSo insert(HoSo t) {
        if (hoSoRepository.findBySoHieuCBCCVC(t.getSoHieuCBCCVC()) != null) {
            return null;
        }
        t.setTrangThaiHoSo("Bình thường");
        return hoSoRepository.save(t);
    }


    @Override
    public HoSo uploadImage(long id, MultipartFile file) throws IOException {
        String fileName = Objects.requireNonNull(file.getOriginalFilename()).replaceAll("\\s", "");
        HoSo qd = hoSoRepository.findByIdHoSo(id);
        qd.setImageUrl(file.getBytes());
        return hoSoRepository.save(qd);
    }

    @Override
    public byte[] downloadFile(long fileID) {
        Optional<HoSo> dbFileData = hoSoRepository.findById(fileID);
        return dbFileData.get().getImageUrl();
    }
}
