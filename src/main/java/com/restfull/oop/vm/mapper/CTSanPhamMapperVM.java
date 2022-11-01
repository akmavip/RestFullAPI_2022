package com.restfull.oop.vm.mapper;

import com.restfull.oop.config.EntityMapper;
import com.restfull.oop.model.CTSanPham;
import com.restfull.oop.vm.CTSanPhamVM;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface CTSanPhamMapperVM extends EntityMapper<CTSanPhamVM, CTSanPham> {
}
