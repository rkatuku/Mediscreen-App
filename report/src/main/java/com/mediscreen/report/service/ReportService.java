package com.mediscreen.report.service;

import java.util.List;

import com.mediscreen.report.entity.Report;

/**
 * Report Action Manager
 */
public interface ReportService {
    /**
     * save and edit report
     * @param report
     * @return
     */
    Report save(Report report);

    /**
     * find report from id
     * @param id
     * @return
     */
    Report find(int id);

    /**
     * delete report from id
     * @param id
     */
    void delete(int id);

    /**
     * get all report
     * @return
     */
    List<Report> list();

    /**
     * get last record report
     * @return
     */
    Report findTopByOrderByIdDesc();

    /**
     * get last record report
     * @return
     */
    Report reportPatient(int idPatient);

    Report reportPatient(String familyName);
}
