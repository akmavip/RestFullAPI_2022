package com.restfull.oop.repository;

import com.restfull.oop.model.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SanPhamRepository  extends JpaRepository<SanPham, Long> { // <Kieu du lieu, Khoa chinh>
}
