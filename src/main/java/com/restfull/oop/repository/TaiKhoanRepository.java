package com.restfull.oop.repository;

import com.restfull.oop.model.KhachHang;
import com.restfull.oop.model.TaiKhoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.StoredProcedureParameter;
import java.util.List;

//@SuppressWarnings("unused")
@Repository
public interface TaiKhoanRepository extends JpaRepository<TaiKhoan, Long> {

    @Query("from TaiKhoan tk where tk.maTK = :maTK and tk.password = :password")
    TaiKhoan findAccount(@Param("maTK") Long maTK,
                       @Param("password") String password);
//
//    @Query(value = "CALL sp_DangNhap(:email, :password);", nativeQuery = true)
//    List<KhachHang> findAccount(@Param("email") String email,
//                                @Param("password") String password);
}
