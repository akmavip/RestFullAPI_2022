package com.restfull.oop.service.impl;


import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.restfull.oop.model.CTGioHang;
import com.restfull.oop.model.GioHang;
import com.restfull.oop.model.HoaDon;
import com.restfull.oop.repository.HoaDonRepository;
import com.restfull.oop.service.PDFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

@Service
public class PDFImpl implements PDFService {

    @Autowired
    private HoaDonRepository hoaDonRepository;

    public Map<String, Object> hoaDonDetail(Long id){
        Map<String, Object> result = new HashMap<>();
        HoaDon hoadon = hoaDonRepository.findByMaHoaDon(id);
        result.put("maHoaDon", hoadon.getMaHoaDon());
        GioHang gioHang = hoadon.getGioHang();
        result.put("hoTen", gioHang.getHoTen());
        result.put("sdt", gioHang.getSdt());
        result.put("diaChi", gioHang.getDiaChi());
        result.put("ngayGiao", gioHang.getNgayGiao());

        List<Map<String, Object>> sanPhams = new ArrayList<>();
        List<CTGioHang> CTGHs = gioHang.getCtGioHangs();
        for(CTGioHang item :  CTGHs){
            Map<String, Object> mapSanpham = new HashMap<>();
            mapSanpham.put("tenSanPham", item.getCTSanPham().getSanPham().getTenSP());
            mapSanpham.put("gia", item.getGia());
            mapSanpham.put("soLuong", item.getSoLuong());
            mapSanpham.put("size", item.getCTSanPham().getSize().getTenSize());
            mapSanpham.put("thanhTien", item.getSoLuong() * item.getGia());
            sanPhams.add(mapSanpham);
        }
        result.put("sanPhams",sanPhams);
        return result;
    }

    public void CreateReport(HttpServletResponse response) throws IOException, DocumentException {

        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern(" hh-mm-ss aa dd-MM-yyyy");
        String pathnn = sdf.format(new Date());
        pathnn = pathnn.replaceAll(" ", "_");

        String path = "D:\\Export" + pathnn + ".pdf";

        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());
        PdfWriter.getInstance(document, new FileOutputStream(path));
        document.open();

        Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        fontTitle.setSize(18);
        Paragraph paragraph = new Paragraph("CLOTHING SHOP", fontTitle);
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);

        Font fontsubTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        fontTitle.setSize(15);
        Paragraph reportTitle = new Paragraph("BÁO CÁO DOANH THU", fontsubTitle);
        reportTitle.setAlignment(Paragraph.ALIGN_CENTER);

        Paragraph ReportTime = new Paragraph("TU... " + " DEN... "  , fontsubTitle);
        ReportTime.setAlignment(Paragraph.ALIGN_CENTER);

        document.add(paragraph);
        document.add(reportTitle);
        document.add(ReportTime);

        PdfPTable t = new PdfPTable(3);
        t.setSpacingBefore(25);
        t.setSpacingAfter(25);

        PdfPCell c1 = new PdfPCell(new Phrase("THANG NAM"));
        t.addCell(c1);
        PdfPCell c2 = new PdfPCell(new Phrase("SO DON"));
        t.addCell(c2);
        PdfPCell c3 = new PdfPCell(new Phrase("THANH TIEN"));
        t.addCell(c3);

        // Vòng for
        t.addCell("5/2022");
        t.addCell("so don");
        t.addCell("VND");

        t.addCell("5/2022");
        t.addCell("so don");
        t.addCell("VND");

        document.add(t);
        document.close();
    }

    @Override
    public void CreateInvoice(HttpServletResponse response, Long maHoaDon) throws IOException, DocumentException {

        Map<String, Object> data = hoaDonDetail(maHoaDon);

        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());
        PdfWriter.getInstance(document, new FileOutputStream("D:\\Invoice" + "SO XXX" + ".pdf"));
        document.open();

        Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        fontTitle.setSize(18);
        Paragraph paragraph = new Paragraph("HOA DON SO "+ maHoaDon, fontTitle);
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);

        Font fontsubTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        fontTitle.setSize(12);
        Paragraph a = new Paragraph("HO VA TEN: "+ data.get("hoTen"), fontsubTitle);
        a.setAlignment(Paragraph.ALIGN_LEFT);

        Paragraph b = new Paragraph("SDT: "+ data.get("sdt")  , fontsubTitle);
        b.setAlignment(Paragraph.ALIGN_LEFT);

        Paragraph c = new Paragraph("DIA CHI: "+ data.get("diaChi")  , fontsubTitle);
        c.setAlignment(Paragraph.ALIGN_LEFT);

        Paragraph d = new Paragraph("NGAY GIAO: "+ data.get("ngayGiao")  , fontsubTitle);
        d.setAlignment(Paragraph.ALIGN_LEFT);

        document.add(paragraph);
        document.add(a);
        document.add(b);
        document.add(c);
        document.add(d);

        PdfPTable t = new PdfPTable(5);
        t.setSpacingBefore(25);
        t.setSpacingAfter(25);

        PdfPCell c1 = new PdfPCell(new Phrase("SAN PHAM"));
        t.addCell(c1);
        PdfPCell c2 = new PdfPCell(new Phrase("GIA"));
        t.addCell(c2);
        PdfPCell c3 = new PdfPCell(new Phrase("SIZE"));
        t.addCell(c3);
        PdfPCell c4 = new PdfPCell(new Phrase("SO LUONG"));
        t.addCell(c4);
        PdfPCell c5 = new PdfPCell(new Phrase("THANH TIEN"));
        t.addCell(c5);

        List<Map<String, Object>> dataTable = (List<Map<String, Object>>) data.get("sanPhams");
        for (Map<String, Object> item : dataTable)
        {
            t.addCell((String) item.get("tenSanPham"));
            t.addCell(String.valueOf((int) item.get("gia")));
            t.addCell((String) item.get("size"));
            t.addCell(String.valueOf((int) item.get("soLuong")));
            t.addCell(String.valueOf((int) item.get("thanhTien")));

        }

        document.add(t);
        document.close();
    }
}
