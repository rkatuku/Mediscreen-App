package com.mediscreen.report.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mediscreen.report.entity.Trigger;

import java.util.List;

public interface TriggerRepository extends MongoRepository<Trigger, Integer> {
    @SuppressWarnings("unchecked")
	Trigger save(Trigger trigger);
    Trigger findById(int id);
    void delete(Trigger trigger);
    @SuppressWarnings({ "rawtypes", "unchecked" })
	List findAll();
    Trigger findTopByOrderByIdDesc();
    Trigger findTopByTriggerCriteria(String triggerCriteria);
}
