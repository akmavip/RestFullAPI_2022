package com.restfull.oop.controller;


import com.restfull.oop.service.QuyenService;
import com.restfull.oop.vm.QuyenVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class QuyenController {

    @Autowired
    private QuyenService quyenService;

    @GetMapping("/quyen")
    @CrossOrigin
    public ResponseEntity<List<QuyenVM>> getList() {
        return ResponseEntity.ok(quyenService.getList());
    }
}
