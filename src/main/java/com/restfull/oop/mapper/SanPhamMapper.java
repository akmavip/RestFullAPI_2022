package com.restfull.oop.mapper;

import com.restfull.oop.config.EntityMapper;
import com.restfull.oop.dto.SanPhamDTO;
import com.restfull.oop.model.SanPham;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface SanPhamMapper extends EntityMapper<SanPhamDTO, SanPham> {
}
