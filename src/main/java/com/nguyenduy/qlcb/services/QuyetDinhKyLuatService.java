package com.nguyenduy.qlcb.services;

import com.nguyenduy.qlcb.models.QuyetDinhKyLuat;
import com.nguyenduy.qlcb.repository.IQuyetDinhKyLuatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class QuyetDinhKyLuatService {
    private final IQuyetDinhKyLuatRepository quyetDinhKyLuatRepository;

    @Autowired
    public QuyetDinhKyLuatService(IQuyetDinhKyLuatRepository quyetDinhKyLuatRepository) {
        this.quyetDinhKyLuatRepository = quyetDinhKyLuatRepository;
    }

    public List<QuyetDinhKyLuat> getAll() {
        List<QuyetDinhKyLuat> listFromDb = new ArrayList<>();
        listFromDb = quyetDinhKyLuatRepository.findAll();
        return listFromDb;
    }


    public void deleteQD(int id) {
        quyetDinhKyLuatRepository.deleteById(id);
    }


    public QuyetDinhKyLuat getById(int id) {
        return quyetDinhKyLuatRepository.findQuyetDinhKyLuatByIdQdkl(id);
    }


    public QuyetDinhKyLuat updateQD(int id, QuyetDinhKyLuat dt) {
        QuyetDinhKyLuat editDT = quyetDinhKyLuatRepository.findQuyetDinhKyLuatByIdQdkl(id);
        editDT.setTenQuyetDinh(dt.getTenQuyetDinh());
        return quyetDinhKyLuatRepository.save(editDT);
    }

    public List<QuyetDinhKyLuat> getAllByDonVi(String dv) {
        List<QuyetDinhKyLuat> listFromDb = new ArrayList<>();
        listFromDb = quyetDinhKyLuatRepository.findQuyetDinhKyLuatByDonVi(dv);
        return listFromDb;
    }

    public QuyetDinhKyLuat insertQD(QuyetDinhKyLuat t) {
        return quyetDinhKyLuatRepository.save(t);
    }
    public QuyetDinhKyLuat uploadFileQD(int id, MultipartFile file) throws IOException {
        String fileName = Objects.requireNonNull(file.getOriginalFilename()).replaceAll("\\s", "");
        QuyetDinhKyLuat qd = quyetDinhKyLuatRepository.findQuyetDinhKyLuatByIdQdkl(id);
        qd.setTenFile(fileName);
        qd.setFileKy(file.getBytes());
        return quyetDinhKyLuatRepository.save(qd);
    }

    public byte[] downloadFile(int fileID) {
        Optional<QuyetDinhKyLuat> dbFileData = quyetDinhKyLuatRepository.findById(fileID);
        return dbFileData.get().getFileKy();
    }
}
