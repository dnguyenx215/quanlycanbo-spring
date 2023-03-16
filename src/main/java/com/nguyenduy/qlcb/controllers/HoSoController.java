package com.nguyenduy.qlcb.controllers;

import com.nguyenduy.qlcb.models.DonVi;
import com.nguyenduy.qlcb.models.HoSo;
import com.nguyenduy.qlcb.services.IHoSoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class HoSoController {
    IHoSoService hoSoService;

    @Autowired
    public HoSoController(IHoSoService hoSoService) {
        this.hoSoService = hoSoService;
    }

    @GetMapping("/hoso/list")
    public ResponseEntity<List<HoSo>> getAllHoSo(@RequestParam(required = false, name = "hoten") String hoTen,
                                                 @RequestParam(required = false, name = "madv") String maDV) throws Throwable {
        try {
            List<HoSo> listHoSo;
            if (hoTen != null) {
                listHoSo = hoSoService.searchAllHoSoByName(hoTen);
            } else if (maDV != null) {
                listHoSo = hoSoService.searchAllHoSoByDonVi(maDV);
            } else {
                listHoSo = hoSoService.getAllHoSo();
            }

            return new ResponseEntity<>(listHoSo, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @GetMapping("/hoso/get")
    public ResponseEntity<HoSo> getHoSoByID(@RequestParam(name = "id") Long id) throws Throwable {
        try {
            HoSo hoSo;
            hoSo = hoSoService.getByIdHoSo(id);
            return new ResponseEntity<>(hoSo, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @PostMapping("/hoso/add")
    public ResponseEntity<HoSo> addHoSo(@RequestBody HoSo hoSo) throws Throwable {
        try {
            HoSo ins = hoSoService.insert(hoSo);
            if (ins != null) {
                return new ResponseEntity<>(ins, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);

            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @PutMapping("/hoso/update")
    public ResponseEntity<HoSo> putHoSo(@RequestParam("id") long idhs, @RequestBody HoSo hoSo) {
        try {
            HoSo putById = hoSoService.update(idhs, hoSo);
            return new ResponseEntity<>(putById, HttpStatus.OK);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/hoso/updateheso")
    public ResponseEntity<HoSo> putHoSoMucLuong(@RequestParam("bac") int bac,
                                                @RequestParam("heso") double heso,
                                                @RequestParam("macb") long macb) {
        try {
            HoSo putById = hoSoService.updateMucLuong(bac, heso, macb);
            return new ResponseEntity<>(putById, HttpStatus.OK);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/hoso/danhgia")
    public ResponseEntity<HoSo> putHoSoDanhGia(@RequestBody() String dg,
                                                @RequestParam("ngaydg") String ngayDG,
                                                @RequestParam("id") long macb) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-d");
            Date date = sdf.parse(ngayDG);
            HoSo putById = hoSoService.updateDanhGia(date, dg, macb);
            return new ResponseEntity<>(putById, HttpStatus.OK);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/hoso/delete")
    public ResponseEntity<HoSo> deleteHoSo(@RequestParam("id") long idhs) {
        try {
            hoSoService.delete(idhs);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
