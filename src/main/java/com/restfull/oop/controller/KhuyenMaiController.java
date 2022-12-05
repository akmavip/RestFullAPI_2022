package com.restfull.oop.controller;

import com.restfull.oop.model.ResponseObject;
import com.restfull.oop.payload.KhuyenMaiPayLoad;
import com.restfull.oop.service.KhuyenMaiService;
import com.restfull.oop.vm.KhuyenMaiVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class KhuyenMaiController {
    @Autowired
    private KhuyenMaiService khuyenMaiService;

    @GetMapping("/promotion")
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
    public KhuyenMaiPayLoad create(@RequestBody KhuyenMaiPayLoad khuyenMaiPayLoad) {
//        return ResponseEntity.ok().body(new ResponseObject("ok", "success", khuyenMaiService.create(khuyenMaiPayLoad)));
         return khuyenMaiService.create(khuyenMaiPayLoad);
//        return 1;
    }
//
//
//    @GetMapping("/hotProducts")
//    public ResponseEntity<ResponseObject> getHostProducts() {
//        return ResponseEntity.ok().body(new ResponseObject("ok", "success", sanPhamService.getHotProducts()));
//    }
//
//    @GetMapping("/productdetail/{id}")
//    public ResponseEntity<ResponseObject> getDetail(@PathVariable Long id) {
//        return ResponseEntity.ok().body(new ResponseObject("ok", "success", sanPhamService.getDetail(id)));
//    }
}
