package com.sword.fighers.swordfighters.events;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

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
    public String showAddEventForm(Model model) {
        return "event";
    }

    @RequestMapping(value = "/add-event", method = RequestMethod.POST)
    public String addEvent(ModelMap modelMap) {
        swordEventService.addSwordEvent(
                "",
                "",
                "",
                modelMap.get("username").toString(),
                LocalDate.now(),
                false
        );
        return "redirect:events";
    }

}
