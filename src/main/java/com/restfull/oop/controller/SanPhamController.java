package com.restfull.oop.controller;

import com.restfull.oop.dto.SanPhamDTO;
import com.restfull.oop.dto.SanPhamFilterDTO;
import com.restfull.oop.model.ResponseObject;
import com.restfull.oop.service.SanPhamService;
import com.restfull.oop.vm.SanPhamVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
public class SanPhamController {
    @Autowired
    private SanPhamService sanPhamService;

    @GetMapping("/products")
    public ResponseEntity<ResponseObject> getList(SanPhamFilterDTO filters) {
        List<SanPhamVM> listSanPham = sanPhamService.getAll(filters);
        return ResponseEntity.ok().body(new ResponseObject("ok", "success", listSanPham));
    }

    //lấy sản phẩm mới, thêm xoá sửa
    @PostMapping("/products")
    public ResponseEntity<ResponseObject> create(@RequestBody SanPhamDTO sanPhamDTO) {
        return ResponseEntity.ok().body(new ResponseObject("ok", "success", sanPhamService.create(sanPhamDTO)));
    }


    @GetMapping("/hotProducts")
    public ResponseEntity<ResponseObject> getHotProducts() {
        return ResponseEntity.ok().body(new ResponseObject("ok", "success", sanPhamService.getHotProducts()));
    }

    @GetMapping("/newProducts")
    public ResponseEntity<ResponseObject> getNewProducts() {
        return ResponseEntity.ok().body(new ResponseObject("ok", "success", sanPhamService.getNewProducts()));
    }

    @GetMapping("/productdetail/{id}")
    public ResponseEntity<ResponseObject> getDetail(@PathVariable Long id) {
        return ResponseEntity.ok().body(new ResponseObject("ok", "success", sanPhamService.getDetail(id)));
    }
}
