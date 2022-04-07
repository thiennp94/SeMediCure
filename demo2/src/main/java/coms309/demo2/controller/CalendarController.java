package coms309.demo2.controller;

import coms309.demo2.model.CalendarEvent;
import coms309.demo2.repository.CalendarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CalendarController {

    @Autowired
    CalendarRepository calendarRepository;

    @GetMapping("/visits")
    List<CalendarEvent> GetAllNewPatient(){
        return calendarRepository.findAll();
    }

    @PostMapping("/visits")
    CalendarEvent PostAdminByPath(@RequestBody CalendarEvent newEvent){
        calendarRepository.save(newEvent);
        return newEvent;
    }


}