package com.restfull.oop.controller;

import com.restfull.oop.dto.GioHangDTO;
import com.restfull.oop.model.ResponseObject;
import com.restfull.oop.service.GioHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GioHangController {
    @Autowired
     private GioHangService gioHangService;

    @PostMapping("/cart")
    public ResponseEntity<ResponseObject> create() {
        return ResponseEntity.ok().body(new ResponseObject("ok", "success", gioHangService.create()));
    }
}

/*
{
  "maKH": 1,
  "fullname": "viet",
  "email": "asd@gmail.com",
  "phone": "0987654321",
  "address": "sg",
  "note": "",
  "ngayTao": "2022-11-29T15:17:50.859Z",
  "trangThai": 0,
  "maNVGiao": "employee01",
  "arr": [
    {
      "number": 2,
      "price": 300000,
      "discount": 0,
      "maSize": "1"
    }
  ],
  "payment": "0"
}
 */