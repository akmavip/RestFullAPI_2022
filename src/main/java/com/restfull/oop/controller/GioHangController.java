package com.restfull.oop.controller;

import com.restfull.oop.dto.GioHangDTO;
import com.restfull.oop.model.ResponseObject;
import com.restfull.oop.payload.GioHangPayload;
import com.restfull.oop.service.GioHangService;
import com.restfull.oop.vm.GioHangVM;
import com.restfull.oop.vm.KhuyenMaiVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GioHangController {
    @Autowired
     private GioHangService gioHangService;


    @GetMapping("/cart")
    public ResponseEntity<ResponseObject> getList() {
        List<GioHangVM> listKhuyenMai = gioHangService.getCart();

        if (!listKhuyenMai.isEmpty()) {
            return ResponseEntity.ok().body(new ResponseObject("ok", "success", listKhuyenMai));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseObject("false", "Cannot find promotion", null));
        }
    }

    @GetMapping("/cart/{maKH}")
    public ResponseEntity<ResponseObject> getCartByMaKH(@PathVariable("maKH") long maKH) {
        List<GioHangVM> ListGioHang = gioHangService.getCartByMaKH(maKH);

        if (ListGioHang.size() > 0) {
            return ResponseEntity.ok().body(new ResponseObject("ok", "success", ListGioHang));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseObject("false", "Cannot find promotion", null));
        }
    }



    @PostMapping("/cart")
    public GioHangPayload create(@RequestBody GioHangPayload gioHangPayload) {
//        return ResponseEntity.ok().body(new ResponseObject("ok", "success", gioHangService.create(gioHangDTO)));
        return gioHangService.create(gioHangPayload);
    }

    @PostMapping("/cart/update")
    public GioHangPayload update(@RequestBody GioHangPayload gioHangPayload) {
//        return ResponseEntity.ok().body(new ResponseObject("ok", "success", gioHangService.create(gioHangDTO)));
        return gioHangService.update(gioHangPayload);
    }
}
