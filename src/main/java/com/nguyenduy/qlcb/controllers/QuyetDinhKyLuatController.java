package com.nguyenduy.qlcb.controllers;

import com.nguyenduy.qlcb.models.QuyetDinhKhenThuong;
import com.nguyenduy.qlcb.models.QuyetDinhKyLuat;
import com.nguyenduy.qlcb.services.QuyetDinhKyLuatService;
import com.nguyenduy.qlcb.services.QuyetDinhKyLuatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class QuyetDinhKyLuatController {
    private final QuyetDinhKyLuatService qdklService;

    @Autowired
    public QuyetDinhKyLuatController(QuyetDinhKyLuatService qdklService) {
        this.qdklService = qdklService;
    }

    @GetMapping("/qdkl/list")
    public ResponseEntity<List<QuyetDinhKyLuat>> getAllQuyetDinhKyLuat(@RequestParam(required = false, name = "donvi") String donVi) throws Throwable {
        try {
            List<QuyetDinhKyLuat> ds;
            if(donVi != null) {
                ds = qdklService.getAllByDonVi(donVi);
                return new ResponseEntity<>(ds, HttpStatus.OK);
            }

            ds = qdklService.getAll();
            return new ResponseEntity<>(ds, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @PostMapping("/qdkl/add")
    public ResponseEntity<QuyetDinhKyLuat> createQuyetDinhKyLuat(@RequestBody QuyetDinhKyLuat item) throws ParseException, SQLException {
        try {
            QuyetDinhKyLuat d = qdklService.insertQD(item);
            return new ResponseEntity<>(d, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/qdkl/{id}")
    public ResponseEntity<QuyetDinhKhenThuong> deleteById(@PathVariable int id) throws ParseException, SQLException {
        try{
            qdklService.deleteQD(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/qdkl/uploadfile")
    public ResponseEntity<?> uploadFileQuyetDinhKL(
            @RequestParam(name="id") int id,
            @RequestPart(name="file") MultipartFile file) throws ParseException, SQLException {
        try {

            QuyetDinhKyLuat d = qdklService.uploadFileQD(id, file);
            return new ResponseEntity<>(d, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("qdkl/open/{id}")
    public ResponseEntity<?> downloadFile(@PathVariable int id){
        byte[] fileData = qdklService.downloadFile(id);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("application/pdf"))
                .body(fileData);
    }


}
