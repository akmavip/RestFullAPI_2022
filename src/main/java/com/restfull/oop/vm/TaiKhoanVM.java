package com.restfull.oop.vm;


import lombok.Data;

@Data
public class TaiKhoanVM {

    private Long maTK;

    private String password;

    private QuyenVM quyen;
}
