package com.restfull.oop.controller;

import com.restfull.oop.model.ResponseObject;
import com.restfull.oop.payload.KhuyenMaiPayLoad;
import com.restfull.oop.service.KhuyenMaiService;
import com.restfull.oop.vm.KhuyenMaiVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class KhuyenMaiController {
    @Autowired
    private KhuyenMaiService khuyenMaiService;

    @GetMapping("/promotion")
    @CrossOrigin
    public ResponseEntity<ResponseObject> getList() {
        List<KhuyenMaiVM> listKhuyenMai = khuyenMaiService.getPromotion();

        if (!listKhuyenMai.isEmpty()) {
            return ResponseEntity.ok().body(new ResponseObject("ok", "success", listKhuyenMai));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseObject("false", "Cannot find promotion", null));
        }
    }

    //Lọc sản phẩm, lọc theo tên, lấy sản phẩm mới, thêm xoá sửa
    @PostMapping("/promotion/create")
    @CrossOrigin
    public KhuyenMaiPayLoad create(@RequestBody KhuyenMaiPayLoad khuyenMaiPayLoad) {
//        return ResponseEntity.ok().body(new ResponseObject("ok", "success", khuyenMaiService.create(khuyenMaiPayLoad)));
         return khuyenMaiService.create(khuyenMaiPayLoad);
    }

    @PostMapping("/promotion/addProduct")
    @CrossOrigin
    public KhuyenMaiPayLoad addProduct(@RequestBody KhuyenMaiPayLoad khuyenMaiPayLoad) {
//        return ResponseEntity.ok().body(new ResponseObject("ok", "success", khuyenMaiService.create(khuyenMaiPayLoad)));
        return khuyenMaiService.addProduct(khuyenMaiPayLoad);
    }
//
//    @GetMapping("/productdetail/{id}")
//    public ResponseEntity<ResponseObject> getDetail(@PathVariable Long id) {
//        return ResponseEntity.ok().body(new ResponseObject("ok", "success", sanPhamService.getDetail(id)));
//    }
}
