package com.sword.fighers.swordfighters.events;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
public class SwordEventController {

    Logger logger = LoggerFactory.getLogger(SwordEventController.class);


    @Autowired
    private SwordEventService swordEventService;

    private static final String EVENTS = "events";
    private static final String REDIRECT = "redirect:/";
    private static final String EVENT = "event";

    @RequestMapping("/")
    public String events(Model model) {
        model.addAttribute(EVENTS, swordEventService.getSwordEvents());
        logger.info("model.getAttribute(\"events\") = {}", model.getAttribute(EVENTS));
        return EVENTS;
    }


    @GetMapping
    public String showAddEventForm(ModelMap model) {
        SwordEvent event = new SwordEvent(0, "", "", "",
                "",
                LocalDate.now().plusDays(100), false);
        model.put(EVENTS, event);
        return EVENTS;
    }

    @PostMapping(value = "/add-event")
    public String addEvent(ModelMap modelMap, @Valid SwordEvent event, BindingResult result) {
        modelMap.addAttribute(EVENT, event);
        if(result.hasErrors()) {
            return EVENT;
        }
        swordEventService.addSwordEvent(
                event.getDefender(),
                event.getChallenger(),
                event.getDescription(),
                "",
                event.getScheduledDate(),
                false
        );
        return REDIRECT;
    }

    @RequestMapping("/delete-event/{id}")
    public String deleteEvent(@PathVariable("id") int id) {
        swordEventService.deleteSwordEvent(id);
        return REDIRECT;
    }

    @RequestMapping("/update-event/{id}")
    public String updateEvent(@PathVariable("id") int id, ModelMap model) {
        model.addAttribute(EVENT, swordEventService.updateSwordEvent(id));
        model.put(EVENT, swordEventService.updateSwordEvent(id));
        return EVENT;
    }

    @PostMapping(value = "/update-event/{id}")
    public String updateEventPost(@PathVariable("id") int id, @Valid SwordEvent event, BindingResult bindingResult) {
        if(bindingResult.hasErrors())
            return EVENT;
        event.setId(id);
        swordEventService.updateSwordEvent(id, event);
        return REDIRECT;
    }
}
