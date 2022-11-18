package com.restfull.oop.repository;

import com.restfull.oop.model.SanPham;
import com.restfull.oop.model.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SizeRepository extends JpaRepository<Size, Long> {
}
