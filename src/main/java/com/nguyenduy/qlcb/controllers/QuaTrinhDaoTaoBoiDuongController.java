package com.nguyenduy.qlcb.controllers;

import com.nguyenduy.qlcb.models.DonVi;
import com.nguyenduy.qlcb.models.HoSo;
import com.nguyenduy.qlcb.models.QuaTrinhDaoTaoBoiDuong;
import com.nguyenduy.qlcb.services.QuaTrinhDaoTaoBoiDuongServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class QuaTrinhDaoTaoBoiDuongController {
    @Autowired
    private QuaTrinhDaoTaoBoiDuongServiceImpl dtService;

    @GetMapping("/quatrinhdtbd/list")
    public ResponseEntity<List<QuaTrinhDaoTaoBoiDuong>> getAll() throws SQLException {
        List<QuaTrinhDaoTaoBoiDuong> ldt =  dtService.getAllQuaTrinhDaoTaoBoiDuong();
        return new ResponseEntity<>(ldt, HttpStatus.OK);
    }

    @PostMapping("/quatrinhdtbd/listbyhoso")
    public ResponseEntity<List<QuaTrinhDaoTaoBoiDuong>> getAllByHS(@RequestBody HoSo h) throws SQLException {
        List<QuaTrinhDaoTaoBoiDuong> ldt =  dtService.getAllQuaTrinhDaoTaoBoiDuongByHoSo(h);
        return new ResponseEntity<>(ldt, HttpStatus.OK);
    }

    @GetMapping("/quatrinhdtbd/get/{id}")
    public ResponseEntity<QuaTrinhDaoTaoBoiDuong> getById(@PathVariable long id) throws ParseException, SQLException {
        QuaTrinhDaoTaoBoiDuong d = dtService.getByIdQuaTrinhDaoTaoBoiDuong(id);
        return new ResponseEntity<>(d, HttpStatus.OK);
    }

    @PostMapping("/quatrinhdtbd/add")
    public ResponseEntity<QuaTrinhDaoTaoBoiDuong> createQuaTrinhDaoTaoBoiDuong(@RequestBody QuaTrinhDaoTaoBoiDuong dt) throws ParseException, SQLException {
        QuaTrinhDaoTaoBoiDuong d = dtService.insert(dt);
        return new ResponseEntity<>(d, HttpStatus.OK);
    }
    @PutMapping("/quatrinhdtbd/{id}")
    public ResponseEntity<QuaTrinhDaoTaoBoiDuong> updateQuaTrinhDaoTaoBoiDuong(@PathVariable long id,
                                                   @RequestBody QuaTrinhDaoTaoBoiDuong dt) throws ParseException, SQLException {
        QuaTrinhDaoTaoBoiDuong d = dtService.update(id, dt);
        return new ResponseEntity<>(d, HttpStatus.OK);
    }

    @DeleteMapping("/quatrinhdtbd/{id}")
    public ResponseEntity<QuaTrinhDaoTaoBoiDuong> deleteById(@PathVariable int id) throws ParseException, SQLException {
       try{
           dtService.delete(id);
           return new ResponseEntity<>(HttpStatus.OK);
       }
       catch (Exception e){
           return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }
}
