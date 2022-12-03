package com.restfull.oop.vm;

import com.restfull.oop.model.TheLoai;
import lombok.Data;

import java.sql.Date;
import java.util.List;

@Data
public class SanPhamVM{

    private Long maSP;

    private String tenSP;

    private TheLoai theLoai;

    private int tongSLTon;

    private int luotXem;

    private Date ngayTao;

    private Date ngayCapNhat;

    private String hinhAnh;

    List<CTSanPhamVM> cTSanPhams;
}
