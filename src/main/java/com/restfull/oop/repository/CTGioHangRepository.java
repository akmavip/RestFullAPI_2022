package com.restfull.oop.repository;

import com.restfull.oop.model.CTGioHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CTGioHangRepository extends JpaRepository<CTGioHang, Long> {
}
