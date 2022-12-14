package com.restfull.oop.controller;

import com.restfull.oop.dto.SignInRequestDTO;
import com.restfull.oop.model.KhachHang;
import com.restfull.oop.model.ResponseObject;
import com.restfull.oop.service.LoginService;
import com.restfull.oop.vm.KhachHangVM;
import com.restfull.oop.vm.TaiKhoanVM;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;
    @PostMapping("/auth/signin")
    @CrossOrigin
    public ResponseEntity<ResponseObject> signIn(@RequestBody SignInRequestDTO signInRequestDTO){
        JSONObject res = loginService.getAll(signInRequestDTO.getEmail(), signInRequestDTO.getPassword());

        if(!res.isEmpty()){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseObject("ok", "success", res));
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseObject("false", "Sai mật khẩu hoặc tài khoản", null));
        }


    }
}
