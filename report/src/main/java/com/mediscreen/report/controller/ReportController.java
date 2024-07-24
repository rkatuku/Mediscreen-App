package com.mediscreen.report.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mediscreen.report.entity.Report;
import com.mediscreen.report.service.ReportService;

@RestController
@RequestMapping("/assess")
public class ReportController {
@Autowired
    ReportService reportService;

    @PostMapping("/id")
    public Report ReportById(@RequestParam("patId") int patId){
        return reportService.reportPatient(patId);
    }

    @PostMapping("/familyName")
    public Report ReportByFamily(@RequestParam("familyName") String familyName){
        return reportService.reportPatient(familyName);
    }
}
