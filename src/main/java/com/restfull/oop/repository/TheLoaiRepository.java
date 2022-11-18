package com.restfull.oop.repository;

import com.restfull.oop.model.Size;
import com.restfull.oop.model.TheLoai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheLoaiRepository extends JpaRepository<TheLoai, Long> {
}
