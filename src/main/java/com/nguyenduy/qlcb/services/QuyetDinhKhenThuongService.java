package com.nguyenduy.qlcb.services;

import com.nguyenduy.qlcb.models.QuyetDinhKhenThuong;
import com.nguyenduy.qlcb.repository.IQuyetDinhKhenThuongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class QuyetDinhKhenThuongService {
    private final IQuyetDinhKhenThuongRepository qdktRepo;

    @Autowired
    public QuyetDinhKhenThuongService(IQuyetDinhKhenThuongRepository qdktRepo) {
        this.qdktRepo = qdktRepo;
    }

    public List<QuyetDinhKhenThuong> getAll() {
        List<QuyetDinhKhenThuong> listFromDb = new ArrayList<>();
        listFromDb = qdktRepo.findAll();
        return listFromDb;
    }

    public List<QuyetDinhKhenThuong> getAllByDonVi(String dv) {
        List<QuyetDinhKhenThuong> listFromDb = new ArrayList<>();
        listFromDb = qdktRepo.findQuyetDinhKhenThuongByDonVi(dv);
        return listFromDb;
    }

    public void deleteQD(int id) {
        qdktRepo.deleteById(id);
    }


    public QuyetDinhKhenThuong getById(int id) {
        return qdktRepo.findQuyetDinhKhenThuongByIdQdKhenThuong(id);
    }


    public QuyetDinhKhenThuong updateQD(int id, QuyetDinhKhenThuong dt) {
        QuyetDinhKhenThuong editDT = qdktRepo.findQuyetDinhKhenThuongByIdQdKhenThuong(id);
        editDT.setTenQuyetDinh(dt.getTenQuyetDinh());
        return qdktRepo.save(editDT);
    }


    public QuyetDinhKhenThuong insertQD(QuyetDinhKhenThuong t) throws IOException {
        return qdktRepo.save(t);
    }

    public QuyetDinhKhenThuong uploadFileQD(int id, MultipartFile file) throws IOException {
        String fileName = Objects.requireNonNull(file.getOriginalFilename()).replaceAll("\\s", "");
        QuyetDinhKhenThuong qd = qdktRepo.findQuyetDinhKhenThuongByIdQdKhenThuong(id);
        qd.setTenFile(fileName);
        qd.setFileKy(file.getBytes());
        return qdktRepo.save(qd);
    }

    public byte[] downloadFile(int fileID) {
        Optional<QuyetDinhKhenThuong> dbFileData = qdktRepo.findById(fileID);
        return dbFileData.get().getFileKy();
    }


}
