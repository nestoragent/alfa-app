package ru.alfa.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by velichko-aa on 16.03.17.
 */
@Slf4j
@Controller
public class BaseController {

    private static final String VIEW_INDEX = "index";
    private static int counter = 0;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcome(ModelMap model) {
        model.addAttribute("message", "Welcome");
        model.addAttribute("counter", ++counter);
        log.debug("[welcome] counter : {}", counter);
        return VIEW_INDEX;

    }

    @RequestMapping(value = "/{save}", method = RequestMethod.GET)
    public String welcomeName(@PathVariable String name,
                              ModelMap model) {

        model.addAttribute("message", "Welcome " + name);
        model.addAttribute("counter", ++counter);
        log.debug("[welcomeName] counter : {}", counter);
        return VIEW_INDEX;

    }
}
