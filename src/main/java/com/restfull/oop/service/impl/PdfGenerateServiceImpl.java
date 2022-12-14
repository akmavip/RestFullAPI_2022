package com.restfull.oop.service.impl;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.lowagie.text.DocumentException;
import com.restfull.oop.model.CTGioHang;
import com.restfull.oop.model.GioHang;
import com.restfull.oop.model.HoaDon;
import com.restfull.oop.repository.CTSanPhamRepository;
import com.restfull.oop.repository.HoaDonRepository;
import com.restfull.oop.repository.SanPhamRepository;
import com.restfull.oop.service.PdfGenerateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.xhtmlrenderer.pdf.ITextRenderer;

import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PdfGenerateServiceImpl implements PdfGenerateService {
    private Logger logger = LoggerFactory.getLogger(PdfGenerateServiceImpl.class);

    @Autowired
    private TemplateEngine templateEngine;

    @Value("${pdf.directory}")
    private String pdfDirectory;

    @Autowired
    private HoaDonRepository hoaDonRepository;

    @Autowired
    private SanPhamRepository sanPhamRepository;

    @Autowired
    private CTSanPhamRepository ctSanPhamRepository;

    @Override
    public void generatePdfFile(String templateName, Map<String, Object> data, String pdfFileName) {
        System.out.println("tempalete " + templateName);
        Context context = new Context();
        context.setVariables(data);

        String htmlContent = templateEngine.process(templateName, context);
        System.out.println("htmlContent " + htmlContent);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(pdfDirectory + pdfFileName);
            ITextRenderer renderer = new ITextRenderer();
            renderer.setDocumentFromString(htmlContent);
            renderer.layout();
            renderer.createPDF(fileOutputStream, false);
            renderer.finishPDF();
        } catch (FileNotFoundException e) {
            logger.error(e.getMessage(), e);
        } catch (DocumentException e) {
            logger.error(e.getMessage(), e);
        }
    }

    public Map<String, Object> hoaDonDetail(Long id) {
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
        for (CTGioHang item : CTGHs) {
            Map<String, Object> mapSanpham = new HashMap<>();
            mapSanpham.put("tenSanPham", sanPhamRepository.findById(item.getMaCTSP()).get().getTenSP());
            mapSanpham.put("gia", item.getGia());
            mapSanpham.put("soLuong", item.getSoLuong());
            mapSanpham.put("size", ctSanPhamRepository.findById(item.getMaCTSP()).get().getSize().getTenSize());
            mapSanpham.put("thanhTien", item.getSoLuong() * item.getGia());
            sanPhams.add(mapSanpham);
        }
        result.put("sanPhams", sanPhams);
        return result;
    }

    @Override
    public void CreateInvoice(HttpServletResponse response, Long maHoaDon) throws IOException, com.itextpdf.text.DocumentException {
        Map<String, Object> data = hoaDonDetail(maHoaDon);

        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());
        PdfWriter.getInstance(document, new FileOutputStream("D:\\Invoice " + maHoaDon + ".pdf"));
        document.open();

        Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        fontTitle.setSize(18);
        Paragraph paragraph = new Paragraph("HOA DON SO " + maHoaDon, fontTitle);
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);

        Font fontsubTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        fontTitle.setSize(12);
        Paragraph a = new Paragraph("HO VA TEN: " + data.get("hoTen"), fontsubTitle);
        a.setAlignment(Paragraph.ALIGN_LEFT);

        Paragraph b = new Paragraph("SDT: " + data.get("sdt"), fontsubTitle);
        b.setAlignment(Paragraph.ALIGN_LEFT);

        Paragraph c = new Paragraph("DIA CHI: " + data.get("diaChi"), fontsubTitle);
        c.setAlignment(Paragraph.ALIGN_LEFT);

        Paragraph d = new Paragraph("NGAY GIAO: " + data.get("ngayGiao"), fontsubTitle);
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

        java.util.List<Map<String, Object>> dataTable = (List<Map<String, Object>>) data.get("sanPhams");
        for (Map<String, Object> item : dataTable) {
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

