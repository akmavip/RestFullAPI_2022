package com.restfull.oop.repository;

import com.restfull.oop.model.Quyen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@SuppressWarnings("unused")
@Repository
public interface QuyenRepository extends JpaRepository<Quyen, Long> {
}
