package com.sword.fighers.swordfighters.events;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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

    @RequestMapping("/")
    public String events(Model model) {
        model.addAttribute("events", swordEventService.getSwordEvents());
        logger.info("model.getAttribute(\"events\") = " + model.getAttribute("events"));
        return "events";
    }
   

    @RequestMapping(value = "/add-event", method = RequestMethod.GET)
    public String showAddEventForm(ModelMap model) {
        SwordEvent event = new SwordEvent(0, "", "", "",
                "",
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
                "",
                event.getScheduledDate(),
                false
        );
        return "redirect:/";
    }

    @RequestMapping("/delete-event/{id}")
    public String deleteEvent(@PathVariable("id") int id) {
        swordEventService.deleteSwordEvent(id);
        return "redirect:/";
    }

    @RequestMapping("/update-event/{id}")
    public String updateEvent(@PathVariable("id") int id, ModelMap model) {
        model.addAttribute("event", swordEventService.updateSwordEvent(id));
        model.put("event", swordEventService.updateSwordEvent(id));
        return "event";
    }

    @RequestMapping(value = "/update-event/{id}", method = RequestMethod.POST)
    public String updateEventPost(@PathVariable("id") int id, @Valid SwordEvent event, BindingResult bindingResult) {
        if(bindingResult.hasErrors())
            return "event";
        event.setId(id);
        swordEventService.updateSwordEvent(id, event);
        return "redirect:/";
    }
    
    private String getUserIdFromSpringSecurity() {
    	return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
