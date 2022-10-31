package com.restfull.oop.controller;

import com.restfull.oop.model.ResponseObject;
import com.restfull.oop.service.SanPhamService;
import com.restfull.oop.vm.CTSanPhamVM;
import com.restfull.oop.vm.SanPhamVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/products")
public class SanPhamController {
    @Autowired
    private SanPhamService sanPhamService;

    @GetMapping("")
    public ResponseEntity<ResponseObject> getList() {
        List<SanPhamVM> listSanPham = sanPhamService.getAll();

        if (!listSanPham.isEmpty()) {
            return ResponseEntity.ok().body(new ResponseObject("ok", "success", listSanPham));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseObject("false", "Cannot find products", null));
        }
    }
}
