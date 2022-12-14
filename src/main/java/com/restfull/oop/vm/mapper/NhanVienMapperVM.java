package com.restfull.oop.vm.mapper;

import com.restfull.oop.config.EntityMapper;
import com.restfull.oop.model.NhanVien;
import com.restfull.oop.vm.NhanVienVM;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface NhanVienMapperVM extends EntityMapper<NhanVienVM, NhanVien> {
}
