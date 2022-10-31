package com.restfull.oop.mapper;

import com.restfull.oop.config.EntityMapper;
import com.restfull.oop.dto.CTSanPhamDTO;
import com.restfull.oop.model.CTSanPham;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface CTSanPhamMapper extends EntityMapper<CTSanPhamDTO, CTSanPham> {
}
