package com.mediscreen.report.service;

import java.util.List;

import com.mediscreen.report.entity.Trigger;

/**
 * Trigger Action Manager
 */
public interface TriggerService {
    /**
     * save and edit trigger
     * @param trigger
     * @return
     */
    Trigger save(Trigger trigger);

    /**
     * find trigger from id
     * @param id
     * @return
     */
    Trigger find(int id);

    /**
     * delete trigger from id
     * @param id
     */
    void delete(int id);

    /**
     * get all trigger
     * @return
     */
    List<Trigger> list();

    /**
     * get last record trigger
     * @return
     */
    Trigger findTopByOrderByIdDesc();

    /**
     * get trigger from libelle
     * @return
     */
    Trigger findByTriggerCriteria(String triggerCriteria);
}
