package com.restfull.oop.controller;


import com.restfull.oop.dto.TaiKhoanDTO;
import com.restfull.oop.service.TaiKhoanService;
import com.restfull.oop.vm.TaiKhoanVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaiKhoanController {

    @Autowired
    private TaiKhoanService taiKhoanService;

    @GetMapping("/taiKhoan")
    @CrossOrigin
    public ResponseEntity<List<TaiKhoanVM>> getList() {
        return ResponseEntity.ok(taiKhoanService.getList());
    }

    @GetMapping("/taiKhoan/{id}")
    @CrossOrigin
    public ResponseEntity<TaiKhoanVM> getDetailTK(@PathVariable Long id) {
        return ResponseEntity.ok(taiKhoanService.getDetail(id));
    }

    @PostMapping("/taiKhoan")
    @CrossOrigin
    public ResponseEntity<TaiKhoanVM> create(@RequestBody TaiKhoanDTO taiKhoanDTO){
        return ResponseEntity.ok(taiKhoanService.create(taiKhoanDTO));
    }

    @PutMapping("/taiKhoan")
    @CrossOrigin
    public ResponseEntity<TaiKhoanVM> update(@RequestBody TaiKhoanDTO taiKhoanDTO){
        return ResponseEntity.ok(taiKhoanService.update(taiKhoanDTO));
    }

    @DeleteMapping("/taiKhoan/{id}")
    @CrossOrigin
    public void delete(@PathVariable Long id){
        taiKhoanService.delete(id);
    }
}
