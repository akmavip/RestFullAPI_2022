package com.restfull.oop.vm.mapper;

import com.restfull.oop.config.EntityMapper;
import com.restfull.oop.model.SanPham;
import com.restfull.oop.vm.SanPhamVM;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface SanPhamMapperVM extends EntityMapper<SanPhamVM, SanPham> {
}
