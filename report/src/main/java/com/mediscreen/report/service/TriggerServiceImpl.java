package com.mediscreen.report.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mediscreen.report.entity.Trigger;
import com.mediscreen.report.repository.TriggerRepository;

import java.util.List;
@Service
public class TriggerServiceImpl implements TriggerService {
    @Autowired
    TriggerRepository triggerRepository;

    @Override
    public Trigger save(Trigger trigger) {
        if(trigger.getId() == 0)
            trigger.setId(findTopByOrderByIdDesc() != null ? findTopByOrderByIdDesc().getId() + 1 : 1);
        if(findByTriggerCriteria(trigger.getTriggerCriteria()) == null)
            trigger = triggerRepository.save(trigger);
        return trigger;
    }

    @Override
    public Trigger find(int id) {
        return triggerRepository.findById(id);
    }

    @Override
    public void delete(int id) {
        triggerRepository.delete(find(id));
    }

    @SuppressWarnings("unchecked")
	@Override
    public List<Trigger> list() {
        return triggerRepository.findAll();
    }

    @Override
    public Trigger findTopByOrderByIdDesc() {
        return triggerRepository.findTopByOrderByIdDesc();
    }

    @Override
    public Trigger findByTriggerCriteria(String triggerCriteria) {
        return triggerRepository.findTopByTriggerCriteria(triggerCriteria);
    }
}
