package com.mediscreen.report.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mediscreen.report.entity.Report;

import java.util.List;

public interface ReportRepository extends MongoRepository<Report, Integer> {
    @SuppressWarnings("unchecked")
	Report save(Report report);
    Report findById(int id);
    void delete(Report report);
    @SuppressWarnings({ "rawtypes", "unchecked" })
	List findAll();
    Report findTopByOrderByIdDesc();
}
