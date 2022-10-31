package com.restfull.oop.repository;

import com.restfull.oop.model.CTSanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CTSanPhamRepository extends JpaRepository<CTSanPham, Long> {
}
