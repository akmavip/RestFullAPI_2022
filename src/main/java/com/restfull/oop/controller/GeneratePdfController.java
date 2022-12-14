package com.restfull.oop.controller;

import com.lowagie.text.DocumentException;
import com.restfull.oop.dto.PDFDTO;
import com.restfull.oop.service.PdfGenerateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController

public class GeneratePdfController {
    @Autowired
    private PdfGenerateService pdfGenerateService;

    @PostMapping("/get-baocao-pdf")
    @CrossOrigin
    public void generatePdfFile(@RequestBody PDFDTO pdfdto) {
        pdfGenerateService.generatePdfFile(pdfdto.getTemplateName(), pdfdto.getData(), pdfdto.getPdfFileName());
    }

    @GetMapping("/create-hoadon-pdf/{id}")
    public void generatePDFInvoice(HttpServletResponse response, @PathVariable Long id) throws IOException, DocumentException, com.itextpdf.text.DocumentException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=pdf_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);

        pdfGenerateService.CreateInvoice(response, id);
    }
}
