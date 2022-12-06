package com.restfull.oop.repository;

import com.restfull.oop.dto.SanPhamFilterDTO;
import com.restfull.oop.model.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SanPhamRepository extends JpaRepository<SanPham, Long> {

    List<SanPham> findTop8ByOrderByLuotXemDesc();

    List<SanPham> findTop8ByOrderByMaSPDesc();

    @Query("from SanPham sp where sp.tenSP = :name and sp.theLoai.maTL = :maTL")
    Optional<SanPham> findByTenSPAndTheLoai(@Param("name") String tenSP,
                                            @Param("maTL") Long maTL);

    @Query("select p from SanPham p "
            + "where ((:#{#filters.maSP} is null) or (p.maSP =:#{#filters.maSP})) "
            + "and ((:#{#filters.tenSP} is null) or (lower(p.tenSP) like concat('%',lower(CAST(:#{#filters.tenSP} AS text)),'%'))) ")
    List<SanPham> findAllAndFilters(@Param("filters") SanPhamFilterDTO filters);
}
