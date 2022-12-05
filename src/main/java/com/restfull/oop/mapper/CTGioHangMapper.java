package com.restfull.oop.mapper;
import com.restfull.oop.config.EntityMapper;
import com.restfull.oop.dto.CTGioHangDTO;
import com.restfull.oop.model.CTGioHang;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface CTGioHangMapper extends EntityMapper<CTGioHangDTO, CTGioHang>{
}
