package com.mediscreen.report.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.mediscreen.report.entity.Trigger;
import com.mediscreen.report.service.TriggerService;

import java.util.List;

@RestController
@RequestMapping("/trigger")
public class TriggerController {
    @Autowired
    TriggerService triggerService;

    @GetMapping
    public List<Trigger> list(){
        return triggerService.list();
    }

    @GetMapping("/{id}")
    public Trigger find(@PathVariable int id){
        return triggerService.find(id);
    }

    @PostMapping
    public Trigger create(@RequestBody Trigger trigger){
        return triggerService.save(trigger);
    }

    @PutMapping
    public Trigger edit(@RequestBody Trigger trigger){
        return triggerService.save(trigger);
    }

    @DeleteMapping("/{id}")
    public void delete(@RequestBody int id){
        triggerService.delete(id);
    }

}
