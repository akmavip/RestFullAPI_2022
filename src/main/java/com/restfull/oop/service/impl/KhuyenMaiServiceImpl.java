package com.restfull.oop.service.impl;

import com.restfull.oop.model.CTKhuyenMai;
import com.restfull.oop.model.KhuyenMai;
import com.restfull.oop.payload.KhuyenMaiPayLoad;
import com.restfull.oop.payload.SanPhamPayLoad;
import com.restfull.oop.repository.CTKhuyenMaiRepository;
import com.restfull.oop.repository.KhuyenMaiRepository;
import com.restfull.oop.service.KhuyenMaiService;
import com.restfull.oop.vm.KhuyenMaiVM;
import com.restfull.oop.vm.mapper.KhuyenMaiMapperVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class KhuyenMaiServiceImpl implements KhuyenMaiService {

    @Autowired
    private KhuyenMaiRepository khuyenMaiRepository;

    @Autowired
    private KhuyenMaiMapperVM khuyenMaiMapperVM;

    @Autowired
    private CTKhuyenMaiRepository ctKhuyenMaiRepository;

    @Override
    public List<KhuyenMaiVM> getPromotion() {

        return khuyenMaiRepository.findAll().stream().map(khuyenMaiMapperVM::toDto).collect(Collectors.toList());

    }

    @Override
    public KhuyenMaiPayLoad create(KhuyenMaiPayLoad khuyenMaiPayLoad) {
        int phanTramGiam = khuyenMaiPayLoad.getPhanTramGiam();
        KhuyenMai khuyenMaiMoi = new KhuyenMai();
        khuyenMaiMoi.setMota(khuyenMaiPayLoad.getMoTa());
        khuyenMaiMoi.setMaNV(khuyenMaiPayLoad.getMaNV());
        khuyenMaiMoi.setNgayApDung(khuyenMaiPayLoad.getNgayApDung());
        khuyenMaiMoi.setNgayKetThuc(khuyenMaiPayLoad.getNgayKetThuc());
        String maNV = String.valueOf(khuyenMaiMoi.getMaNV());
        khuyenMaiRepository.save(khuyenMaiMoi);

        KhuyenMai KMtest = new KhuyenMai();
        KMtest.setMaKM(khuyenMaiRepository.findNewestPromotion(maNV));
        List <SanPhamPayLoad> dssp = khuyenMaiPayLoad.getDssp();
        for (int i = 0; i < dssp.size(); i++) {
            for (int j = 0; j < dssp.get(i).getCtsanPhams().size(); j++) {
                CTKhuyenMai ctKhuyenMai = new CTKhuyenMai();
                ctKhuyenMai.setMaCTSP(dssp.get(i).getCtsanPhams().get(j).getMaCTSP());
                ctKhuyenMai.setPhanTramGiam(phanTramGiam);
                ctKhuyenMai.setKhuyenMai(KMtest);
                ctKhuyenMaiRepository.save(ctKhuyenMai);
            }
        }

        return khuyenMaiPayLoad;
    }

    @Override
    public KhuyenMaiPayLoad addProduct(KhuyenMaiPayLoad khuyenMaiPayLoad) {
        int phanTramGiam = khuyenMaiPayLoad.getPhanTramGiam();
        Long maKM = khuyenMaiPayLoad.getMaKM();

        KhuyenMai KMtest = new KhuyenMai();
        KMtest.setMaKM(maKM);

        List <SanPhamPayLoad> dssp = khuyenMaiPayLoad.getDssp();
        for (int i = 0; i < dssp.size(); i++) {
            for (int j = 0; j < dssp.get(i).getCtsanPhams().size(); j++) {

                CTKhuyenMai ctKhuyenMai = new CTKhuyenMai();
                ctKhuyenMai.setMaCTSP(dssp.get(i).getCtsanPhams().get(j).getMaCTSP());
                ctKhuyenMai.setPhanTramGiam(phanTramGiam);
                ctKhuyenMai.setKhuyenMai(KMtest);
                ctKhuyenMaiRepository.save(ctKhuyenMai);
            }
        }
        return khuyenMaiPayLoad;
    }

}
