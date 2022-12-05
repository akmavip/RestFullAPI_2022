package com.restfull.oop.mapper;

import com.restfull.oop.config.EntityMapper;
import com.restfull.oop.dto.CTKhuyenMaiDTO;
import com.restfull.oop.model.CTKhuyenMai;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface CTKhuyenMaiMapper extends EntityMapper<CTKhuyenMaiDTO, CTKhuyenMai> {
}
