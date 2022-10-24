package com.restfull.oop.controller;


import com.restfull.oop.model.Quyen;
import com.restfull.oop.service.QuyenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QuyenController {

    @Autowired
    private QuyenService quyenService;

    @GetMapping("/quyen")
    public ResponseEntity<List<Quyen>> getList() {
        return ResponseEntity.ok(quyenService.getList());
    }
}
