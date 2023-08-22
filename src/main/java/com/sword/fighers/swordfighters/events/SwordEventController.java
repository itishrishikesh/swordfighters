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
@SessionAttributes("username")
public class SwordEventController {

    Logger logger = LoggerFactory.getLogger(SwordEventController.class);


    @Autowired
    private SwordEventService swordEventService;

    @RequestMapping("/events")
    public String events(Model model) {
        model.addAttribute("events", swordEventService.getSwordEvents());
        logger.info("model.getAttribute(\"events\") = " + model.getAttribute("events"));
        return "events";
    }

    @RequestMapping(value = "/add-event", method = RequestMethod.GET)
    public String showAddEventForm(ModelMap model) {
        SwordEvent event = new SwordEvent(0, "", "", "",
                model.get("username").toString(),
                LocalDate.now().plusDays(100), false);
        model.put("event", event);
        return "event";
    }

    @RequestMapping(value = "/add-event", method = RequestMethod.POST)
    public String addEvent(ModelMap modelMap, @Valid SwordEvent event, BindingResult result) {
        modelMap.addAttribute("event", event);
        if(result.hasErrors()) {
            return "event";
        }
        swordEventService.addSwordEvent(
                event.getDefender(),
                event.getChallenger(),
                event.getDescription(),
                modelMap.get("username").toString(),
                LocalDate.now(),
                false
        );
        return "redirect:events";
    }

    @RequestMapping("/delete-event/{id}")
    public String deleteEvent(@PathVariable("id") int id) {
        swordEventService.deleteSwordEvent(id);
        return "redirect:/events";
    }

    @RequestMapping("/update-event/{id}")
    public String updateEvent(@PathVariable("id") int id, ModelMap model) {
        model.addAttribute("event", swordEventService.updateSwordEvent(id));
        model.put("event", swordEventService.updateSwordEvent(id));
        return "event";
    }
}
