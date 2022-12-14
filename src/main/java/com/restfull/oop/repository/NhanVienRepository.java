package com.restfull.oop.repository;

import com.restfull.oop.model.KhachHang;
import com.restfull.oop.model.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, String> {
    @Query("from NhanVien nv where nv.email = :email")
    NhanVien findEmployeeByEmail(@Param("email") String email);

    @Query("from NhanVien nv where nv.maNV = :maNV")
    List<NhanVien> findEmployeeByMaNV(@Param("maNV") String maNV);
}
