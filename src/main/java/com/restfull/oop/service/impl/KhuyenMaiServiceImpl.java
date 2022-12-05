package com.restfull.oop.service.impl;

import com.restfull.oop.dto.KhuyenMaiDTO;
import com.restfull.oop.mapper.CTKhuyenMaiMapper;
import com.restfull.oop.mapper.KhuyenMaiMapper;
import com.restfull.oop.model.CTKhuyenMai;
import com.restfull.oop.model.KhuyenMai;
import com.restfull.oop.payload.KhuyenMaiPayLoad;
import com.restfull.oop.payload.SanPhamPayLoad;
import com.restfull.oop.repository.CTKhuyenMaiRepository;
import com.restfull.oop.repository.KhuyenMaiRepository;
import com.restfull.oop.service.KhuyenMaiService;
import com.restfull.oop.vm.KhuyenMaiVM;
import com.restfull.oop.vm.mapper.CTKhuyenMaiMapperVM;
import com.restfull.oop.vm.mapper.KhuyenMaiMapperVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
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
        System.out.println("ds arr " + khuyenMaiPayLoad.getDssp().get(0).getDetail());
        System.out.println("ds mota " + khuyenMaiPayLoad.getMoTa());
        System.out.println("ds manv " + khuyenMaiPayLoad.getMaNV());
        System.out.println("ds ngayapdung " + khuyenMaiPayLoad.getNgayApDung());
        System.out.println("ds ngayketthuc " + khuyenMaiPayLoad.getNgayKetThuc());
        System.out.println("ds ma km " + khuyenMaiPayLoad.getMaKM());

        int phanTramGiam = khuyenMaiPayLoad.getPhanTramGiam();
        KhuyenMai khuyenMaiMoi = new KhuyenMai();
        khuyenMaiMoi.setMota(khuyenMaiPayLoad.getMoTa());
        khuyenMaiMoi.setMaNV(khuyenMaiPayLoad.getMaNV());
        khuyenMaiMoi.setNgayApDung(khuyenMaiPayLoad.getNgayApDung());
        khuyenMaiMoi.setNgayKetThuc(khuyenMaiPayLoad.getNgayKetThuc());
        String maNV = String.valueOf(khuyenMaiMoi.getMaNV());
        khuyenMaiRepository.save(khuyenMaiMoi);

//        Optional<KhuyenMai> maKM = khuyenMaiRepository.findNewestPromotion(maNV);
        KhuyenMai KMtest = new KhuyenMai();
        KMtest.setMaKM(khuyenMaiRepository.findNewestPromotion(maNV));

        System.out.println("mã khuyeensm ãi mới = " + KMtest);
        List <SanPhamPayLoad> dssp = khuyenMaiPayLoad.getDssp();
        for (int i = 0; i < dssp.size(); i++) {
            System.out.println("san pham "+ i+  " " + dssp.get(i));

            for (int j = 0; j < dssp.get(i).getDetail().size(); j++) {
                System.out.println("ctsp " +i+ " "+  dssp.get(i).getDetail().get(j).getMaCTSP());
//                System.out.println("maKM  "+  maKM.get());
                System.out.println("phan tram giam "+  phanTramGiam);


                CTKhuyenMai ctKhuyenMai = new CTKhuyenMai();
                ctKhuyenMai.setMaCTSP(dssp.get(i).getDetail().get(j).getMaCTSP());
                ctKhuyenMai.setPhanTramGiam(phanTramGiam);
                ctKhuyenMai.setKhuyenMai(KMtest);
                ctKhuyenMaiRepository.save(ctKhuyenMai);
                System.out.println("new " + ctKhuyenMai);
            }
        }
//        Long maKM = khuyenmai1.get().getMaKM();
//        System.out.println("khuyenmai "+ maKM);
//        Optional<CTKhuyenMai> ctKhuyenMai1 = ctKhuyenMaiRepository.findNewestPromotionDetail(khuyenmai1.get().getMaKM());

        return khuyenMaiPayLoad;
    }

    @Override
    public KhuyenMaiVM update(KhuyenMaiDTO khuyenMaiDTO) {
        return null;
    }
}
