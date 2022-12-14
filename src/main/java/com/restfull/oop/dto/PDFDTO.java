package com.restfull.oop.dto;

import lombok.Data;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@Data
public class PDFDTO {
    private String templateName;
    private Map<String, Object> data;
    private String pdfFileName;
}
