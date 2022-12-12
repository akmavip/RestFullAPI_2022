package com.restfull.oop.repository;

import com.restfull.oop.model.GioHang;
import com.restfull.oop.model.KhachHang;
import com.restfull.oop.vm.GioHangVM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GioHangRepository extends JpaRepository<GioHang, Long> {
    @Query("select max(gh.idGio) as maKM from GioHang gh where gh.khachHang = :maKH")
    Long findNewestCart(@Param("maKH") KhachHang maKH);

    @Query("from GioHang gh where gh.idGio = :idGio")
    GioHang findCartToUpdate(@Param("idGio") Long idGio);

    @Query("from GioHang gh where gh.khachHang = :maKH")
    List<GioHang> findCartByMa(@Param("maKH") KhachHang maKH);
}
