package com.restfull.oop.vm;


import com.restfull.oop.model.Quyen;
import lombok.Data;

@Data
public class TaiKhoanVM {

    private Long maTK;

    private String password;

    private Quyen Quyen;
}
