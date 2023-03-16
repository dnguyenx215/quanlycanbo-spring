package com.nguyenduy.qlcb.controllers;

import com.nguyenduy.qlcb.models.NgachChucDanh;
import com.nguyenduy.qlcb.services.NgachChucDanhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class NgachChucDanhController {
    private final NgachChucDanhService ngachService;

    @Autowired
    public NgachChucDanhController(NgachChucDanhService ngachService) {
        this.ngachService = ngachService;
    }

    @GetMapping("/ngach/list")
    public ResponseEntity<List<NgachChucDanh>> getAllNgachChucDanh() throws Throwable {
        try {
            List<NgachChucDanh> ds;
            ds = ngachService.getAllNgach();
            return new ResponseEntity<>(ds, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @GetMapping("/ngach/{id}")
    public ResponseEntity<NgachChucDanh> getNgachChucDanhByID(@PathVariable String id) throws ParseException, SQLException {
        try {
            NgachChucDanh d = ngachService.getNgachByID(id);
            return new ResponseEntity<>(d, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/ngach/add")
    public ResponseEntity<NgachChucDanh> createNgachChucDanh(@RequestBody NgachChucDanh item) throws ParseException, SQLException {
        try {
            NgachChucDanh d = ngachService.insert(item);
            return new ResponseEntity<>(d, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/ngach")
    public ResponseEntity<NgachChucDanh> editNgachChucDanh(@RequestParam(name = "id") String id,
                                                           @RequestBody NgachChucDanh item) throws ParseException, SQLException {
        try {
            NgachChucDanh d = ngachService.update(id, item);
            return new ResponseEntity<>(d, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/ngach")
    public ResponseEntity<NgachChucDanh> deleteNgachChucDanh(@RequestParam(name = "id") String id) throws ParseException, SQLException {
        try {
            ngachService.delete(id);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/hesongach/list")
    public ResponseEntity<List<NgachChucDanh>> getAllNgachChucDanhByLoai(@RequestParam(required = false,
            name = "loai") String loai, @RequestParam(required = false, name = "nhom") String nhom) throws Throwable {
        try {
            List<NgachChucDanh> ds = new ArrayList<NgachChucDanh>();
            if (loai != null) {
               // ds = ngachService.getAllNgachByLoai(loai);
            } else if (nhom != null) {
                ds = ngachService.getAllNgachByNhom(nhom);
            }
            return new ResponseEntity<>(ds, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @PostMapping("/hesongach/add")
    public ResponseEntity<NgachChucDanh> addHeSoNgachChucDanhByLoai(@RequestParam(name = "loai") String loai,
                                                                    @RequestBody ArrayList<Float> heSo) throws ParseException, SQLException {
        try {
            ngachService.setHeSoByLoai(loai, heSo);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/hesongach/loai")
    public ResponseEntity<List<String>> findAllLoai() throws Throwable {
        try {
            List<String> ds = ngachService.findAllLoai();
            return new ResponseEntity<>(ds, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @GetMapping("/hesongach/nhom")
    public ResponseEntity<List<String>> findAllNhom() throws Throwable {
        try {
            List<String> ds = ngachService.findAllNhomNgach();
            return new ResponseEntity<>(ds, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @GetMapping("/heso")
    public ResponseEntity<NgachChucDanh> findHeSoByBacNgach(@RequestParam("bac") String b,
                                                      @RequestParam("mangach") String m) {
        try {
            NgachChucDanh ds = ngachService.findHeSoByBacNgach(b, m);
            return new ResponseEntity<>(ds, HttpStatus.OK);
        } catch (Exception e) {
            ResponseEntity.internalServerError().body(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

}
