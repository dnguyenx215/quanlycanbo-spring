package com.nguyenduy.qlcb.controllers;

import com.nguyenduy.qlcb.models.DanToc;
import com.nguyenduy.qlcb.models.QuyetDinhKhenThuong;
import com.nguyenduy.qlcb.services.QuyetDinhKhenThuongService;
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
@CrossOrigin("http://localhost:4200")
public class QuyetDinhKhenThuongController {
    private final QuyetDinhKhenThuongService qdktService;

    @Autowired
    public QuyetDinhKhenThuongController(QuyetDinhKhenThuongService qdktService) {
        this.qdktService = qdktService;
    }

    @GetMapping("/qdkt/list")
    public ResponseEntity<List<QuyetDinhKhenThuong>> getAllQuyetDinhKhenThuong(@RequestParam(required = false, name = "donvi") String donVi) throws Throwable {
        try {
            List<QuyetDinhKhenThuong> ds;
            if(donVi != null) {
                ds = qdktService.getAllByDonVi(donVi);
                return new ResponseEntity<>(ds, HttpStatus.OK);
            }
            else {
                ds = qdktService.getAll();
                return new ResponseEntity<>(ds, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @PostMapping("/qdkt/add")
    public ResponseEntity<QuyetDinhKhenThuong> createQuyetDinhKhenThuong(
            @RequestBody() QuyetDinhKhenThuong qdkt,
            @RequestPart(name="file", required = false) MultipartFile file) throws ParseException, SQLException {
        try {

            QuyetDinhKhenThuong d = qdktService.insertQD(qdkt);
            return new ResponseEntity<>(d, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/qdkt/uploadfile")
    public ResponseEntity<?> uploadFileQuyetDinhKhenThuong(
            @RequestParam(name="id") int id,
            @RequestPart(name="file") MultipartFile file) throws ParseException, SQLException {
        try {

            QuyetDinhKhenThuong d = qdktService.uploadFileQD(id, file);
            return new ResponseEntity<>(d, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/qdkt/{id}")
    public ResponseEntity<QuyetDinhKhenThuong> updateKT(@PathVariable int id, @RequestBody QuyetDinhKhenThuong kt) throws ParseException, SQLException {
        QuyetDinhKhenThuong d = qdktService.updateQD(id, kt);
        return new ResponseEntity<>(d, HttpStatus.OK);
    }

    @DeleteMapping("/qdkt/{id}")
    public ResponseEntity<QuyetDinhKhenThuong> deleteById(@PathVariable int id) throws ParseException, SQLException {
        try{
            qdktService.deleteQD(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("qdkt/open/{id}")
    public ResponseEntity<?> downloadFile(@PathVariable int id){
        byte[] fileData = qdktService.downloadFile(id);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_PDF)
                .body(fileData);
    }

}
