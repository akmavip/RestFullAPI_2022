package com.restfull.oop.repository;

import com.restfull.oop.model.CTKhuyenMai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CTKhuyenMaiRepository extends JpaRepository<CTKhuyenMai, Long> {

}
