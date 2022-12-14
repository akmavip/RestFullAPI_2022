package com.restfull.oop.controller;

import com.restfull.oop.dto.SanPhamDTO;
import com.restfull.oop.dto.SanPhamFilterDTO;
import com.restfull.oop.model.ResponseObject;
import com.restfull.oop.service.SanPhamService;
import com.restfull.oop.vm.SanPhamVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SanPhamController {
    @Autowired
    private SanPhamService sanPhamService;

    @GetMapping("/products")
    @CrossOrigin
    public ResponseEntity<ResponseObject> getList(SanPhamFilterDTO filters) {
        List<SanPhamVM> listSanPham = sanPhamService.getAll(filters);

        if (!listSanPham.isEmpty()) {
            return ResponseEntity.ok().body(new ResponseObject("ok", "success", listSanPham));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseObject("false", "Cannot find products", null));
        }
    }

    //Lọc sản phẩm, lọc theo tên, lấy sản phẩm mới, thêm xoá sửa
    @PostMapping("/products")
    @CrossOrigin
    public ResponseEntity<ResponseObject> create(@RequestBody SanPhamDTO sanPhamDTO) {
        return ResponseEntity.ok().body(new ResponseObject("ok", "success", sanPhamService.create(sanPhamDTO)));
    }


    @GetMapping("/hotProducts")
    @CrossOrigin
    public ResponseEntity<ResponseObject> getHostProducts() {
        return ResponseEntity.ok().body(new ResponseObject("ok", "success", sanPhamService.getHotProducts()));
    }

    @GetMapping("/productdetail/{id}")
    @CrossOrigin
    public ResponseEntity<ResponseObject> getDetail(@PathVariable Long id) {
        return ResponseEntity.ok().body(new ResponseObject("ok", "success", sanPhamService.getDetail(id)));
    }
}
