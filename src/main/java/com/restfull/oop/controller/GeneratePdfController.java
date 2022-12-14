package com.restfull.oop.controller;

import com.restfull.oop.dto.PDFDTO;
import com.restfull.oop.model.ResponseObject;
import com.restfull.oop.service.NhanVienService;
import com.restfull.oop.service.PdfGenerateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController

public class GeneratePdfController {
        @Autowired
        private PdfGenerateService pdfGenerateService;
        @PostMapping("/get-baocao-pdf")
        @CrossOrigin
        public void generatePdfFile(@RequestBody PDFDTO pdfdto) {
              pdfGenerateService.generatePdfFile(pdfdto.getTemplateName(),  pdfdto.getData(), pdfdto.getPdfFileName());
        }

}
