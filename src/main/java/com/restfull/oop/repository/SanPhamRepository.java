package com.restfull.oop.repository;

import com.restfull.oop.model.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SanPhamRepository  extends JpaRepository<SanPham, Long> { // <Kieu du lieu, Khoa chinh>

    List<SanPham> findTop8ByOrderByLuotXemDesc();

    @Query("from SanPham sp where sp.tenSP = :name and sp.theLoai.maTL = :maTL")
    Optional<SanPham> findByTenSPAndTheLoai(@Param("name") String tenSP,
                                            @Param("maTL") Long maTL);
}
