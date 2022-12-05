package com.restfull.oop.mapper;

import com.restfull.oop.config.EntityMapper;
import com.restfull.oop.dto.KhuyenMaiDTO;
import com.restfull.oop.model.KhuyenMai;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface KhuyenMaiMapper extends EntityMapper<KhuyenMaiDTO, KhuyenMai> {
}
