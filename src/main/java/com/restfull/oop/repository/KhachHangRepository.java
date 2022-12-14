package com.restfull.oop.repository;

import com.restfull.oop.model.GioHang;
import com.restfull.oop.model.KhachHang;
import com.restfull.oop.model.TaiKhoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KhachHangRepository extends JpaRepository<KhachHang, Long> {

    @Query("from KhachHang kh where kh.email = :email")
    KhachHang findUserByEmail(@Param("email") String email);
}
