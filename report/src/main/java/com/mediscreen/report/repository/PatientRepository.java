package com.mediscreen.report.repository;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mediscreen.report.entity.Patient;

@FeignClient(name = "microservice-patient")
@RibbonClient(name = "microservice-patient")
public interface PatientRepository {

    @GetMapping("/patient/{id}")
    Patient findPatient(@PathVariable int id);
    @GetMapping("/patient/family-name/{familyName}")
    Patient findPatientByName(@PathVariable String familyName);
}
