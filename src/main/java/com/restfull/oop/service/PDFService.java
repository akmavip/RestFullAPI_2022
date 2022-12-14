package com.restfull.oop.service;

import com.itextpdf.text.DocumentException;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface PDFService {

    void CreateReport(HttpServletResponse response) throws IOException, DocumentException;

    void CreateInvoice(HttpServletResponse response, Long maHoaDon) throws IOException, DocumentException;
}
