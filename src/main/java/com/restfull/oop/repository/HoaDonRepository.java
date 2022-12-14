package com.restfull.oop.repository;

import com.restfull.oop.model.HoaDon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HoaDonRepository extends JpaRepository<HoaDon, Long> {
    HoaDon findByMaHoaDon(Long maHoaDon);
}
