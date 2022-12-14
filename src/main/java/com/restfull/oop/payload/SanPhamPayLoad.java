package com.restfull.oop.payload;

import com.restfull.oop.model.TheLoai;
import com.restfull.oop.vm.CTSanPhamVM;
import lombok.Data;

import java.sql.Date;
import java.util.List;

@Data
public class SanPhamPayLoad {

    private Long maSP;

    private String tenSP;

    private Long maTL;

//    private TheLoai theLoai;

    private int tongSLTon;

    private int luotXem;

    private Date ngayTao;

    private Date ngayCapNhat;

    private String hinhAnh;

    List<CTSanPhamPayLoad> ctsanPhams;
}
