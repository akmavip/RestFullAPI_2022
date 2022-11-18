package com.restfull.oop.repository;

import com.restfull.oop.model.CTSanPham;
import com.restfull.oop.model.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CTSanPhamRepository extends JpaRepository<CTSanPham, Long> {

    @Query("from CTSanPham c where c.sanPham.maSP = :id")
    List<CTSanPham> findAllBySanPhamId(@Param("id") Long productId);

    @Query("from CTSanPham c where c.sanPham.maSP =:id and c.size.maSize = :size")
    Optional<CTSanPham> findBySanPhamAndSize(@Param("id") Long productId,
                                             @Param("size") Long sizeId);
}
