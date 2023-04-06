package com.nguyenduy.qlcb.services;

import com.nguyenduy.qlcb.models.DonVi;
import com.nguyenduy.qlcb.models.HoSo;
import com.nguyenduy.qlcb.models.QuaTrinhDaoTaoBoiDuong;
import com.nguyenduy.qlcb.repository.IQuaTrinhDaoTaoBoiDuongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuaTrinhDaoTaoBoiDuongServiceImpl {
    IQuaTrinhDaoTaoBoiDuongRepository QTDTBDRepository;

    @Autowired
    public QuaTrinhDaoTaoBoiDuongServiceImpl(IQuaTrinhDaoTaoBoiDuongRepository QTDTBDRepository) {
        this.QTDTBDRepository = QTDTBDRepository;
    }

    public List<QuaTrinhDaoTaoBoiDuong> getAllQuaTrinhDaoTaoBoiDuong() {
        return QTDTBDRepository.findAll();
    }


    public List<QuaTrinhDaoTaoBoiDuong> getAllQuaTrinhDaoTaoBoiDuongByHoSo(HoSo h) {
        return QTDTBDRepository.findAllByHoSo(h);
    }


    public void delete(long id) {
        QuaTrinhDaoTaoBoiDuong ent = QTDTBDRepository.findById(id);
        QTDTBDRepository.delete(ent);
    }

    public QuaTrinhDaoTaoBoiDuong getByIdQuaTrinhDaoTaoBoiDuong(long id) {
        return QTDTBDRepository.findById(id);
    }

    public QuaTrinhDaoTaoBoiDuong update(long id, QuaTrinhDaoTaoBoiDuong t) {
        QuaTrinhDaoTaoBoiDuong editObj = QTDTBDRepository.findById(id);
        editObj.setTuNgay(t.getTuNgay());
        editObj.setDenNgay(t.getDenNgay());
        editObj.setTenChuyenNganhDaoTaoBoiDuong(t.getTenChuyenNganhDaoTaoBoiDuong());
        editObj.setTrinhDoDaoTaoBoiDuong(t.getTrinhDoDaoTaoBoiDuong());
        editObj.setCoSoDaoTaoBoiDuong(t.getCoSoDaoTaoBoiDuong());
        editObj.setTrangThaiDaoTaoBoiDuong(t.getTrangThaiDaoTaoBoiDuong());
        return QTDTBDRepository.save(editObj);
    }

    public QuaTrinhDaoTaoBoiDuong insert(QuaTrinhDaoTaoBoiDuong t) {
        if(QTDTBDRepository.findById(t.getId()) != null) {
            return null;
        }
        return QTDTBDRepository.save(t);
    }
}
