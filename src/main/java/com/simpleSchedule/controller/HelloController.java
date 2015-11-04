package com.simpleSchedule.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SteveGreen on 17/10/15.
 */
@Controller
@RequestMapping("test")
public class HelloController {

    @RequestMapping(value="helloooooo", method = RequestMethod.GET)
    public String helloooooo(Model model) {
        List<String> stringList = new ArrayList<String>();
        stringList.add("A");
        stringList.add("B");
        stringList.add("C");
        stringList.add("D");
        model.addAttribute("stringList", stringList);
        return "appointments";
    }

}
