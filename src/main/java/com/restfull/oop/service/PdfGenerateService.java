package com.restfull.oop.service;

import com.itextpdf.text.DocumentException;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public interface PdfGenerateService {
    void generatePdfFile(String templateName, Map<String, Object> data, String pdfFileName);

    void CreateInvoice(HttpServletResponse response, Long maHoaDon) throws IOException, DocumentException;
}
