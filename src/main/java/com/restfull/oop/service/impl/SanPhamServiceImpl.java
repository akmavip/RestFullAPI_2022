package com.restfull.oop.service.impl;

import com.restfull.oop.dto.SanPhamDTO;
import com.restfull.oop.exception.NotFoundException;
import com.restfull.oop.mapper.CTSanPhamMapper;
import com.restfull.oop.mapper.SanPhamMapper;
import com.restfull.oop.model.CTSanPham;
import com.restfull.oop.model.SanPham;
import com.restfull.oop.model.Size;
import com.restfull.oop.repository.CTSanPhamRepository;
import com.restfull.oop.repository.SanPhamRepository;
import com.restfull.oop.repository.SizeRepository;
import com.restfull.oop.repository.TheLoaiRepository;
import com.restfull.oop.service.SanPhamService;
import com.restfull.oop.vm.SanPhamVM;
import com.restfull.oop.vm.mapper.CTSanPhamMapperVM;
import com.restfull.oop.vm.mapper.SanPhamMapperVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class SanPhamServiceImpl implements SanPhamService {

    @Autowired
    private SanPhamRepository sanPhamRepository;

    @Autowired
    private SanPhamMapper sanPhamMapper;

    @Autowired
    private SanPhamMapperVM sanPhamMapperVM;

    @Autowired
    private CTSanPhamRepository ctSanPhamRepository;

    @Autowired
    private CTSanPhamMapper ctSanPhamMapper;

    @Autowired
    private CTSanPhamMapperVM ctSanPhamMapperVM;

    @Autowired
    private SizeRepository sizeRepository;

    @Autowired
    private TheLoaiRepository theLoaiRepository;

    @Override
    @Transactional(readOnly = true)
    public List<SanPhamVM> getAll() {
        List<SanPham> sanPhams = sanPhamRepository.findAll();
        return sanPhamRepository.findAll().stream().map(sanPhamMapperVM::toDto).collect(Collectors.toList());
    }

    @Override
    public List<SanPhamVM> getHotProducts() {
        return sanPhamRepository.findTop8ByOrderByLuotXemDesc().stream().map(sanPhamMapperVM::toDto).collect(Collectors.toList());
    }

    @Override
    public SanPhamVM getDetail(Long id) {
        Optional<SanPham> taiKhoan = sanPhamRepository.findById(id);
        if (!taiKhoan.isPresent() || taiKhoan.isEmpty()) {
            throw new NotFoundException("Sản phẩm không được tìm thấy");
        }
        return sanPhamMapperVM.toDto(taiKhoan.get());
    }
    //Lọc , lọc theo tên, lọc sp mới
    @Override
    public SanPhamVM create(SanPhamDTO sanPhamDTO) {

        //Nếu trùng tên, loại thì xét đến size
        //Size trùng thì cộng số lượng, size khác thì tạo detail mới
        Optional<SanPham> sanPhamOptional = sanPhamRepository.findByTenSPAndTheLoai(sanPhamDTO.getTenSP(), sanPhamDTO.getMaTL());
        Size size =sizeRepository.findById(sanPhamDTO.getMaSize()).get();
        SanPham sanPham = new SanPham();
        SanPhamVM sanPhamVM = new SanPhamVM();
        if(sanPhamOptional.isPresent() ){
            Optional<CTSanPham> ctSanPhamOptional = ctSanPhamRepository.findBySanPhamAndSize(sanPhamOptional.get().getMaSP(), sanPhamDTO.getMaSize());
            if(!ctSanPhamOptional.isPresent()) {
                CTSanPham ctSanPham = new CTSanPham();
                ctSanPham.setSanPham(sanPhamOptional.get());
                ctSanPham.setSize(size);
                ctSanPham.setGia(sanPhamDTO.getGia());
                ctSanPham.setSlTon(sanPhamDTO.getSlTon());
                ctSanPham.setMoTa(sanPhamDTO.getMota());
                //Set lại SL tồn
                sanPhamOptional.get().setTongSLTon(sanPhamOptional.get().getTongSLTon() + sanPhamDTO.getSlTon());
                ctSanPhamRepository.save(ctSanPham);
                sanPhamRepository.save((sanPhamOptional.get()));

                sanPhamVM = sanPhamMapperVM.toDto(sanPhamOptional.get());
                return sanPhamVM;
            }
            else {
                ctSanPhamOptional.get().setSlTon(ctSanPhamOptional.get().getSlTon() + sanPhamDTO.getSlTon());
                sanPhamOptional.get().setTongSLTon(sanPhamOptional.get().getTongSLTon() + sanPhamDTO.getSlTon());
                ctSanPhamRepository.save(ctSanPhamOptional.get());
                sanPhamRepository.save((sanPhamOptional.get()));

                sanPhamVM = sanPhamMapperVM.toDto(sanPhamOptional.get());
                return sanPhamVM;
            }
        }
        else {
            sanPham = sanPhamMapper.toEntity(sanPhamDTO);
            sanPham.setTongSLTon(sanPhamDTO.getSlTon());
            sanPham.setTheLoai(theLoaiRepository.findById(sanPhamDTO.getMaTL()).get());
            sanPhamRepository.save(sanPham);
            //Lưu CTSP
            CTSanPham ctSanPham = new CTSanPham();
            ctSanPham.setSanPham(sanPham);
            ctSanPham.setSize(size);
            ctSanPham.setGia(sanPhamDTO.getGia());
            ctSanPham.setSlTon(sanPhamDTO.getSlTon());
            ctSanPham.setMoTa(sanPhamDTO.getMota());
            ctSanPhamRepository.save(ctSanPham);

            sanPhamVM = sanPhamMapperVM.toDto(sanPham);
            return sanPhamVM;
        }
    }

    @Override
    public void delete(Long maSP) {
        SanPham sanPham = sanPhamRepository.findById(maSP).get();
        if(sanPham.getCTSanPhams().size()> 0) {
            new Exception("Sản phẩm chứa nhiều loại đang bán");
        }
        sanPhamRepository.delete(sanPham);
    }
}
