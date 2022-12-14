package com.restfull.oop.controller;

import com.restfull.oop.dto.SanPhamDTO;
import com.restfull.oop.dto.SignInRequestDTO;
import com.restfull.oop.model.ResponseObject;
import com.restfull.oop.service.LoginService;
import com.restfull.oop.service.NhanVienService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class NhanVienController {
    @Autowired
    private NhanVienService nhanvienService;
    @GetMapping("/admin/employee")
    @CrossOrigin
    public ResponseEntity<ResponseObject> getList() {
        return ResponseEntity.ok().body(new ResponseObject("ok", "success", nhanvienService.getList()));
    }

}
