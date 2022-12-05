package com.restfull.oop.repository;

import com.restfull.oop.model.KhuyenMai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface KhuyenMaiRepository extends JpaRepository<KhuyenMai, Long> { // <Kieu du lieu, Khoa chinh>
    @Query("select max(km.maKM) as maKM from KhuyenMai km where km.maNV = :maNV")
    Long findNewestPromotion(@Param("maNV") String maNV);

}
