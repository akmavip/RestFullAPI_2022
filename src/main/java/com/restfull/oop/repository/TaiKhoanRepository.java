package com.restfull.oop.repository;

import com.restfull.oop.model.TaiKhoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@SuppressWarnings("unused")
@Repository
public interface TaiKhoanRepository extends JpaRepository<TaiKhoan, Long> {
}
